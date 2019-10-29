package MyLearn.Demo;

import com.mysql.cj.xdevapi.JsonArray;

import javax.swing.tree.TreeNode;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: test
 * @Description:
 * @Company: www.leador.com.cn
 * @Date: 2019-09-18 14:06
 * @author: wangjiyuan
 * @Version: 1.0
 **/
public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String s1 = new String("asddfg");
        String s2 = new String("老王");
        s1.intern();
        s1.length();
        System.out.println(s1.getBytes());
        String[] strings = {"2","3"};
        int b = strings.length;
        List<String> list = Arrays.asList("2","3");
        list.toArray();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String obj = iterator.next();
        }
        Collection<String> clist = Collections. unmodifiableCollection(list);
        Long s3 = new Long(10l);
        Long s4 = new Long(10l);
        Long s5 = 10l;
        Long s6 = 10l;
        System.out.println(s5 == s6);
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("1","111");
        map.put("2","222");
        System.out.println(map.get("1").hashCode());
        System.out.println(map.get("2").hashCode());

        String str1 = "通话";
        String str2 = "重地";
        System. out. println(String. format("str1：%d | str2：%d",  str1. hashCode(),str2. hashCode()));
        System. out. println(str1. equals(str2));

        short sh1 = 1;
        sh1 = (short)( sh1 + 1);
        sh1 += 1;
        int a = 2 << 3;
        System.out.println(a);
        Integer.valueOf("1");
        Integer.parseInt("1");
        String x = 1 + "";
        String.valueOf(1);
        String s1 = "你好";
        String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
        String sr = reverse("123");
        System.out.println(sr);
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonth());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        System.out.println();
        Collection collection = new LinkedList();
        Object o = new Object();
        JsonArray jsonArray = new JsonArray();*/
        /*Scanner scanner = new Scanner(System.in);
        String src = scanner.next();
        char pre = '\0';
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char cur = src.charAt(i);
            if (cur == pre) {
                count++;
            } else {
                if (pre != '\0') {
                    if(count > 1) {
                        result.append(count);
                    }
                    result.append(pre);
                }
                pre = cur;
                count = 1;
            }
        }
        if (pre != '\0') {
            if(count > 1) {
                result.append(count);
            }
            result.append(pre);
        }
        System.out.println(result.toString());*/
        //Character.isLetterOrDigit('a');
        /*char a = 'a';
        System.out.println((int)a);*/
        /*String str = "13500006666,13611125565,15899903312";
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        while (m.find()){
            System.out.println(m.group());
        }*/
        int a = 1;
        double b = 1.0;
        System.out.println((int) b);
        System.out.println(a==b);
    }

     public static String reverse(String originStr) {
         if(originStr == null || originStr.length() <= 1)
             return originStr;
         return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
