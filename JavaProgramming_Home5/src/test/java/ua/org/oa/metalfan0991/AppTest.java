package ua.org.oa.metalfan0991;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Abashkin Aleksandr on 24.01.2016.
 */
public class AppTest {
    /**
     * Тест методов
     * Для проверки будем использовать файл с исходным текстом на русском языке.
     * А также русско-украинский словарь.
     */
    Map<String, String> map = new HashMap<String, String>();
    String adressFileSourceTranslate = "DictionaryApp\\SourceText\\Russian text.txt";
    String adressFileVocabulary = "DictionaryApp\\Vocabulary\\Russian-Ukrainian Vocabulary.txt";

    @Test
    public void testTranslate() throws Exception {
        App.readFromFileVocabulary(adressFileVocabulary);
        assertEquals("testTranslate() --> ", App.translate("Мама") , "мати ");
    }

    @Test
    public void testReadFromFileSourceTranslate() throws Exception {
        App.readFromFileSourceTranslate(adressFileSourceTranslate);
    }

}