package ua.org.oa.metalfan0991.task5_2.part3;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Abashkin Aleksandr on 07.01.2016.
 */
public class Demo {
    public static void main(String[] args) {
        MyDeque<Number> deque = new MyDequeImpl<Number>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addLast(40);
        deque.addLast(50);


// ---------------- PART 1 -----------------------


        LinkedList<Number> linkedList = new LinkedList<Number>();
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        System.out.println("~~~~~~~~~~  PART 1  ~~~~~~~~~~~~~~");
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
//        +1.3. Переопределить метод toString таким образом, чтобы результат выводился виде:
//        {результат вызова toString для элемента 1, результат вызова toString для элемента 2,

//      System.out.println(deque.toString());
//       deque.clear();  //Удалить все элементы в списке
//       System.out.println("Удалить все элементы в списке и вывести содержимое --> " + Arrays.toString(deque.toArray()));


// ---------------- PART 2 -----------------------

        System.out.println("~~~~~~~~~~  PART 2  ~~~~~~~~~~~~~~");

        Iterator<Number> it = deque.iterator();
        while (it.hasNext()) {
            System.out.println("it.next() while ---> " + it.next());
        }


        for (Number element : deque) {
            System.out.println("it.next() for each ---> " + element);
        }


        Iterator<Number> it2 = deque.iterator();
//        Закомментированный код с демонстрацией работы метода remove()
//        if (it2.hasNext()) {
//            it2.remove();
//            System.out.println("it.next() if ---> " + it2.next());
//            System.out.println("it.next() if ---> " + it2.next());
//        }


        // ---------------- PART 3 -----------------------

        System.out.println("~~~~~~~~~~  PART 3  ~~~~~~~~~~~~~~");

        ListIterator<Number> lit = deque.listIterator();
        while (lit.hasNext()) {
            System.out.println("lit.next()  ---> " + lit.next());
        }
        while (lit.hasPrevious()) {
            System.out.println("lit.previous()  ---> " + lit.previous());
        }
        lit.set(3);

        System.out.println("Повторно пройдемся по коллекции: ");

        while (lit.hasNext()) {
            System.out.println("lit.next()  ---> " + lit.next());
        }
        while (lit.hasPrevious()) {
            System.out.println("lit.previous()  ---> " + lit.previous());
        }
    }
}
