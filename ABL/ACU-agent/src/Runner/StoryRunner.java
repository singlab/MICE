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
import java.util.HashMap;
import java.util.Map;
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
	private Server server;
	private Location starting_village = new Location("starting_village");
	private Location outskirts = new Location("outskirts");
	private Location player_location = starting_village;
	private AuthorAgent agent = new AuthorAgent();
	private String playerChoice = "event";
	
    public static void main(String[] args) throws IOException {
    	//TODO: We need to figure out how to open up ABL and add in our own
    	// 		callbacks.
    	Gson gson = new Gson();
    	
    	Map<String, StoryNode> nodes = new HashMap<String, StoryNode>();

    	try {
    		nodes = gson.fromJson(new FileReader("../../story.json"), 
    				Map.class);
    		
    		System.out.println(nodes);
    		System.out.println(nodes.get("node1"));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    		System.out.println("Got caught when trying to convert json to java");
    	}
	
    	Scanner scan = new Scanner(System.in);
    	
    	runner = new StoryRunner();
    	// The server handles any kind of Unity and Javascript calls.g
    	//TODO: Get Unity and Java talking to each other, so you can have 
    	// event listeners on the player choice function.
    	runner.server = new Server();
    	new Thread(() -> runner.server.startServer(runner, gson, 5000)).start();
    	//TODO: Create an event listener that fires sendOutgoingMessage whenever
    	// 		something specific happens.
    	scan.close();
    	
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

class StoryNodes {
	public Map<String, StoryNode> nodes = new HashMap<String, StoryNode>();

}
class StoryNode {
	public String text;
	public String[] next;
}
class hey {
	public String hey;
	public String toString() {
		return hey;
	}
}

class test {
	public String name;
	public hey object;
	public String toString() {
		String string = "";
//		for (int i = 0; i < name.length; i++) {
//			string += name[i];
//		}
		return object.toString();
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