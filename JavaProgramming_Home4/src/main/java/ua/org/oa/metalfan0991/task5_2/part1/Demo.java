package ua.org.oa.metalfan0991.task5_2.part1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Abashkin Aleksandr on 07.01.2016.
 */
public class Demo {
    public static void main(String[] args) {
        MyDeque<Number> deque = new MyDequeImpl<Number>();
        deque.addFirst(433);
        deque.addFirst(8.88);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(338);
        deque.addLast(222222);

        LinkedList<Number> linkedList = new LinkedList<Number>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);


        System.out.println("Исходное содержимое связного списка --> " + Arrays.toString(deque.toArray()));
        System.out.println("Список содержит 433 --> " + deque.contains(433));

        System.out.println("Получить первый элемент в списке --> " + deque.getFirst());
        System.out.println("Получить последний элемент в списке --> " + deque.getLast());
        System.out.println("Вернуть массив элементов из списка (сохраняя упорядоченность элементов списка) --> " + Arrays.toString(deque.toArray()));
        System.out.println("Вернуть количество элементов в списке --> " + deque.size());
        System.out.println("Удаление первого элемента в списке --> " + deque.removeFirst());
        System.out.println("Содержимое связного списка --> " + Arrays.toString(deque.toArray()));
        System.out.println("Удаление последнего элемента в списке --> " + deque.removeLast());
        System.out.println("Содержимое связного списка --> " + Arrays.toString(deque.toArray()));
        System.out.println("Проверить, содержит ли список все элементы списка deque --> " + deque.containsAll(linkedList));
//        +1.3. Переопределить метод toString таким образом, чтобы результат выводился в виде:
//        {результат вызова toString для элемента 1, результат вызова toString для элемента 2, ... }

        System.out.println(deque.toString());
        deque.clear();  //Удалить все элементы в списке
        System.out.println("Удалить все элементы в списке и вывести содержимое --> " + Arrays.toString(deque.toArray()));







//        ListIterator<Number> numberListIterator = deque.listIterator();
//        if (numberListIterator.hasNext()){
//            numberListIterator.next();
//            System.out.println(numberListIterator.next());
//
//        }

//        System.out.println("Список содержит 433 --> " + deque.contains(433));
//        System.out.println("Удаление первого элемента в списке --> " + deque.removeFirst());
//        System.out.println("Содержимое связного списка --> " + deque.getAll());
//        System.out.println("Удаление последнего элемента в списке --> " + deque.removeLast());
//        System.out.println("Содержимое связного списка --> " + deque.getAll());
//        System.out.println("Получить первый элемент в списке --> " + deque.getFirst());
//        System.out.println("Получить последний элемент в списке --> " + deque.getLast());
//        System.out.println("Вернуть массив элементов из списка (сохраняя упорядоченность элементов списка) --> " + Arrays.toString(deque.toArray()));
//        System.out.println("Вернуть количество элементов в списке --> " + deque.size());
//        System.out.println("Проверить, содержит ли список все элементы списка deque --> " + deque.containsAll(deque));
//        System.out.println("Содержимое связного списка --> " + deque.getAll());
//        System.out.println(deque.toString());
//        deque.nodeTools();
//        deque.clear();  //Удалить все элементы в списке
//        System.out.println("Удалить все элементы в списке и вывести содержимое --> " + deque.getAll());


//--------------Дальше пошел код на котором я трениировался с итератором

//        List<Number> numberLinkedList = new LinkedList<Number>();
//        numberLinkedList.add(1);
//        numberLinkedList.add(3);
//        numberLinkedList.add(45);
//        numberLinkedList.add(6);
//
//        ListIterator<Number> numberListIterator = numberLinkedList.listIterator();
//        if (numberListIterator.hasNext()){
//            numberListIterator.next();
//            System.out.println(numberListIterator.next());
//
//        }
//        if (numberListIterator.hasPrevious()){
//            System.out.println(numberListIterator.previous());
//            System.out.println(numberListIterator.previous());
//
//        }


//        String palStr = "abcba";
//        List<Character> palindrome = new LinkedList<Character>();
//        for (char ch : palStr.toCharArray()) {
//            palindrome.add(ch);
//        }
//        System.out.println("Исходная строка ---> " + palStr);
//        ListIterator<Character> iterator = palindrome.listIterator();
//        ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());
//        boolean result = true;
//        while (revIterator.hasPrevious() && iterator.hasNext()) {
//            if (iterator.next() != revIterator.previous()) {
//                result = false;
//                break;
//            }
//        }
//        if (result) {
//            System.out.println("Вводимая строка палиндром");
//        } else {
//            System.out.println("Вводимая строка не палиндром");
//        }


    }
}
