/**
 * Created by Abashkin Aleksandr on 21.03.2016.
 */

import annotations.time.Time;

import java.io.*;

/**
 * Практическое занятие I/O Stream
 * <p/>
 * +++1. Создать и заполнить файл случайными целыми числами.
 * <p/>
 * +++2. Создать метод который отсортирует содержимое файла из пункта 1 по возрастанию
 * <p/>
 * +++3. В файле построчно содержится список студентов и их оценки. Вывести
 * на экран фамилии студентов, которые имеют средний балл более "90".
 * <p/>
 * Пример содержимого файла:
 * Illia Vinnichenko = 90
 * Koliy Lototskiy = 84
 * <p/>
 * +++ 4. Прочитать строки из файла и поменять местами первое и последнее слова
 * в каждой строке. (Усложненный вариант – поменять местами первое и
 * последнее слово в предложении).
 * <p/>
 * +++ 5. Скопировать содержимое одного файла в другой файл с использованием
 * буферизированных и не буферизированных потоков. Сравнить время
 * <p/>
 * +++ 6. Создать класс Student и класс Group содержащий коллекцию студентов.
 * Выполнить сериализацию и десериализацию объекта класса Group.
 */
public class App {
    private static String fileAdressForQuest1 = "src/main/resources/question1";
    private static String fileAdressForQuest2 = "src/main/resources/question2";
    private static String fileAdressForQuest3 = "src/main/resources/question3";
    private static String fileAdressForQuest4 = "src/main/resources/question4";
    private static String fileAdressForQuest5_1 = "src/main/resources/question5/question5_Bufer_INPUT";
    private static String fileAdressForQuest5_2 = "src/main/resources/question5/question5_Bufer_OUTPUT";
    private static String fileAdressForQuest5_3 = "src/main/resources/question5/question5_NOTBufer_INPUT";
    private static String fileAdressForQuest5_4 = "src/main/resources/question5/question5_NOTBufer_OUTPUT";
    private static File fileGroup = new File("src/main/resources/question6/Group.data");


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("~~~~~~~~~1. Создать и заполнить файл случайными целыми числами.~~~~~~~~~~~~");
        System.out.println(StringUtils.randomNumbers(fileAdressForQuest1, 100));

        System.out.println("~~~~~~~~~2. Создать метод который отсортирует содержимое файла из пункта 1 по возрастанию.~~~~~~~~~~~~");
        System.out.println(StringUtils.writeToFile(StringUtils.readFromFile(fileAdressForQuest1), fileAdressForQuest2));

        System.out.println("~~~~~~~~~3. В файле построчно содержится список студентов и их оценки. Вывести на экран фамилии студентов, которые имеют средний балл более \"90\".~~~~~~~~~~~~");
        System.out.println("Весь список: " + StringUtils.fileToMap(fileAdressForQuest3));
        System.out.println("Отсортированный список: " + StringUtils.sortByScore(StringUtils.fileToMap(fileAdressForQuest3), 90));

        System.out.println("~~~~~~~~~~4. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке. (Усложненный вариант – поменять местами первое и последнее слово в предложении).~~~~~~~~~~~~~~~");
        System.out.println("Исходная строка :" + StringUtils.readFromFile2(fileAdressForQuest4));
        System.out.println("Результат : " + (StringUtils.changeSentence(StringUtils.readFromFile2(fileAdressForQuest4))));
        StringUtils.writeToFile(StringUtils.changeSentence(StringUtils.readFromFile2(fileAdressForQuest4)), fileAdressForQuest4);

        System.out.println("~~~~~~~~~~~5. Скопировать содержимое одного файла в другой файл с использованием буферизированных и не буферизированных потоков. Сравнить время~~~~~~~~~~~");
        long timestart1 = System.currentTimeMillis();
        System.out.println(StringUtils.bufferedCopyUtils(fileAdressForQuest5_1, fileAdressForQuest5_2));
        long timeend1 = System.currentTimeMillis();
        System.out.println("Время работы метода bufferedCopyUtils(fileAdressForQuest5_1, fileAdressForQuest5_2):  " + (timeend1 - timestart1));
        long timestart2 = System.currentTimeMillis();
        System.out.println(StringUtils.NotBufferedCopyUtils(fileAdressForQuest5_3, fileAdressForQuest5_4));
        long timeend2 = System.currentTimeMillis();
        System.out.println("Время работы метода NotBufferedCopyUtils(fileAdressForQuest5_3, fileAdressForQuest5_4):  " + (timeend2 - timestart2));

        System.out.println("~~~~~~~~~~~6. Создать класс Student и класс Group содержащий коллекцию студентов. Выполнить сериализацию и десериализацию объекта класса Group.~~~~~~~~~~~");
        Group myGroup = new Group("Group 1");
        Student student = new Student("Sasha", 25, myGroup);
        Student student2 = new Student("Petya", 25, myGroup);
        Student student3 = new Student("Vasya", 25, myGroup);
        SerializableClassUtils.serializableMethod(myGroup,fileGroup);



    }
}
