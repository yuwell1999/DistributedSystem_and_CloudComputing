package Ex01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server implements Runnable {
    String info = "信息发送成功";
    byte[] container = new byte[Constants.PACKAGE_LENGTH];
    // 封装成包
    private final DatagramPacket packet = new DatagramPacket(container, container.length);
    private DatagramPacket packet1;

    private DatagramSocket datagramSocket = null;

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.init();
        server.run();
    }

    public void init() throws IOException {
        // 创建服务端和端口
        datagramSocket = new DatagramSocket(Constants.SERVER_PORT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                datagramSocket.receive(packet);

                System.out.println("服务器接收的信息为：");
                System.out.println(new String(container, 0, packet.getLength()));

                byte[] data = info.getBytes();
                packet1 = new DatagramPacket(data, data.length, packet.getSocketAddress());
                datagramSocket.send(packet1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
