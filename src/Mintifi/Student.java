package Mintifi;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a num array, index representing studentId starting from 1,
Print the index of top three students who scored the highest marks.
 */
public class Student {
    int id;
    int marks;

    public Student(int id, int marks){
        this.id = id;
        this.marks = marks;
    }

    public static class StudentComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o2.marks,o1.marks);
        }
    }

    public static void main(String[] args){
        int[] num = {20,100,40,20,25,60,70,55,50,80};

        Student[] studentsArr = new Student[num.length];

        for(int i = 0; i < num.length; i++){
            studentsArr[i] = new Student(i+1, num[i]);
        }

        Arrays.sort(studentsArr, new StudentComparator());

        for(int i = 0; i < 3; i++)
            System.out.println(studentsArr[i].id);
    }
}
