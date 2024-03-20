import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[] populations;
  static Map<Integer, Set<Integer>> map;
  static int min = Integer.MAX_VALUE;

  static void combination(int start, int n, int r, List<Integer> listA){ // nCr
    if(r==0){
      Set<Integer> setB = new HashSet<>(map.keySet());
      setB.removeAll(listA);
      List<Integer> listB = new LinkedList<>(setB);

      if(isValid(listA) && isValid(listB)){
        int pA = getPopulation(listA);
        int pB = getPopulation(listB);
        min = Math.min(min, Math.abs(pA-pB));
      }
      return;
    }
    for (int i=start; i<=n; i++){
      listA.add(i);
      combination(start+1, n, r-1, listA);
      listA.remove(listA.size()-1);
    }
  }

  static boolean isValid(List<Integer> list){
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N+1];

    queue.add(list.get(0));
    visited[list.get(0)] = true;
    int visitCnt = 1;

    while(!queue.isEmpty()){
      int node = queue.poll();

      for(int next:map.get(node)){
        if(list.contains(next) && !visited[next]){
          queue.add(next);
          visited[next] = true;
          visitCnt++;
        }
      }
    }

    return list.size() == visitCnt;
  }

  static int getPopulation(List<Integer> list){
    int sum = 0;
    for(int n:list){
      sum+=populations[n];
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    StringTokenizer st;
    
    N = Integer.parseInt(br.readLine());
    populations = new int[N+1];
    map = new HashMap<>();

    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++){
      populations[i] = Integer.parseInt(st.nextToken());
      map.put(i, new HashSet<>());
    }

    for(int key=1; key<=N; key++){
      st = new StringTokenizer(br.readLine());
      int size = Integer.parseInt(st.nextToken());
      for(int i=0; i<size; i++){
        int value = Integer.parseInt(st.nextToken());
        map.get(key).add(value);
        map.get(value).add(key);
      }
    }

    for(int i=1; i<=N/2; i++){
      List<Integer> listA = new LinkedList<>();
      combination(1, N, i, listA);
    }

    System.out.println(min==Integer.MAX_VALUE?-1:min);
  }
}
