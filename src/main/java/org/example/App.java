//try {exception} catch {(типа ексепшена e) e.printStackTrace(); - отпечатать эксепшн в консоль}
//finally, throws, throw
//
// 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//
// 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//
// 3 В методе main() вызвать полученный метод, обработать возможные исключения
//MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
//при условии что подали на вход корректный массив).



package org.example;

public class App {

    public static void main(String[] args) {
        int result = 0;

        String[][] correctArray = {{"1","1","1","1"},{"1","1","1","1"}};
        String[][] arrayException = {{"1", "1", "1", "1", "2"}, {"1", "1", "1", "1", "2"}};
        String[][] dataException = {{"1", "1", "1", "фыв"}, {"1", "1", "1", "йцуке"}};

        System.out.println("Рабочий массив");
        System.out.println(" ");
        try {
            result = 0;
            result = massiv(correctArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат сложения равен "+String.valueOf(result));
        }
        System.out.println(" ");
        System.out.println("Массив с неправильным размером");
        System.out.println(" ");
        try {
            result = 0;
            result = massiv(arrayException);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат сложения равен "+String.valueOf(result));
        }
        System.out.println(" ");
        System.out.println("Массив с ошибками в ячейках");
        System.out.println(" ");
        try {
            result = 0;
            result = massiv(dataException);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат сложения равен "+String.valueOf(result));
        }

    }

    public static int massiv(String[][] array) throws MyArrayDataException, MyArraySizeException {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        if (array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 1; i < 3; i++) {
            sum3 = i;
            for (int j = 1; j < 5; j++) {
                sum4 = j;
                try {
                    sum2 = Integer.parseInt(array[i - 1][j - 1]);
                    sum1 += sum2;
                } catch (IllegalArgumentException e) {
                    String message = " в " + String.valueOf(sum3) + " ряде, " + String.valueOf(sum4) + " ячейке";
                    throw new MyArrayDataException(message);
                }

            }
        } return sum1;
    }
}