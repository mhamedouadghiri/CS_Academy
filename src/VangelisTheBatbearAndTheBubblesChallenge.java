import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class VangelisTheBatbearAndTheBubblesChallenge {
    private int V;
    private LinkedList<Integer>[] adj;

    private VangelisTheBatbearAndTheBubblesChallenge(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    private Boolean isCycleUtil(int v, Boolean[] visited, int parent) {
        visited[v] = true;
        Integer i;

        for (Integer integer : adj[v]) {
            i = integer;
            if (!visited[i]) {
                if (isCycleUtil(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    private Boolean isCyclic() {
        Boolean[] visited = new Boolean[V];
        Arrays.fill(visited, false);

        for (int u = 0; u < V; u++)
            if (!visited[u])
                if (isCycleUtil(u, visited, -1))
                    return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, m;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            VangelisTheBatbearAndTheBubblesChallenge graph = new VangelisTheBatbearAndTheBubblesChallenge(n);
            for (int j = 0; j < m; j++) {
                graph.addEdge(scanner.nextInt(), scanner.nextInt());
            }
            if (graph.isCyclic())
                System.out.println(1);
            else System.out.println(0);
        }
    }
}
