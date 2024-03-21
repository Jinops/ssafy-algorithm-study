package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 게리맨더링 {

	static int[] people;
	static boolean[][] isClose;
	static int N;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;

		N = Integer.parseInt(br.readLine());
		people = new int[N]; // 인구 저장
		boolean[] isSelected = new boolean[N]; // 이미 한 구역으로 선택 되었는지 아닌지
		isClose = new boolean[N][N]; // 인접 여부 저장

		st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			people[i] = Integer.parseInt(st1.nextToken());
			st2 = new StringTokenizer(br.readLine());
			int closeArea = Integer.parseInt(st2.nextToken());

			for (int j = 0; j < closeArea; j++) {
				int areaNum = Integer.parseInt(st2.nextToken());
				isClose[i][areaNum-1] = true;
			}
		}

		makeArea(0, isSelected, 0);
		if (minDiff == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDiff);
	}

	static void makeArea(int townIdx, boolean[] isSelected, int selectedNum) {
		// base case
		
		if (townIdx == N) {
			// 선택 과정을 끝냈다면
			
			// 0. 각 선거구는 구역을 적어도 하나 포함해야 한다.
			if (selectedNum == 0 || selectedNum == N)
				return;

			LinkedList<Integer> area1 = new LinkedList<>();
			LinkedList<Integer> area2 = new LinkedList<>();

			// 1. 선택된 마을 vs 선택되지 않은 마을로 두 구역 나누기
			for (int i = 0; i < isSelected.length; i++) {
				if (isSelected[i])
					area1.add(i);
				else
					area2.add(i);
			}

			// 2. 인접 여부 검사 : 연결이 됏는지를 검사하려고 하지말고, 아무데도 연결이 안되어있으면 false 처리
			if (isPossible(area1) && isPossible(area2)) { // 두 구역 모두 인접 여부 조건 만족한다면,
				// 3. 인접 여부 조건 만족한다면, 인구 차이 계산
				int diff = calculatePeopleDiff(area1, area2);
				minDiff = Math.min(diff, minDiff);
			}

			return;
		}

		// recursive case
		isSelected[townIdx] = true;
		makeArea(townIdx + 1, isSelected, selectedNum + 1);
		isSelected[townIdx] = false;
		makeArea(townIdx + 1, isSelected, selectedNum);
	}

//	static boolean isPossible(LinkedList<Integer> area) { // 해당 구역의 마을끼리 인접한지 검사
//
//		for (int i = 0; i < area.size(); i++) {
//			boolean flag = false;
//			for (int j = 0; j < area.size(); j++) {
//				if (isClose[i][j])
//					flag = true;
//			}
//			if (!(flag))
//				return false;
//		}
//		return true;
//	}

	static boolean isPossible(LinkedList<Integer> area) {
	    // 구역이 빈 경우나 하나의 구역만 있는 경우는 항상 true를 반환
	    if (area.size() == 1)
	        return true;

	    // 방문 여부를 저장하는 배열
	    boolean[] visited = new boolean[N];

	    // 첫 번째 구역을 시작으로 DFS 수행
	    dfs(area.getFirst(), visited, area);

	    // 모든 구역이 방문되었는지 확인
	    for (int town : area) {
	        if (!visited[town])
	            return false;
	    }
	    return true;
	}

	static void dfs(int current, boolean[] visited, LinkedList<Integer> area) {
	    visited[current] = true;

	    // 현재 구역과 연결된 인접한 구역을 확인하여 DFS 수행
	    for (int i = 0; i < N; i++) {
	        if (!isClose[current][i] || visited[i] || !area.contains(i))
	            continue;
	        dfs(i, visited, area);
	    }
	}
	
	
	static int calculatePeopleDiff(LinkedList<Integer> area1, LinkedList<Integer> area2) {
		int sum1 = 0, sum2 = 0;

		for (int i = 0; i < area1.size(); i++) {
			sum1 += people[area1.get(i)];
		}
		for (int i = 0; i < area2.size(); i++) {
			sum2 += people[area2.get(i)];
		}

		return Math.abs(sum1 - sum2);
	}
}