package cn.mirage.supermarket.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpGetUtil {

    public static String getHttpPlainText(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
