package com.company.graph;

import java.util.LinkedList;

/**
 * DFS 깊이우선순회 구현하기
 * 재귀 이용
 *
 *
 * 구현 예정
 * - 스택을 이용해서 구현해보기
 * 비연결 그래프 or 방향그래프인 경우 dfs() 실행 시 모든 노드가 방문되지 않을 수 있다.
 * dfs() 반복호출해서 해결하기 -> 시간복잡도 O(n+m)
 */
public class Graph_DFS {

    class Node {
        private int data;
        private Node preNode; //직전 노드
        private LinkedList<Node> adjacent; //인접리스트
        private boolean visited;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<Node>();
            this.visited = false;
            this.preNode = null;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void setPreNode(Node preNode) {
            this.preNode = preNode;
        }

        public int getData() {
            return data;
        }

        public Node getPreNode() {
            return preNode;
        }

        public LinkedList<Node> getAdjacent() {
            return adjacent;
        }

        public boolean isVisited() {
            return visited;
        }
    }

    private Node[] nodes;

    public Graph_DFS(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void dfs(Node start) {

        start.setVisited(true);
        LinkedList<Node> adjacent = start.getAdjacent();
        adjacent.forEach(node ->{
            if (!node.isVisited()) {
                node.setPreNode(start); //재귀를 이용하기 때문에 이전노드를 기록할 필요없음
                System.out.print(node.getData() + "-> ");
                dfs(node);
            }
        });

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

        Graph_DFS g = new Graph_DFS(9);
/*
  0
 /
1ㅡㅡ3    7
|  / | \ /
| /  |  5
2ㅡㅡ4   \
          6ㅡ8
*/
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        System.out.print(g.getNodes()[0].getData() + "-> ");
        g.dfs(g.getNodes()[0]);



    }
}
