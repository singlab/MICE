package Runner;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Server {
	Socket clientSocket;
	
	public void startServer(StoryRunner runner, Gson gson, int port) {
		System.out.println(port);
		System.out.println("hello");
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server is listening on port " + port);
			
			this.clientSocket = serverSocket.accept();
			InputStream in = this.clientSocket.getInputStream();
			System.out.println("New client connected");

			byte[] buffer = new byte[1024];
			int read;
			String output = "";
			while ((read = in.read(buffer)) != -1) {
				//TODO: This isn't firing... And I'm not sure why
				System.out.println("Receiving message...");
				
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
    		
    }
    public void sendOutgoingMessage(String msg) {
    	System.out.println("Sending outgoing message...");
    	OutputStream output = null;
		try {
			output = this.clientSocket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error sending message: output stream");
		}
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(msg);
    }
    
    public Socket getClientSocket() {
    	return this.clientSocket;
    }
}
