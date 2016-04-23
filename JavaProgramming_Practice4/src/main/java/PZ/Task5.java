package PZ;
import java.io.*;
import java.util.*;
/**
 * Created by Abashkin Aleksandr on 21.03.2016.
 */


/**
 * 5. Задан текст на английском языке. Выделить все различные слова. Для
 каждого слова подсчитать частоту его встречаемости. Слова, отличающиеся
 регистром букв, считать различными. Использовать класс HashMap. Текст
 считать из файла.

 6. Перегрузить метод из пятого задания с возвратом отсортированного Map,
 по чем сортировать и в каком направлении указывать через enum
 константы.
 */
public class Task5 {
    private List<String> list;

    public Task5() {
        list = new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public static List<String> listFromFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return list;

    }


    public static Map<String, Integer> toMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        list.forEach(line -> {
            String words[] = line.split("[ ,]");

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                    continue;
                }
                map.put(word, 1);
            }

        });

        return map;
    }


    public static Map<String, Integer> sortWord(Map<String, Integer> map) {
        final Map<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return map.get(lhs).compareTo(map.get(rhs));
            }
        });
        sortedMap.putAll(map);
        return sortedMap;
    }
}
