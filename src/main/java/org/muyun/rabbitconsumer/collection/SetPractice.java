package org.muyun.rabbitconsumer.collection;

import org.muyun.rabbitconsumer.entry.Student;
import org.muyun.rabbitconsumer.entry.Teacher;
import org.muyun.rabbitconsumer.utils.MyComparator;

import java.util.*;

//HashSet 底层是数组、链表、红黑树 ==> hash表 保证数据唯一的方法通过equals() 和 hashCode()
// hashCode()计算hash码值，如果两个数据对象相同，他们的hashCode()相同
// equals() 在存储hash表的时候判断唯一 自定义的对象一定要重写equals() 和hashCode()方法
//TreeSet 红黑树  implement Comparable 重写comparaTo方法 通过返回值-1、0-1比较
//     10
//    9  11
//      左低右高的形式排列 相同不放入
//LinkedHashSet 链表+hash表 继承HashSet 插入顺序排序
// 无序唯一 只能增删
public class SetPractice {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("bc");
        set.add("cb");
        System.out.println(set);

        set.add("a");
        System.out.println(set);

        Student stuFir = new Student(1,"张三", 18);
        Student stuSec = new Student(2,"李四", 19);

        Set<Student> treeSetStudent = new HashSet<>();
        treeSetStudent.add(new Student(1,"张三", 18));
        treeSetStudent.add(new Student(2,"张三", 18));
        treeSetStudent.add(stuSec);
        System.out.println(treeSetStudent);

        Set<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("b");
        linkedHashSet.add("bc");
        linkedHashSet.add("b");
        linkedHashSet.add("a");
        System.out.println(linkedHashSet);

        Set<Student> treeSet = new TreeSet<>();
        treeSet.add(stuFir);
        treeSet.add(stuSec);
        System.out.println(treeSet);


        Set<Integer> stringSet = new HashSet<>();
        stringSet.add(10);
        stringSet.add(9);
        stringSet.add(12);
        stringSet.add(11);
        System.out.println(stringSet );


        MyComparator myComparator = new MyComparator();
        Teacher teacherWang = new Teacher("王老师", 18);
        Teacher teacherLi = new Teacher("李老师", 19);
        int num = myComparator.compare(teacherWang, teacherLi);
        System.out.println(num);
        // 应用外部比较器
        Set<Teacher> tcherSet = new TreeSet<>(myComparator);

        Set<Teacher> teacherSet = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        teacherSet.add(teacherWang);
        teacherSet.add(teacherLi);
        teacherSet.add(new Teacher("李老师", 19));

        // 不能为空、会报错
        //teacherSet.add(null);
        System.out.println(teacherSet);


    }
}
