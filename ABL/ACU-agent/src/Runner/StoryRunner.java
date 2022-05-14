package Runner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    	Gson gson = new Gson();
    	System.out.println("this is executing.");
    	FileReader output;
    	try {
    		Object object = gson.fromJson(new FileReader("../../story.json"), 
    				Object.class);
    		System.out.println(object);
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println("Got caught");
    	}



        
        
        
    	Scanner scan = new Scanner(System.in);
    	
    	runner = new StoryRunner();
    	// Create a new agent. 
    	runner.setAgent(new AuthorAgent());
    	runner.StartAgent();
    	
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
    //TODO figure out how to input story nodes...
    public static String PrintPlayerOptions() {
    	String options = "";
    	String locationString = "Which location to go to?";
    	options += locationString;
    	return options;
    }
    
    public void StartAgent() {
    	// Create new thread for agent.
    	new Thread() {
    		public void run() {
    			while (true) {
    				try {
    					runner.getAgent().startBehaving();
    					Thread.sleep(50);
    				}
    				catch (Exception e) {}
    			}
    		}
    	}.start();
    	// Load agent with data.
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