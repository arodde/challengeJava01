package monApplication.research;

import java.io.*;


class Student implements Serializable { } // 1

public class ExempleSerializationSupInfo {

    private static final String FILE_NAME = "student.ser";
    private static final String PATH_FILE = "xyztmp/";


    public static void main(String[] args) {
        Student me = new Student(); // 2

        // sérialisation
        try {
            FileOutputStream fs = new FileOutputStream(PATH_FILE+FILE_NAME);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(me); // 3
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // desérialisation
        try {
            FileInputStream fis = new FileInputStream(PATH_FILE+FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            me = (Student) ois.readObject(); // 4
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
// 1
    Nous déclarons la classe Student qui implémente l'interface Serializable.
    Serializable est une interface marqueur; il ne fournit pas de méthodes à implémenter.
// 2
    On instancie un objet de type Student, qui comme nous le savons est sérialisable.
// 3
    On sérialise l'objet Student. Il a fallu une bonne quantité de préparation avant que
nous puissions effectivement sérialiser notre chat. Tout d'abord, nous mettons tout
notre code lié aux E/S dans un bloc try…catch. Ensuite, nous créons un FileOutputStream
pour écrire l'objet. Ensuite, nous l’enveloppons (wrap) dans un objet de type
ObjectOutputStream, qui est la classe qui founit la méthode magique de sérialisation
dont nous avons besoin, la méthode writeObject(). Rappelez-vous que l'invocation
de cette méthode effectue deux tâches: il sérialise l'objet, puis il écrit
l'objet sérialisé dans un fichier.
// 4
    On désérialise l'objet Student en invoquant la méthode readObject(). Cette méthode
retourne un objet, nous avons donc de jeter l'objet désérialisé revenir à un Student.
*/
