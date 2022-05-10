package abl.sensors;

import Runner.StoryRunner;
import abl.runtime.BehavingEntity;
import abl.wmes.ChoiceWME;
/**
 * Adds a PlayerWME object to working memory when sense in invoked.
 * 
 * @author Ben Weber 3-7-11
 */
public class StoryStateSensor extends SerialSensor {

	/**
	 * Adds a Player WME to working memory of the agent and deletes previous player WMEs in memory.
	 */
	protected void sense() {
		// Gotta figure out how to throttle this sensor... Or make a new wme..
		
//		StoryStateWME storyWME = new StoryStateWME(StoryRunner.getInstance()
//				.getStoryState());
//		
//		BehavingEntity.getBehavingEntity().deleteAllWMEClass("StoryStateWME");
//		
//		BehavingEntity.getBehavingEntity().addWME(storyWME);
//		System.out.println("Added new story WME");
	}
}
	