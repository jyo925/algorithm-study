package com.company.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BSF 너비우선순회 구현하기
 * 인접리스트, 큐 이용
 * 최단경로
 * 시간복잡도 O(n+m) n = 노드개수, m = 간선개수
 *
 * 구현 예정
 * 비연결 그래프 or 방향그래프인 경우 bfs() 실행 시 모든 노드가 방문되지 않을 수 있다.
 * -> bfs를 반복호출해서 해결하기
 * -> while there exists unvisited node v ====> bfs(v)
 */
public class Graph_BFS {

    class Node {
        private int data;
        private LinkedList<Node> adjacent; //인접리스트

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<Node>();
        }

        public int getData() {
            return data;
        }

        public LinkedList<Node> getAdjacent() {
            return adjacent;
        }

    }

    private Node[] nodes;

    private int[] d; //s노드로부터 각 노드까지의 최단 경로 길이(에지 개수), -1로 초기화해서 -1이면 미방문

    private Node[] predecessor; // 최단경로 상에서 각 노드의 직전 노드 번호(predecessor)

    public Graph_BFS(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
        d = new int[nodes.length];
        predecessor = new Node[nodes.length];
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int[] getD() {
        return d;
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


    public void bfs(Node start) {

        for (int j = 0; j < nodes.length; j++) {
            d[j] = -1;
            predecessor[j] = null;
        }

        d[start.getData()] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            LinkedList<Node> adjacent = tmp.getAdjacent();

            //이웃노드들에 대해 방문표시 & 큐에 삽입
            for (int i = 0; i < adjacent.size(); i++) {
                Node adjNode = adjacent.get(i);
                int index = adjNode.getData();
                if (d[index] == -1) { //미방문 노드이면
                    d[index] = d[tmp.getData()] + 1;
                    predecessor[index] = tmp;
                    q.add(adjNode);
                }
            }
        }

    }

    //최단 경로 출력하기
    public void printPath(Node start, Node end) {
        System.out.println(start.getData());
        System.out.println(end.getData());

        if (start.getData() == end.getData()) {
            System.out.print(start.getData() + "-> ");
        } else if (predecessor[end.getData()] == null) {
            System.out.println("No path from " + start.getData() + "to " + end.getData() + "exists.");
        } else {
            printPath(start, predecessor[end.getData()]);
            System.out.print(end.getData() + "-> ");
        }
    }

    public static void main(String[] args) {

        Graph_BFS g = new Graph_BFS(9);
 /*
        //노드 삽입 확인
        Node[] tmp = bfs.getNodes();
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i].getData());
        }*/
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

        g.bfs(g.getNodes()[0]);
/*        int[] dd = g.getD();
        for (int tmp : dd) {
            System.out.print(tmp + ", ");
        }*/

        Node start = g.getNodes()[0];
        Node end = g.getNodes()[8];
        System.out.println(end);
        System.out.println(start);
        g.printPath(start, end);


    }
}
