package monApplication.research;

import java.util.Scanner;

public class Bazaar {
    private Scanner scanner;

    public static void main(String[] args){
        Bazaar bazaar = new Bazaar();


    }
    public Bazaar(){
        jeuneIntermitant();


        scanner.close();
    }
    public void jeuneIntermitant(){
        /**
         *
         */
        int heure1 = 25;
        int heure2 = 25;
        int ecart_1_2 = 0;
        int ecart_2_1 = 0;
        while(heure1<0 || heure1 >24){
            System.out.println("Entrer l'heure premier repas: ");
            heure1 = scanner.nextInt();
        }
        while(heure2<0 || heure2 >24){
            System.out.println("Entrer l'heure second repas: ");
            heure2 = scanner.nextInt();
        }
        int i = 0;
        int val = heure1;
        while(val < heure2){
            val++;
            i++;
        }
        System.out.println("Entre h1 et h2 : "+ i +"heures.");
        ecart_1_2 = i;
        i=0;
        val= heure2;
        while(val != heure1){
            val++;
            if (val == 24)
                val =0;
            i++;
        }
        System.out.println("Entre h2 et h1 : "+ i +"heures.");
        ecart_2_1 = i;
        if( ecart_1_2 >= 14 || ecart_2_1 >= 14)
            System.out.println("Méthode respectée");
        else
            System.out.println("Jeûne trop court");
    }
    public void volumeBenne(){
        /**
         gives the meter rating for the given volume and
         based on two determined measures out of three
         among the height, the width and the length
         */
        double volume = 0.0;
        double height = 0.0;
        double width = 0.0;
        double length = 0.0;
        System.out.println("Saisir trois mesures, celle laissée à zéro sera calculée en fonction des trois autres");

        System.out.println("Saisir le volume : ");
        volume= scanner.nextDouble();
        scanner.next();

        System.out.println("Saisir la hauteur : ");
        height = scanner.nextDouble();
        scanner.next();

        System.out.println("Saisir la largeur : ");
        width = scanner.nextDouble();
        scanner.next();

        System.out.println("Saisir la longueur : ");
        length = scanner.nextDouble();
        scanner.next();

        System.out.println(
                "la largeur est de "+ width + (width<=1?" mètre":" mètres") +
                " un volume de " + volume + (volume<=1?" mètre cube":" mètres cube") +
                " la longueur est de "+ length + (length<=1?" mètre":" mètres") +
                " la hauteur est de "+ height + (height<=1?" mètre":" mètres")) ;

        System.out.println("Dimensions de la benne : volume = largeur * longueur * hauteur \n" +
                "\t largeur  : "+ width +" m\n"+
                "\t longueur : "+ length+" m\n"+
                "\t hauteur  : "+ height+" m\n"+
                "\t volume   : "+ volume+" m^3");

volume = height * length * width;
        height = volume/(width* length);
        width = volume/(height* length);
        length= volume/(width*height  );

    }
}
