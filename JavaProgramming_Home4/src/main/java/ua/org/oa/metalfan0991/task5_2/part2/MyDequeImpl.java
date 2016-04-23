package ua.org.oa.metalfan0991.task5_2.part2;


import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Abashkin Aleksandr on 07.01.2016.
 */
public class MyDequeImpl<E> implements MyDeque<E> {
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    protected transient int modCount = 0;


    // ---------- МЕТОДЫ -----------

    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }


    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }


    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    public Number[] toArray() {
        Number[] result = new Number[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = (Number) x.item;
        return result;
    }

    public int size() {
        return size;
    }


    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e))
                return false;
        }
        return true;
    }


    @Override
    public String toString() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println("Результат вызова toString для элемента " + i + " ---> " + node(i).item);
        }
        return "";
    }

    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


    // ---------- Part 2 ----------------
    //    Добавить в класс MyDequeImpl<E> метод, который реализует метод Iterable#iterator:
    //
    //    public Iterator<E> iterator() { return new IteratorImpl(); }
    //
    //    метод должен возвращает объект внутреннего класса IteratorImpl:


    public Iterator<E> iterator() {
        return new IteratorImpl();
    }


    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

//    private class IteratorImpl implements Iterator<E> {
//    проверяет, есть ли следующий элемент для выборки методом next
//    public boolean hasNext() { // ... }
//    возвращает следующий элемент
//    public E next() { // ... }	}
//    удаляет элемент, который был возвращен ранее методом next
//    public void remove() {

    private class IteratorImpl implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        IteratorImpl() {
            // assert isPositionIndex(index);
            next = (0 == size) ? null : node(0);
            nextIndex = 0;
        }

        public boolean hasNext() {


            return nextIndex < size;
        }

        public E next() {

            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }


    private static class Node<E> {
        // хранимый элемент
        E item;
        // ссылка на следующий элемент списка
        Node<E> next;
        // ссылка на предыдущий элемент списка
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }

}
