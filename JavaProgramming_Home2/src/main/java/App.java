/**
 * Created by Aleksandr Abashkin on 12/7/2015.
 */

/*+!!!! 1) функция, которая переворачивает строчку наоборот. Пример: было “Hello world!” стало “!dlrow olleH”
       !!!! + 2) функция, которая определяет является ли строчка полиндромом. Пример: А роза упала на лапу Азора
       !!!! + 3) функция которая проверяет длину строки, и если ее длина больше 10, то оставить в строке только первые 6 символов,
        иначе дополнить строку символами 'o' до длины 12.

       !!!! + 4) функция, которая меняет местами первое и последнее слово в строчке
        + 5) функция, которая меняет местами первое и последнее слово в каждом предложении. (предложения могут разделятся ТОЛЬКО знаком точки)
        + 6) функция, которая проверяет содержит ли строка только символы 'a', 'b', 'c' или нет.
        + 7) функция, которая определят является ли строчка датой формата MM.DD.YYYY
        + 8) функция, которая определяет является ли строчка почтовым адресом
        + 9) функция, которая находит все телефоны в переданном тексте формата +Х(ХХХ)ХХХ-ХХ-ХХ, и возвращает их в виде массива*/
public class App {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~1~~~~~~~~~~~~~~~");
        System.out.println("Функция, которая переворачивает строчку наоборот:");
        System.out.println("Используя метод reverse() класса StringBuilder:");
        System.out.println("Исходная строка :" + "Hello World!");
        System.out.println(StringUtils.stringReverse1("Hello World!"));
        System.out.println("Или перебирая массив char[]:");
        System.out.println("Исходная строка :" + "Hello World!");
        System.out.println(StringUtils.stringReverse2("Hello World!"));


        System.out.println("~~~~~~~~~~~~~~2~~~~~~~~~~~~~~~");
        System.out.println("Функция, которая определяет является ли строчка полиндромом(Вариант №1)");
        System.out.println("Результат : " + StringUtils.stringIsPalindrom1("ololo"));  //чувствителен к пробелам и разному регистру
        System.out.println("Функция, которая определяет является ли строчка полиндромом(Вариант №2).");
        System.out.println("Результат : " + StringUtils.stringIsPalindrom2("А роза упала на лапу Азора"));


        System.out.println("~~~~~~~~~~~~~~3~~~~~~~~~~~~~~~");
        System.out.println("Функция которая проверяет длину строки , и если ее длина больше 10," +
                " то оставить в строке только первые 6 символов,\n" +
                " иначе дополнить строку символами 'o' до длины 12.");
        System.out.println(StringUtils.stringLengthUtils("Hello"));


        /*System.out.println("~~~~~~~~~~~~~4~~~~~~~~~~~~~~~");
        System.out.println("Функция, которая меняет местами первое и последнее слово в строчке : ");
        System.out.println("mama mila ramu");
        System.out.println("Вариант 1 : "+(StringUtils.changeWords1("mama mila ramu")));
        System.out.println("Вариант 2 : "+(StringUtils.changeWords2("mama mila ramu")));*/


        System.out.println("~~~~~~~~~~~~~5~~~~~~~~~~~~~~~");
        System.out.println("функция, которая меняет местами первое и последнее слово в каждом предложении" +
                ". (предложения могут разделятся ТОЛЬКО знаком точки)");
        System.out.println("Исходная строка : Мама мыла раму.Мама мыла пол.Мама устала всё мыть.");
        System.out.println("Результат : " + (StringUtils.changeWords1("Мама мыла раму. Мама мыла пол. мама устала всё мыть.")));


        System.out.println("~~~~~~~~~~~~6~~~~~~~~~~~~~~~~");
        System.out.println("Функция, которая проверяет содержит ли строка только символы 'a', 'b', 'c' или нет.");
        System.out.println(StringUtils.findChars("mama mila ramu"));


        System.out.println("~~~~~~~~~~~~7~~~~~~~~~~~~~~~~");
        System.out.println("Функция, которая определят является ли строчка датой формата MM.DD.YYYY");
        System.out.println(StringUtils.dateFormat("12.16.2015555"));

        System.out.println("~~~~~~~~~~~~8~~~~~~~~~~~~~~~~");
        System.out.println("Функция, которая определяет является ли строчка почтовым адресом");
        System.out.println(StringUtils.findAdress("ыцуаауц metalfan0991@gmail.com уцуцуауцацу32423"));

        System.out.println("~~~~~~~~~~~~9~~~~~~~~~~~~~~~~");
        System.out.println("функция, которая находит все телефоны в переданном тексте " +
                "формата +ХX(ХХХ)ХХХ-ХХ-ХХ, и возвращает их в виде массива");
        System.out.println(StringUtils.findPhoneNumber("+ХX(ХХХ)ХХХ-ХХ-ХХ" +
                "+38(066)601-36-99" +
                "+38(066)601-32-02" +
                "+3(066)601-36-99" +
                "+7(066)601-32-99" +
                "Просто строка"));

    }
}

