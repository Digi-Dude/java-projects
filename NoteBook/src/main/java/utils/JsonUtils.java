package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import views.NoteView;

public class JsonUtils {
    public static String noteParseToJSON(NoteView noteContent) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isList",noteContent.getIsList());
        jsonObject.put("font", noteContent.getFont());
        jsonObject.put("fontSize", noteContent.getFontSize());
        jsonObject.put("content", noteContent.getContent());
        String jsonParse = jsonObject.toString();
        return jsonParse;
    }


    public static String[] jsonArrayToArray(JSONArray jsonArray) {
        String[] strArray = new String[jsonArray.length()];
        for(int i =0; i < strArray.length; i++) {
            strArray[i] = (String) jsonArray.get(i);
        }
        return strArray;
    }
}
