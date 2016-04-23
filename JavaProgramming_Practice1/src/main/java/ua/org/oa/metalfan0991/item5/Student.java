package ua.org.oa.metalfan0991.item5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Abashkin Alexandr on 3/12/2016.
 */
public class Student {
    private String name;
    private String surname;
    private Group group;
    private List<Exam> examList = new ArrayList<>();


    public Student(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public boolean addExam(Exam exam) {
        examList.add(exam);
        return true;
    }

    // - узнать наивысшую оценку среди всех экзаменов по данному предмету
    public int getMaxAssessment(String subjectsName) throws NoSuchSubjectOrDateException {
        List<Integer> maxAssessment = new ArrayList();
        for (Exam exam : examList) {
            if (subjectsName.equals(exam.getSubjectsName())) {
                maxAssessment.add(exam.getStudentAssessment());
            } else {
                System.out.println("Нет такого предмета: " + subjectsName);
                throw new NoSuchSubjectOrDateException();
            }
        }
        return Collections.max(maxAssessment);
    }

    public boolean addAssessment(String examDate, String subjectsName, int assessment) throws NoSuchSubjectOrDateException {
        boolean ok = false;
        for (Exam exam : examList) {
            if ((subjectsName.equals(exam.getSubjectsName())) && (examDate.equals(exam.getExamDate()))) {
                exam.setStudentAssessment(assessment);
                ok = true;
            }
        }
        if (!ok) {
            throw new NoSuchSubjectOrDateException();
        }
        return true;
    }

    public boolean deleteAssessment(String examDate, String subjectsName) throws NoSuchSubjectOrDateException {
        boolean ok = false;
        for (Exam exam : examList) {
            if ((subjectsName.equals(exam.getSubjectsName())) && (examDate.equals(exam.getExamDate()))) {
                exam.setStudentAssessment(0);
                ok = true;
            }
        }
        if (!ok) {
            throw new NoSuchSubjectOrDateException();
        }
        return true;
    }


    public int getNumberOfExam(int assessment) throws NoSuchSubjectOrDateException {
        int count = 0;
        for (Exam exam : examList) {
            if (assessment == exam.getStudentAssessment()) {
                count++;
            }
        }
        return count;
    }

    public double getAverageAssessment(int semester) throws NoSuchSubjectOrDateException {
        double sum = 0;
        for (Exam exam : examList) {
            if (semester == exam.getSemester()) {
                sum += exam.getStudentAssessment();
            }
        }
        return sum / examList.size();
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group + "}";
    }
}
