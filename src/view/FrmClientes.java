package view;
//Os imports são inclusos automaticamente

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import dao.DaoCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Clientes;

public class FrmClientes extends javax.swing.JInternalFrame {
    // Os MaskFormatter foram declarados aqui para que possam ser utilizados enquanto o formulário estiver na memória.

    MaskFormatter mfTel;
    MaskFormatter mfCep;
    MaskFormatter mfUf;
    MaskFormatter mfData;
    boolean gravar = false;
    boolean editar = false;
    static boolean visible = false;

    public static boolean getVis() {
        return visible;
    }

    public void setVis(boolean v) {
        visible = v;
    }

    public FrmClientes() {
        try {
            // Método abaixo já vem pré-digitado no construtor e está escondido abaixo, pois foi gerado pelo editor gráfico
            initComponents();
            //Instaceamento dos MaskFormatter
            mfUf = new MaskFormatter("UU");
            mfUf.setPlaceholderCharacter('_');
            mfUf.setValueContainsLiteralCharacters(false);
            mfUf.setValueClass(String.class);
            DefaultFormatterFactory dffUf = new DefaultFormatterFactory(mfUf);
            txtUF.setFormatterFactory(dffUf);

            mfCep = new MaskFormatter("#####-###");
            mfCep.setPlaceholderCharacter('_');
            mfCep.setValueContainsLiteralCharacters(false);
            mfCep.setValueClass(String.class);
            DefaultFormatterFactory dffCep = new DefaultFormatterFactory(mfCep);
            txtCep.setFormatterFactory(dffCep);

            mfTel = new MaskFormatter("(##)#####-####");
            mfTel.setPlaceholderCharacter('_');
            //mfTel.setValidCharacters("1234567");
            mfTel.setValueContainsLiteralCharacters(false);
            mfTel.setValueClass(String.class);
            DefaultFormatterFactory dffTel = new DefaultFormatterFactory(mfTel);
            txtTelefone.setFormatterFactory(dffTel);

            mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            mfData.setValueContainsLiteralCharacters(true);
            mfData.setValueClass(String.class);
            DefaultFormatterFactory dffData = new DefaultFormatterFactory(mfData);
            txtDataNasc.setFormatterFactory(dffData);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um ParseException na aplicação do MaskFormatter: " + ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
        DaoCliente c = new DaoCliente();
        String nome = "";
        c.setNome(nome);
        try {
            ArrayList<DaoCliente> listaClientes = c.pesquisar(c);
            atualizaTable(listaClientes);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro no DB: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro de classe: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        pnlBotoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlCampos = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        pnlCamposMsk = new javax.swing.JPanel();
        txtUF = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtDataNasc = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Cidade", "Bairro", "UF", "CEP", "Telefone", "Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.getTableHeader().setResizingAllowed(false);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setResizable(false);
        }

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIncluir)
                .addGap(109, 109, 109)
                .addComponent(btnAlterar)
                .addGap(109, 109, 109)
                .addComponent(btnExcluir)
                .addGap(109, 109, 109)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnGravar)
                .addGap(109, 109, 109)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGravar)
                        .addComponent(btnCancelar))
                    .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar)
                        .addComponent(btnPesquisar)
                        .addComponent(btnExcluir)
                        .addComponent(btnIncluir)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        txtCodigo.setEnabled(false);

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        txtNome.setEnabled(false);

        txtEndereco.setEnabled(false);

        jLabel3.setText("Endereço:");

        jLabel4.setText("Cidade:");

        jLabel5.setText("Bairro:");

        txtCidade.setEnabled(false);

        txtBairro.setEnabled(false);

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        txtUF.setEnabled(false);

        txtCep.setEnabled(false);

        jLabel6.setText("UF:");

        jLabel7.setText("CEP:");

        txtTelefone.setEnabled(false);

        txtDataNasc.setEnabled(false);

        jLabel8.setText("Telefone:");

        jLabel9.setText("Nascimento:");

        javax.swing.GroupLayout pnlCamposMskLayout = new javax.swing.GroupLayout(pnlCamposMsk);
        pnlCamposMsk.setLayout(pnlCamposMskLayout);
        pnlCamposMskLayout.setHorizontalGroup(
            pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposMskLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCep))
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        pnlCamposMskLayout.setVerticalGroup(
            pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposMskLayout.createSequentialGroup()
                .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(pnlCamposMskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCamposMsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(pnlCamposMsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        try {
            if (tblClientes.getSelectedRow() >= 0) {
                Object[] options = {"Sim", "Não"};
                if ((JOptionPane.showOptionDialog(this, "Deseja mesmo APAGAR o cliente selecionado?", "Aviso:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1])) == JOptionPane.YES_OPTION) {
                    DaoCliente c = new DaoCliente();
                    c.setCodCli(Integer.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString()));
                    c.setCodCli(c.getCodCli());
                    c.excluir();
                    c.excluir();
                    if (c.excluir()) {
                        JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!", "Exclusão:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    formWindowOpened(null);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Selecione o cliente primeiro!", "Aviso:", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        habilitaBotoes(false);
        habilitaCampos(true);
        limpaCampos();
        txtCodigo.setEnabled(false);
        txtCodigo.requestFocus();
        gravar = true;
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        try {
            //Novo DaoCliente para armazenar os dados que serão Gravados/Alterados
            DaoCliente dcli = new DaoCliente();
            //O sdf declarado abaixo será usado para converter a data de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //Preenchendo o dcli (DaoCliente) com os dados
            try {
                try {

                    dcli.setCodCli(Integer.valueOf(txtCodigo.getText()));
                } catch (Exception e) {
                }
                dcli.setNome(txtNome.getText());
                dcli.setEndereco(txtEndereco.getText());
                dcli.setCidade(txtCidade.getText());
                dcli.setBairro(txtBairro.getText());
                dcli.setUf(txtUF.getValue().toString());
                dcli.setCep(txtCep.getValue().toString());
                dcli.setTelefone(txtTelefone.getValue().toString());
                dcli.setDataNasc(sdf.parse(txtDataNasc.getText()));
            } catch (Exception e) {
            }
            //Caso o usuário escolheu Incluir
            if (gravar) {
                dcli.incluir();
            }
            //Caso o usuário escolheu Alterar
            if (editar) {
                dcli.alterar();
            }
            //Voltando o formulário para o padrão
            habilitaBotoes(true);
            habilitaCampos(false);
            gravar = false;
            editar = false;
            limpaCampos();
            //Atualizando o JTable
            formWindowOpened(null);
            // Tratando possiveis exceções 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro no Banco de Dados: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar o driver do BD: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        habilitaBotoes(false);
        habilitaCampos(true);
        limpaCampos();
        txtCodigo.setEnabled(false);
        txtNome.requestFocus();
        editar = true;
        try {
            //Verifica se tem clientes no grid
            if (tblClientes.getRowCount() > 0) {
                //linha selecionada no JTable
                int posLinha = tblClientes.getSelectedRow();
                //Verificando se alinha foi selecionada, caso 'true' pega os dados da respectiva liha e envia para os campos
                if (posLinha >= 0) {
                    txtCodigo.setText(tblClientes.getValueAt(posLinha, 0).toString());
                    txtNome.setText(tblClientes.getValueAt(posLinha, 1).toString());
                    txtEndereco.setText(tblClientes.getValueAt(posLinha, 2).toString());
                    txtCidade.setText(tblClientes.getValueAt(posLinha, 3).toString());
                    txtBairro.setText(tblClientes.getValueAt(posLinha, 4).toString());
                    //Os Campos abaixo são JFormattedTextField, por isso usaremos setValue()
                    txtUF.setValue(tblClientes.getValueAt(posLinha, 5).toString());
                    if (tblClientes.getValueAt(posLinha, 6).toString().equals("#####-###")) {
                        txtCep.setValue("");
                    } else {
                        //Usamos o MaskFormatter abaixo para converter e 'textoParaValor' <--> stringToValue o dado do telefone, pois ele está formatado pelo mesmo.
                        txtCep.setValue(mfCep.stringToValue(tblClientes.getValueAt(posLinha, 6).toString()).toString());
                    }

                    //Vrificando se o campo Telefone no JTable está vazio
                    if (tblClientes.getValueAt(posLinha, 7).toString().equals("(__)_____-____")) {
                        txtTelefone.setValue("");
                    } else {
                        //Usamos o MaskFormatter abaixo para converter e 'textoParaValor' <--> stringToValue o dado do telefone, pois ele está formatado pelo mesmo.
                        txtTelefone.setValue(mfTel.stringToValue(tblClientes.getValueAt(posLinha, 7).toString()).toString());
                    }
                    txtDataNasc.setValue(tblClientes.getValueAt(posLinha, 8).toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente para alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
                    btnCancelarActionPerformed(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não há clientes cadastrados ainda!", "Erro:", JOptionPane.ERROR_MESSAGE);
                btnCancelarActionPerformed(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitaBotoes(true);
        habilitaCampos(false);
        limpaCampos();
        gravar = false;
        editar = false;
        formWindowOpened(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        DaoCliente c = new DaoCliente();
        try {

            String nome = JOptionPane.showInputDialog(this, "Informe o nome do cliente ou parte dele:", "Pesquisar", JOptionPane.QUESTION_MESSAGE);
            if (nome != null) {
                c.setNome(nome);
                

                btnCancelar.setEnabled(true);
                
                if (c.pesquisar(c).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O cliente não foi encontrado", "Erro:", JOptionPane.ERROR_MESSAGE);
                } else {
                    atualizaTable(c.pesquisar(c));
                    tblClientes.setRowSelectionInterval(0, 0);

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro no DB: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro de classe: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            Object[] btn = {"  Sim  ", "  Não  "};
            if (JOptionPane.showOptionDialog(this, "Deseja mesmo sair?", "Aviso:",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, //new ImageIcon("") ,
                    btn, btn[1]) == JOptionPane.YES_OPTION) {
                //Encerra a JVM atual e consequentemente o sistema nela rodando
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro:\n" + e.getMessage(), "Erro no encerramento:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmClientes().setVisible(true);
            }
        });
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        //Carregando os dados na iniialização do formulário.
        //Modo similar ao do btnPesquisar
        DaoCliente c = new DaoCliente();
        c.setNome("");
        ArrayList<DaoCliente> ListaClientes;
        try {
            ListaClientes = c.pesquisar(c);
            atualizaTable(ListaClientes);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no DB: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de classe: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpaTable() {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void atualizaTable(ArrayList<DaoCliente> clientes) {
        //Limpando os dados da Tabela
        limpaTable();
        //Objeto para formatar Datas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foram encontrados clientes no banco de dados.", "Atenção:", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //Modelo de Tabela para popular tblClientes (JTable)
            DefaultTableModel dadosClientes = (DefaultTableModel) tblClientes.getModel();
            //Linha em branco para incluir na tabela e criar espaço para inserir dados
            String Linha[] = new String[]{"", "", "", "", "", "", "", "", ""};
            try {
                //Criado como referencia para posição da linha
                int posicao = -1;
                for (DaoCliente cliente : clientes) {
                    posicao++;
                    //incluindo linhas em branco
                    dadosClientes.addRow(Linha);
                    //preenchendo a linha em branco, celula e celula
                    dadosClientes.setValueAt(cliente.getCodCli(), posicao, 0);
                    dadosClientes.setValueAt(cliente.getNome(), posicao, 1);
                    dadosClientes.setValueAt(cliente.getEndereco(), posicao, 2);
                    dadosClientes.setValueAt(cliente.getCidade(), posicao, 3);
                    dadosClientes.setValueAt(cliente.getBairro(), posicao, 4);
                    dadosClientes.setValueAt(cliente.getUf().toUpperCase(), posicao, 5);
                    dadosClientes.setValueAt(mfCep.valueToString(cliente.getCep()), posicao, 6);
                    //Usando o MaskFormatter para formatar o dado do campo Telefone
                    dadosClientes.setValueAt(mfTel.valueToString(cliente.getTelefone()), posicao, 7);
                    //Usando o SimpleDateFormat para formatar o dado do campo DataNasc
                    dadosClientes.setValueAt(sdf.format(cliente.getDataNasc().getTime()), posicao, 8);
                }
                //Populando tblClientes (JTable) com dadosClientes já preenchida
                tblClientes.setModel(dadosClientes);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void habilitaBotoes(boolean hab) {
        btnIncluir.setEnabled(hab);
        btnAlterar.setEnabled(hab);
        btnExcluir.setEnabled(hab);
        btnPesquisar.setEnabled(hab);
        btnGravar.setEnabled(!hab);
        btnCancelar.setEnabled(!hab);
    }

    private void habilitaCampos(boolean hab) {
        txtCodigo.setEnabled(hab);
        txtNome.setEnabled(hab);
        txtEndereco.setEnabled(hab);
        txtCidade.setEnabled(hab);
        txtBairro.setEnabled(hab);
        txtUF.setEnabled(hab);
        txtCep.setEnabled(hab);
        txtTelefone.setEnabled(hab);
        txtDataNasc.setEnabled(hab);
    }

    private void limpaCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        //Os campos abaixo são JFormattedTextField, por isso usaremos setValue()
        txtUF.setValue("");
        txtCep.setValue("");
        txtTelefone.setValue("");
        txtDataNasc.setValue("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlCamposMsk;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
