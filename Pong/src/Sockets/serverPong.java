package Sockets;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class serverPong {
    public static void main(String[] args) throws IOException {
    String[] arg = new String[2];
    String clientSentence;
    String capitalizedSentence;
    ServerSocket welcomeSocket = new ServerSocket(7070);
    int a=0;
    while(a<1000000){
    	a++;
    	Socket connectionSocket = welcomeSocket.accept();
    	BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    	DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    	clientSentence = inFromClient.readLine();
    	System.out.println("Received: " + clientSentence);
    	capitalizedSentence = clientSentence.toUpperCase() + '\n';
    	outToClient.writeBytes(capitalizedSentence);
    	}
    welcomeSocket.close();
    }
}