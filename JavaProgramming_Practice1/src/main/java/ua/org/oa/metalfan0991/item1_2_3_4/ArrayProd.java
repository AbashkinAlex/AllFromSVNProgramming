package ua.org.oa.metalfan0991.item1_2_3_4;

/**
 * Created by Abashkin on 11/8/2015.
 */
public class ArrayProd {
    /**
     * Запрещает создание объектов
     */
    private ArrayProd() {

    }

    /**
     *
     * @param arr - массив для подсчета произведения всех его членов
     * @return Произведение всех членов массива arr[]
     * @throws MyException
     */
    public static int prod(int[] arr) throws MyException {
        int prod = 0;
        if (arr == null) {
            throw new MyException();

        } else if (arr != null && arr.length != 0) {
            prod = 1;
            for (int i : arr) {
                prod = prod * i;
            }
        }
        return prod;
    }
}

