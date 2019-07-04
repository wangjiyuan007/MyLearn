package MyLearn.Demo;

import java.math.BigInteger;
import java.util.Scanner;

public class JieCheng {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        while (scr.hasNext()){
            int target = scr.nextInt();
            BigInteger result = new BigInteger("1"); //保证数据是BigInteger类型的，可以用初始化（valueOf）或者new一个
            for (int i=1; i<=target; i++){
                result = result.multiply(BigInteger.valueOf(i));
            }
            System.out.println(result);
        }
    }
}
