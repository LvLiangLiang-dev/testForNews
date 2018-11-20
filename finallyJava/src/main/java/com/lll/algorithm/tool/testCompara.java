package com.lll.algorithm.tool;

import java.util.Arrays;

/**
 *
 * Created by lvliangliang on 2017/12/19.
 */
public class testCompara {
    public static void main(String[] args) {
        Student stu[]={
                new Student(2,"zhangsan",100),
                new Student(1,"lisi",88),
                new Student(4,"wangwu",91),
                new Student(1,"zhaoliu",77)
        };
        System.out.println(stu[0].compareTo(stu[1]));
        System.out.println(stu);

        Arrays.sort(stu);
        for(Student s:stu)
            System.out.println(s);

        System.out.println(Math.random()*(100-10+1)+10);
        System.out.println((int)(Math.random()*(100-10+1))+10);

    }

}
class Student implements Comparable<Student>{
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.id>o.id)return 1;
        else if(this.id<o.id)return -1;
        else{
            if(this.age>o.age) return 1;
            else if(this.age<o.age) return -1;
            else return 0;
        }
    }
}

