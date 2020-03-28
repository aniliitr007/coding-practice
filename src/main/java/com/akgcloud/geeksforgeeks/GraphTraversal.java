package com.akgcloud.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    public static class Vertext {
        private boolean visited;
        private char    label;

        public Vertext(char lab) {
            label = lab;
            visited = false;
        }
    }

    private final int MAX_VERTEX_COUNT = 20;
    private int       vertexCount;
    private int[][]   adjMatrix;
    private Vertext[] vertices;

    public GraphTraversal() {
        vertexCount = 0;
        vertices = new Vertext[MAX_VERTEX_COUNT];
        adjMatrix = new int[MAX_VERTEX_COUNT][MAX_VERTEX_COUNT];
        for (int i = 0; i < MAX_VERTEX_COUNT; i++) {
            for (int j = 0; j < MAX_VERTEX_COUNT; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertext(label);
    }

    public void addUndirectedEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void addDirectedEdge(int i, int j) {
        adjMatrix[i][j] = 1;
    }

    private int getAdjUnvisitedVertex(Integer v) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[v][i] == 1 && vertices[i].visited == false) {
                return i;
            }
        }
        return -1;
    }

    public void resetVisitedFlags() {
        for (int i = 0; i < vertexCount; i++) {
            vertices[i].visited = false;
        }
    }

    public void createUndirectedGraph() {
        addVertex('A');
        addVertex('B');
        addVertex('C');
        addVertex('D');
        addVertex('E');
        addVertex('F');
        addVertex('G');
        addVertex('H');
        addVertex('I');
        addUndirectedEdge(0, 1);
        addUndirectedEdge(1, 2);
        addUndirectedEdge(2, 3);
        addUndirectedEdge(2, 4);
        addUndirectedEdge(4, 5);
        addUndirectedEdge(4, 6);
        addUndirectedEdge(4, 7);
        addUndirectedEdge(7, 1);
        addUndirectedEdge(6, 8);
        addUndirectedEdge(7, 8);
    }

    public void createDirectedGraph() {
        addVertex('A');
        addVertex('B');
        addVertex('C');
        addVertex('D');
        addDirectedEdge(0, 1);
        addDirectedEdge(0, 2);
        addDirectedEdge(2, 0);
        addDirectedEdge(2, 3);
        addDirectedEdge(1, 2);
    }

    public void displayVertex(int v) {
        System.out.println(vertices[v].label);
    }

    public void dfs() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        displayVertex(0);
        vertices[0].visited = true;
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                // backtracking
                v = stack.pop();
            } else {
                stack.push(v);
                displayVertex(v);
                vertices[v].visited = true;
            }
        }
        resetVisitedFlags();
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        displayVertex(0);
        vertices[0].visited = true;
        int v2;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            while ((v2 = getAdjUnvisitedVertex(v)) != -1) {
                queue.add(v2);
                displayVertex(v2);
                vertices[v2].visited = true;
            }
        }
        resetVisitedFlags();
    }

    public void shortestPathFromVertex(int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        vertices[s].visited = true;
        int[] distance = new int[vertexCount];
        int[] path = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            distance[i] = -1;
        }
        distance[s] = 0;
        int v = s;
        int w;
        while (!queue.isEmpty()) {
            v = queue.poll();
            while ((w = getAdjUnvisitedVertex(v)) != -1) {
                if (distance[w] == -1) {
                    distance[w] = distance[v] + 1;
                    path[w] = v;
                    queue.add(w);
                    vertices[w].visited = true;
                }
            }
        }
        resetVisitedFlags();

        // print distance table
        for (int i = 0; i < vertexCount; i++) {
            System.out.println(vertices[i].label + " " + distance[i] + " " + vertices[path[i]].label);
        }
    }

    public boolean isPathExist(int s, int d) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        vertices[s].visited = true;
        int v2;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            while ((v2 = getAdjUnvisitedVertex(v)) != -1) {
                queue.add(v2);
                vertices[v2].visited = true;
                if (v2 == d) {
                    return true;
                }
            }
        }
        resetVisitedFlags();
        return false;
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();
        graph.createUndirectedGraph();
        System.out.println("graph dfs");
        graph.dfs();
        System.out.println("\ngraph bfs");
        graph.bfs();
        System.out.println("shortest path from c = 2");
        graph.shortestPathFromVertex(2);
        System.out.println(graph.isPathExist(6, 3));
        
        // Directed graph
        GraphTraversal directedGraph = new GraphTraversal();
        directedGraph.createDirectedGraph();
        System.out.println("directed bfs :");
        directedGraph.bfs();
        System.out.println(directedGraph.isPathExist(3, 1));
    }

}
