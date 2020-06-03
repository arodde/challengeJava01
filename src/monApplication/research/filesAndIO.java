package monApplication.serial;

import java.io.*;
import java.util.Scanner;

public class filesAndIO {
    private Employee e ;
    private Scanner scanner;
    public static void main(String[] args){
        filesAndIO filesAndIO = new filesAndIO();


    }
    public filesAndIO(){
        scanner = new Scanner(System.in);
        Employee e = new Employee();
        e.address = "Phokka Kuan, Ambehta Peer";
        e.name = "Reyan Ali";
        e.number = 101;
        e.SSN = 11122333;
        this.e = e;
//        copyContentFirstFileInSecondFile();
//        copyCharactersFirstFileInSecondFile();
//        standardStream();
//
//        jeuneIntermitant();
        useOutPutStream();
//        xxxx();
//        xxx();
//        xx();
//        x();
        scanner.close();
    }
    public void copyContentFirstFileInSecondFile(){
        /**
         copy content first file in second file
         */
        File first;
        File second;
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            first = new File("xyztmp/input.txt");
            second = new File("xyztmp/output.txt");
            in = new FileInputStream(first);
            out = new FileOutputStream(second);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("fichier non trouvé.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("problème d'accès au fichier trouvé");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.out.println("problème fermeture flux de lecture depuis fichier");
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.out.println("problème fermeture flux d'écriture dans un fichier");
                }
            }
        }
    }
    public void copyCharactersFirstFileInSecondFile(){
        /**
         * copies content of character from the first
         * file in to the secon file
         */
        File first;
        File second;
        FileReader in = null;
        FileWriter out = null;

        try {
            first = new File("xyztmp/input.txt");
            second = new File("xyztmp/output.txt");
            in = new FileReader(first);
            out = new FileWriter(second);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
    public void standardStream(){
        /**
         *
         */
        InputStreamReader cin = null;

        try {
            cin = new InputStreamReader(System.in);
            System.out.println("Enter characters, 'q' to quit.");
            char c;
            do {
                c = (char) cin.read();
                System.out.print(c);
            } while(c != 'q');
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (cin != null) {
                try {
                    cin.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
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
    public void useOutPutStream(){
        /**
         *
         */
        try {
            byte bWrite [] = {11,21,3,40,5};
            OutputStream os = new FileOutputStream("xyztmp/test.txt");
            for(int x = 0; x < bWrite.length ; x++) {
                os.write( bWrite[x] );   // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("xyztmp/test.txt");
            int size = is.available();

            for(int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
    public void x(){
        /**
         *
         */

    }
    public void xx(){
        /**
         *
         */

    }
    public void xxx(){
        /**
         *
         */

    }
    public void xxxx(){
        /**
         *
         */

    }
}
