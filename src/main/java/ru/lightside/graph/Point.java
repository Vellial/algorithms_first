package ru.lightside.graph;

import java.util.Objects;

public class Point {
    private final String next;
    private final String name;
    private final double distance;

    public Point(String name, String next, double distance) {
        this.next = next;
        this.name = name;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(next, point.next) && Objects.equals(name, point.name);
    }

    @Override
    public int hashCode() {
        // Генерируем хэш-код на основе полей
        return Objects.hash(next, name);
    }

    @Override
    public String toString() {
        return name + "->" + distance + "->" + next;
    }
}
