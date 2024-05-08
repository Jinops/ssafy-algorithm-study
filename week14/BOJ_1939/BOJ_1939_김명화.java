import java.io.*;
import java.util.*;
 
class Node implements Comparable<Node>{
	int to;
	int weight;
	
	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return o.weight-this.weight;
	}
	
}

public class BOJ_1939_김명화 {
    static int N, M, A, B;
    static int[] dist;
    static ArrayList<Node> node[];
    static final int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        node = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            node[i] = new ArrayList<>();
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node[from].add(new Node(to, weight));
            node[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
 
        dijkstra();
 
        sb.append(dist[B]);
        System.out.println(sb);
    }
 
    public static void dijkstra() {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(A, INF));
        dist[A] = INF;
        while (!pq.isEmpty()) {
        	Node curr = pq.poll();
        	
            int from = curr.to;
            int weight = curr.weight;
            
            if (dist[from] > weight) continue;
 
            for (int i = 0; i < node[from].size(); i++) {
                int to = node[from].get(i).to;
                int weightTo = Math.min(weight, node[from].get(i).weight);
                if (weightTo > dist[to]) {
                    dist[to] = weightTo;
                    pq.offer(new Node(to, weightTo));
                }
            }
        }
    }
 
}