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
	#region private members 	
	private TcpClient socketConnection; 	
	private Thread clientReceiveThread;
    private int _PORT = 5000;
	#endregion  	

    // private static SocketClient _instance;
	// public static SocketClientInstance => SocketClient._instance;  
	// Use this for initialization 	
	void Start () {
		ConnectToTcpServer();     
        Debug.Log("The server has started");
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
	/// Runs in background clientReceiveThread; Listens for incomming data. 	
	/// </summary>     
	private void ListenForData() { 		
		try { 			
			socketConnection = new TcpClient("localhost", _PORT);  			
			Byte[] bytes = new Byte[1024];              
			while (true) { 				
				// Get a stream object for reading 				
				using (NetworkStream stream = socketConnection.GetStream()) { 					
					int length; 					
					// Read incomming stream into byte arrary. 					
					while ((length = stream.Read(bytes, 0, bytes.Length)) != 0) { 						
						var incommingData = new byte[length]; 						
						Array.Copy(bytes, 0, incommingData, 0, length); 						
						// Convert byte array to string message. 						
						string serverMessage = Encoding.ASCII.GetString(incommingData); 						
						Debug.Log("server message received as: " + serverMessage); 					
					} 				
				} 			
			}         
		}         
		catch (SocketException socketException) {             
			Debug.Log("Socket exception: " + socketException);         
		}     
	}  	



    public void SendServerMessage(List<string> tags) {
        if (socketConnection == null) {             
            Debug.Log("Socket connect is null.");
			return;
		}
		try { 
			// Get a stream object for writing.
			NetworkStream stream = socketConnection.GetStream(); 			
			if (stream.CanWrite) {  

				string clientMessage = "";
                foreach(string tag in tags) {
                    clientMessage += tag;
                }
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
}