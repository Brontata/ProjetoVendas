package view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Util {

    public void limpaTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }

    public void habilitaComponentes(boolean hab, JComponent container) {
        for (Component jcomp : container.getComponents()) {
            jcomp.setEnabled(hab);
        }
    }

    public void limpaCampos(JComponent container) {
        for (Component jcomp : container.getComponents()) {
            if (jcomp instanceof JTextField) {
                ((JTextField) jcomp).setText("");
            } else if (jcomp instanceof JTextArea) {
                ((JTextArea) jcomp).setText("");
            } else if (jcomp instanceof JComboBox) {
                if (((JComboBox) jcomp).getModel().getSize() > 0) {
                    ((JComboBox) jcomp).setSelectedIndex(0);
                }
            } else if (jcomp instanceof JFormattedTextField) {
                ((JFormattedTextField) jcomp).setValue("");
            } else if (jcomp instanceof JSpinner) {
                ((JSpinner) jcomp).setValue(0);
            }
        }
    }

    public void habilitaBotoes(boolean hab, JComponent container) {
        for (Component jcomp : container.getComponents()) {
            if (jcomp instanceof JButton) {
                jcomp.setEnabled(hab);
                /*
                 * Comparando o conteudo do atributo 'AccessibleName' do Objeto
                 * para descobrir se e´ o 'btnCancelar' ou 'btnGravar' eles
                 * devem ter seu valor alterado para permitir essa comparação.
                 */
                if ((jcomp.getAccessibleContext().getAccessibleName().equals("Cancelar"))) {
                    jcomp.setEnabled(!hab);
                }
                if ((jcomp.getAccessibleContext().getAccessibleName().equals("Gravar"))) {
                    jcomp.setEnabled(!hab);
                }
            }
        }
    }

    /**
     * Enumerador de Operação, para diferenciarmos se o Formulário está no modo
     * 'Editar' ou 'Gravar'
     */
    public static enum Operacao {

        /**
         * 'GRAVAR' vale 1 e 'EDITAR' vale 2
         */
        GRAVAR(1),
        /**
         * 'GRAVAR' vale 1 e 'EDITAR' vale 2
         */
        EDITAR(2);

        private final int valor;

        Operacao(int valorOpcao) {
            valor = valorOpcao;
        }

        public int getValor() {
            return valor;
        }
    }

}
