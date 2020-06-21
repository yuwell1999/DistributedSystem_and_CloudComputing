package Ex01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class Client {
    byte[] packet = new byte[Constants.PACKAGE_LENGTH];
    private final DatagramPacket datagramPacket = new DatagramPacket(packet, packet.length);
    private DatagramPacket datagramPacket1 = null;

    public static void main(String[] args) throws IOException {
        new Client().init();
    }

    public void init() throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            // 创建服务端和端口
            // 打包，指明发送ip地址和端口
            datagramPacket1 = new DatagramPacket(new byte[0], 0, InetAddress.getByName(Constants.IP_ADDRESS), Constants.SERVER_PORT);

            System.out.println("请在控制台输入客户端要发送的信息：");
            Scanner input = new Scanner(System.in);

            while (input.hasNextLine()) {
                byte[] buff = input.nextLine().getBytes();
                datagramPacket1.setData(buff);
                // 调用send函数
                datagramSocket.send(datagramPacket1);
                datagramSocket.receive(datagramPacket);

                System.out.println(new String(packet, 0, datagramPacket.getLength()));
            }
        }
    }
}
