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
     * ������� 5
     * Issue Type:	Task Task
     * Assignee:	������� ���������
     * Created:	28/���/15 2:44 PM
     * Description:
     * <p/>
     * �������� ���������� ����������. � �������� ��������� �������� ������������ ��������� ����.
     * ����� ��� �������� ����� �� �����. ������� �������� � �������.
     * <p/>
     * ��������� ��������:
     * <p/>
     * +1. ������� ���������� ���������.
     * <p/>
     * +2. ������ �������������� ��������� ������ � ������� � ����� ������������;
     * <p/>
     * +3. ����������� �������� � ����� ���������� ������������� �� ������ �������� (�� �����) (����� �� ����� � �������� ����������).
     * <p/>
     * +����� ������(����������) � ������ � ���� �������������� ����� class File, �������� �������� �� ������ .exists(), .listFiles(),
     * .getName() ����� ������.
     * <p/>
     * 4.+ ��� ������ ���������� ������� ����������� ����������� �� ����� � ����������� � HashMap.
     * <p/>
     * 5.+ ������ ���� ����� ���������, ������� � �������� ���������� �������� ���� � ����� ������� ���� ���������� (String) �
     * ������� ������� ������������ (HashMap).
     * <p/>
     * 6. +����������� �������� �� ����������� ���������� ����������� ��������, ���� ���� ��� ����������� ����������� ������ ��������.
     * <p/>
     * 7.+ ������� ������������ ����� � �������.
     * <p/>
     * Project:	PTOCTXVB
     * Priority:	Major Major
     * Reporter:	Remote issue assignee account
     * Security Level:	Assignee (Assignee)
     *
     * @param args
     */


    static String adressFileSourceTranslate = "DictionaryApp\\SourceText\\Russian text.txt";                         //����� � ����� � �������� ������� �� ������� ����� ��� ��������
    //    static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Russian-English Vocabulary.txt";         //����� � ����� � ������-���������� �������
    static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Russian-Ukrainian Vocabulary.txt";       //����� � ����� � ������-���������� �������


//      static String adressFileSourceTranslate = "DictionaryApp\\SourceText\\English text.txt";                      //����� � ����� � �������� ������� �� ���������� ����� ��� ��������
//      static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\English-Russian Vocabulary.txt";      //����� � ����� � �����-������� �������

//      static String adressFileSourceTranslate = "DictionaryApp\\SourceText\\Ukrainian text.txt";                    //����� � ����� � �������� ������� �� ���������� ����� ��� ��������
//      static String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Ukrainian-Russian Vocabulary.txt";    //����� � ����� � ��������-������� �������


    static boolean English;
    static boolean Russian;
    static boolean Ukrainian;

    public static void main(String[] args) {


        System.out.println("���������� ����������");
        System.out.println("�������� ����� ���� �� �����.������ ������ ��������� � ���������� adressFileSourceTranslate(������ ������ �����������������).");
        System.out.println("������� ����� ���� �� �����(����������� ������� ����������������).");
        System.out.println("������� �� 5 ���� (���������� �����-�������, ��� 2000 ����).");

        System.out.println("readFromFileSourceTranslate " + adressFileSourceTranslate + " ---> " + readFromFileSourceTranslate(adressFileSourceTranslate));
        System.out.println("readFromFileVocabulary " + adressFileVocabulary + " ---> " + readFromFileVocabulary(adressFileVocabulary));


        System.out.println("Translated : "+translate(readFromFileSourceTranslate(adressFileSourceTranslate)));

    }

//-------����� �������� ������ ��� �������� � ���������� �������
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

//-------����� �������� � �������� ��������� ����� ����� � �������� �������, � ���������� ������ � ���� �������
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
//-------����� �������� � �������� ��������� ����� �������, � ���������� HashMap � ������������ �������
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


                Pattern patternTranslated = Pattern.compile(" +.+");     //(" +.+\\S")   (" +.+")   and=�  ("[^=]+.")              ("[^=]+")
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
                map.put(str1, str2); // ��������� � HashMap ��� ����� � ���������� ��� ���� ����-��������
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
