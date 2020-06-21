package Ex02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.receiveMessage();
    }

    public void sendMessage(String ip, int port, String msg) throws Exception {
        Socket s = new Socket(ip, port);
        OutputStream os = s.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println(msg);
    }

    public void receiveMessage() throws Exception {
        ServerSocket ss = new ServerSocket(Constants.SERVER_PORT);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("客户端发送的信息为：" + br.readLine());
    }
}
