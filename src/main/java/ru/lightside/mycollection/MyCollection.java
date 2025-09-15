package ru.lightside.mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MyCollection<T extends Comparable<? super T>> {
    private final List<T> data;
    private final Comparator<? super T> comparator;

    public MyCollection() {
        this(Comparator.naturalOrder());
    }

    public MyCollection(Comparator<? super T> comparator) {
        this.data = new ArrayList<>();
        this.comparator = Objects.requireNonNull(comparator, "Comparator cannot be null");
    }

    // Проверять наличие или отсутствие определённого значения.
    public boolean isExists(T value) {
        return indexOf(value) != -1;
    }

    // Получать индекс местонахождения значения в коллекции (если значение в ней присутствует).
    public int indexOf(T value) {
        int lowIndex = 0;
        int highIndex = data.size() - 1;

        while (lowIndex <= highIndex) {
            int middle = (lowIndex + highIndex) / 2;
            T middleVal = data.get(middle);
            int compareVal = compare(value, middleVal);

            if (compareVal < 0) {
                highIndex = middle - 1;
            } else if (compareVal > 0) {
                lowIndex = middle + 1;
            } else {
                return middle;
            }
        }
        return -(lowIndex + 1);
    }

    // Удалять значение по индексу.
    public T deleteByIndex(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + data.size());
        }

        T removedElement = data.get(index);

        for (int i = index; i < data.size() - 1; i++) {
            data.set(i, data.get(i + 1));
        }

        return removedElement;
    }

    // Добавлять значение в коллекцию. Так как коллекция отсортирована, добавление по индексу недопустимо.
    public void add(T value) {
        Objects.requireNonNull(value, "Null values are not allowed in this collection.");

        if (data.isEmpty()) {
            data.add(value);
        }

        int insertionPoint = indexOf(value);

        // Если элемент не найден, корректируем insertionPoint, чтобы получить правильный индекс для вставки.
        if (insertionPoint < 0) {
            insertionPoint = -(insertionPoint) - 1;
        }
        // Если элемент найден (insertionPoint >= 0), то insertionPoint уже является корректным индексом для вставки

        data.add(insertionPoint, value);
    }

    // Получать по индексу.
    public T get(int index) {
        return data.get(index);
    }

    private int compare(T value, T middleVal) {
        if (comparator != null) {
            return comparator.compare(value, middleVal);
        } else {
            return value.compareTo(middleVal);
        }
    }

    /**
     * Возвращает количество элементов в коллекции.
     * Сложность: O(1).
     *
     * @return Количество элементов.
     */
    public int size() {
        return data.size();
    }

    /**
     * Проверяет, пуста ли коллекция.
     * Сложность: O(1).
     *
     * @return true, если коллекция не содержит элементов, иначе false.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Очищает коллекцию, удаляя все элементы.
     * Сложность: O(1).
     */
    public void clear() {
        data.clear();
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
