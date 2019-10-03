package xxx.yyy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) {
        final int PORT = 8000;

        try {
            DatagramSocket ds = new DatagramSocket(PORT);
            byte[] buffer = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

            do {
                ds.receive(dp);

                String str = new String(dp.getData(), 0, dp.getLength());

                if (str.equals(""))
                    break;

                System.out.println("收到字串：" + str);
            } while (true);

            System.out.println("Client端已結束！");

            ds.close();
        } catch (Exception e) {
            System.out.println("UdpServer fails.");
        }

    }
}
