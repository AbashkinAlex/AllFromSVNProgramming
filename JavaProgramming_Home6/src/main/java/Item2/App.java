package Item2;

/**
 * Created by Abashkin Aleksandr on 29.01.2016.
 */

import jdk.nashorn.internal.parser.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 2. Написать приложение мини-файловый редактор.
 *
 * Реализовать команды, создания файла, удаления файла, перейменования, для папки
 * отображение списка файлов внутри.
 *
 * В комнадной строке передавать название файла и команду
 */


public class App {
    static String nameNewFile;
    static String renameNewFile;
    static String deleteNewFile;
    static String folderName;
    static boolean fileExist;
    static boolean fileRename;
    static boolean fileDelete;

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {


            System.out.println("В какой папке будем смотреть список файлов ?" +
                    " (адрес папки с файлами что мы создавали : src\\main\\resources\\item2\\ ) ");
            folderName = bufferedReader.readLine();
            System.out.println("Все файлики в папочке :");
            for (int i = 0; i < listFiles(folderName).length; i++) {
                System.out.println(listFiles(folderName)[i].getName());
            }


            System.out.println("Как назовём новый файл?");
            nameNewFile = "src\\main\\resources\\item2\\" + bufferedReader.readLine() + ".txt";
            File f = createNewFile(nameNewFile);
            if (fileExist) {
                System.out.println("Новый файл создан с именем " + f.getName() + ".");
            } else {
                System.out.println("Файл " + f.getName() + " уже существует");
            }


            System.out.println("Как переименуем файл " + f.getName() + " ?");
            renameNewFile = "src\\main\\resources\\item2\\" + bufferedReader.readLine() + ".txt";
            File f2 = renameFile(nameNewFile, renameNewFile);
            if (fileRename) {
                System.out.println("Файл " + f.getName() + " переименован в " + f2.getName());
            } else {
                System.out.println("Не удается переименовать! Файл " + f2.getName() + " уже существует!");
            }


            System.out.println("Какой файл будем удалять ?");
            deleteNewFile = "src\\main\\resources\\item2\\" + bufferedReader.readLine() + ".txt";
            if (deleteFile(deleteNewFile)) {
                System.out.println("Файл удалён");
            } else {
                System.out.println("Файлаv не существует в указанной директории.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static File[] listFiles(String s) {
        File myFolder = new File(s);
        File[] files = myFolder.listFiles();
        return files;
    }

    public static File createNewFile(String s) {
        File newFile = new File(s);
        try {
            if (newFile.createNewFile()) {
                fileExist = true;
            } else {
                fileExist = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    public static File renameFile(String nameNewFile, String renameNewFile) {
        File beforeRename = new File(nameNewFile);
        File afterRename = new File(renameNewFile);
        if (beforeRename.renameTo(afterRename)) {
            fileRename = true;
        } else {
            fileRename = false;
        }
        return afterRename;
    }

    public static boolean deleteFile(String s) {
        File newFile = new File(s);
        if (newFile.delete()) {
            fileDelete = true;
        } else {
            fileDelete = false;
        }
        return fileDelete;
    }
}
