package Runner;

import java.util.Scanner;
import abl.generated.AuthorAgent;
import abl.wmes.*;

/**
 * Okay, so I guess today we are going to be doing something a little bit 
 * different.
 * So, how can we break down the overall story structure the way that Josh 
 * wants me to do? Well, we know for sure that a part of the story is going 
 * to be something about the setting. However, we need to know when the setting 
 * actually becomes a Milieu story. So, that means that Milieu stories 
 * aren't actually associated with characters, but instead when they get sent 
 * to some place. Like a prison or something like that?
 * 
 * So think about how loZ does this with the use of the Dark World, right?
 */
// We want to have a story guided by MICE. 
// Let's first start by opening up a character story!
// We need story data first.
// We have a beginning, middle, and end. So let's use these to be the driving 
// action in terms of making new MICE connections. Don't forget that you can 
// do a fractal story telling thing. Where each start can be interlaced 
// properly. You just have to close out the stories correctly. Locations 
// matter. Notice how you have the cake realm and the ovenless realm. Are 
// stories locked into these realms? Do you need to resolve them first?
// Does going into the middle bit increase story intensity?


/**
 * This is for the issue with MICE end thread failing.
 * Maybe you could use the daemon function, or
 * persistence things act like other. 7.2, or
 * Ignore failure.  
 *
 */

public class StoryRunner {
	
	private static StoryRunner runner;
	private static Location location = new Location();

	private static AuthorAgent agent = new AuthorAgent();
	private String playerChoice = "event";
	
	public void startAgent() {
		agent.startBehaving();
	}
	
    public static void main(String[] args) {
    	location.location = "Starting town.";
    	
    	Scanner scan = new Scanner(System.in);
    	
    	runner = new StoryRunner();
    	new Thread() {
    		public void run() {
    			while (true) {
    				try {
    					runner.startAgent();
    					Thread.sleep(50);
    				}
    				catch (Exception e) {}
    			}
    		}
    	}.start();
    	
    	while (!scan.equals("done")) {
    		// Get player choice.
    		runner.setChoice(scan.nextLine());	
    		ChoiceWME storyWME = new ChoiceWME(runner.getStoryState());

    		runner.getAgent().deleteAllWMEClass("ChoiceWME");   	
    		runner.getAgent().addWME(storyWME);
    	}
    	scan.close();
    	
    }
    public static StoryRunner getInstance() {	
    	return runner;
    }
    public String getStoryState() {
    	return playerChoice;
    }
    public void setChoice(String state) {
    	this.playerChoice = state;
    	System.out.println(this.playerChoice);
    }
    public AuthorAgent getAgent() {
    	return agent;
    }
    public Location getLocation() {
    	return location;
    }
}

class Location {
	public String location;
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