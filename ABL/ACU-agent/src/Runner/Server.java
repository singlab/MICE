package Runner;

import java.io.*;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import abl.wmes.*;

public class Server {
	Socket clientSocket;
	
	public void startServer(StoryRunner runner, Gson gson, int port) {
		boolean shouldContinue= true;
		while (shouldContinue) {
			runner.getAgent().deleteAllWMEClass("TagWME"); //TODO PLEASE REMOVE
			try (ServerSocket serverSocket = new ServerSocket(port)) {
				System.out.println("Server is listening on port " + port);
				
				this.clientSocket = serverSocket.accept();
				InputStream input = this.clientSocket.getInputStream();
				System.out.println("New client connected");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(input));
				
				byte[] buffer = new byte[1024];
				int read = -1;
				String output = "";
				while ((output = in.readLine()) != null) {
					System.out.println(output);
					// you have the agent through the runner, and the wme that way
					// or update some kind of state that way, I don't know.
					if (output.equals("ShouldEnd")) {
						CheckTree();
					} else {
						SendToABL(runner, output);						
					}
					if (output.equals("end")) {
						shouldContinue = false;
					}
				}
				System.out.println("Something was read.");
			} catch (IOException ex) {
				System.out.println("Server exception: " + ex.getMessage());
				ex.printStackTrace();
			}
			
		}		
    }
	private void CheckTree() {
		
		sendOutgoingMessage("0");
	}
	private void SendToABL(StoryRunner runner, String msg) {
		TagWME wme = new TagWME(msg);
		System.out.println(wme);
		runner.getAgent().addWME(wme);
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
