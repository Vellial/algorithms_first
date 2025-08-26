package ru.lightside.minmax;

/*
Реализуйте метод, который принимает массив целых чисел и находит минимум и максимум этого массива,
таким образом, чтобы асимптотика была O(n), однако использовалось не более чем 3(n/2) сравнений.
 */
public class MinMaxArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 1, 3, 2, 5, 4, 7, 9, 3, -2}; // ожидаемый результат: min: -2, max: 9
        findMinMax(array);
    }

    static void findMinMax(int[] array) {
        int min = array[0], max = array[array.length - 1];

        for (int i = 0; i < array.length - 1; i++) {
            if (min > array[i+1]) {
                min = array[i+1];
            }
            if (max < array[i]) {
                max = array[i];
            }

        }

        System.out.printf("min: %s%n", min);
        System.out.printf("max: %s%n", max);
    }


}
