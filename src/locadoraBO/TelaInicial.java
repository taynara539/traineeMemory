/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraBO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taynara.santos
 */
public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        cadastros = new javax.swing.JMenu();
        cadsGame = new javax.swing.JMenuItem();
        cadsGeneros = new javax.swing.JMenuItem();
        locacoes = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();
        sobre = new javax.swing.JMenu();
        informacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setText("Menu");

        cadastros.setText("Cadastros");

        cadsGame.setText("Games");
        cadsGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadsGameActionPerformed(evt);
            }
        });
        cadastros.add(cadsGame);
        cadsGame.getAccessibleContext().setAccessibleParent(cadsGame);

        cadsGeneros.setText("Gêneros");
        cadsGeneros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadsGenerosMouseClicked(evt);
            }
        });
        cadsGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadsGenerosActionPerformed(evt);
            }
        });
        cadastros.add(cadsGeneros);

        menu.add(cadastros);

        locacoes.setText("Locações");
        locacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locacoesActionPerformed(evt);
            }
        });
        menu.add(locacoes);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        menu.add(sair);

        jMenuBar1.add(menu);

        sobre.setText("Sobre");

        informacao.setText("Informações");
        informacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacaoActionPerformed(evt);
            }
        });
        sobre.add(informacao);

        jMenuBar1.add(sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void informacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacaoActionPerformed
        // TODO add your handling code here:

        TelaInformações sobre = new TelaInformações();
        sobre.setVisible(true);

    }//GEN-LAST:event_informacaoActionPerformed

    private void cadsGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadsGameActionPerformed

        System.out.println("\nIniciando Games!");

        try {

            CadastroGames cad = new CadastroGames();
            cad.setVisible(true);
        } catch (Exception ex) {

            System.out.println("\nErro ao iniciar cadastro Game.\n" + ex);

        }


    }//GEN-LAST:event_cadsGameActionPerformed

    private void cadsGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadsGenerosActionPerformed
        // TODO add your handling code here:

        System.out.println("\nIniciando Gênero!");

        try {

            CadastroGenero cadastroGenero = new CadastroGenero();

            cadastroGenero.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cadsGenerosActionPerformed


    private void locacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locacoesActionPerformed
        // TODO add your handling code here:

        System.out.println("\nIniciando Locações!");

        try {

            CadastroLocacoes cadastroLocacoes = new CadastroLocacoes();
            cadastroLocacoes.setVisible(true);

        } catch (Exception ex) {

            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_locacoesActionPerformed

    private void cadsGenerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadsGenerosMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cadsGenerosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cadastros;
    private javax.swing.JMenuItem cadsGame;
    private javax.swing.JMenuItem cadsGeneros;
    private javax.swing.JMenuItem informacao;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem locacoes;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenu sobre;
    // End of variables declaration//GEN-END:variables
}