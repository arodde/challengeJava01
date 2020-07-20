package monApplication.research;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Benne {
    /**
     gives the meter rating for the given volume and
     based on two determined measures out of three
     among the height, the width and the length
     or gives the volume for the determined measures width,
     length and height
     */
    public String s ="[\\d]+[\\,|\\.][\\d]+";
    public double volume = 0.0;
    public double height = 0.0;
    public double width = 0.0;
    public double length = 0.0;
    public int counter = 0;
    private boolean stop= false;
    private Scanner scanner;

    public static void main(String[] args){
        Benne benne = new Benne();
    }
    public Benne(){
        scanner = new Scanner(System.in);
        raz();
        String s ="\\d+\\.\\d+";
        inputValues();
        determinationMeasureBenne();
//        x();
        scanner.close();
    }
    public void determinationMeasureBenne(){
        while(!stop){
            inputValues();
            checkOnlyZeroValue();
            if(volume == 0.0)
                calculateVolume();
            else if (width == 0.0)
                calculateWidth();
            else if (height == 0.0)
                calculateHeight();
            else
                calculateLength();
            displayResult();
            raz();
        }
    }
    public void inputValues (){
        System.out.println("Saisir trois mesures, celle " +
                "laissée à zéro sera calculée en fonction" +
                " des trois autres.\nsaisir une valeur " +
                "négagive non nulle pour quitter");
        try {
            userInputVolume();
            userInputHeight();
            userInputLength();
            userInputWidth();
//            userInput(volume);
//            userInput(height);
//            userInput(length);
//            userInput(width);
//            userInputDouble(volume);
//            userInputDouble(height);
//            userInputDouble(length);
//            userInputDouble(width);
//            try{
//                inputVolume();
//            } catch (InputMismatchException e){
//                if(e!=null) // la fonction est appelée une nouvelle fois ce que j'attendais
//                   /*
//                    mais si l'utilateur est vraiment borné l'exception
//                    InputMismatchException basique sera appelée et affichée
//                    dans la console là ou je souhaite avoir un nouvel appel
//                    de la fonction
//                   */
//                    inputVolume();
//            }
//
//            try{
//                inputHeight();
//            } catch (InputMismatchException e){
//                if(e!=null)
//                    inputHeight();
//            }
//
//            try{
//                inputWidth();
//            } catch (InputMismatchException e){
//                if(e!=null)
//                    inputWidth();
//            }
//
//            try{
//                inputLength();
//            } catch (InputMismatchException e){
//                if(e!=null)
//                    inputLength();
//            }
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }finally {
            raz();
        }

    }
    public void raz(){
        counter = 4;
        width = 0;
        height = 0;
        length = 0;
        volume = 0;
    }
    public void askExitLoop(){
        if(width < 0.0 || height < 0.0 || length < 0.0 || volume < 0.0 )
            stop = true;
    }
    public boolean checkOnlyZeroValue(){
        if (width==0){ counter--;}
        if (length==0){ counter--;}
        if (height==0){ counter--;}
        if (volume ==0){ counter--;}
        if (counter != 1){
            System.out.println("Calcul impossible");
            return false;
        } else {
            return true;
        }
    }
    public void volumeBenne(){
        System.out.println("Dimensions de la benne : " +
                "volume = largeur * longueur * hauteur \n" +
                "\t largeur  : "+ width +" m\n"+
                "\t longueur : "+ length+" m\n"+
                "\t hauteur  : "+ height+" m\n"+
                "\t volume   : "+ volume+" m^3");
    }
    public String displayResult() {
        return "Dimensions de la benne : " +
                "volume = largeur * longueur * hauteur \n" +
                "\t largeur  : "+ width +" m\n"+
                "\t longueur : "+ length+" m\n"+
                "\t hauteur  : "+ height+" m\n"+
                "\t volume   : "+ volume+" m^3";
    }
    public void calculateVolume (){volume = height * length * width;}
    public void calculateHeight (){
        try{
            height = volume/(width* length);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
    public void calculateWidth(){
        try{
            width = volume/(height* length);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
    public void calculateLength(){
        try{
            width = volume/(height* length);
            length= volume/(width*height);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
//    public void inputVolume () throws InputMismatchException{
////        boolean exceptionFound = false;
////        while(exceptionFound){
//        System.out.println("Saisir le volume : ");
////            volume= scanner.nextDouble();
//        volume = Double.parseDouble(scanner.next());
////            scanner.next();
////        }
//    }
    public void userInputVolume(){
        System.out.println("Entrer le volume : ");
        String str = scanner.next();
        if(testRegex(str,s))
            volume = Double.parseDouble(str);
        else
            userInputVolume();
    }
    public void userInputHeight(){
        System.out.println("Entrer la hauteur : ");
        String str = scanner.next();
        if(testRegex(str,s))
            height = Double.parseDouble(str);
        else
            userInputHeight();
    }
    public void userInputWidth(){
        System.out.println("Entrer la largeur : ");
        String str = scanner.next();
        if(testRegex(str,s))
            width = Double.parseDouble(str);
        else
            userInputWidth();
    }
    public void userInputLength(){
        System.out.println("Entrer la longueur : ");
        String str = scanner.next();
        if(testRegex(str,s))
            length = Double.parseDouble(str);
        else
            userInputLength();
    }

//    public void inputWidth () throws InputMismatchException {
//        System.out.println("Saisir la largeur : ");
//        width = scanner.nextDouble();
//        scanner.next();
//    }
//    public void inputHeight ()throws InputMismatchException{
//        System.out.println("Saisir la hauteur : ");
//        height = scanner.nextDouble();
//        scanner.next();
//    }
//    public void inputLength ()throws InputMismatchException{
//        System.out.println("Saisir la longueur : ");
//        length = scanner.nextDouble();
//        scanner.next();
//    }
//    private void compareToRegex(String input) throws InputMismatchException {
//
//        displayTestRegex(input, s) ;
//        // blabla... tu compares
//        // soit ça throw, soit elle fait rien
//    }
    public  boolean testRegex(String sPattern, String sMatcher){
        /*
           this method gives a message which show if the pattern matches with the proposed string or not
        */
        boolean b = false;
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
            return true;
        }
        else
        {
            System.out.print("KO :(");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
            return false;
        }
//        System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
    }

//    public void userInput(double value) {
//        String input = new String();
//        try {
//            input = scanner.nextLine();// (ça fait longtemps, à voir le fonctionner de Scanner mais utilise un String)
//            compareToRegex(input);
//            System.out.println(input);
//            value = Double.parseDouble(input);
//        } catch (InputMismatchException e) {
//            userInput(value);
//        }
//    }

//    public void userInputDouble(double value) {
////        Scanner scanner = new Scanner(System.in);
////        Double input  = value;
//        try {
////            inputVolume();
//            value = scanner.nextDouble();
//        } catch (InputMismatchException e) {
//            userInputDouble(value);
//            return;
//        }
//        System.out.println(value);
//    }
    public void x(){
        boolean b = false;
        String sPattern = "[\\d]+";
        String sMatcher = "1236";
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
        }
        else
        {
            System.out.print("KO :(");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
        }
        System.out.println("-----------------------------------------------------");
        sPattern = "[\\,|\\.]";
        sMatcher = ".";
         pattern = Pattern.compile(sPattern);
         matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
        }
        else
        {
            System.out.print("KO :(");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
        }
        System.out.println("-----------------------------------------------------");
        sMatcher = "5789";
        sPattern = "[\\d]+";
        pattern = Pattern.compile(sPattern);
        matcher = pattern.matcher(sMatcher);
        b = matcher.matches();
        if(b){
            System.out.print("OK :)");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
        }
        else
        {
            System.out.print("KO :(");
            System.out.println(" ---> "+sPattern+"  \""+ sMatcher+"\"" );
        }
    }
}
