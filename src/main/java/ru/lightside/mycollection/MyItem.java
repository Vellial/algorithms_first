package ru.lightside.mycollection;

public class MyItem<E> {
    E item;
    MyItem<E> next;
    MyItem<E> prev;

    MyItem(E item, MyItem<E> next, MyItem<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
