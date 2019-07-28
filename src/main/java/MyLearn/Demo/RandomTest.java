package MyLearn.Demo;

/**
 * @Title: RandomTest
 * @Description: 随机数测试
 * @Company: www.leador.com.cn
 * @Date: 2019-07-26 11:27
 * @author: wangjiyuan
 * @Version: 1.0
 **/
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0;i < 10;i++){
            int index = (int) (Math.random() * 11);
            System.out.println(index);
        }
    }
}
