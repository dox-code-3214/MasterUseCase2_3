package com.sdetlabs.masterusecase2.mcu2;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SoapWS {

	static int responseCode;

	public static int GetRequestStatusCode() {

		try {

			String url = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx?op=Add";

			@SuppressWarnings("deprecation")
			URL obj = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			connection.setRequestMethod("GET");

			responseCode = connection.getResponseCode();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return responseCode;

	}
	
	public static int PostRequestStatusCode() {
		
		try {
            String url = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx?op=Add";

            @SuppressWarnings("deprecation")
			URL obj = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("POST");

            connection.setDoOutput(true);

            String soapRequestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                    + "xmlns:web=\"http://www.example.com/\"><soapenv:Header/><soapenv:Body>"
                    + "<web:Add><web:intA>10</web:intA><web:intB>20</web:intB></web:Add>"
                    + "</soapenv:Body></soapenv:Envelope>";

            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setRequestProperty("Content-Length", String.valueOf(soapRequestBody.length()));

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(soapRequestBody.getBytes());
            outputStream.flush();
            outputStream.close();

            responseCode = connection.getResponseCode();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return responseCode;
		
	}
}
