package ua.org.oa.metalfan0991; /**
 * Created by Aleksandr Abashkin on 22.12.2015.
 */

/**
 * Создать Generic хранилище данных(ua.org.oa.metalfan0991.GenericStorage). В качестве хранилища использовать массив.
 * Должно быть реализовано CRUD(create read update delete — «Создание чтение обновление удаление») операций.
 * <p>
 * Детальное описание:
 * +1.	Создать конструктор без параметров. При вызове такого конструктора должен инициализироваться массив длиной 10.
 * +2.	Создать конструктор с параметром (int size). Size - размер массива.
 * +3.	Метод add(T obj), который добавит новый элемент в хранилище в конец
 * +4.	Метод T get(int index), который возвратит элемент по индексу в масиве.
 * +5.	Метод T[] getAll(), который вернет массив элементов. (Распечатать массив при помощи Arrays.toString(<-Ваш массив->))
 * +6.	Метод update(int index, T obj), который подменит объект по заданной позиции только, если на этой позиции уже есть элемент.
 * +7.	Meтод delete(int index), который удалит элемент по индексу и захлопнет пустую ячейку в массиве, если на этой позиции уже есть элемент.
 * +8.	Метод delete(T obj), который удалит заданный объект из массива
 * +9.	Метод который возвратит размер массива ЗАПОЛНЕНОГО
 * <p>
 * Примечание:
 * нужно всегда хранить индекс ячейки массива, который указывает на позицию следующую после последнего элемента.
 * Изначально это 0 так как массив пуст, после добавления первого элемента индекс указывает на 1 и т.д.
 * не забывайте что переменная index (get(int index), update(int index, T obj), delete(int index) )
 * должна всегда попадать в рамки 0 - индекс последнего элемента.
 */
public class GenericStorage<T> {
    private T[] myArray;
    private Object[] myListDef;

    int beginLength;            // начальный размер массива
    int defaultLength = 10;     // размер массива по умолчанию
    int indexNewElement = 0;    // храним индекс ячейки массива
    T[] myListForRemove;


    public int getBeginLength() {
        return beginLength;
    }

    public void setBeginLength(int beginLength) {
        this.beginLength = beginLength;
    }

    public int getIndexNewElement() {
        return indexNewElement;
    }

    public void setIndexNewElement(int indexNewElement) {
        this.indexNewElement = indexNewElement;
    }


    //Создать конструктор без параметров. При вызове такого конструктора должен инициализироваться массив длиной 10.
    public GenericStorage() {
        myArray = (T[]) new Object[10];
    }

    //Создать конструктор с параметром (int size). Size - размер массива.
    public GenericStorage(int beginLength) {
        this.beginLength = beginLength;
        myArray = (T[]) new Object[this.beginLength];

    }


    public int arrSize() {
        return myArray.length;
    }

    public void setIncrementIndex() {
        this.indexNewElement++;
    }

    //Метод add(T obj), который добавит новый элемент в хранилище в конец
    public void add(T obj) {
        myArray[this.indexNewElement] = obj;
        setIncrementIndex();
    }

    public T get() {
        return myArray[myArray.length - 1];

    }


    public T get(int id) throws MyException {
        if (id < myArray.length && id >= 0)
            return myArray[id];
        else
            throw new MyException("Wrong index");
    }


    public T[] getAll() {
        return myArray;
    }

    public void update(int index, T obj) {
        myArray[index] = obj;

    }

    public void remove() {
        int lastId = myArray.length;
        myArray = removeEl(lastId);

    }

    public T[] removeEl(int index) {
        int lastId = myArray.length;
        myListForRemove = (T[]) new Object[lastId - 1];

        if (lastId == index) {
            System.arraycopy(myArray, 0, myListForRemove, 0, lastId - 1);
        } else {
            for (int j = 0; j < lastId - 1; j++) {
                if (j < index) {
                    myListForRemove[j] = myArray[j];
                } else {
                    myListForRemove[j] = myArray[j + 1];
                }
            }
        }
        return myListForRemove;
    }

    public void remove(int id) {
        myArray = removeEl(id);

    }

    public void delete(T obj) {
        for (int i = 0; i < getIndexNewElement() - 1; i++) {
            if (myArray[i].equals(obj)) {
                remove(i);
            }
        }
    }

    public boolean delete() {
        if (myArray.length == -1)
            return false;
        myArray = null;
        return true;
    }

    public int getLength() {
        return myArray.length;
    }


}
