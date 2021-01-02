import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class PersonTest {

    public static void main(String[] args) {

        //
        Person p1=new Person();
        Class c1=p1.getClass();
        System.out.println(c1);

        Class c2=Person.class;

        //获得完整的名字
        String className=c2.getName();
        System.out.println(className);

        //获得类的public类型的属性
        Field[] fields=c2.getFields();
        for (Field field:fields){
            System.out.println(field.getName());
        }

        //获得类的所有属性，包括私有的
        Field[] allFields=c2.getDeclaredFields();
        for (Field field:allFields){
            System.out.println(field.getName());
        }

        //获得类的所有方法
        Method[] allMethods=c2.getDeclaredMethods();
        for (Method method:allMethods){
            System.out.println(method.getName());
        }

        //获得指定的属性
        try{
            Field f1=c2.getField("age");
            System.out.println(f1);

            //获得指定的私有属性
            Field f2= c2.getDeclaredField("name");
           /* setAccessible，启用和禁用访问安全检查的开关，值为true，则表示反射的对象在使用时
           * 应该取消Java语言的访问检查，反之不取消。
           * */
            f2.setAccessible(true);
            System.out.println(f2);

            //创建这个类的一个对象
            Object p2=c2.newInstance();

            //将p2对象的f2赋值为Bob,f2属性即为私有属性name
            f2.set(p2,"Bob");
            //利用反射机制可以打破封装，导致了Java对象的属性不安全
            System.out.println(f2.get(p2));

            //获取构造方法
            Constructor [] constructors=c2.getConstructors();
            for (Constructor constructor:constructors){
                System.out.println(constructor.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
