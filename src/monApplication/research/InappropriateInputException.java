package monApplication.research;

public class InappropriateInputException extends Exception{

        public InappropriateInputException(){
            System.out.println("saisir une valeur décimale comme ces exemples:\n" +
                    "12.3, 5.0 ou 0.52 ");

        }

}
