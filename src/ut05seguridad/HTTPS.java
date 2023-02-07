package ut05seguridad;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class HTTPS {

	public static void main(String[] args) {
		SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try {
			Socket client = clientFactory.createSocket("www.meneame.net", 443);
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			
			out.print("GET / HTTP/1.1\r\n");
			out.print("Host: www.meneame.net\r\n");
			out.print("\r\n");
			out.flush();
			
			String s;
			while( (s = in.readLine()) != null) {
				System.out.println(s);
			}
			
			in.close();
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
