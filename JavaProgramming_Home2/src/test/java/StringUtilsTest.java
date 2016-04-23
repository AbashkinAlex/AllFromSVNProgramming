import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksandr Abashkin on 12/21/2015.
 */
public class StringUtilsTest {

    /*Field for testing method stringReverse1*/
    String testStr1 = "Hello world!";
    String testStr1Rez = "!dlrow olleH";

    /*Field for testing method stringReverse2*/
    String testStr1_1 = "Hello world!";
    String testStr1_1Rez = "!dlrow olleH";

    /*Field for testing method stringIsPalindrom1*/
    String testStr2_1 = "ololo";
    Boolean testStr2_1Rez = true;


    /*Field for testing method stringIsPalindrom2*/
    String testStr2_2 = "ololo";
    Boolean testStr2_2Rez = true;

    /*Field for testing method stringLengthUtils*/
    String testStr3 = "Hello";
    String testStr3Rez = "Вводимая строка (Hello) содержит менее 10 символов, значит нужно дополнить строку символами 'o' до длины 12 : Helloooooooo";

    String testStr4 = "Hello my dear friend";
    String testStr4Rez = "Вводимая строка (Hello my dear friend) содержит более 10 символов, значит оставляем только первые 6 символов : Hello ";

    /*Field for testing method changeWords1*/
    String testStr5_1 = "Hello my dear friend";
    String testStr5_1Rez = "friend my dear Hello ";

    /*Field for testing method changeWords2*/
    String testStr5_2 = "Hello my dear friend";
    String testStr5_2Rez = "friend my dear Hello";

    /*Field for testing method changeSentence*/
    String testStr6 = "Hello my dear friend. The weather is good.";
    String testStr6Rez = "friend my dear Hello. good weather is The. ";

    /*Field for testing method findChars*/
    String testStr7 = "Hello my dear friend. The weather is good.";
    String testStr7Rez = "В строке присутствует символ 'a'";

    /*Field for testing method dateFormat*/
    String testStr8 = "10.02.2015";
    String testStr8Rez = "Дата 10.02.2015 является строчка датой формата MM.DD.YYYY .";
    /*Field for testing method findAdress*/
    String testStr9 = "Country@Ukraine.com";
    String testStr9Rez = "Адрес найден : Country@Ukraine.com";
    /*Field for testing method findPhoneNumber*/
    String testStr10 = "+ХX(ХХХ)ХХХ-ХХ-ХХ" +
            "+38(066)601-36-99" +
            "+38(066)601-32-02" +
            "+3(066)601-36-99" +
            "+7(066)601-32-99" +
            "Просто строка";
    String[] arrPhone = {"+38(066)601-36-99, +38(066)601-32-02"};


    @Test
    public void testStringReverse1() throws Exception {
        assertEquals("Check str1.1 ", testStr1Rez, StringUtils.stringReverse1(testStr1).toString());
    }

    @Test
    public void testStringReverse2() throws Exception {
        assertEquals("Check str1.2 ", testStr1_1Rez, StringUtils.stringReverse2(testStr1_1).toString());
    }

    @Test
    public void testStringIsPalindrom1() throws Exception {
        assertEquals("Check str2.1 ", testStr2_1Rez, StringUtils.stringIsPalindrom1(testStr2_1));
    }

    @Test
    public void testStringIsPalindrom2() throws Exception {
        assertEquals("Check str2.2 ", testStr2_2Rez, StringUtils.stringIsPalindrom2(testStr2_2));
    }

    @Test
    public void testStringLengthUtils1() throws Exception {
        assertEquals("Check str3 ", testStr3Rez, StringUtils.stringLengthUtils(testStr3));
    }

    @Test
    public void testStringLengthUtils2() throws Exception {
        assertEquals("Check str4 ", testStr4Rez, StringUtils.stringLengthUtils(testStr4));
    }

    @Test
    public void testChangeWords1() throws Exception {
        assertEquals("Check str5.1 ", testStr5_1Rez, StringUtils.changeWords1(testStr5_1));
    }

    @Test
    public void testChangeWords2() throws Exception {
        assertEquals("Check str5.2 ", testStr5_2Rez, StringUtils.changeWords2(testStr5_2));
    }

    @Test
    public void testChangeSentence() throws Exception {
        assertEquals("Check str6 ", testStr6Rez, StringUtils.changeSentence(testStr6));
    }

    @Test
    public void testFindChars() throws Exception {
        assertEquals("Check str7 ", testStr7Rez, StringUtils.findChars(testStr7));
    }

    @Test
    public void testDateFormat() throws Exception {
        assertEquals("Check str8 ", testStr8Rez, StringUtils.dateFormat(testStr8));
    }

    @Test
    public void testFindAdress() throws Exception {
        assertEquals("Check str9 ", testStr9Rez, StringUtils.findAdress(testStr9));
    }

    @Test
    public void testFindPhoneNumber() throws Exception {
        assertEquals("Check str10 ", Arrays.toString(arrPhone), StringUtils.findPhoneNumber(testStr10));
    }
}