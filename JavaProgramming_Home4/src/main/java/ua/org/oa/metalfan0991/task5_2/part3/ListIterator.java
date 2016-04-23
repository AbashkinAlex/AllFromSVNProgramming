package ua.org.oa.metalfan0991.task5_2.part3;

import java.util.Iterator;

/**
 * Created by Abashkin Aleksandr on 10.01.2016.
 */
public interface ListIterator<E> extends Iterator<E> {
    // проверяет, есть ли предыдущий элемент для выборки методом previous

    boolean hasPrevious();

// возвращает предыдущий элемент

    E previous();

// заменяет элемент, который на предыдущем шаге был возвращен next/previous на данный элемент

    void set(E e);

// удаляет элемент, который на предыдущем шаге был возвращен next/previous

    void remove();

}
//Методы set/remove могут быть вызваны только после next/previous. Повторный вызов (подряд) set/remove должен приводить к выбросу исключения IllegalStateException
