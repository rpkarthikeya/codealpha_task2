package service;

import model.Student;

import java.util.ArrayList;

class GradeTracker {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public double getAverage() {

        if(students.isEmpty())
            return 0;

        double sum = 0;

        for(Student s : students)
            sum += s.getGrade();

        return sum/students.size();
    }

    public double getHighest() {

        if(students.isEmpty())
            return 0;

        double max = students.get(0).getGrade();

        for(Student s : students)
            if(s.getGrade() > max)
                max = s.getGrade();

        return max;
    }

    public double getLowest() {

        if(students.isEmpty())
            return 0;

        double min = students.get(0).getGrade();

        for(Student s : students)
            if(s.getGrade() < min)
                min = s.getGrade();

        return min;
    }
}