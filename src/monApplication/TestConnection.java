package monApplication;

import uti.Uti;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class TestConnection {
    /**
     * test the internet connection
     */


    public void preliminaryTestInternetConnection() throws UnknownHostException, IOException {
        /**
         * function which confirms the internet connection
         * or precises the cause of problem of connection.
         */
        Uti.info("preliminaryTestInternetConnection","testConnectionInternet()","");
        try {
            try {
                URL url = new URL("http://www.google.com");
                System.out.println(url.getHost());
                HttpURLConnection con = (HttpURLConnection) url
                        .openConnection();
                con.connect();
                switch (con.getResponseCode()){
                    case 200 :
                        System.out.println("Ok connexion établie, connexion à l'api");
                        break;
                    case 400 :
                        System.out.println("Nom de commune non trouvé dans la liste de communes de l'api");
                        break;
                    case 401 :
                        System.out.println("Token absent ou invalide");
                        break;
                    case 403 :
                        System.out.println("Nombre de requêtes autorisées par l'abonnement déjà atteint");
                        break;
                    case 404 :
                        System.out.println("Url d'api inconnue");
                        break;
                    case 500 :
                        System.out.println("Le serveur présente une erreur");
                        break;
                    case 503 :
                        System.out.println("Service de l'api actuellement indisponible");
                        break;
                    default :
                        System.out.println("cas d'erreur non prêvu par l'api.");
                        break;
                }

            } catch (Exception exception) {
                System.out.println("No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayServerResponse(int value){
        /**
         * this function displays the server response.
         */
        Uti.info("TestConnection","displayServerResponse()","");
        switch (value) {
            case 200:
                System.out.println(value+" : Ok connexion établie, connexion à l'api");
                break;
            case 400:
                System.out.println(value+" : Nom de commune non trouvé dans la liste de communes de l'api");
                break;
            case 401:
                System.out.println(value+" : Token absent ou invalide");
                break;
            case 403:
                System.out.println(value+" : Nombre de requêtes autorisées par l'abonnement déjà atteint");
                break;
            case 404:
                System.out.println(value+" : Url d'api inconnue");
                break;
            case 500:
                System.out.println(value+" : Le serveur présente une erreur");
                break;
            case 503:
                System.out.println(value+" : Service de l'api actuellement indisponible");
                break;
            default:
                System.out.println(value+" : cas d'erreur non prêvu par l'api.");
                break;
        }
    }
    public void testInternetConnection() throws UnknownHostException, IOException {
        /**
         * function which confirms the internet connection
         * or precises the cause of problem of connection.
         */
        Uti.info("TestConnection", "testConnectionInternet()", "");
        try {
            try {
                URL url = new URL("http://www.google.com");
                System.out.println(url.getHost());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                displayServerResponse(httpURLConnection.getResponseCode());


            } catch (Exception exception) {
                System.out.println("No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}