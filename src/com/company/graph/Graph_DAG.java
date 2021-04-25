package com.company.graph;

import java.util.LinkedList;

/**
 * 방향사이클(자기자신으로 다시 돌아오는)이 없는 방향그래프
 * 예: 작업들간 우선순위, 라면끓이는 순서
 *
 * 위상정렬 이용
 * 위상 정렬(topological sorting)은 방향이 있는 그래프의 꼭짓점들(vertex)을 변의 방향을 거스르지 않도록 나열하는 것
 * 1. 이전노드(선행노드)가 없는 노드를 1개 선택한다.
 * 2. 해당노드를 위상정렬배열에 추가하고 해당노드와 진출간선을 삭제하고 1번 반복
 * 
 * 구현 예쩡
 * -> 위상정렬 다른 방법으로 구현 가능함
 */
public class Graph_DAG {

    class Node {
        private int data;
        private boolean visited;
        private LinkedList<Node> adjacent; //인접리스트

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<Node>();
            this.visited = false;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public int getData() {
            return data;
        }

        public LinkedList<Node> getAdjacent() {
            return adjacent;
        }

    }

    private Node[] nodes;

    public Graph_DAG(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public LinkedList<Node> topologicalSort() {

        LinkedList<Node> r = new LinkedList<>();

        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            if (!node.isVisited()) {
                Dfs_TS(node, r);
            }
        }
        return r;
    }

    private void Dfs_TS(Node node, LinkedList<Node> r) {

        node.setVisited(true);
        LinkedList<Node> adjacent = node.getAdjacent();

        adjacent.forEach(i -> {
            if (!i.isVisited()) {
                Dfs_TS(i, r);
            }
        });

        r.add(0, node);

    }

    //에지 생성
    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        //상대방이 있는지 확인하고 없으면 추가
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    public static void main(String[] args) {

        Graph_DAG g = new Graph_DAG(9);
/*
  0
 /
1ㅡㅡ3    7
   /  \ /
  /     5
2ㅡㅡ4   \
          6ㅡ8
*/
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        //2 -> 4 -> 0 -> 1 -> 3 -> 5 -> 7 -> 6 -> 8
        LinkedList<Node> list = g.topologicalSort();
        list.forEach(i -> {
            System.out.print(i.data + " -> ");
        });

    }
}
