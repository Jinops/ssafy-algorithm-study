import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
	static class Node {
		int idx, weights;

		Node(int idx, int weights) {
			this.idx = idx;
			this.weights = weights;
		}
	}

	static List<Node> list[];
	static int n;
	static int max = 0;
	static boolean visited[];
	static int max_idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[parent].add(new Node(child, weight));
			list[child].add(new Node(parent, weight));
		}

		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[n + 1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		System.out.println(max);

	}

	public static void dfs(int idx, int weights) {
		if (max < weights) {
			max = weights;
			max_idx = idx;
		}

		for (Node node : list[idx]) {
			if (!visited[node.idx]) {
				visited[node.idx] = true;
				dfs(node.idx, weights + node.weights);
			}
		}

	}

}
