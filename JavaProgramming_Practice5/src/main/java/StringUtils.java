import annotations.time.Time;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr Abashkin on 05.12.2015.
 */
public class StringUtils {
    public static boolean randomNumbers(String filename, int numbers) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers; i++) {
            sb.append(random.nextInt()).append(System.lineSeparator());
        }
        return writeToFile(sb.toString(), filename);
    }

    public static boolean writeToFile(String text, String filename) {
        File file = new File(filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static LinkedList<Integer> readFromFile(String filename) throws IOException {
        File file = new File(filename);
        LinkedList<Integer> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = br.readLine()) != null) {
                list.add(Integer.parseInt(s));
            }
            list.sort(Comparator.<Integer>naturalOrder());

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean writeToFile(LinkedList<Integer> list, String filename) {
        File file = new File(filename);
        try (BufferedWriter bis = new BufferedWriter(new FileWriter(file))) {
            for (Integer integer : list) {
                bis.write(integer.toString());
                bis.newLine();
            }
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Map<String, String> fileToMap(String adress) {
        String str;
        Map<String, String> map = new HashMap<>();
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
                Pattern patternForTranslate = Pattern.compile(".+[=]");
                Pattern patternTranslated = Pattern.compile("[^=]+.");
                Matcher matcherForTranslate = patternForTranslate.matcher(str);
                Matcher matcherTranslated = patternTranslated.matcher(str);

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

    public static Map<String, String> sortByScore(Map<String, String> map, Integer score) {

        Map<String, String> sortedMap = new HashMap<>();
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            if (Integer.parseInt(entry.getValue()) > score) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }
        return sortedMap;
    }

    //функция, которая меняет местами первое
    // и последнее слово в каждом предложении. (предложения могут разделятся ТОЛЬКО знаком точки)

    public static String changeSentence(String str) {
        String[] sentence = str.split("\\. ");
        String newSentence;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sentence.length; i++) {
            {
                String[] mas = sentence[i].split("\\ ");
                String newStr = new String();

                newStr = newStr.concat(mas[mas.length - 1]).concat(" ");

                for (int j = 1; j < mas.length - 1; j++) {

                    newStr = newStr.concat(mas[j]).concat(" ");
                }
                newStr = newStr.concat(mas[0]) + ". ";
                stringBuilder.append(newStr);
            }

        }
        newSentence = stringBuilder.toString();

        return newSentence;
    }

    public static String readFromFile2(String fileAdress) {
        StringBuilder sb = new StringBuilder();
        try(FileReader reader = new FileReader(fileAdress))
        {

            int c;
            while((c=reader.read())!=-1){
                sb.append((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }
//    @Time(format="method time: %s ms")
    public static boolean bufferedCopyUtils(String inputFileAdress,String outputFileAdress){
        File fileIn = new File(inputFileAdress);
        File fileOut = new File(outputFileAdress);

        try (BufferedReader br = new BufferedReader(new FileReader(fileIn));
             BufferedWriter dw = new BufferedWriter(new FileWriter(fileOut))){
            String line;
            while((line = br.readLine())!=null){
                dw.write(line);
                dw.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
//    @Time(format="method time: %s ms")
    public static boolean NotBufferedCopyUtils(String inputFileAdress,String outputFileAdress) throws IOException {
        File fileIn = new File(inputFileAdress);
        File fileOut = new File(outputFileAdress);
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(fileIn)){
            char[] ch = new char[128];
            int count;
            while ((count = fr.read(ch))!=-1) {
                sb.append(ch, 0, count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(fileOut)){
            fw.write(sb.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }



}





