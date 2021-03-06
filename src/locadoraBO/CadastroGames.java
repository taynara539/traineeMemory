/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraBO;

import java.util.List;
import locadoraMODELO.Game;
import locadoraDAO.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import locadoraDAO.GameDAO;
import locadoraMODELO.Genero;

/**
 *
 * @author taynara
 */
public class CadastroGames extends javax.swing.JFrame {

    /**
     * Creates new form CAdpac
     *
     * @throws java.lang.Exception
     */
    public CadastroGames() throws Exception {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) Games.getModel();
        Games.setRowSorter(new TableRowSorter(modelo));
        lerGame();
        listarGenero();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Games = new javax.swing.JTable();
        botaoSelecionar = new javax.swing.JButton();
        Sinopse = new javax.swing.JPanel();
        sinopse = new javax.swing.JTextField();
        idGames = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        qtdeJogadores = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        genero = new javax.swing.JTextField();
        listaGeneros = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        sit = new javax.swing.JComboBox<>();
        botaoSair = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoIncluir = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GAMES");

        Games.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Qtde Jogadores", "Gênero", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Games.setColumnSelectionAllowed(true);
        Games.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Games.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GamesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Games);
        Games.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

        Sinopse.setBorder(javax.swing.BorderFactory.createTitledBorder("Sinopse"));
        Sinopse.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                SinopseAncestorRemoved(evt);
            }
        });

        sinopse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinopseActionPerformed(evt);
            }
        });

        idGames.setEditable(false);
        idGames.setBorder(null);
        idGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idGamesActionPerformed(evt);
            }
        });

        jLabel4.setText("ID");

        jLabel5.setText("Título");

        jLabel6.setText("Qtde Jogadores:");

        jLabel8.setText("Gênero:");

        genero.setEditable(false);

        listaGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar..." }));
        listaGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaGenerosActionPerformed(evt);
            }
        });

        jLabel9.setText("Situação:");

        sit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONÍVEL", "LOCADO" }));
        sit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SinopseLayout = new javax.swing.GroupLayout(Sinopse);
        Sinopse.setLayout(SinopseLayout);
        SinopseLayout.setHorizontalGroup(
            SinopseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SinopseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SinopseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sinopse)
                    .addGroup(SinopseLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idGames, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtdeJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SinopseLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listaGeneros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        SinopseLayout.setVerticalGroup(
            SinopseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SinopseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SinopseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdeJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SinopseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(sit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(sinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.setEnabled(false);
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.setEnabled(false);
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.setEnabled(false);
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoIncluir.setText("Incluir");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Sinopse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(375, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSalvar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botaoLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSelecionar)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sinopse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoSair)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoIncluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7)
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tornarNaoEditavel() throws Exception {

        sinopse.setEditable(false);
        idGames.setEditable(false);
        qtdeJogadores.setEditable(false);
        genero.setEditable(false);
        titulo.setEditable(false);

    }

    public void dadosConsultaGame(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) Games.getModel();
        modelo.setNumRows(0);
        Games.setRowSorter(new TableRowSorter(modelo));

        for (Game m : GameDAO.buscarGameporNome(nome)) {
            modelo.addRow(new Object[]{
                m.getIdGame(),
                m.getTitulo(),});
            m.getSituacao();

        }
    }

    private void listarGenero() throws Exception {

        List<Genero> todosGeneros;
        todosGeneros = GeneroDAO.getAll();
        todosGeneros.forEach((s) -> {
            listaGeneros.addItem(s.getDescricao());

        });

    }

    private void selecionar() {

        try {
            tornarNaoEditavel();

        } catch (Exception ex) {
            Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            tornarNaoEditavel();

        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        int pegarCod, j;
        String s = null;
        String xx;
        Game med;

        try {
            pegarCod = Games.getSelectedRow();

            s = Integer.toString(pegarCod);
            j = (int) Games.getValueAt(pegarCod, 0);

            xx = Integer.toString(j);
            med = GameDAO.retTabGamePeloId(xx);

            String g = GeneroDAO.descricaoGenero(med.getIdGenero());

            sinopse.setText(med.getSinopse());
            idGames.setText(Integer.toString(med.getIdGame()));
            titulo.setText(med.getTitulo());
            qtdeJogadores.setText(Integer.toString(med.getQtdeJogador()));
            genero.setText(Integer.toString(med.getIdGenero()));
            sit.setSelectedItem(med.getSituacao());

            listaGeneros.setSelectedItem(g);

        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void tornarEditavel() throws Exception {

        sinopse.setEditable(true);
        idGames.setEditable(true);
        qtdeJogadores.setEditable(true);
        genero.setEditable(true);
        titulo.setEditable(true);

    }

    public void limpaCampos() throws Exception {

        sinopse.setText("");
        idGames.setText("");
        qtdeJogadores.setText("");
        genero.setText("");
        titulo.setText("");
        listaGeneros.setSelectedIndex(0);
        sit.setSelectedIndex(0);

    }

    private void atualizarGame(Game game) throws Exception {

        try {

            GameDAO.updateGamePorIdGame(game);

            lerGame();

        } catch (Exception e) {

            JOptionPane.showInputDialog("\nErro ao cadastrar Game \n" + e);
        }

    }

    public void lerGame() throws Exception {

        DefaultTableModel modelo = (DefaultTableModel) Games.getModel();
        modelo.setNumRows(0);
        Games.setRowSorter(new TableRowSorter(modelo));

        for (Game m : GameDAO.getAll()) {
            modelo.addRow(new Object[]{
                m.getIdGame(),
                m.getTitulo(),
                m.getQtdeJogador(),
                m.getIdGenero(),
                m.getSituacao()

            });

        }
    }

    private void excluirGame() throws Exception {

        int idDoGame = 0;
        String textoDeId;
        String situacao;
        String locado = "LOCADO";
        String disponivel = "DISPONÍVEL";

        textoDeId = idGames.getText();
        idDoGame = Integer.parseInt(textoDeId);

        situacao = (String) sit.getSelectedItem();

        if (situacao == locado) {

            JOptionPane.showMessageDialog(null, "Game Locado! Impossível excluir ");

        } else {

            GameDAO.excluirGame(idDoGame);
            lerGame();
            limpaCampos();

        }

    }

    private void cadastrarGame() throws Exception {

        try {

            String espec;
            int especia;

            Game gamm = new Game();

            espec = (String) (listaGeneros.getSelectedItem());
            especia = GeneroDAO.retornaIdGenero(espec);

            gamm.setIdGenero(especia);
            gamm.setQtdeJogador(Integer.parseInt(qtdeJogadores.getText()));
            gamm.setSinopse(sinopse.getText());
            gamm.setTitulo(titulo.getText());
            gamm.setSituacao(sit.getSelectedItem().toString());
            GameDAO.incluirGame(gamm);

            lerGame();

        } catch (Exception e) {

            JOptionPane.showInputDialog("\nErro ao Incluir Game \n" + e);
        }

    }
    private void GamesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GamesMouseClicked

    }//GEN-LAST:event_GamesMouseClicked


    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed
        // TODO add your handling code here:

        botaoLimpar.setEnabled(true);
        botaoSalvar.setEnabled(true);
        botaoIncluir.setEnabled(false);
        botaoAlterar.setEnabled(true);
        botaoExcluir.setEnabled(true);

        try {
            selecionar();
            lerGame();
        } catch (Exception ex) {
            Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoSelecionarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        try {
            int g;
            listaGeneros.getSelectedItem();
            g = GeneroDAO.retornaIdGenero((String) listaGeneros.getSelectedItem());
            Game game = new Game();

            game.setSinopse(sinopse.getText());
            game.setIdGame(Integer.parseInt(idGames.getText()));

            game.setIdGenero(g);
            game.setQtdeJogador(Integer.parseInt(qtdeJogadores.getText()));
            game.setTitulo(titulo.getText());
            game.setSituacao((String) sit.getSelectedItem());

            atualizarGame(game);

        } catch (Exception ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed

        try {

            limpaCampos();

        } catch (Exception ex) {
            Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        try {

            tornarEditavel();
            idGames.setEditable(false);
            botaoLimpar.setEnabled(false);
            genero.setEditable(false);
            genero.setVisible(false);
            listaGeneros.setEditable(false);

        } catch (Exception ex) {
            Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);
        }

        botaoAlterar.setEnabled(true);


    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed

        try {

            cadastrarGame();
            limpaCampos();

        } catch (Exception ex) {
            Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void SinopseAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SinopseAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_SinopseAncestorRemoved

    private void idGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idGamesActionPerformed
        // TODO add your handling code here:
        //idMedico.setText(receberMedicoSelecionado.toString());
    }//GEN-LAST:event_idGamesActionPerformed

    private void sinopseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinopseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sinopseActionPerformed

    private void listaGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaGenerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaGenerosActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        try {
            // TODO add your handling code here:

            excluirGame();

        } catch (Exception ex) {
            Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void sitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sitActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroGames().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroGames.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Games;
    private javax.swing.JPanel Sinopse;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JTextField genero;
    private javax.swing.JTextField idGames;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Object> listaGeneros;
    private javax.swing.JTextField qtdeJogadores;
    private javax.swing.JTextField sinopse;
    private javax.swing.JComboBox<String> sit;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
