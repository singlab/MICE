package Runner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import abl.generated.AuthorAgent;
import abl.wmes.*; //TODO: Maybe remove this. Seeing as how you don't use it.
import com.google.gson.*;

/**
 * This is for the issue with MICE end thread failing.
 * Maybe you could use the daemon function, or
 * persistence things act like other. 7.2, or
 * Ignore failure.  
 *
 */

public class StoryRunner {
	
	private static StoryRunner runner;
	private Location starting_village = new Location("starting_village");
	private Location outskirts = new Location("outskirts");
	private Location player_location = starting_village;
	private AuthorAgent agent;
	private String playerChoice = "event";
	
    public static void main(String[] args) throws IOException {
    	//TODO: Actually get json from file into this file.
    	//TODO: send data over to a javascript server.
    	Gson gson = new Gson();
    	try {
    		Object object = gson.fromJson(new FileReader("../../story.json"), 
    				Object.class);
    		System.out.println(object);
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println("Got caught");
    	}
	
        //TODO: Using strings here... We should just send out the json

        
    	Scanner scan = new Scanner(System.in);
    	
    	runner = new StoryRunner();
    	//Starts server on another thread.
    	new Thread(() -> runner.startServer(gson)).start();
    	//Starting agent.
//    	runner.setAgent(new AuthorAgent());
//    	new Thread(() -> runner.getAgent().startBehaving()).start();
    	// Create a new agent. 
//    	runner.StartAgent();
    	
    	// Prompt the player (AuthorAgent.
    	// Get choice (User input)
    	// React to choice, giving next story beat. (AuthorAgent.)
    	
    	while (!scan.equals("done")) {
    		// Get player choice and send it to the agent.
    		System.out.println(PrintPlayerOptions());
    		String playerChoice = scan.nextLine();
    		// Parse player choice.
    		if (playerChoice.contains("go")) {
    			//update location 
    		} else {
    			// Figure out what is going on.
    		}
    		runner.setChoice(playerChoice);	

    		// output agent response.
    	}
    	scan.close();
    	
    }
    public void sendOutgoingMessage(String jo, Socket socket) {
    	System.out.println("Sending outgoing message...");
    	OutputStream output = null;
		try {
			output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error sending message: output stream");
		}
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(jo);
    }
    
    public void startServer(Gson gson) {
    	int port = 5000;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server is listening on port " + port);
			
			Socket clientSocket;
			clientSocket = serverSocket.accept();
			InputStream in = clientSocket.getInputStream();
			System.out.println("New client connected");
			new Thread(() -> runner.sendOutgoingMessage("Hello", clientSocket)).start();
			byte[] buffer = new byte[1024];
			int read;
			String output = "";
			while ((read = in.read(buffer)) != -1) {
				//TODO: This isn't firing... And I'm not sure why
				System.out.println("Receiving message...");
				String dataString = new String(buffer, 0, read);
				output += dataString;
				System.out.println(dataString);
				System.out.flush();
				Object test = gson.toJson(output, Object.class);
				System.out.println(test);
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
    		
    }
    
    
    //TODO figure out how to input story nodes...
    public static String PrintPlayerOptions() {
    	String options = "";
    	String locationString = "Which location to go to?";
    	options += locationString;
    	return options;
    }
    public static StoryRunner getInstance() {	
    	return runner;
    }
    public String getPlayerChoice() {
    	return playerChoice;
    }
    public void setChoice(String state) {
    	this.playerChoice = state;
    	System.out.println(this.playerChoice);
    }
    public AuthorAgent getAgent() {
    	return agent;
    }
    public void setAgent(AuthorAgent agent) {
    	this.agent = agent;
    }
    public String getLocationName() {
    	return player_location.getLocation();
    }
}

class Location {
	public String location;
	public Location(String locationName) {
		this.location = locationName;
	}
	public String getLocation() {
		return location;
	}
}
class Story 
{
	public String start;
	public String middle;
	public String end;
	public String[] resolutions;
	public String type;
	public String location;
}