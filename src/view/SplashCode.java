package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author aluno
 */

public class SplashCode extends JWindow{
    
     private int duration;
     
    private int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        this.duration = duration * 1000;
    }
     
    public SplashCode(int duration){
        setDuration(duration);
        
    }
    public void showSplash(){
        
    JPanel content = (JPanel) getContentPane();
    content.setBackground(Color.white);
    
    int width = 500;
    int height = 300;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    
    int x = (screen.width - width) / 2;
    int y = (screen.height - height)/ 2;
    
        setBounds(x, y, width, height);
        
        JLabel label = new JLabel (new ImageIcon("src/imagens/loading.gif"));
        JLabel copyrt = new JLabel("Aguarde...", JLabel.CENTER);
        label.setSize(x / 2, y / 2);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color cinzinha = new Color (238, 233, 233, 255);
        content.setBorder(BorderFactory.createLineBorder(cinzinha, 5));
        
        setVisible(true);
        
        try {
            Thread.sleep (getDuration());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorre um erro: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(false);
    }
    public void showSplashAndExit() throws Exception {
        
    showSplash();
    
    
    FrmMenu frmMenu = new FrmMenu();
    
        try {
            frmMenu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE );
      throw e;
        }
        
        this.dispose();
    }

}
