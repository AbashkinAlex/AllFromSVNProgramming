package ua.org.oa.metalfan0991.item1_2_3_4;

/**
 * <p>
 * класс суммирования элементов массива ArraySum, содержащий статический метод Sum(),
 * принимающий массив в качестве параметра.
 * </p>
 * @author <a href="mailto:metalfan0991@gmail.com">Aleksandr Abashkin</a>
 * @since 2015-11-07
 */
public final class ArraySum {

    /**
     * Запрещаем создание объектов
     */
    private ArraySum() {

    }

    /**
     * Суммирует элементы массива
     *
     * @param arr массив суммируемых элементов
     * @return сумма всех элементов массива
     */

    public static int sum(int[] arr) throws MyException{
        if (arr==null){
            throw new MyException();
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;

        }
        return sum;
    }

    public static void creatArr() throws Exception{
//        if (i == 1){
//            int[] arrayTest = {5,7,9,3};
//            for (int i2 : arrayTest) {
//
//            }
//        }
//        else if(i == 0) {
//            int[] empty = {};
//        }
return;
    }
}

