package Ex02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyStreamSocket extends Socket {
    public static void main(String[] args) throws Exception {
        MyStreamSocket mss = new MyStreamSocket();

        System.out.println("请在控制台输入客户端要发送的信息：");
        Scanner input = new Scanner(System.in);
        String clientMsg = input.next();

        mss.sendMessage(Constants.IP_ADDRESS, Constants.SERVER_PORT, clientMsg);
    }

    public void sendMessage(String ip, int port, String msg) throws Exception {
        Socket s = new Socket(ip, port);
        OutputStream os = s.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println(msg);
    }

    public String receiveMessage() throws Exception {
        ServerSocket ss = new ServerSocket(Constants.SERVER_PORT);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.readLine();
    }
}
