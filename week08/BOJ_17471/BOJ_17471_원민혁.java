import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int population;
	boolean[] next = new boolean[11];
	Node() {}
	Node(int population) {
		this.population = population;
	}
}

public class boj_17471 {
	static int N;
	static Node[] cities;
	static boolean[] list = new boolean[11];
	static int count;
	static int dif = Integer.MAX_VALUE;
	static int totalPopulation = 0;
	static int sum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cities = new Node[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cities[i] = new Node(Integer.parseInt(st.nextToken()));
			totalPopulation += cities[i].population;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				cities[i].next[Integer.parseInt(st.nextToken())] = true;
			}
		}
		for (int i = 1; i <= N/2; i++) { // 부분집합의 원수 개수
			count = 0;
			findPart(i, 1);
		}
		if (dif == Integer.MAX_VALUE) {
			dif = -1;
		}
		System.out.print(dif);
		
		
	}
	
	private static void findPart(int num, int start) {
		if (count >= num) {
			int tmpDif = Math.abs(2 * sum - totalPopulation);
			if (dif > tmpDif) {
				if (isPossible()) {
					dif = tmpDif;
				}
			}
		}
		for (int j = start; j <= N; j++) {
			list[j] = true;
			count++;
			sum += cities[j].population;
			findPart(num, j+1);
			list[j] = false;
			count--;
			sum -= cities[j].population;
		}
	}

	private static boolean isPossible() {
		boolean[] visit = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < visit.length; i++) {
			if (list[i]) {
				queue.offer(i);
				visit[i] = true;
				break;
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();
				for (int j = 1; j < 11; j++) {
					if (cities[tmp].next[j] && list[j] && !visit[j]) {
						queue.offer(j);
						visit[j] = true;
					}
				}
			}
		}
		for (int i = 1; i < visit.length; i++) {
			if (!list[i]) {
				queue.offer(i);
				visit[i] = true;
				break;
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();
				for (int j = 1; j < 11; j++) {
					if (cities[tmp].next[j] && !list[j] && !visit[j]) {
						queue.offer(j);
						visit[j] = true;
					}
				}
			}
		}
		for (int i = 1; i < visit.length; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}
}