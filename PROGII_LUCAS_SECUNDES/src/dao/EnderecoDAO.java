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
import model.Endereco;

/**
 *
 * @author lucas
 */
public class EnderecoDAO {

    Connection con;

    public void create(Endereco e) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO endereco "
                                        + "(logradouro,complemento,bairro,numero,cep)"
                                        + "VALUES(?,?,?,?,?)");
            stmt.setString(1, e.getLogradouro());
            stmt.setString(2, e.getComplemento());
            stmt.setString(3, e.getBairro());
            stmt.setString(4, e.getNumero());
            stmt.setString(5, e.getCep());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }

    public List<Endereco> read() {

        con = (Connection) ConnectionSql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Endereco> enderecos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM endereco");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Endereco endereco = new Endereco();

                endereco.setIdEndereco(rs.getInt("IdEndereco"));
                endereco.setLogradouro(rs.getString("Logradouro"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setComplemento(rs.getString("Complemento"));
                endereco.setNumero(rs.getString("Numero"));
                endereco.setCep(rs.getString("Cep"));
                enderecos.add(endereco);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionSql.closeConnection(con, stmt, rs);

        }

        return enderecos;

    }

    public void update(Endereco e) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE endereco "
                                        +"SET logradouro = ?,complemento = ?,bairro = ?,numero = ?,cep = ? "
                                        +"WHERE idEndereco = ?");
            stmt.setString(1, e.getLogradouro());
            stmt.setString(2, e.getComplemento());
            stmt.setString(3, e.getBairro());
            stmt.setString(4, e.getNumero());
            stmt.setString(5, e.getCep());
            stmt.setInt(6, e.getIdEndereco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }
    public void delete(Endereco e) {

        con = (Connection) ConnectionSql.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM endereco  "
                                        +"WHERE idEndereco = ?");
            stmt.setInt(1, e.getIdEndereco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionSql.closeConnection(con, stmt);
        }

    }
    
    public List<Endereco> readForEndereco(String Endereco) {

        con = (Connection) ConnectionSql.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Endereco> enderecos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM endereco WHERE Logradouro LIKE ?");
            stmt.setString(1, "%"+Endereco+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Endereco endereco = new Endereco();

                endereco.setIdEndereco(rs.getInt("IdEndereco"));
                endereco.setLogradouro(rs.getString("Logradouro"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setComplemento(rs.getString("Complemento"));
                endereco.setNumero(rs.getString("Numero"));
                endereco.setCep(rs.getString("Cep"));
                enderecos.add(endereco);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionSql.closeConnection(con, stmt, rs);

        }

        return enderecos;

    }

}
