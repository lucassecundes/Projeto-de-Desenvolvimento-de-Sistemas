/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progii_lucas_secundes;

import dao.EnderecoDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Endereco;

/**
 *
 * @author aluno
 */
public class CadastrarEndereco extends javax.swing.JFrame {

    /**
     * Creates new form Endereco
     */
    public CadastrarEndereco() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTEndereco.getModel();
        jTEndereco.setRowSorter(new TableRowSorter(modelo));

        readJTable();

    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTEndereco.getModel();
        modelo.setNumRows(0);

        EnderecoDAO edao = new EnderecoDAO();

        for (Endereco e : edao.read()) {

            modelo.addRow(new Object[]{
                e.getIdEndereco(),
                e.getLogradouro(),
                e.getComplemento(),
                e.getBairro(),
                e.getNumero(),
                e.getCep()

            });

        }

    }
    
    public void readJTableForEndereco(String endereco) {
        DefaultTableModel modelo = (DefaultTableModel) jTEndereco.getModel();
        modelo.setNumRows(0);

        EnderecoDAO edao = new EnderecoDAO();

        for (Endereco e : edao.readForEndereco(endereco)) {

            modelo.addRow(new Object[]{
                e.getIdEndereco(),
                e.getLogradouro(),
                e.getComplemento(),
                e.getBairro(),
                e.getNumero(),
                e.getCep()

            });

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbLogradouro = new javax.swing.JLabel();
        jblComplemento = new javax.swing.JLabel();
        jlbBairro = new javax.swing.JLabel();
        jblNumero = new javax.swing.JLabel();
        jblCep = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEndereco = new javax.swing.JTable();
        jlbBusca = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbLogradouro.setText("Logradouro");

        jblComplemento.setText("Complemento");

        jlbBairro.setText("Bairro");

        jblNumero.setText("Numero");

        jblCep.setText("CEP");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ENDEREÇO");

        txtLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroActionPerformed(evt);
            }
        });

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jTEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdEndereco", "Logradouro", "Complemento", "Bairro", "Numero", "Cep"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEnderecoMouseClicked(evt);
            }
        });
        jTEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTEnderecoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTEndereco);

        jlbBusca.setText("Busca Logradouro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCancelar)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblComplemento)
                            .addComponent(jlbBairro)
                            .addComponent(jblNumero)
                            .addComponent(jblCep)
                            .addComponent(jlbLogradouro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogradouro)
                            .addComponent(txtComplemento)
                            .addComponent(txtBairro)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCep, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLogradouro)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblComplemento)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jblCep)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar)
                    .addComponent(jbCadastrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed

        Endereco e = new Endereco();
        EnderecoDAO dao = new EnderecoDAO();
        e.setLogradouro(txtLogradouro.getText());
        e.setComplemento(txtComplemento.getText());
        e.setBairro(txtBairro.getText());
        e.setNumero(txtNumero.getText());
        e.setCep(txtCep.getText());

        dao.create(e);

        txtLogradouro.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        txtCep.setText("");

        readJTable();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
       this.setVisible(false);

    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jTEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnderecoKeyReleased

        if (jTEndereco.getSelectedRow() != -1) {

            txtLogradouro.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 1).toString());
            txtComplemento.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 2).toString());
            txtBairro.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 3).toString());
            txtNumero.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 4).toString());
            txtCep.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 5).toString());

        }

    }//GEN-LAST:event_jTEnderecoKeyReleased

    private void jTEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEnderecoMouseClicked

        if (jTEndereco.getSelectedRow() != -1) {

            txtLogradouro.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 1).toString());
            txtComplemento.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 2).toString());
            txtBairro.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 3).toString());
            txtNumero.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 4).toString());
            txtCep.setText(jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 5).toString());

        }

    }//GEN-LAST:event_jTEnderecoMouseClicked

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed

        if (jTEndereco.getSelectedRow() != -1) {

            Endereco e = new Endereco();
            EnderecoDAO dao = new EnderecoDAO();
            e.setLogradouro(txtLogradouro.getText());
            e.setComplemento(txtComplemento.getText());
            e.setBairro(txtBairro.getText());
            e.setNumero(txtNumero.getText());
            e.setCep(txtCep.getText());
            e.setIdEndereco((int)jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 0));
            dao.update(e);

            txtLogradouro.setText("");
            txtComplemento.setText("");
            txtBairro.setText("");
            txtNumero.setText("");
            txtCep.setText("");

            readJTable();

        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        
        if (jTEndereco.getSelectedRow() != -1) {

            Endereco e = new Endereco();
            EnderecoDAO dao = new EnderecoDAO();

            e.setIdEndereco((int) jTEndereco.getValueAt(jTEndereco.getSelectedRow(), 0));
            
            dao.delete(e);

            txtLogradouro.setText("");
            txtComplemento.setText("");
            txtBairro.setText("");
            txtNumero.setText("");
            txtCep.setText("");

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para deletar.");
        }
        
        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
         
        readJTableForEndereco(txtBusca.getText());
        
        
        
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEndereco;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JLabel jblCep;
    private javax.swing.JLabel jblComplemento;
    private javax.swing.JLabel jblNumero;
    private javax.swing.JLabel jlbBairro;
    private javax.swing.JLabel jlbBusca;
    private javax.swing.JLabel jlbLogradouro;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
