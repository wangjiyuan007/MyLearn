package MyLearn.ClassAndReflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

//定义可重复注解
@Repeatable(Annos.class)
@interface Anno {}
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos{
    Anno[] value();
}
//使用4个注解修饰该类
@SuppressWarnings(value = "unchecked")
@Deprecated
//使用重复注解修饰该类
@Anno
@Anno
public class ClassTest {
    //为该类定义一个私有的构造器
    private ClassTest(){

    }
    //定义一个有参数的构造器
    public ClassTest(String name){
        System.out.println("执行有参数的构造器");
    }
    //定义一个无参数的info方法
    public void info(){
        System.out.println("执行无参数的info方法");
    }
    //定义一个有参数的info方法
    public void info(String str){
        System.out.println("执行有参数的info方法"+"，其str参数值："+str);
    }
    //定义一个内部用的测试类
    class Inner{

    }
    public static void main(String[] args) throws Exception{
        //获取ClassTest对应的Class
        Class<ClassTest> clazz = ClassTest.class;
        //获取该Class对象所对应类的全部构造器
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器如下：");
        for (Constructor c : ctors){
            System.out.println(c);
        }
        //获取该Class对象所对应类的全部public方法
        Method[] mtds = clazz.getMethods();
        System.out.println("ClassTest的全部public方法如下：");
        for (Method md : mtds){
            System.out.println(md);
        }
        //获取该Class对象所对应类的指定方法
        System.out.println("ClassTest里带一个字符串参数的info方法为："+
                clazz.getMethod("info",String.class));
        //获取该Class对象所对应类的全部注解
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest的全部Annotation如下:");
        for (Annotation an : anns){
            System.out.println(an);
        }
        System.out.println("该元素上的@SuppressWarnings注解为："+
                Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));
        System.out.println("该元素上的@Anno注解为："+
                Arrays.toString(clazz.getAnnotationsByType(Anno.class)));
        //获取该Class对象所对应类的全部内部类
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下：");
        for (Class c : inners){
            System.out.println(c);
        }
        //使用forname方法加载内部类
        Class inclazz = Class.forName("MyLearn.ClassAndReflect.ClassTest$Inner");
        //访问外部类
        System.out.println("inClazz对应的外部类为："+
                inclazz.getDeclaredClasses());
        System.out.println("ClassTest的包为：" + clazz.getPackage());
        System.out.println("ClassTest的父类为：" + clazz.getSuperclass());
    }
}
