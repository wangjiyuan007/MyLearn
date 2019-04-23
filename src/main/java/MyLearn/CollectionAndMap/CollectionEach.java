package MyLearn.CollectionAndMap;

import java.util.Collection;
import java.util.HashSet;

public class CollectionEach {
    public static void main(String[] args){
        Collection books = new HashSet();
        books.add("轻量级Jave EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        //调用foreach()方法遍历集合
        books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
