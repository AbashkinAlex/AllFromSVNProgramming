package ua.org.oa.metalfan0991.item5;


/**
 * Created by Abashkin Alexandr on 3/12/2016.
 */
public class App {
    public static void main(String[] args) throws NoSuchSubjectOrDateException {
        //Создаем группу
        Group someGroup = new Group("Гр-1", "Прикладная математика", "ЭМСфак");
        //Создаем студента
        Student vasya = new Student("Вася", "Пупкин");
        //Создаем экзамены
        Exam EnglishExam1 = new Exam("English", "JANUARY 4 2016", 1);
        Exam EnglishExam2 = new Exam("English", "JANUARY 5 2016", 1);
        Exam EnglishExam3 = new Exam("English", "JANUARY 6 2016", 1);
        Exam EnglishExam4 = new Exam("English", "JANUARY 7 2016", 1);
        //добавить студента в группу
        vasya.setGroup(someGroup);
        //добавить экзамены что он сдавал
        vasya.addExam(EnglishExam1);
        vasya.addExam(EnglishExam2);
        vasya.addExam(EnglishExam3);
        vasya.addExam(EnglishExam4);
        //Выставляем оценки студенту
        vasya.addAssessment("JANUARY 4 2016", "English", 5);
        vasya.addAssessment("JANUARY 5 2016", "English", 8);
        vasya.addAssessment("JANUARY 6 2016", "English", 8);
        vasya.addAssessment("JANUARY 7 2016", "English", 12);

        // - узнать наивысшую оценку среди всех экзаменов по данному предмету
        System.out.println("Max assessment is : " + vasya.getMaxAssessment("English"));
        // удалить для него оценку по экзамену
        vasya.deleteAssessment("JANUARY 7 2016", "English");
        // - узнать наивысшую оценку среди всех экзаменов по данному предмету
        System.out.println("Max assessment is(after remove one assessment) : " + vasya.getMaxAssessment("English"));
        // - узнать число экзаменов, которые он сдал с указанной оценкой
        System.out.println("The number of examinations which he passed with an estimate of 8 points: " + vasya.getNumberOfExam(8));
        // - узнать его средний балл за указанный семестр;
        System.out.println("Average score for the 1 semester: " + vasya.getAverageAssessment(1));
    }
}
