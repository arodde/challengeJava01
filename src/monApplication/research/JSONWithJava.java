package monApplication.research;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;

public class JSONWithJava {
    public static void main(String[] args){
        JSONWithJava jsonWithJava = new JSONWithJava();
    }
    public JSONWithJava(){
        encodingJSONInJava();
        decodingJSONInJava();
    }
    public void encodingJSONInJava(){
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));

        System.out.print(obj);
    }
    public void decodingJSONInJava(){
        JSONObject obj = new JSONObject();

        obj.put("name","foo");
        obj.put("num",new Integer(100));
        obj.put("balance",new Double(1000.21));
        obj.put("is_vip",new Boolean(true));

        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonText = out.toString();
        System.out.print(jsonText);
    }


}
