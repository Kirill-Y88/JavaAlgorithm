package Lesson7;

import java.util.LinkedList;

public abstract class GraphPath {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    GraphPath(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
    }


    public boolean hasPathTo(int dist){
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist){
        if(!hasPathTo(dist)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        int length = 0;
        while(vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
            length++;
        }
        System.out.println("Длина пути = " + length);
        return stack;
    }

}
