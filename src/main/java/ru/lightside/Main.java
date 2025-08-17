package ru.lightside;


import ru.lightside.graph.Graph;
import ru.lightside.graph.Point;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Point> points = new HashSet<Point>();

        points.add(new Point("A", "B", 1500.9));
        points.add(new Point("B", "F", 1500.6));
        points.add(new Point("F", "E", 300.85));
        points.add(new Point("F", "C", 500.2));
        points.add(new Point("E", "D", 2500.1));
        points.add(new Point("E", "C", 900.5));
        points.add(new Point("C", "A", 2000.1));
        points.add(new Point("D", "A", 1000.5));

        Graph graph = new Graph(points);

        System.out.println(graph);


        Point[][] m = new Point[6][6];   // A
        m[0][1] = new Point("A", "B", 1500.9);   // B
        m[1][2] = new Point("B", "F", 1500.6);   // B
        m[2][3] = new Point("F", "C", 500.2);   // B
        m[2][4] = new Point("F", "E", 300.85);   // B
        m[4][3] = new Point("E", "C", 900.5);   // B
        m[3][0] = new Point("C", "A", 2000.1);   // B
        m[4][5] = new Point("E", "D", 2500.1);   // B
        m[5][0] = new Point("D", "A", 1000.5);   // B

        System.out.println(Arrays.deepToString(m));
    }
}