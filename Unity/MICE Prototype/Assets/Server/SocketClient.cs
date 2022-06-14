using System.Threading.Tasks;
using UnityEngine;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Sockets;
using System.Text;
using System.Threading;

//Just some testing code from this gist
// https://gist.github.com/danielbierwirth/0636650b005834204cb19ef5ae6ccedb
// Should be replaced with a more robust message system.
public class SocketClient : MonoBehaviour {  	
	public GameObject SceneController;
	#region private members 	
	private BasicInkExample inkscript;
	private TcpClient socketConnection; 	
	private Thread clientReceiveThread;
    private int _PORT = 5000;
	private static string serverMessage = "";
	private static CancellationTokenSource source = new CancellationTokenSource();
	private static CancellationToken token = source.Token;
	#endregion  	
    // private static SocketClient _instance;
	// public static SocketClientInstance => SocketClient._instance;  
	// Use this for initialization 	
	void Start () {
		ConnectToTcpServer();     
        Debug.Log("The server has started");
		inkscript = SceneController.GetComponent<BasicInkExample>();
	}  	
	/// <summary> 	
	/// Setup socket connection. 	
	/// </summary> 	
	private void ConnectToTcpServer () { 		
		try {  			
			clientReceiveThread = new Thread (new ThreadStart(ListenForData)); 			
			clientReceiveThread.IsBackground = true; 			
			clientReceiveThread.Start();  		
		} 		
		catch (Exception e) { 			
			Debug.Log("On client connect exception " + e); 		
		} 	
	}  	
	/// <summary> 	
	/// Runs in background clientReceiveThread; Listens for incoming data. 	
	/// </summary>     
	private void ListenForData() { 		
		try { 			
			socketConnection = new TcpClient("localhost", _PORT);  			
			Byte[] bytes = new Byte[1024];              
			while (true) { 				
				// Get a stream object for reading 				
				using (NetworkStream stream = socketConnection.GetStream()) { 					
					int length; 					
					// Read incoming stream into byte arrary. 					
					while ((length = stream.Read(bytes, 0, bytes.Length)) != 0) { 						
						var incomingData = new byte[length]; 						
						Array.Copy(bytes, 0, incomingData, 0, length); 						
						// Convert byte array to string message. 						
						serverMessage = Encoding.ASCII.GetString(incomingData); 						
						serverMessage = serverMessage.Trim();
						// if (serverMessage[0] == '0') {
						// 	Debug.Log("WE ARE FIRING OFF THE SCENE");
						// 	inkscript.HandleSceneData	(serverMessage.Substring(1));

						// } else if (serverMessage[0] == '1') {
						// 	inkscript.HandleShouldEndData(serverMessage.Substring(1));
						// } else {
						// 	inkscript.HandleVarData("text", serverMessage.Substring(1));
						// }
						// inkscript.HandleSceneData(serverMessage);
						Debug.Log("server message received as: " + serverMessage);
						source.Cancel();
					}
				}
			}         
		}         
		catch (SocketException socketException) {             
			Debug.Log("Socket exception: " + socketException);         
		}     
	}  	



    async public Task<string> SendServerMessage(string msg) {
        if (socketConnection == null) {             
            Debug.Log("Socket connect is null.");
		} else {
			try { 
				// Get a stream object for writing.
				NetworkStream stream = socketConnection.GetStream(); 
				serverMessage = "";
				if (stream.CanWrite) {  
					string clientMessage = msg;
					clientMessage += "\n";
					// Convert string message to byte array.                 
					byte[] clientMessageAsByteArray = Encoding.ASCII.GetBytes(clientMessage); 				
					// Write byte array to socketConnection stream.                 
					stream.Write(clientMessageAsByteArray, 0, clientMessageAsByteArray.Length);                 
					Debug.Log("Client sent message - should be received by server");             
				}         
			} 		
			catch (SocketException socketException) {             
				Debug.Log("Socket exception: " + socketException);         
			}
		}
		// await Task.Delay(1000, token); TODO: Learn more about how async works.
		await Task.Delay(100);
		return serverMessage;
	}

}