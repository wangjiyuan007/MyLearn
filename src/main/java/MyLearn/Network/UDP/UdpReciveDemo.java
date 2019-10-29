package MyLearn.Network.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ：shuquanliang
 * @date ：Created in 2019/6/21 15:06
 * @description：
 */
public class UdpReciveDemo {
    public static void main(String[] args) throws Exception {
        //创建一个DatagramSocket实例，并且把实例绑定到本机的地址，端口10005
        DatagramSocket datagramSocket = new DatagramSocket(10005);
        byte[] bytes = new byte[1024];
        //以一个空数组来创建DatagramPacket，这个对象作用就是接收DatagramSocket中的数据包
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        while (true) {
            //接收到的数据包
            datagramSocket.receive(datagramPacket);
            //获取接收的数据
            byte[] data = datagramPacket.getData();
            //把数组转成字符
            String str = new String(data, 0, datagramPacket.getLength());
            //如果数据包中是88的信息，则跳出并且关闭
            if ("88".equals(str)) {
                System.out.println("断开接收请求");
                break;
            }
            //打印数据
            System.out.println("接收到的数据为:" + str);
        }
        datagramSocket.close();
    }
}
