import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr Abashkin on 12/21/2015.
 */

/**
      ЗАДАНИЕ
 Реализовать Markdown парсер. Markdown это упрощенный язык разметки который используется в Wiki.
        ##Header line
        Simple line with em
        Simple *line* with strong
        Line with link [Link to google](https://www.google.com) in center
        Line *with* many *elements* and link [Link to FB](https://www.facebook.com)

 Результат преобразования должен быть таковым:
<html>
<body>
<h2>Header line</h2>
<p>Simple line <em>with</em> em</p>
<p>Simple <strong>line</strong> with strong</p>
<p>Line with link <a href=“https://www.google.com“>Link to google</a> in center</p>
<p> Line <strong>with</strong> <em>many</em> <strong>welementsith</strong>
<a href=“https://www.facebook.com“>Link to FB</a></p>
</body>
</html>
         */



public class Part2 {
    public void generateHtml() {
        StringBuilder sb = new StringBuilder();     //нужен чтобы построчно из файла записать в массив
        StringBuffer sb2 = new StringBuffer();      //нужен для построения кода HTML на основании проделанных изменений
        ArrayList<String> str = new ArrayList();
        Pattern pattern1;       //зачем это всё нужно, я описал ниже
        Pattern pattern2;
        Pattern pattern3;
        Pattern pattern4;
        Pattern pattern5;

        Matcher matcher1;
        try (BufferedReader br = new BufferedReader(new FileReader("НАШ ИСХОДНЫЙ КОД.txt"))) {
            String line = null;
            while ((line = br.readLine()) != null) {   //построчно из текстового файла заносим данные в ArrayList
                sb.append(line);
                sb.append("\n");
                str.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Данные которые были записаны в массив ArrayList -->" + str);

       //Делаем четыре скомпилированные представления регулярного выражения
        pattern1 = Pattern.compile("#{1,}");                //для работы с заголовками
        pattern2 = Pattern.compile("[\\s](\\...)");         //для работы с абзацами
        pattern3 = Pattern.compile("\\*...\\*{1,}");        //для работы с абзацами
        pattern4 = Pattern.compile("\\[(?<text>[\\s\\S]*?)\\]\\((?<url>[\\s\\S]*?)\\)");    //для работы со ссылками


        int test_pat = 0;
        sb2.append("<html>\n");
        sb2.append("<body>\n");
        for (String str1 : str) {
            matcher1 = pattern1.matcher(str1); //здесь "движок" сравнивает по регулярки 1
            test_pat = 0;
            while (matcher1.find()) {
                sb2.append("<h" + matcher1.group().length() + ">");
                sb2.append(str1.substring(matcher1.group().length()));
                sb2.append("</h" + matcher1.group().length() + ">");
                test_pat = 1;
            }
            matcher1 = pattern2.matcher(str1); //здесь "движок" сравнивает по регулярки 2(и т.д. по коду)
            while (matcher1.find()) {
                sb2.append("<p>");
                sb2.append(str1.replace(matcher1.group(), "<em>" + matcher1.group() + "</em>"));
                sb2.append("</p>");
                test_pat = 1;
            }

            matcher1 = pattern3.matcher(str1);
            while (matcher1.find()) {
                sb2.append("<p>");
                sb2.append(str1.replace(matcher1.group(), "<strong>" + matcher1.group() + "</strong>"));
                sb2.append("</p>");
                test_pat = 1;
            }
            matcher1 = pattern4.matcher(str1);
            while (matcher1.find()) {
                sb2.append("<a href=“");
                sb2.append(matcher1.group("url"));
                sb2.append("“>");
                sb2.append(matcher1.group("text"));
                sb2.append("</a>");
                test_pat = 1;
            }
            if (test_pat == 0) {
                sb2.append("<p>");
                sb2.append(str1);
                sb2.append("</p>");
            }

            sb2.append("\n");
        }
        sb2.append("</body>\n");
        sb2.append("</html>");
        System.out.println(sb2.toString());


    }
}

