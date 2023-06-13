import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Servidor iniciado. Aguardando conexão...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Cliente: " + inputLine);
            if (inputLine.equals("!quit")) {
                break;
            }
        }

        System.out.println("Cliente desconectado.");
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
