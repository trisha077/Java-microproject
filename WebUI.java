public class WebUI {
    public static String render(String resultMessage) {
        return "<!DOCTYPE html><html><head><title>Java Security Tool</title>" +
               "<style>body{font-family:'Segoe UI',sans-serif;background:#f1f5f9;display:flex;justify-content:center;padding-top:50px;}" +
               ".card{background:#fff;padding:30px;border-radius:10px;box-shadow:0 4px 6px #0001;width:380px;}" +
               "h2{color:#1e3a8a;margin-top:0;}input{width:100%;padding:10px;margin:8px 0;border:1px solid #ccc;border-radius:5px;box-sizing:border-box;}" +
               "button{width:48%;padding:10px;margin-top:10px;border:none;border-radius:5px;cursor:pointer;color:#fff;}" +
               ".btn-enc{background:#1e3a8a;margin-right:4%;}.btn-dec{background:#0284c7;}" +
               ".res{margin-top:15px;padding:10px;background:#e2e8f0;border-radius:5px;font-weight:bold;color:#0f172a;}</style></head>" +
               "<body><div class='card'><h2>Encryption System</h2>" +
               "<form method='POST'>" +
               "<input type='text' name='text' placeholder='Enter Text' required />" +
               "<input type='text' name='key' placeholder='Enter Secret Key' required />" +
               "<button class='btn-enc' name='action' value='encrypt'>Encrypt</button>" +
               "<button class='btn-dec' name='action' value='decrypt'>Decrypt</button>" +
               "</form>" + (resultMessage.isEmpty() ? "" : "<div class='res'>" + resultMessage + "</div>") +
               "</div></body></html>";
    }
}