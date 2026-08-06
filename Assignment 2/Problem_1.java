//Problem 1: Tree of Trusted Servers
import java.util.Scanner;
import java.util.ArrayList;

public class Problem_1 {
    static int trustedCount = 0;

    static void dfs(int node, int parent, long currentXor, long[] keys, ArrayList<Integer>[] adj, long K) {
        currentXor ^= keys[node];

        if (currentXor >= K) {
            trustedCount++;
        }

        for (int neighbor : adj[node]) {
            if (neighbor != parent) { 
                dfs(neighbor, node, currentXor, keys, adj, K);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] keys = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            keys[i] = sc.nextLong();
        }

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1, 0, 0, keys, adj, K);

        System.out.println(trustedCount);
    }
}