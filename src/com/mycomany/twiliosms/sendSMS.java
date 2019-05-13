package com.mycomany.twiliosms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class sendSMS {

    public static void main(String[] args) {
        sendSMS mS = new sendSMS();
      //  mS.sendSms();
        System.out.println("Testing... "+mS.sendSms());
    }

    public String sendSms() {
        try {
            // Construct data
            String apiKey = "apikey=" + "6H9m4NYVTOE-71x4FX6AtXm5MOhYv9GomI9pkYDzVk";
            String message = "&message=" + "9121";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + "919833685778";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        //    System.out.println();
        } catch (Exception e) {
            System.out.println("Error SMS " + e);
            return "Error " + e;
        }
    }

}
