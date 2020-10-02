package monApplication;

import monApplication.classApi.City;
import monApplication.item_answer.CityNullException;
import monApplication.item_answer.ItemAnswerCity;
import uti.ManageWindowPositionInScreen;
import uti.UnpossibleMeasureException;
import uti.Uti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class MaFen extends JFrame implements FocusListener {

    public TopPanel topPanel;
    //    public JPanel bottom;
    public ResultBottom resultBottom;
    public monApplication.CityWeatherInformations cityWeatherInformations;
    public JPanel mainPanel = new JPanel();
    public JScrollPane jScrollPane  = new JScrollPane();
    //    public BorderLayout borderLayout= new BorderLayout();
//    public TestConnection testConnection = new TestConnection();
    public Menu menu= new Menu(this);
    public URL testedUrl;
    //    public String request = "";
//    public String stringJSON = "";
//
//    public JSONObject jsonObject = null;
//    public ItemAnswerCity itemAnswerCity;
    public ArrayList<City> cities = new ArrayList<City>();
    public int widthFrame = 700;
    public int heigthFrame = 500;
    public Dimension dimensionFrame = new Dimension(widthFrame,heigthFrame);


    public static void main(String[] args) {
        Uti.info("", "", "");
        MaFen mafen = new MaFen();
    }


    public MaFen() {
        Uti.info("MaFen", "MaFen()", "");
        /**
         * constructor
         * add fields in window
         */
        frameInitialization();
        menu.initMenu();
// add borderLayout in mainPanel
        topPanelSetting();
        bottomSetting();
        mainPanelLayout();
        addScrollPaneToMaFen();
        adjustSizeContent();
        this.setVisible(true);
    }
    public void frameInitialization(){
        Uti.info("MaFen", "frameInitialization", "");
        this.setTitle("Affichage Météo par ville");
        this.setSize(dimensionFrame);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void postionFrameInScreen(int posX,int posY){
        try {
            ManageWindowPositionInScreen manageWindowPositionInScreen = new ManageWindowPositionInScreen(this,posX, posY);
        } catch (UnpossibleMeasureException e) {
            e.printStackTrace();
            ManageWindowPositionInScreen.informations(
                    Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height
            );
        }
    }

    public void topPanelSetting(){
        Uti.info("MaFen", "topPanelSetting", "");
        topPanel = new TopPanel(this);
        topPanel.cityWeatherInformations.addFocusListener(this);
        topPanel.resizeInFrame();
    }

    public void bottomSetting(){
        Uti.info("MaFen", "bottomSetting", "");
        resultBottom = new ResultBottom(this);
    }

    public void createItemCities(int i) throws CityNullException {
        Uti.info("MaFen", "createItemCities", "");
        resultBottom.setLayout(new BoxLayout(resultBottom, BoxLayout.PAGE_AXIS));
        ItemAnswerCity itemAnswerCity = new ItemAnswerCity(this,cities.get(i));
        resultBottom.add(itemAnswerCity.cityWeatherInformations.infoCityJTable);
    }

    public void adjustSizeContent(){
        Uti.info("MaFen", "adjustSizeContent", "");
        topPanel.resizeInFrame();
        resultBottom.adjustBottomSize();
    }

    public void mainPanelLayout2(){
        Uti.info("MaFen", "mainPanelLayout", "");
        mainPanel.setBackground(Color.yellow);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultBottom),BorderLayout.SOUTH);

    }
    public void mainPanelLayout(){
        Uti.info("TestAlignement","mainPanelLayout","");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(topPanel);

        mainPanel.add(new JScrollPane(resultBottom));
        resultBottom.setVisible(false);
    }

    public void addScrollPaneToMaFen(){
        Uti.info("TestAlignement","addScrollPaneToMaFen","");
        /**T
         * para 1 : target of the JScrollPane
         */
        jScrollPane = new JScrollPane(mainPanel);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane);
    }
    public boolean testInternetConnection() {
        Uti.info("MaFen", "testInternetConnection", "");
        /**
         *  this function test if the client is connected to internet and return a boolean
         *  true if the internet connection orders. The url is correct OR NOT correct
         *  false if the internet connection doesn't orders.
         */

        String testedUrl = "https://api.meteo-concept.com/api/";
        try {
            URL url = new URL(testedUrl);
            apiFound(url);
            return true;
        } catch (MalformedURLException e) {
            apiNotFound();
            return false;
        } catch (IOException e) {
            missingInternetConnection();
            return false;
        }
    }
    public void apiFound(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.connect();
        System.out.println("1");
        System.out.println("Vous êtes connectés à internet");
        topPanel.errorLabel.setText("Vous êtes connectés à internet");
    }
    public void apiNotFound(){
        System.out.println("2");
        System.out.println("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
        topPanel.errorLabel.setText("La connexion à internet est valide, mais l'url " + testedUrl + " est invalide.");
    }
    public void missingInternetConnection(){
        System.out.println("3");
        System.out.println("Une connexion à internet est requise");
        topPanel.errorLabel.setText("Une connexion à internet est requise");
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        System.out.println("maFen : FocusGained");
        topPanel.resizeInFrame();
        if(resultBottom!=null){
            resultBottom.adjustBottomSize();
//            topPanel.resizeInFrame();
        }

    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        System.out.println("maFen : FocusLost");
        topPanel.resizeInFrame();
        if(resultBottom!=null){
            resultBottom.adjustBottomSize();
//            topPanel.resizeInFrame();
        }

    }


    class CityWeatherInformationsJtextFieldFocusListener extends JTextField implements FocusListener{
        public TestConnection testConnection = new TestConnection();
        @Override
        public void focusGained(FocusEvent e) {
            Uti.info("CityWeatherInformations","focusGained","");
            checkConnection();
        }

        @Override
        public void focusLost(FocusEvent e) {
            Uti.info("CityWeatherInformations","focusLost","");
            checkConnection();
        }
        public void checkConnection(){
            try {
                testConnection.testInternetConnection();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}