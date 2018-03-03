    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author lucas
 */
public class UsuarioDAO {

    Connection con;

    public void create(Usuario u) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario "
                    + "(nome,sobrenome)VALUES(?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }

    public List<Usuario> read() {

        con = (Connection) ConnectionSql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setSobrenome(rs.getString("Sobrenome"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt, rs);
        }

        return usuarios;

    }

    public void update(Usuario u) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE usuario SET "
                    + "nome = ?,sobrenome = ? WHERE idUsuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setInt(3, u.getIdUsuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }

    public void delete(Usuario u) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario  "
                    + "WHERE idUsuario = ?");
            stmt.setInt(1, u.getIdUsuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }

    public List<Usuario> readForNome(String nome) {

        con = (Connection) ConnectionSql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setSobrenome(rs.getString("Sobrenome"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt, rs);
        }

        return usuarios;

    }
}
