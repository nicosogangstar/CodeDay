package Sockets;
import java.io.*;
import java.net.*;

public class clientPong {
    public static void main(String[] args) throws IOException {
        
        String hostName = "69.250.8.138";
        int portNumber = 7070;

        try (
            Socket pSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(pSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(pSocket.getInputStream()));
        )
        {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("END"))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                	//Should display data recieved
                    System.out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
    
}