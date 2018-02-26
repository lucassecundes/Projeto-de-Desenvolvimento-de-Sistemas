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
import model.Perfil;

/**
 *
 * @author lucas
 */
public class PerfilDAO {

    Connection con;

    public void create(Perfil p) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO perfil "
                    + "(nome,descricao)VALUES(?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }

    public List<Perfil> read() {

        con = (Connection) ConnectionSql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Perfil> perfils = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM perfil");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Perfil perfil = new Perfil();

                perfil.setIdPerfil(rs.getInt("idPerfil"));
                perfil.setNome(rs.getString("Nome"));
                perfil.setDescricao(rs.getString("Descricao"));

                perfils.add(perfil);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt, rs);
        }

        return perfils;

    }

    public void update(Perfil p) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE perfil SET "
                    + "nome = ?,descricao = ? WHERE idPerfil = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getIdPerfil());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }

    public void delete(Perfil p) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM perfil  "
                    + "WHERE idPerfil = ?");
            stmt.setInt(1, p.getIdPerfil());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }
    
    public List<Perfil> readForNome(String nome) {

        con = (Connection) ConnectionSql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Perfil> perfils = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM perfil WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Perfil perfil = new Perfil();

                perfil.setIdPerfil(rs.getInt("idPerfil"));
                perfil.setNome(rs.getString("Nome"));
                perfil.setDescricao(rs.getString("Descricao"));

                perfils.add(perfil);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt, rs);
        }

        return perfils;

    }
}
