package Lesson7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Graph graph = new Graph(10);

        for (int i = 0; i < 10; i++) {
                graph.addEdge(i, random.nextInt(10));
                graph.addEdge(i, random.nextInt(10));
                graph.addEdge(i, random.nextInt(10));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Graph# " + i + "  " + graph.getAdjList(i));
        }

        System.out.println("----");

        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2);
        System.out.println(dfp.hasPathTo(0));
        System.out.println(dfp.pathTo(0));

        System.out.println();

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 2);
        System.out.println(bfp.hasPathTo(0));
        System.out.println(bfp.pathTo(0));

    }
}
