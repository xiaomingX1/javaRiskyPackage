package src.main.java.org.mPackage.ssrf;

import javax.servlet.http.HttpUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

// 20220206-添加
public class URLConnectionSSRF {
    public static String URLCon(String url){
        try {
            URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); //send request
            // BufferedReader in = new BufferedReader(new InputStreamReader(u.openConnection().getInputStream()));
            String inputLine;
            StringBuilder html = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                html.append(inputLine);
            }
            in.close();
            return html.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public static void main(String[] argv){
        System.out.println(URLCon("http://www.baidu.com"));
    }
}
