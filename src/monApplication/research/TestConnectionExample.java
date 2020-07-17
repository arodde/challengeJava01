package monApplication.research;


import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.UnknownHostException;

public class TestConnectionExample {
    public static void main(String[] args) throws UnknownHostException,
            IOException {
        try {
            try {
                URL url = new URL("http://www.google.com");
                System.out.println(url.getHost());
                HttpURLConnection con = (HttpURLConnection) url
                        .openConnection();
                con.connect();
                if (con.getResponseCode() == 200){
                    System.out.println("Connection established!!");
                }
            } catch (Exception exception) {
                System.out.println("No Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}