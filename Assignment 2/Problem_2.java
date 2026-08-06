//Problem 2: Emergency Route Validation
import java.util.*;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        
        dist[1] = 0;
        queue.add(1);

        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (dist[curr] <= D) {
                count++;
            }

            for (int neighbor : adj[curr]) {
                if (dist[neighbor] == -1) { 
                    dist[neighbor] = dist[curr] + 1;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(count);
    }
}