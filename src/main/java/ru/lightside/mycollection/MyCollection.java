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
        // Collections.binarySearch возвращает индекс элемента, если он найден,
        // или (-(insertion point) - 1), если не найден.
        int index = Collections.binarySearch(data, value, comparator);
        return (index >= 0) ? index : -1;
    }

    // Удалять значение по индексу.
    public T deleteByIndex(int index) {
        return data.remove(index);
    }

    // Добавлять значение в коллекцию. Так как коллекция отсортирована, добавление по индексу недопустимо.
    public void add(T value) {
        Objects.requireNonNull(value, "Null values are not allowed in this collection.");

        int insertionPoint = Collections.binarySearch(data, value, comparator);

        // Если элемент не найден, корректируем insertionPoint,
        // чтобы получить правильный индекс для вставки.
        if (insertionPoint < 0) {
            insertionPoint = -(insertionPoint) - 1;
        }
        // Если элемент найден (insertionPoint >= 0),
        // то insertionPoint уже является корректным индексом для вставки
        // (в случае дубликатов, будет вставлен перед/на месте найденного).

        data.add(insertionPoint, value);
    }

    // Получать по индексу.
    public T get(int index) {
        return data.get(index);
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
