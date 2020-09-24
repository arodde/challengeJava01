package monApplication;

public class CallAPI /*implements Runnable */{
//    RequestApi requestApi;
//    public CallAPI(RequestApi requestApi, String stringJSON){
//        Uti.info("callAPI","callAPI","");
//        this.requestApi = requestApi;
//    }
//    @Override
//    public void run() {
//        Uti.info("callAPI","run","");
//        // ask and receive(?) data from api
//        Uti.mess("C'est ici que l'appel de la récupération  des données se fera via un thread distinct");
//        //connectionImplementation();
//
//        // request creation :
//        // HttpURLConnection
//        // https://api.meteo-concept.com/api/forecast/nextHours?token=MON_TOKEN
//
//        String formulesPossibles[]= new String[6];
//        String token;
//        String insee="23564";
//        String param=(insee!=""?"&insee="+insee:"");
//        formulesPossibles[0] ="location/city";
//        formulesPossibles[1] ="forecast/nextHours";
//        formulesPossibles[2] ="forecast/daily";
//        formulesPossibles[3] ="forecast-period";
//        formulesPossibles[4] ="forecast-hour";
//        formulesPossibles[5] ="forecast-map-day";
//        token ="3b057412276cdbe9dcf39dc6ec656d8ef3635c6804b74792cdbbf5d851b8c29f";
//        try {
//            // GET
//            // this url is composed of the forecast type and the token
//            URL url =new URL(
//                    "https",
//                    "api.meteo-concept.com",
//                    "/api/"+formulesPossibles[0]+"?"+
//                            "token="+token+param);
//            System.out.println(url.toString());
//            // read directly url
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(url.openStream()));
//
//        // todo serverAnswers exceptions or switch
//
//        String serverMessage;
//        int serverAnswer = 0;
//        switch (serverAnswer){
//            case 200 :
//                // OK
//                serverMessage = "Error : "+serverAnswer+"OK";
//                System.out.println(serverMessage);
//                break;
//            case 400 :
//                //Missing parameter, or incorrect value.
//                serverMessage = "Error : "+serverAnswer+"Paramètre manquant, ou valeur incorrecte.";
//                break;
//            case 401 :
//                //Authentication required (token absent or invalid)
//                serverMessage = "Error : "+serverAnswer+" Authentification nécessaire (token absent ou invalide)";
//                System.out.println(serverMessage);
//                break;
//            case 403 :
//                //Unauthorized action (URL not authorized with your subscription)
//                serverMessage = "Error : "+serverAnswer+" Action non autorisée (URL non autorisée avec votre abonnement)";
//                System.out.println(serverMessage);
//                break;
//            case 404 :
//                //Inaccessible page (URL unknown
//                serverMessage = "Error : "+serverAnswer+" Page inaccessible (URL inconnue)";
//                System.out.println(serverMessage);
//                break;
//            case 500 :
//                //Internal server error, contact us
//                serverMessage = "Error : "+serverAnswer+" Erreur interne au serveur, contactez-nous";
//                System.out.println(serverMessage);
//                break;
//            case 503 :
//                //The API is temporarily unavailable, try again in a few minutes
//                serverMessage = "Error : "+serverAnswer+" L'API est momentanément indisponible, réessayez dans quelques minutes";
//                System.out.println(serverMessage);
//                break;
//            default:
//                //Case of error not foreseen by the API manager, when our application was designed.
//                serverMessage = "Error : "+serverAnswer+" Cas d'erreur non prêvue par le gestionnaire de l'API, lorsque notre application a été conçue.";
//                System.out.println(serverMessage);
//                //
//                System.out.println("");
//        }
//        */
//            String inputLine;
//            while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine); // cities array
//            in.close();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Uti.mess("sortie run");
//
//
//
//    }


}
//class CallAPI {
//           /*    public void connectionImplementation(URL url) throws IOException {
//                Uti.info("CallAPI","connectionImplementation","");
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                try {
//                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//        //            readStream(in);
//                    System.out.println(readStream(in));
//                } finally {
//                    urlConnection.disconnect();
//                }
//            }
//
//            private String readStream(InputStream is) throws IOException {
//                Uti.info("CallAPI","readStream","");
//                StringBuilder sb = new StringBuilder();
//                BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
//                for (String line = r.readLine(); line != null; line =r.readLine()){
//                    sb.append(line);
//                }
//                is.close();
//                return sb.toString();
//            }*/
//}