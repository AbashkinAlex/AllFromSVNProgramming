import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexandr Abashkin on 3/14/2016.
 */
public class Parser {
    public static StringBuilder readFile(String fileAdress) throws IOException{
        File file = new File(fileAdress);
        StringBuilder stringBuilder = new StringBuilder("");
        try  {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    public static ArrayList<Baby> parcerForBaby(StringBuilder stringBuilder) throws IOException{
                ArrayList<Baby> babyList = new ArrayList<Baby>();
        Pattern pattern = Pattern.compile("<td>([0-9]+)</td><td>([A-Z]{1}[a-z]+)</td><td>([A-Z]{1}[a-z]+)</td>");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        while (matcher.find()){
            String rank = matcher.group(1);
        String maleName = matcher.group(2);
        String femaleName = matcher.group(3);
            Baby baby = new Baby(Integer.parseInt(rank),maleName,femaleName);
            babyList.add(baby);
        }
        return babyList;

    }



    public static ArrayList<Notebook> parcerForNoteBook(StringBuilder stringBuilder) throws IOException{
        ArrayList <Notebook> notebooks = new ArrayList<Notebook>();
        Pattern pattern = Pattern.compile("(>Ноутбук )(\\w+)(.+?)(</a></h6><p class=\"description\">)(.+?)(<br />)(.+?)(<span class=\"price cost\">)(.+?)");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        while (matcher.find()){
            String firma = matcher.group(2);
            String model = matcher.group(3);
            String description = matcher.group(5);
            String price = matcher.group(9);
            Notebook notebook = new Notebook(firma,model,description,Double.parseDouble(price));
            notebooks.add(notebook);
        }
        return notebooks;
    }






}
