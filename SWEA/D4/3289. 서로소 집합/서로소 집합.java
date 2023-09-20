import java.util.Scanner;

public class Solution {
	static int n;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
				
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt(); // n개의 숫자가 주어진다.
			int m = sc.nextInt(); // 연산의 횟수

			p = new int[n + 1];
			for (int i = 0; i < n + 1; i++) { // 노드개수만큼 실행, index0번은 버림
				p[i] = i;	//Make-set
			}

			// StringBuilder를 이용하여 출력할 것들을 저장한 후 한 번에 출력 (안하면 런타임에러 남)
			sb.append("#" + tc + " ");		//sb.append() 괄호 안을 읽어서 sb에 저장
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt(); // 0 or 1
				int x = sc.nextInt();
				int y = sc.nextInt();

				if (a == 0) {	
					union(x, y);
					
				} else if (a == 1) {
					if (findset(x) == findset(y)) {
						sb.append(1);
					} else {
						sb.append(0);
					}				
				}
			}
			sb.append("\n");	//줄바꿈
		}
		System.out.println(sb);	//출력~~
	}// main

	static void union(int x, int y) {
		x= findset(x);
		y= findset(y);
		if(x==y) {
			return;			
		}
//		p[findset(y)] = findset(x); // x의 대표를 y의 대표로 넣겠다. rank고려x
		p[y] = x; // 허나! 이렇게 작성하는 것은 문제를 잘 이해했고 확신이 있을때 하는 행위
	}

	static int findset(int x) {
		// 효율성 따지지 않은 순수 그잡채 기술
		if (x == p[x])
			return x;
		return p[x] = findset(p[x]);	// Path compression
//		p[x] = findset(p[x]);
//	return p[x];				이 2줄을 하나로 쓴 것이 59번 줄
		
//		// 패쓰 컴푸레숀~~~
//		if (x != p[x]) 
//			p[x] = findset(p[x]);
//		return p[x];
//		
	}
}