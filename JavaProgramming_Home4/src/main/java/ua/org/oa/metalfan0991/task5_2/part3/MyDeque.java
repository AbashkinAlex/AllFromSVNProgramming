package ua.org.oa.metalfan0991.task5_2.part3;

import java.util.Collection;

/**
 * Created by Abashkin Aleksandr on 07.01.2016.
 */
public interface MyDeque<E>  extends Iterable<E>, ListIterable<E>{
    // добавить элемент в начало списка
    void addFirst(E e);
    // добавить элемент в конец списка
    void addLast(E e);
    // получить элемент из начала списка и удалить его
    E removeFirst();
    // получить элемент из конца списка и удалить его
    E removeLast();
    // получить элемент из начала списка, не удаляя его
    E getFirst();
    // получить элемент из конца списка, не удаляя его
    E getLast();
    // проверить, содержится ли объект o в списке
    // (с помощью equals)
    boolean contains(Object o);
    // очистить список
    void clear();
    // вернуть массив элементов из списка
    // (сохраняя упорядоченность элементов списка)
    Object[] toArray();
    // вернуть количество элементов в списке
    int size();
    // проверить, содержит ли список все элементы списка deque
    boolean containsAll(Collection<?> c);

}
