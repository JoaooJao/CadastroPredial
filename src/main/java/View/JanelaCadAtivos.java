/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ClienteDAO;
import DAO.VeiculoDAO;
import estacionamento.Veiculo;
import estacionamento.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oakens
 */
public class JanelaCadAtivos extends javax.swing.JFrame {

    /**
     * Creates new form JanelaCadAtivos
     */
    private String modoAtual = ""; // "cliente" ou "veiculo"

    
    public JanelaCadAtivos() {
        initComponents();
        listarVeiculos();
    }

    private void configurarTabelaClientes() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"CPF", "NOME", "TELEFONE", "CIDADE"}, 0
        );
        jTable2.setModel(model);
    }

    private void configurarTabelaVeiculos() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"DONO (CPF)", "MARCA", "MODELO", "PLACA"}, 0
        );
        jTable2.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jTable2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DONO", "MARCA", "MODELO", "PLACA"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton1.setText("LISTAR V");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton2.setText("REMOVER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 51));
        jButton3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton3.setText("CADASTRAR C");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 255, 51));
        jButton4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton4.setText("CADASTRAR V");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 204, 204));
        jButton5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton5.setText("LISTAR C");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 204, 51));
        jButton6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton6.setText("EDITAR");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton3)
                        .addGap(5, 5, 5)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modoAtual = "veiculo";
        configurarTabelaVeiculos();
        listarVeiculos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int linhaSelecionada = jTable2.getSelectedRow();

if (linhaSelecionada < 0) {
    JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.");
    return;
}

if ("cliente".equals(modoAtual)) {
    String cpf = String.valueOf(jTable2.getValueAt(linhaSelecionada, 0));

    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Deseja realmente remover o cliente " + cpf + "?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.removerClientePorCpf(cpf);
        listarClientes();
    }

} else if ("veiculo".equals(modoAtual)) {
    String placa = String.valueOf(jTable2.getValueAt(linhaSelecionada, 3));

    int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Deseja realmente remover o veículo com placa " + placa + "?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION
    );

    if (confirmacao == JOptionPane.YES_OPTION) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.removerVeiculoPorPlaca(placa);
        listarVeiculos();
    }

} else {
    JOptionPane.showMessageDialog(this, "Modo de visualização desconhecido.");
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JanelaCadCliente objJanelaCadastro = new JanelaCadCliente();
        objJanelaCadastro.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JanelaCadVeiculo objJanelaCadVeiculo = new JanelaCadVeiculo();
        objJanelaCadVeiculo.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        modoAtual = "cliente";
        configurarTabelaClientes();
        listarClientes();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
int linha = jTable2.getSelectedRow();

if (linha < 0) {
    JOptionPane.showMessageDialog(this, "Selecione uma linha.");
    return;
}

if ("cliente".equals(modoAtual)) {
    String cpf = String.valueOf(jTable2.getValueAt(linha, 0));
    Cliente cliente = new ClienteDAO().buscarClientePorCpf(cpf);

    if (cliente != null) {
        JanelaCadCliente tela = new JanelaCadCliente();
        tela.carregarCliente(cliente);
        tela.setVisible(true);
    }
} else if ("veiculo".equals(modoAtual)) {
    String placa = String.valueOf(jTable2.getValueAt(linha, 3));
    Veiculo veiculo = new VeiculoDAO().buscarVeiculoPorPlaca(placa);

    if (veiculo != null) {
        JanelaCadVeiculo tela = new JanelaCadVeiculo();
        tela.carregarVeiculo(veiculo);
        tela.setVisible(true);
    }
}

    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadAtivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaCadAtivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    private void listarVeiculos() {
        try {
            VeiculoDAO objVeiculoDAO = new VeiculoDAO();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setNumRows(0);

            List<Veiculo> listaVeiculo = objVeiculoDAO.listaVeiculo();

            for (Veiculo veiculo : listaVeiculo) {
                model.addRow(new Object[]{
                    veiculo.getCpfCliente(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getPlaca()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar veículos: " + e.getMessage());
        }
    }

    private void listarClientes() {
        try {
            ClienteDAO objClienteDAO = new ClienteDAO();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setNumRows(0);

            List<Cliente> listaClientes = objClienteDAO.listarClientes();

            for (Cliente cliente : listaClientes) {
                model.addRow(new Object[]{
                    cliente.getCpf(),
                    cliente.getNome(),
                    cliente.getTelefone(),
                    cliente.getCidade()  
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar clientes: " + e.getMessage());
        }
    }
}
