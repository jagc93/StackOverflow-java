package serviciorest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceOkHttpClient {

	public static void main(String[] args) {
		try {
//			OkHttpClient client = new OkHttpClient().newBuilder()
//					.build();
//			MediaType mediaType = MediaType.parse("application/json");
//			RequestBody body = RequestBody.create(mediaType, "{\"documento\":\"1144140156\", \"UID\":\"1215\"}");
//			Request request = new Request.Builder()
//					.url("http://10.18.1.37:28015/microservicio-verificar-autenticacion-tercero/autenticacionTerceroJSON")
//					.method("POST", body)
//					.addHeader("Content-Type", "application/json")
//					.build();
//			Response response = client.newCall(request).execute();
//
//			System.out.println(response.body().string());
			
			URL urlWs = new URL("http://10.18.1.37:28015/microservicio-verificar-autenticacion-tercero/autenticacionTerceroJSON");
			HttpURLConnection conn = (HttpURLConnection) urlWs.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			writer.write("{\"documento\":\"1144140156\", \"UID\":\"1215\"}");
			writer.flush();
			writer.close();

			os.close();
			conn.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String respuesta = null;
			String output;
			while ((output = br.readLine()) != null) {
				respuesta = (output);
			}

			conn.disconnect();
			
			System.out.println(respuesta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
