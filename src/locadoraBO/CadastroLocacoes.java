/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraBO;

import java.util.ArrayList;
import locadoraMODELO.*;
import java.util.List;
import java.util.logging.Level;
import locadoraDAO.*;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author taynara.santos
 */
public class CadastroLocacoes extends javax.swing.JFrame {

    /**
     * Creates new form CadastroAtendimento
     *
     */
    public CadastroLocacoes() throws Exception {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) Locacoes1.getModel();
        Locacoes1.setRowSorter(new TableRowSorter(modelo));

        lerAtendimento();
        gamesDisponiveis();
        listarGamess();
        tornarNaoEditavel();
        idLocacao.setEditable(false);
        botaoAlterar.setEnabled(false);
        botaoSalvar.setEnabled(false);
    }

    public void excluirLocacao(int id) throws Exception {

        List<Gen> teste = new ArrayList<>();
        teste = GenDAO.gameDaLocacaoJoin(id);

        for (Gen t : teste) {
            GameDAO.updateSituacaoparaDisponivel(t.getId_game());
        }

        LocacaoDAO.excluirLocacao(id);
    }

    public void lerGenero() throws Exception {

        DefaultTableModel modelo = (DefaultTableModel) gamesLocacao.getModel();
        modelo.setNumRows(0);

        gamesLocacao.setRowSorter(new TableRowSorter(modelo));

        GeneroDAO med = new GeneroDAO() {
        };

        for (Genero m : med.getAll()) {
            modelo.addRow(new Object[]{
                m.getIdGenero(),
                m.getDescricao()});

        }

    }

    public void exibirGamesPorLocacao(int g) throws Exception {

        idLocacao.setText(Integer.toString(g));

        DefaultTableModel modelo1 = (DefaultTableModel) gamesLocacao.getModel();
        modelo1.setNumRows(0);
        gamesLocacao.setRowSorter(new TableRowSorter(modelo1));

        for (Gen t : GenDAO.gameDaLocacaoJoin(g)) {
            modelo1.addRow(new Object[]{
                t.getId_game(),
                t.getTitulo(),
                t.getDescricao()});
        }

        Locacoes s = new Locacoes();

        s = (Locacoes) LocacaoDAO.getAllComGames(g).get(0);

        telefone.setText(s.getTelefone());
        dtDevolucao.setText(s.getDtDevolucao());
        dtLocacao.setText(s.getDtLocacao());
        nomeCliente.setText(s.getNomeCliente());
        valor.setText(Float.toString(s.getValor()));

    }

    public void campos() throws Exception {

        Locacoes s = new Locacoes();

        s = (Locacoes) LocacaoDAO.getAll().get(0);

        valor.setText(Float.toString(s.getValor()));
        telefone.setText(s.getTelefone());
        dtDevolucao.setText(s.getDtDevolucao());
        dtLocacao.setText(s.getDtLocacao());

    }

    public void lerAtendimento() throws Exception {

        DefaultTableModel modelo = (DefaultTableModel) Locacoes1.getModel();
        modelo.setNumRows(0);
        Locacoes1.setRowSorter(new TableRowSorter(modelo));

        for (Locacoes m : LocacaoDAO.getAll()) {
            modelo.addRow(new Object[]{
                m.getIdLocacao(),
                m.getNomeCliente(),
                m.getTelefone(),
                m.getDtLocacao(),
                m.getDtDevolucao()

            });

        }
    }

    public void limparcampos() {

        valor.setText("");
        nomeCliente.setText("");
        idLocacao.setText("");
        telefone.setText("");
        dtLocacao.setText("");
        dtDevolucao.setText("");

    }

    public void dadosConsultaAtendimento(String atendimento) {

        DefaultTableModel modelo = (DefaultTableModel) gamesLocacao.getModel();
        modelo.setNumRows(0);

        for (Locacoes atd : LocacaoDAO.buscaLocacoesporId(atendimento)) {
            modelo.addRow(new Object[]{
                atd.getIdLocacao(),
                atd.getNomeCliente(),
                atd.getIdGame()
            });
        }
    }

    private void tornarNaoEditavel() {

        valor.setEditable(false);
        nomeCliente.setEditable(false);
        telefone.setEditable(false);
        dtLocacao.setEditable(false);
        dtDevolucao.setEditable(false);

    }

    public void gamesDisponiveis() throws Exception {

        DefaultTableModel modelo = (DefaultTableModel) gamesLocacao.getModel();
        modelo.setNumRows(0);
        gamesLocacao.setRowSorter(new TableRowSorter(modelo));

        for (Gen m : GenDAO.gamesDisponiveis()) {
            modelo.addRow(new Object[]{
                m.getId_game(),
                m.getTitulo(),
                m.getDescricao()

            });

        }

    }

    private void listarGamess() throws Exception {

        List<Game> todosGames;
        todosGames = GameDAO.getAll();

        todosGames.forEach((s) -> {
        });

    }

    private void tornarEditavel() {

        valor.setEditable(true);
        nomeCliente.setEditable(true);
        telefone.setEditable(true);
        dtLocacao.setEditable(true);
        dtDevolucao.setEditable(true);

    }

    // public void incluirAtendimento() throws Exception GeneroDAO
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idLocacao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        nomeCliente = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtDevolucao = new javax.swing.JFormattedTextField();
        dtLocacao = new javax.swing.JFormattedTextField();
        botaoSair = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gamesLocacao = new javax.swing.JTable();
        botaoIncluir = new javax.swing.JButton();
        botaoSelecionar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        botaoExcluir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Locacoes1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        jLabel1.setText("Código Locação:");

        jLabel2.setText("Cliente");

        jLabel3.setText("Telefone: ");

        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });

        jLabel4.setText("Dt. Loc");

        jLabel5.setText("Dt. Dev");

        try {
            dtDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dtDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtDevolucaoActionPerformed(evt);
            }
        });

        try {
            dtLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dtLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtLocacaoActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LOCAÇÕES");

        gamesLocacao.setAutoCreateRowSorter(true);
        gamesLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Game", "Título", "Gênero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gamesLocacao.setColumnSelectionAllowed(true);
        gamesLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gamesLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gamesLocacaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gamesLocacao);
        gamesLocacao.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        botaoIncluir.setText("Nova");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });

        botaoSelecionar.setText("Visualizar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor:");

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        Locacoes1.setAutoCreateRowSorter(true);
        Locacoes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Telefone", "Data Locação", "Data Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Locacoes1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Locacoes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Locacoes1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Locacoes1);
        Locacoes1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Locacoes1.getColumnModel().getColumnCount() > 0) {
            Locacoes1.getColumnModel().getColumn(3).setResizable(false);
        }

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(120, 120, 120))
                                    .addComponent(dtDevolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSelecionar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoIncluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoAlterar)
                            .addComponent(botaoSalvar)
                            .addComponent(botaoExcluir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dtDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dtDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtDevolucaoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void dtLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtLocacaoActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        // TODO add your handling code here:

        try {

            botaoSalvar.setEnabled(true);
            botaoIncluir.setEnabled(false);
            botaoSelecionar.setEnabled(false);

            tornarEditavel();
            idLocacao.setEditable(false);
            botaoAlterar.setEnabled(false);
            botaoSalvar.setEnabled(false);

        } catch (Exception ex) {
            Logger.getLogger(CadastroGenero.class.getName()).log(Level.SEVERE, null, ex);
        }

        botaoAlterar.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoSelecionar.setEnabled(true);


    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void gamesLocacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamesLocacaoMouseClicked

    }//GEN-LAST:event_gamesLocacaoMouseClicked

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        try {

            this.dispose();
            // TODO add your handling code here:

            detalheLocacao locar = new detalheLocacao();
            locar.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(CadastroLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed

        botaoAlterar.setEnabled(true);
        GeneroDAO g = new GeneroDAO();
        int pegarCod, j;
        String s = null;
        String xx;

        pegarCod = Locacoes1.getSelectedRow();

        s = Integer.toString(pegarCod);
        j = (int) Locacoes1.getValueAt(pegarCod, 0);

        xx = Integer.toString(j);

        try {

            exibirGamesPorLocacao(j);

        } catch (Exception ex) {
            Logger.getLogger(CadastroLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botaoSelecionarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // TODO add your handling code here:

        try {

            Locacoes atend = new Locacoes();
            atend.setDtLocacao(dtLocacao.getText());
            atend.setDtDevolucao(dtDevolucao.getText());
            atend.setNomeCliente(nomeCliente.getText());
            atend.setValor(Float.parseFloat(valor.getText()));

            atend.setTelefone(telefone.getText());
            atend.setIdLocacao(Integer.parseInt(idLocacao.getText()));
            LocacaoDAO.alterarDadosAtendimento(atend);

            lerAtendimento();
            listarGamess();
            gamesDisponiveis();
        } catch (Exception ex) {
            Logger.getLogger(CadastroLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        botaoSalvar.setEnabled(false);
        limparcampos();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        // TODO add your handling code here:
        try {
            int pegarCod, j;
            String s = null;
            String xx;

            pegarCod = Locacoes1.getSelectedRow();

            s = Integer.toString(pegarCod);
            j = (int) Locacoes1.getValueAt(pegarCod, 0);

            xx = Integer.toString(j);

            excluirLocacao(j);
            limparcampos();
            lerAtendimento();
            gamesDisponiveis();
            listarGamess();

        } catch (Exception ex) {
            Logger.getLogger(CadastroLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void Locacoes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Locacoes1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Locacoes1MouseClicked

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
            java.util.logging.Logger.getLogger(CadastroLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroLocacoes().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroLocacoes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Locacoes1;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JFormattedTextField dtDevolucao;
    private javax.swing.JFormattedTextField dtLocacao;
    private javax.swing.JTable gamesLocacao;
    private javax.swing.JTextField idLocacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables

}
