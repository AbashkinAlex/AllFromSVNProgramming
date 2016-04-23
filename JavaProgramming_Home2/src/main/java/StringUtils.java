import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr Abashkin on 12/7/2015.
 */


/**

?1. Создать класс StringUtils, в котором реализовать следующие функции:
       + 1) функция, которая переворачивает строчку наоборот. Пример: было “Hello world!” стало “!dlrow olleH”
       + 2) функция, которая определяет является ли строчка полиндромом. Пример: А роза упала на лапу Азора
       + 3) функция которая проверяет длину строки, и если ее длина больше 10, то оставить в строке только первые 6 символов,
         иначе дополнить строку символами 'o' до длины 12.

       + 4) функция, которая меняет местами первое и последнее слово в строчке
       + 5) функция, которая меняет местами первое и последнее слово в каждом предложении. (предложения могут разделятся ТОЛЬКО знаком точки)
       + 6) функция, которая проверяет содержит ли строка только символы 'a', 'b', 'c' или нет.
       + 7) функция, которая определят является ли строчка датой формата MM.DD.YYYY
       + 8) функция, которая определяет является ли строчка почтовым адресом
       + 9) функция, которая находит все телефоны в переданном тексте формата +Х(ХХХ)ХХХ-ХХ-ХХ, и возвращает их в виде массива

        Все методы покрыть тестами.
*/

public class StringUtils {
    //Метод принимает строку. Возвращает реверс строки. Вариант №1
    public static String stringReverse1(String str) {

        return new StringBuilder(str).reverse().toString();
    }

    //Метод принимает строку. Возвращает реверс строки. Вариант №2
    public static String stringReverse2(String str) {
        char[] ar1 = str.toCharArray();
        char[] ar2 = new char[str.length()];
        for (int i = 0; i < ar1.length; i++) {
            ar2[(ar1.length - 1) - i] = ar1[i];
        }

        return new String(ar2);
    }

    //Метод принимает строку. Вернет true ,если строка палиндром, если нет false(Вариант№1).
    public static boolean stringIsPalindrom1(String str) {
        String palindrom1 = stringReverse1(str);
        if (str.equals(palindrom1)) {
            return true;
        }
        return false;
    }

    //Метод принимает строку. Вернет true ,если строка палиндром, если нет false(Вариант№2).
    public static boolean stringIsPalindrom2(String str) {
        str = str.toLowerCase().trim().replace(" ", "");
        return str.equals(StringUtils.stringReverse1(str));
    }


    //Метод принимает строку. Вернёт видоизменненную строку.
    public static String stringLengthUtils(String str) {
        char[] ch = str.toCharArray();
        if (ch.length > 10) {
            String str2 = new String(ch, 0, 6);
            return "Вводимая строка (" + str + ") содержит более 10 символов," +
                    " значит оставляем только первые 6 символов : "
                    + str2;
        } else {
            StringBuffer sb = new StringBuffer(str);
            while (sb.length() <= 11) {
                sb.append("o");

            }
            return "Вводимая строка (" + str + ") содержит менее 10 символов," +
                    " значит нужно дополнить строку символами 'o' до длины 12 : " + sb.toString();
        }
    }


    //функция, которая меняет местами первое и последнее слово в строчке (Вариант №1)
    public static String changeWords1(String str) {
        Pattern pat = Pattern.compile("[ ]");
        String[] cw = pat.split(str);
        String[] ncw = new String[cw.length];
        System.arraycopy(cw, cw.length - 1, ncw, 0, 1);
        System.arraycopy(cw, 1, ncw, 1, cw.length - 2);
        System.arraycopy(cw, 0, ncw, cw.length - 1, 1);


        StringBuilder sb = new StringBuilder();
        for (String s : ncw) {
            sb.append("" + s + " ");
        }
        return sb.toString();

    }

    //функция, которая меняет местами первое и последнее слово в строчке (Вариант №2)
    public static String changeWords2(String str) {
        String[] mas = str.split("\\ ");
        String newStr = new String();

        newStr = newStr.concat(mas[mas.length - 1]).concat(" ");

        for (int i = 1; i < mas.length - 1; i++) {

            newStr = newStr.concat(mas[i]).concat(" ");
        }
        newStr = newStr.concat(mas[0]);
        return newStr;

    }
    //функция, которая меняет местами первое
    // и последнее слово в каждом предложении. (предложения могут разделятся ТОЛЬКО знаком точки)

    public static String changeSentence(String str) {
        String[] sentence = str.concat(" ").split("\\. ");
        String newSentence = new String();
        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i < sentence.length; i++) {

            s1.append(changeWords2(sentence[i]) + ". ");
        }
        newSentence = s1.toString();

        return newSentence;
    }

//функция, которая проверяет содержит ли строка только символы 'a', 'b', 'c' или нет.

    public static String findChars(String str) {
        char[] ch = str.toCharArray();

        for (char c : ch) {
            {
                if (c == 'a') {
                    return "В строке присутствует символ 'a'";
                }
                if (c == 'b') {
                    return "В строке присутствует символ 'b'";
                }
                if (c == 'c') {
                    return "В строке присутствует символ 'c'";
                }
            }
        }

        return "";
    }

    // функция, которая определят является ли строчка датой формата MM.DD.YYYY

    public static String dateFormat(String str) {

        Pattern dateCheck = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
        Matcher m = dateCheck.matcher(str);
        if (m.find()) {
            return "Дата " + str + " является строчка датой формата MM.DD.YYYY .";
        }

        return "Дата " + str + " не является строчка датой формата MM.DD.YYYY .";
    }

    //    функция, которая определяет является ли строчка почтовым адресом

    public static String findAdress(String str) {

        Pattern pattern = Pattern.compile("\\w+@\\w+\\.com");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            return "Адрес найден : " + matcher.group();
        }

        return "Метод завершил свою работу";
    }

//    функция, которая находит все телефоны в переданном тексте формата +ХX(ХХХ)ХХХ-ХХ-ХХ, и возвращает их в виде массива

    public static String findPhoneNumber(String str) {
        List list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\+[0-9]{2}\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(str);
        String phone = new String();
        StringBuilder count = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            list.add(matcher.group());
            }

        return String.valueOf(list);
    }

}


