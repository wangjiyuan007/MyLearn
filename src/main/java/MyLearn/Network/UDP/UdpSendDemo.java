package MyLearn.Network.UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ：shuquanliang
 * @date ：Created in 2019/6/21 15:14
 * @description：
 */
public class UdpSendDemo {
    public static void main(String[] args) throws Exception {
        //创建一个DatagramSocket实例
        DatagramSocket datagramSocket = new DatagramSocket();
        //使用键盘输入构建一个BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            //转换byte
            byte[] bytes = line.getBytes();
            //创建一个用于发生的DatagramPacket对象
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 10005);
            datagramSocket.send(datagramPacket);
            if ("88".equals(line)) {
                System.out.println("断开发送请求");
                break;
            }
        }
        datagramSocket.close();
    }
}
