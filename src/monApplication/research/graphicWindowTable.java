package monApplication.research;

import monApplication.classApi.City;

import javax.swing.*;
import java.awt.*;

public class graphicWindowTable extends JFrame {

public void dataPreparation(City city,String[][] t2Dim){
    /**
     * fill the table used for gives data to table of objects data
     */
    String[]cityField= {"insee","name","cp","latitude","longitude","altitude"};

    for(int i = 0; i<t2Dim.length;i++){
        t2Dim[i][0] = cityField[i];
    }

    //
    t2Dim[0][1]= city.insee;
    t2Dim[1][1]= city.name;
    t2Dim[2][1]= String.valueOf(city.cp);
    t2Dim[3][1]= String.valueOf(city.latitude);
    t2Dim[4][1]= String.valueOf(city.longitude);
    t2Dim[5][1]= String.valueOf(city.altitude);
    //
}
    public graphicWindowTable(){
        /**
         * gives the description of an object in a table
         * displayed in a frame
         */
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTable");
        this.setResizable(false);
        this.setSize(300, 140);
        double tt= 1.80;
        JPanel jPanel = new JPanel();
        City city = new City(
                "a",
                "bbbbbbbbb",
                00231,
                1.3,
                1.4,
                5);
        String[][] obj = new String[6][2];
        dataPreparation(city,obj);

        //Les données du tableau
        Object[][] data= {
                {obj[0][0], obj[0][1]},
                {obj[1][0], obj[1][1] },
                {obj[2][0], obj[2][1] },
                {obj[3][0], obj[3][1] },
                {obj[4][0], obj[4][1] },
                {obj[5][0], obj[5][1] }
        };

        //Les titres des colonnes
        String  title[] = {"champ", "valeur"};
        JTable tableau = new JTable(data, title);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        jPanel.add(new JScrollPane(tableau));
        jPanel.setBackground(Color.GREEN);
        this.setMaximumSize(new Dimension(tableau.getWidth(),tableau.getHeight()));
        this.getContentPane().add(new JScrollPane(jPanel));
    }

    public static void main(String[] args){
        graphicWindowTable gWT = new graphicWindowTable();
        gWT.setVisible(true);
    }
}