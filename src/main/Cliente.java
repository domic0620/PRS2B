package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
	
		try {
			System.out.println("Enviando solicitud...");
			Socket socket = new Socket("127.0.0.1", 5000);
			System.out.println("Conectados!");
			
			
			Scanner scanner = new Scanner(System.in);
			
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bwriter = new  BufferedWriter(osw);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader breader = new BufferedReader(isr);
			
			

			while(true) {
				String line = scanner.nextLine();
				bwriter.write(line+"\n");
				bwriter.flush();
				
				String recibido = breader.readLine();
				System.out.println("Mensaje recibido: "+recibido);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
