package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대상금_1244 {
    
    static char[] arr;
    static int chance;
    static int max;
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        
        int T =Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
            
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken(); // 숫자판의 정보
            chance = Integer.parseInt(st.nextToken()); // 교환 횟수
            arr = new char[str.length()];
            max =0;
            
            for(int i=0; i<str.length(); i++) {
                arr[i] = str.charAt(i);
            }
            
            
            // 시간 초과 방지 : https://velog.io/@sua_ahn/SWEA-1244-%EC%B5%9C%EB%8C%80-%EC%83%81%EA%B8%88-Java 참고
            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
            	chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            
            
            changeNumber(0,0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
    
    static void changeNumber(int idx, int cnt) {
    	// base 
    	if(cnt==chance) {
    		// 결과 상금 생성
    		String result = "";
    		for(char s : arr) {
    			result += s; 
    		}
    		// 최댓값 갱신
    		max = Math.max(max, Integer.parseInt(result));
    		return;
    	}
    	
    	// recursive
    	for(int i=idx; i<arr.length; i++) {
    		for(int j=i+1; j<arr.length; j++) {
    			// case#1: swap 수행 후 재귀
    			swap(i,j);
    			changeNumber(i, cnt+1);
    			// case#2: 원상복구
    			swap(i,j);
    		} 		
    	}
    }
    
    static void swap(int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}