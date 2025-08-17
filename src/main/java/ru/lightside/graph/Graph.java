package ru.lightside.graph;

import java.util.HashSet;
import java.util.Set;

public record Graph(Set<Point> points) {
    public Graph(Set<Point> points) {
        this.points = new HashSet<>(points);
    }

    public void add(Point p) {
        points.add(p);
    }
}
