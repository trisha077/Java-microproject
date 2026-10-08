import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CipherEngine {

    public static String processForm(String body) {
        try {
            String text = "", key = "", action = "";
            String[] pairs = body.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=");
                if (kv.length > 1) {
                    String val = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                    if (kv[0].equals("text")) text = val;
                    if (kv[0].equals("key")) key = val;
                    if (kv[0].equals("action")) action = val;
                }
            }
            boolean isEncrypt = action.equalsIgnoreCase("encrypt");
            String output = transform(text, key, isEncrypt);
            return "Result: " + output;
        } catch (Exception e) {
            return "Error processing request.";
        }
    }

    public static String transform(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int keyLen = key.length();
        if (keyLen == 0) return text;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char k = key.charAt(i % keyLen);
            int shift = k % 26;
            if (!encrypt) shift = -shift;

            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch - 'A' + shift + 260) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch - 'a' + shift + 260) % 26 + 'a'));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}