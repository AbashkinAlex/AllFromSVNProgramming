package Item2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.*;

/**
 * Created by Abashkin Aleksandr on 29.01.2016.
 */
public class AppTest {


    @Test
    public void testListFiles() throws Exception {
        //Метод тестировал с расчетом что в директории "src\\main\\resources\\item2" будет лежать только 2 файла ("1.txt","2.txt").
        assertEquals("ListFiles() ", "[src\\main\\resources\\item2\\1.txt, src\\main\\resources\\item2\\2.txt, src\\main\\resources\\item2\\New Folder]", Arrays.toString(App.listFiles("src\\main\\resources\\item2")));
    }

    @Test
    public void testCreateNewFile() throws Exception {
        File file = new File("src\\main\\resources\\item2\\New Folder\\3.txt");
        assertEquals("CreateNewFile() ", file  , App.createNewFile("src\\main\\resources\\item2\\New Folder\\3.txt"));
    }

    @Test
    public void testRenameFile() throws Exception {
        File file1 = new File("src\\main\\resources\\item2\\New Folder\\3.txt");
        File file2 = new File("100");
        assertEquals("RenameFile() ", file2  , App.renameFile(file1.getName(), "100"));
    }

    @Test
    public void testDeleteFile() throws Exception {
        assertEquals("DeleteFile() ", true  , App.deleteFile("src\\main\\resources\\item2\\New Folder\\3.txt"));
    }
}