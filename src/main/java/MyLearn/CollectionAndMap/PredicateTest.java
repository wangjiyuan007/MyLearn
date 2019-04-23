package MyLearn.CollectionAndMap;

import java.util.Collection;
import java.util.HashSet;

public class PredicateTest {
    public static void main(String[] args){
        Collection books = new HashSet();
        books.add("轻量级Jave EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");

        //使用Lambda表达式过滤集合
        books.removeIf(ele -> ((String)ele).length()<10);
        System.out.println(books);
    }


}
