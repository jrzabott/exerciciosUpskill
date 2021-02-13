package t4j.app.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.http.HttpMethod;
import t4j.app.dto.UserInfoDTO;

public class HttpRequest {

    private int resultCode;
    private HttpURLConnection conn;
    private HttpMethod method;
    private String GETResponse = "";
    private String POSTBody = "";
    private URL url;

    public HttpRequest(URL url) {
        this.url = url;
        this.method = HttpMethod.GET;
    }

    public HttpRequest(URL url, String POSTBody) {
        this.url = url;
        this.method = HttpMethod.POST;
        this.POSTBody = POSTBody;
    }

    public HttpRequest(URL url, HttpMethod method) {
        this.url = url;
        this.method = method;
    }

    public int getResponseCode() {
        return resultCode;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getResponseBody() {
        return GETResponse;
    }

    public String getPOSTBody() {
        return POSTBody;
    }

    public URL getUrl() {
        return url;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setGETResponse(String GETResponse) {
        this.GETResponse = GETResponse;
    }

    public void setPOSTBody(String POSTBody) {
        this.POSTBody = POSTBody;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    private void updateUserInfoDTOWithConnectionInfo(UserInfoDTO u) {
        connect();
        u.setLastHttpResponse(this.getResponseBody());
        u.setLastHttpResponseCode(String.valueOf(this.getResponseCode()));
    }

    public void connect(UserInfoDTO u) {
        connect();
        u.setLastHttpResponse(this.getResponseBody());
        u.setLastHttpResponseCode(String.valueOf(this.getResponseCode()));
    }

    public void connect() {
        StringBuilder sb = null;
        try {
            this.conn = (HttpURLConnection) this.url.openConnection();
            this.conn.setRequestMethod(this.method.name());

            // POST ///////////////////////////////////
            // Preparar conexão para envio do POST
            if (!this.POSTBody.isEmpty()) {
                conn.setDoOutput(true); // permitir que escrevamos Output para o request.
                OutputStream osw;
                osw = conn.getOutputStream();
                osw.write(this.POSTBody.getBytes()); // !!! Atenção pra conversão dos strings em Bytes
                osw.flush();
                osw.close();
            }
            // Fim do POST

            this.conn.connect();
            this.resultCode = this.conn.getResponseCode();

            BufferedReader bf;
            sb = new StringBuilder();
            String line;
            if (this.conn.getResponseCode() >= 100 && this.conn.getResponseCode() <= 399) {
                bf = new BufferedReader(new InputStreamReader(this.conn.getInputStream()));
                do {
                    line = bf.readLine();
                    sb.append(line);
                } while (line != null);
            } else {
                bf = new BufferedReader(new InputStreamReader(this.conn.getErrorStream()));
                do {
                    line = bf.readLine();
                    sb.append(line);
                } while (line != null);
            }
            this.GETResponse = sb.toString();
        } catch (IOException ex) {
            System.out.println("*************************");
            System.out.println("Erro ao efetuar conexão: ");
            System.out.println(sb.toString());
            System.out.println(ex.getMessage());
            this.GETResponse = sb.toString() + "\n" + ex.getMessage();
        }
    }
}
