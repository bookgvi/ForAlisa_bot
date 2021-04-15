package BotSimple;


import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static Constants.ApiConstants.WTF_API_URI;

public class YesNoWtf {
    private String yes = "Угу";
    private String no = "Неа";

    public YesNoWtf() {
    }

    public YesNoWtf(String yes, String no) {
        this.yes = yes;
        this.no = no;
    }

    public String yesOrNo() {
        try {
            URI wtfUrl = new URI(WTF_API_URI);
            HttpRequest wtfRequest = HttpRequest.newBuilder(wtfUrl).GET().build();
            HttpResponse<String> wtfResponse = HttpClient.newBuilder().build().send(wtfRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(wtfResponse.body().toString());
            return json.getString("answer").equals("yes") ? yes : no;
        } catch (URISyntaxException | IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
