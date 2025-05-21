//Creating a server to connect to a client
/*This is a java simple HTTP server that listens on port 8080, accepts requests from the client
 and then responds to the client requests
 for this case the response is just the date and a welcome message*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPserver {

    public static void main(String[] args) throws Exception {
        // creates a new server socket at port 8080
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080........");
        while (true) {
            //
            try (Socket socket = server.accept()) {

                // reads HTTP requests and prints them to the terminal
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                // sends a response to the http client with date and message
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today + " Welcome";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }

    }
}
