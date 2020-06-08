package monApplication.research;

import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JSONWithJava {
    public static void main(String[] args) {
        JSONWithJava jsonWithJava = new JSONWithJava();
    }

    public JSONWithJava() {
//        encodingJSONInJava();
//        decodingJSONInJava();
        x();
    }

    public void encodingJSONInJava() {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj);
    }

    public void decodingJSONInJava() {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonText = out.toString();
        System.out.print(jsonText);
    }

    public void x() {
        JSONParser parser = new JSONParser();
        String text = "{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}";
        ContainerFactory containerFactory = new ContainerFactory() {
            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap<>();
            }

            @Override
            public List creatArrayContainer() {
                return new LinkedList<>();
            }
        };
        try {
            Map map = (Map) parser.parse(text, containerFactory);
            map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }

    }
}



