import java.util.Scanner;

public class Solution {
	static int N, M;
	static int p[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int answer=0;
			p = new int[N + 1]; // parents 표시할 배열
			for (int i = 0; i <= N; i++) {
				p[i]=i;
			}

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				union(x, y);
			}
			
			  //부모 값이 자기 자신과 같은 것의 개수가 그룹의 개수
            for(int i=1; i<=N;i++) {
            	if(p[i]==i) {
            		answer++;
            	}
            }
            System.out.printf("#%d %d\n", tc, answer);
		}//tc
	}// main

	static void union(int i, int j) {
		i = findset(i);
		j = findset(j);
		
		if (i == j) {
			return;
		}
		p[j] = i;
	}// union

	static int findset(int i) {
		if (i == p[i]) 
			return i;
		return p[i] = findset(p[i]);

	}// findset
}