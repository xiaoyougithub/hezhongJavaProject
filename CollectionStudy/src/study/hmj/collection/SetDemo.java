package study.hmj.collection;
/**
 * 
 * @author Hmj
 * @Date 2019-07-11
 *	集合：集合是存储不同元素的数据集合，所以要改写元素的hashCode和equals方法
 *	hashCode是jdk根据对象地址或字符串等计算得到的int数值
 *	equals方法先比较对象的地址空间再比较对象的值是否一致
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Person p1 = new Person("lxp",10);
        Person p2 = new Person("lxp",10);
        Person p3 = new Person("lxp",20);

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p1);
        System.out.println("---------");
        list.add(p2);
        System.out.println("---------");
        list.add(p3);
        System.out.println("List size=" + list.size());

        System.out.println("----分割线-----");

        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        System.out.println("---------");
        set.add(p2);
        System.out.println("---------");
        set.add(p3);
        System.out.println("Set size="+set.size());
    }


    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("Call equals();name="+name);
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return name.equals(person.name);

        }

        @Override
        public int hashCode() {
            System.out.println("Call hashCode(),age="+age);
            return age;
        }
    }
}
