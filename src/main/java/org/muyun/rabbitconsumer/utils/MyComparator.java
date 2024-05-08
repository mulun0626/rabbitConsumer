package org.muyun.rabbitconsumer.utils;

import org.muyun.rabbitconsumer.entry.Teacher;

import java.util.Comparator;

// 外部比较器 Teacher类无法改变的时候创建（如果类能改动优先写内部比较器）
public class MyComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getAge() - o2.getAge();
    }
}
