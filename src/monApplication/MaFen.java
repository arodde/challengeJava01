package monApplication;

import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaFen extends JFrame {

    public JPanel mainPanel = new JPanel();
    public JPanel interact = new JPanel();
    public JPanel result = new JPanel();
    public JEditorPane jEditorPaneCity = new JEditorPane();
    public JButton jbuttonAskWeatherInformations = new JButton("Demander informations météo");
    public static void main(String[] args){
        MaFen mafen = new MaFen();
    }
    public MaFen(){
        Uti.info("MaFen","MaFen()","");

        this.setTitle("Affichage Météo par ville");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

// add borderLayout in mainPanel
        BorderLayout borderLayout = new BorderLayout();
        mainPanel.setBackground(Color.white);
        mainPanel.add(interact,BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(result),BorderLayout.CENTER);
        result.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-50));
        result.setBackground(Color.red);
        interact.setPreferredSize(new Dimension(this.getWidth(), 50));
        interact.add(jEditorPaneCity,BorderLayout.EAST);
        interact.setBackground(Color.gray);
        interact.add(jbuttonAskWeatherInformations,BorderLayout.WEST);

        // display the window
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    class AskApi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // check the text in jEditorPaneCity
            // if it's different of "" or null
            //      check internet connection
            //      if connection ok
            //          create thread
            //          stock recept data
            //      else
            //          display message "Une connexion internet est requise"
        }
    }
}
