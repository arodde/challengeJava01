package monApplication.research;

import javax.swing.*;
import java.awt.*;

public class JTableExample extends JFrame {
    public JPanel jPanel = new JPanel();
    public JPanel jPanel2 = new JPanel();
    public JTableExample(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JTableExample.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setSize(300, 120);
        this.getContentPane().add(jPanel);
        jPanel.add(jPanel2);
        jPanel.setBackground(Color.blue);
        jPanel2.setBackground(Color.red);
        //Les données du tableau
        Object[][] data = {
                {"Cysboy", "28 ans", "1.80 m"},
                {"BZHHydde", "28 ans", "1.80 m"},
                {"IamBow", "24 ans", "1.90 m"},
                {"FunMan", "32 ans", "1.85 m"}
        };

        //Les titres des colonnes
        String  title[] = {"Pseudo", "Age", "Taille"};
        JTable tableau = new JTable(data, title);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        jPanel2.add(new JScrollPane(tableau));
    }

    public static void main(String[] args){
        JTableExample fen = new JTableExample();
        fen.setVisible(true);
    }
}


