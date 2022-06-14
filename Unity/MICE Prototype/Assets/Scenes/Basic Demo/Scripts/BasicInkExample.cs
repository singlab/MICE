using System.Threading.Tasks;
using UnityEngine;
using UnityEngine.UI;
using System.Collections;
using System.Collections.Generic;
using System;
using Ink.Runtime;

// This is a super bare bones example of how to play and display a ink story in Unity.
public class BasicInkExample : MonoBehaviour {
    public static event Action<Story> OnCreateStory;
	public GameObject server;
	private static string serverData = "";
	private Boolean shouldEnd = false;
	private const float DURATION = 2f;
	private float timeRemaining = DURATION;


//TODO: Basic loop
// 		play game 
// 		open threads
//		create new flows through them
		// when reaching epilogue, check to see if all flows are closed.
		// if not. Close out flows.
		// once all flows are closed, then end game.
		// make sure all story beats can work without much contextual issues.
	IEnumerator waiter(Choice choice) {
		yield return new WaitForSecondsRealtime(1);
		if (serverData != "") {	
			Debug.Log("this is firing");
			story.ChoosePathString("event_end");
			serverData = "";
		} else {
			story.ChooseChoiceIndex (choice.index);
		}
		RefreshView();
	}

	async void OnApplicationQuit() {
		await server.GetComponent<SocketClient>().SendServerMessage("END");
		
	}
	public void HandleShouldEndData(string msg) {
		if (msg == "0") {
			shouldEnd = false;
		} else {
			shouldEnd = true;
		}
	}
	public void HandleSceneData(string msg) {
		Debug.Log(msg);
		serverData = msg;
	}
	public void HandleVarData(string var, string msg) {
		story.variablesState[var] = msg;
	}
	
    void Awake () {
		// Remove the default message
		RemoveChildren();
		StartStory();
	}

	// Creates a new Story object with the compiled story which we can then play!
	void StartStory () {
		story = new Story (inkJSONAsset.text);
        if(OnCreateStory != null) { OnCreateStory(story); }
		RefreshView();
	}
	
	// This is the main function called every time the story changes. It does a few things:
	// Destroys all the old content and choices.
	// Continues over all the lines of text, then displays all the choices. If there are no choices, the story is finished!
	void RefreshView () {
		// check to see if we are in epilogue...
		// Remove all the UI on screen
		RemoveChildren ();
		
		// TODO: The most busted line of code in here. Honestly, this should
		// be destroyed with a vindictive zeal only conjured up by the most
		// dogmatic of individuals. 
		// Basically makings sure the first string is fired within each story
		// state so we can evaluate the state string.
		story.Continue();
		// Read all the content until we can't continue any more
		while (story.canContinue) {
			// Continue gets the next line of the story
			string text = story.Continue();
			// This removes any white space from the text.
			text = text.Trim();
			// Display the text on screen!
			CreateContentView(text);
		}

		// Display all the choices, if there are any!
		if(story.currentChoices.Count > 0) {
			for (int i = 0; i < story.currentChoices.Count; i++) {
				Choice choice = story.currentChoices [i];
				Button button = CreateChoiceView (choice.text.Trim ());
				// Tell the button what to do when we press it
				button.onClick.AddListener (delegate {
					OnClickChoiceButton (choice);
				});
			}
		}
		// If we've read all the content and there's no choices, the story is finished!
		else {
			Button choice = CreateChoiceView("End of story.\nRestart?");
			choice.onClick.AddListener(delegate{
				StartStory();
			});
		}
	}

	// // When we click the choice button, tell the story to choose that choice!
	// void OnClickChoiceButton (Choice choice) {
	// 	string state = (string) story.variablesState["state"];
	// 	Debug.Log("Sending message...");
	// 	server.GetComponent<SocketClient>().SendServerMessage(state);
	// 	StartCoroutine(waiter(choice));
	// 	// TODO: Figure out a way to only have one RefreshView function...
	// 	// That way we don't have to worry about multiple places this function
	// 	// fires.
	// 	// RefreshView();
	// }

	async void OnClickChoiceButton (Choice choice) {
		string state = (string) story.variablesState["state"];
		Debug.Log("Sending state..." + state);
		serverData = await server.GetComponent<SocketClient>().SendServerMessage(state);
		Debug.Log("OnClickCHoiceButton serverData is: " + serverData);
		if (serverData != "") {	
			Debug.Log("STORY DATA IS CHANGING THANKS TO ABL.");
			story.ChoosePathString("event_end");
			serverData = "";
		} else {
			story.ChooseChoiceIndex (choice.index);
		}
		// TODO: Figure out a way to only have one RefreshView function...
		// That way we don't have to worry about multiple places this function
		// fires.
		RefreshView();
	}

	// Creates a textbox showing the the line of text
	void CreateContentView (string text) {
		Text storyText = Instantiate (textPrefab) as Text;
		storyText.text = text;
		storyText.transform.SetParent (canvas.transform, false);
	}

	// Creates a button showing the choice text
	Button CreateChoiceView (string text) {
		// Creates the button from a prefab
		Button choice = Instantiate (buttonPrefab) as Button;
		choice.transform.SetParent (canvas.transform, false);
		
		// Gets the text from the button prefab
		Text choiceText = choice.GetComponentInChildren<Text> ();
		choiceText.text = text;

		// Make the button expand to fit the text
		HorizontalLayoutGroup layoutGroup = choice.GetComponent <HorizontalLayoutGroup> ();
		layoutGroup.childForceExpandHeight = false;

		return choice;
	}

	// Destroys all the children of this gameobject (all the UI)
	void RemoveChildren () {
		int childCount = canvas.transform.childCount;
		for (int i = childCount - 1; i >= 0; --i) {
			GameObject.Destroy (canvas.transform.GetChild (i).gameObject);
		}
	}

	[SerializeField]
	private TextAsset inkJSONAsset = null;
	public Story story;

	[SerializeField]
	private Canvas canvas = null;

	// UI Prefabs
	[SerializeField]
	private Text textPrefab = null;
	[SerializeField]
	private Button buttonPrefab = null;
}
