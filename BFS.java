import java.util.*;
//BFS：广度优先算法

public class BFS {
    private int V;// 图中顶点的数量
    private LinkedList<Integer>[] adj; // 用邻接表表示图

    BFS(int v){
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> iter = adj[s].listIterator();
            while (iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS g = new BFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        System.out.println("广度优先遍历结果：");

        g.BFS(0);
    }

}
