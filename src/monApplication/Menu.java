package monApplication;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu /*extends JFrame*/ {


//    public static Scanner sc;
    public int currentChoice =0;
    public JMenuBar jMenuBar;
    public JMenu jMenuLocalisation;

//    public JMenuItem jMenuItemClose ;
    public JMenuItem jMenuLocalisationCity;
    public JMenuItem jMenuLocalisationCities;
public MaFen maFen;
    String[] thematic ;
    String[] topicLocalisation;
    public JMenuItemLocalisationCityListener jMenuItemLocalisationCityListener = new JMenuItemLocalisationCityListener();
    public JMenuItemLocalisationCitiesListener jMenuItemLocalisationCitiesListener = new JMenuItemLocalisationCitiesListener();

//    public static void main(String[] args)  {
//        /**
//         * creates and opens the main window
//         */
//        uti.Uti.info("Main","main","");
////        sc = new Scanner( System .in);
//        Menu menu = new Menu();
////        sc.close();
//    }

    public Menu(MaFen maFen){
        /**
         * this constructor create the main window
         * call
         *  - initArrayAnManagment
         *  - initMenu
         */
        this.maFen = maFen;
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        setTitle("AirBnB");
//        setResizable(false);
//        setSize(600,400);
//        setLocationRelativeTo(null);
//        initMenu();
//        setVisible(true);
    }
    public void initMenu(){
        /**
         * create the menu bar with all JMenu and JMenuItem with their specific action
         */
        uti.Uti.info("ViewMenu","initMenu","");
        initTable();
        jMenuBar = new JMenuBar();
        menuButtonLocalisation();
        menuButtonClose();
        menuLayout();
        addButtonMenuActionListener();
        maFen.setJMenuBar(jMenuBar);
    }
    public void addButtonMenuActionListener(){
        jMenuLocalisationCity.addActionListener(jMenuItemLocalisationCityListener);
        jMenuLocalisationCities.addActionListener(jMenuItemLocalisationCitiesListener);
    }
    public void menuButtonLocalisation(){
        jMenuLocalisation = new JMenu(thematic[0]);
        jMenuLocalisationCity = new JMenuItem(topicLocalisation[0]);
        jMenuLocalisationCities = new JMenuItem(topicLocalisation[1]);
    }
    public void menuButtonClose(){
//        jMenuItemClose = new JMenuItem("Fermer");
//        jMenuItemClose.addActionListener(
//                new ActionListener(){
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        /**
//                         * Saves bookings in a file text before closing application
//                         */
//                        uti.Uti.info("ViewMenu", "initMenu","");
//
//                        System.exit(0);
//                    }
//                }
//        );
    }
    public void menuLayout(){
        jMenuLocalisation.add(jMenuLocalisationCity);
        jMenuLocalisation.add(jMenuLocalisationCities);
        jMenuBar.add(jMenuLocalisation);
//        jMenuBar.add(jMenuItemClose);
    }
    //    public void f(){    }
    public void initTable(){
        thematic = new String[1];
        thematic[0]="Localisation";
        topicLocalisation = new String[]{"Recherche par code insee","Recherche par nom de communes"};
    }


    class JMenuItemLocalisationCityListener implements ActionListener {
        /**
         * creates and opens the window to add an appartement
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uti.Uti.info("JMenuItemLocalisationCityListener","actionPerformed()","");
            maFen.resultBottom.razBottom();
            currentChoice = 1;
            maFen.topPanel.cityLabel.setText("Code Insee : ");
            maFen.topPanel.cityWeatherInformations.setText("                    ");
        }
    }
    class JMenuItemLocalisationCitiesListener implements ActionListener {
        /**
         * creates and opens the window to add an appartement
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            uti.Uti.info("JMenuItemLocalisationCitiesListener","actionPerformed()","");
            maFen.resultBottom.razBottom();
            currentChoice = 2 ;
            maFen.topPanel.cityLabel.setText("Ville : ");
            maFen.topPanel.cityWeatherInformations.setText("                    ");

        }
    }

//    public class Persistence{
//        public File parentFile = new File("miscelleanous/");
//        String fileName ="bookings.txt";

//        public void createNewRealFile(){
//            /**
//             creates a new file if the file doesn't exist in the path.
//             the path is composed of rootProject and the additionalPath.
//             */
//
//            uti.Uti.info("Persistence","createNewRealFile","");
//            String s="";
//            try {
//                s = parentFile.getPath()+"/"+fileName;
//                File f = new File(s);
//                if (f.createNewFile())
//                    System.out.println("File created");
//                else
//                    System.out.println("File already exists");
//            } catch (Exception e) {
//                System.out.println("Chemin : "+ s );
//                System.err.println(e);
//            }
//        }
//        public void saveBookings(){
//            uti.Uti.info("Persistence","saveBookings","");
//            try {
//                FileWriter fw = new FileWriter(parentFile.getPath()+"/"+fileName);
//                BufferedWriter bw = new BufferedWriter(fw);
//                PrintWriter pw = new PrintWriter(bw);
//                pw.print("Réservations");
//
//                pw.print("\nFin du fichier");
//                pw.close();
//            } catch (Exception e) {
//                System.err.println("error");
//            }
//        }
}
