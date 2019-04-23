package MyLearn.CollectionAndMap;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
    public static void main(String[] args){
        Collection books = new HashSet();
        books.add("轻量级Jave EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");

        for(Object obj : books){
            String book = (String)obj;
            System.out.println(book);
            if(book.equals("疯狂Java讲义")){
                //会报ConcurrentModificationException异常
                //books.remove(book);
            }
        }
        System.out.println(books);
    }
}
