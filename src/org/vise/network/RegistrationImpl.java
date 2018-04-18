package org.vise.network;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * 
 * @author marcopazzaglia
 *
 */
public class RegistrationImpl implements Registration {

    private OkHttpClient client;
    private String inUrl;
    private String nomeUtente;
    private String email;
    private String pwd;
    private Url url;
    private boolean success;
    private String risposta;
    private String totalUrl;
    private JSONObject json;
    private String error;

    RegistrationImpl(final String nomeUtente, final String email, final String pwd) {
        this.client = new OkHttpClient();
        this.url = new Url();
        this.nomeUtente = nomeUtente;
        this.email = email;
        this.pwd = pwd;
        this.success = false;
        this.inUrl = url.getUrl();
        this.totalUrl = totalUrl();
        this.error = "";
        json = new JSONObject();
        totalUrl();
        }

    @Override
    public final boolean getSuccess() {
        return this.success;
    }

    @Override
    public final String getErrorMessage() {
        return error;
    }

    @Override
    public final String totalUrl() {
        totalUrl = this.inUrl + "register.php?nome_utente=" + this.nomeUtente + "&email=" + this.email + "&pwd=" + this.pwd;
        return totalUrl;
    }

    @Override
    public final String run(final String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
             risposta = response.body().string();
             return risposta;
        }
    }

    @Override
    public final String getError() throws JSONException {
        this.error = json.getJSONObject("error").getString("message");
        return error;
    }

}
