import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 1234;

        Socket socket = new Socket(serverIP, serverPort);
        System.out.println("Conectado ao servidor.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.print("Digite uma mensagem (ou !quit para sair): ");
            userInput = scanner.nextLine();
            out.println(userInput);

            String serverResponse = in.readLine();
            System.out.println("Servidor: " + serverResponse);
        } while (!userInput.equals("!quit"));

        System.out.println("Desconectado do servidor.");
        in.close();
        out.close();
        socket.close();
        scanner.close();
    }
}
