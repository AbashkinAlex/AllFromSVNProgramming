package ua.org.oa.metalfan0991;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Abashkin Aleksandr on 13.01.2016.
 */
public class App {
    /**
     * Remote issue assignee account created Task PTOCTXVB-68
     * Задание 5
     * Issue Type:	Task Task
     * Assignee:	Абашкин Александр
     * Created:	28/ноя/15 2:44 PM
     * Description:
     * <p/>
     * Написать приложение переводчик. В качестве хранилища словарей использовать текстовый файл.
     * Текст для перевода брать из файла. Перевод печатать в консоль.
     * <p/>
     * Детальное описание:
     * <p/>
     * +1. Сделать консольный интерфейс.
     * <p/>
     * +2. Должно поддерживаться несколько языков и перевод в обоих направлениях;
     * <p/>
     * +3. Направления перевода и языки определять автоматически по файлам словарей (их имена) (лежат на диске в заданной директории).
     * <p/>
     * +Поиск файлов(директорий) и работа с ними осуществляется через class File, обратите внимание на методы .exists(), .listFiles(),
     * .getName() этого класса.
     * <p/>
     * 4.+ При старте приложения словарь переводчика считывается из файла и сохраняется в HashMap.
     * <p/>
     * 5.+ Должен быть метод перевести, который в качестве аргументов получает путь к файлу который надо переводить (String) и
     * словарь который использовать (HashMap).
     * <p/>
     * 6. +Реализовать проверку на доступность выбранного направления перевода, если язык или направление отсутствует кинуть эксепшин.
     * <p/>
     * 7.+ Вывести переведенный текст в консоль.
     * <p/>
     * Project:	PTOCTXVB
     * Priority:	Major Major
     * Reporter:	Remote issue assignee account
     * Security Level:	Assignee (Assignee)
     *
     * @param args
     */


    static String adressFileSourceTranslate = "DictionaryApp\\SourceText\\Russian text.txt";                         //Адрес к файлу с исходным текстом на русском языке для перевода
    //    static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Russian-English Vocabulary.txt";         //Адрес к файлу с русско-английским словарём
    static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Russian-Ukrainian Vocabulary.txt";       //Адрес к файлу с русско-украинским словарём


//      static String adressFileSourceTranslate = "DictionaryApp\\SourceText\\English text.txt";                      //Адрес к файлу с исходным текстом на английском языке для перевода
//      static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\English-Russian Vocabulary.txt";      //Адрес к файлу с англо-русским словарём

//      static String adressFileSourceTranslate = "DictionaryApp\\SourceText\\Ukrainian text.txt";                    //Адрес к файлу с исходным текстом на украинском языке для перевода
//      static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Ukrainian-Russian Vocabulary.txt";    //Адрес к файлу с украиско-русским словарём


    static boolean English;
    static boolean Russian;
    static boolean Ukrainian;

    public static void main(String[] args) {


        System.out.println("Приложение переводчик");
        System.out.println("Исходный текст берёт из файла.Адреса файлов прописаны в переменной adressFileSourceTranslate(нужные адреса раскомментировать).");
        System.out.println("Словарь также берёт из файла(необходимый словарь раскоментировать).");
        System.out.println("Словари на 5 слов (исключение Англо-русский, там 2000 слов).");

        System.out.println("readFromFileSourceTranslate " + adressFileSourceTranslate + " ---> " + readFromFileSourceTranslate(adressFileSourceTranslate));
        System.out.println("readFromFileVocabulary " + adressFileVocabulary + " ---> " + readFromFileVocabulary(adressFileVocabulary));


        System.out.println("Translated : "+translate(readFromFileSourceTranslate(adressFileSourceTranslate)));

    }

//-------Метод получает строку для перевода и возвращает перевод
    public static String translate(String string) {

        String translate;
        StringBuilder sb = new StringBuilder();
            try {
                for (String s : string.split(" ")) {                  //for (String s : string.split("\\W+"))

                    translate = readFromFileVocabulary(adressFileVocabulary).get(s.toLowerCase());
                    sb.append(translate != null ? translate : s).append(" ");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        return sb.toString();
    }

//-------Метод получает в качестве аргумента адрес файла с исходным текстом, а возвращает строку с этим текстом
    public static String readFromFileSourceTranslate(String adress) {
        String str = null;
        File sourceFile = new File(adress);
        if (sourceFile.getName().equals("English text.txt")) {
            English = true;
        }
        if (sourceFile.getName().equals("Russian text.txt")) {
            Russian = true;
        }
        if (sourceFile.getName().equals("Ukrainian text.txt")) {
            Ukrainian = true;
        }
        BufferedReader sourceBufferedReader;
        try {
            sourceBufferedReader = new BufferedReader(new FileReader(sourceFile));
            str = sourceBufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
//-------Метод получает в качестве аргумента адрес словаря, а возвращает HashMap с добавленными словами
    public static Map<String, String> readFromFileVocabulary(String adress) {
        String str;
        Map<String, String> map = new HashMap<String,String>();
        File file = new File(adress);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((str = br.readLine()) != null) {
                String str1 = null;
                String str2 = null;
                Pattern patternForTranslate = null;

                if (English) {
                    patternForTranslate = Pattern.compile("\\w+\\ ");       //("\\W+")
                }
                if (Russian) {
                    patternForTranslate = Pattern.compile("\\W+");   //("\\w+\\ ")  (".+\\w[^=]")      ("([A-Za-z[^=]]){1,10}(\\W)")  ("\\W+")
                    if (file.getName().equals("Russian-Ukrainian Vocabulary.txt")) {
                        patternForTranslate = Pattern.compile(".+ ");   //("\\w+\\ ")  (".+\\w[^=]")      ("([A-Za-z[^=]]){1,10}(\\W)")  ("\\W+")
                    }
                }
                if (Ukrainian) {
                    patternForTranslate = Pattern.compile(".+ ");   //("\\w+\\ ")  (".+\\w[^=]")      ("([A-Za-z[^=]]){1,10}(\\W)")  ("\\W+")
                }


                Pattern patternTranslated = Pattern.compile(" +.+");     //(" +.+\\S")   (" +.+")   and=и  ("[^=]+.")              ("[^=]+")
                Matcher matcherForTranslate = patternForTranslate.matcher(str.toLowerCase());
                Matcher matcherTranslated = patternTranslated.matcher(str.toLowerCase());

                while (matcherForTranslate.find()) {
                    StringBuffer stringBuffer = new StringBuffer(matcherForTranslate.group());
                    stringBuffer.delete(matcherForTranslate.group().length() - 1, matcherForTranslate.group().length());
                    str1 = stringBuffer.toString();
                }
                while (matcherTranslated.find()) {
                    StringBuffer stringBuffer = new StringBuffer(matcherTranslated.group());
                    stringBuffer.delete(0, 1);
                    str2 = stringBuffer.toString();
                }
                map.put(str1, str2); // Добавляем в HashMap все слова с переводами как пару ключ-значение
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
