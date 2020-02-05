package uti;

import java.util.Scanner;

public  class Uti{

//    private Scanner sc= new Scanner(System.in);

    public static void info(String sClasse, String sMethode, String sCommentaire){
        String sLaClasse = sClasse;
        String sLaMethode = sMethode;
        String sLeCommentaire = sCommentaire;
        System.out.print("=====> "+sLaClasse+" ");
        System.out.print("=====> "+sLaMethode);
        if(sLeCommentaire!=""){
            System.out.print(" =====> "+sLeCommentaire);
        }
        System.out.println(".");
    }
    public static void mess(String message){
        System.out.println(">>>======>  "+message);
    }
    public static boolean recommencer(String sQuestion, String sOption1, String sOption2){
        /*
        * valide la poursuite d'une option selon le choix de l'utilisateur
        * */
        String sConsigne="";
        String sChoix="";
        boolean bOk= false;
        // contrôle de la saisie
        while(!bOk){
            sConsigne = "Procéder à une nouvelle conversion? (O/N)";
            sConsigne = sQuestion+" ("+sOption1+"/"+sOption2+")";
            sChoix = choixLettre(sConsigne,sOption1,sOption2);
            if(sChoix.equals(sOption1) || sChoix.equals(sOption2)){
//                System.out.println("une proposition valide : "+sOption1 +" ou "+sOption2);
                bOk = true;
            }
            else
            {
//                System.out.println("une proposition valide : non");
            }
        }
        //
        if(sChoix.equals(sOption1)){ // sChoix == sOption1
            System.out.println("recommencer : oui");
            return true;
        }
        else // sChoix == sOption2
        {
            System.out.println("recommencer : non");
            return false;
        }
    }
    public static String choixLettre(String sConsigne, String sProposition1, String sProposition2){
        /*
        * contrôle la bonne saisie d'une lettre entre les 2 options proposées
        * */
        Scanner sc= new Scanner(System.in);
        String sChoix="";
        boolean bOk= false;
            while(!bOk){
            System.out.println(sConsigne);
            System.out.println("Votre choix? : "+sProposition1+"/"+sProposition2);
            sChoix = sc.nextLine();
            System.out.println(sChoix);
            sChoix = sChoix.toUpperCase();
            System.out.println(sChoix);
            if(sChoix.equals(sProposition1) || sChoix.equals(sProposition2) ){
//                System.out.println("une proposition valide : oui");
                bOk = true;
            }
            else
            {
//                System.out.println("une proposition valide : non");
            }
        }
        return sChoix;
    }
    public static double arrondi(double A, int B) {
        /**
         arrondi A à B chiffres après la virgule
         */
        return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
    }
    public static void sep(){
        System.out.println("-------------------------------------------------------------------------");
    }
}
