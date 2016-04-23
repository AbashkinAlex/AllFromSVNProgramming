package ua.org.oa.metalfan0991.item5;


/**
 * Created by Abashkin Alexandr on 3/12/2016.
 */
public class Exam {
    private String subjectsName;
    private Integer studentAssessment;
    private String examDate;
    private int semester;



    public Exam(String subjectsName, String examDate, int semester) {
        setSubjectsName(subjectsName);
        setExamDate(examDate);
        setSemester(semester);
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(String subjectsName) {
        this.subjectsName = subjectsName;
    }

    public int getStudentAssessment() {
        return studentAssessment;
    }

    public void setStudentAssessment(Integer studentAssessment) {
        this.studentAssessment = studentAssessment;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }


    public boolean deleteStudentAssessment(){
        setStudentAssessment(null);
        return true;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "subjectsName='" + subjectsName + '\'' +
                ", studentAssessment=" + studentAssessment +
                ", examDate='" + examDate + '\'' +
                ", semester=" + semester +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (semester != exam.semester) return false;
        if (subjectsName != null ? !subjectsName.equals(exam.subjectsName) : exam.subjectsName != null) return false;
        if (studentAssessment != null ? !studentAssessment.equals(exam.studentAssessment) : exam.studentAssessment != null)
            return false;
        return !(examDate != null ? !examDate.equals(exam.examDate) : exam.examDate != null);

    }

    @Override
    public int hashCode() {
        int result = subjectsName != null ? subjectsName.hashCode() : 0;
        result = 31 * result + (studentAssessment != null ? studentAssessment.hashCode() : 0);
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        result = 31 * result + semester;
        return result;
    }
}
