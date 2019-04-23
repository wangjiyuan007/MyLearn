package MyLearn.CollectionAndMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args){
        Collection books = new HashSet();
        books.add("轻量级Jave EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        //获取books集合对应的迭代器
        Iterator it = books.iterator();
        while (it.hasNext()){
            String book = (String)it.next();
            System.out.println(book);
            if (book.equals("疯狂Java讲义")){
                //从集合中删除上一次next()方法返回的元素,这里不能写books.remove()
                it.remove();
            }
            //在这里赋值不会改变集合元素本身，因为book只是一个值，并不是集合中的对象
            book = "测试字符串";
        }
        System.out.println(books);
    }
}
