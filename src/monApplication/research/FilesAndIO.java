package monApplication.research;

import java.io.*;
import java.util.Scanner;

public class FilesAndIO {
    private Employee e ;
    private Scanner scanner;
    public static void main(String[] args){
        FilesAndIO filesAndIO = new FilesAndIO();


    }
    public FilesAndIO(){
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
//        jeuneIntermitant();
//        useOutPutStream();
//        bufferedReaderExample();
        bufferedWriterExample();
//        xxxx();
//        xxx();
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
    public void bufferedReaderExample(){
        /**
         * writes in the console the content of a file with a buffer
         */
        FileReader fr= null;
        try {
            fr = new FileReader("xyztmp/testout.txt");
            System.out.println("fichier testout.txt trouvé.");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("exception levée sur FileReader: fichier non trouvé");
        }
        BufferedReader br=new BufferedReader(fr);

        int i=-1;
        while(true){
            try {
                if (!((i=br.read())!=-1)) break;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.print((char)i);
        }
        try {
            br.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("exception levée sur fermeture du BufferedReader");
        }
        try {
            fr.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("exception levée sur fermeture du FileReader");
        }
    }
    public void bufferedWriterExample(){
        /**
         * writes the content input by keyboard in a file with a buffer
         * the precedent content is totally replaced
         */
        File file =null;
        FileWriter writer = null;
        try {
            file = new File("xyztmp/testout.txt");
            writer = new FileWriter(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            buffer.write("Welcome to javaTpoint.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            buffer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("Success");
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
