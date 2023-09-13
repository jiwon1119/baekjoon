import java.util.Scanner;

public class Solution {
	static int N, B, ans; // N: 점원의수 1~20 / B : 선반의높이 1 ~ 모든 점원키의합
	static int[] High; // 점원들의 키 배열

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원 수
			B = sc.nextInt(); // 선반의 높이
			High = new int[N];
			for(int i=0; i<N; i++) {
				High[i]=sc.nextInt();
			} // 입력 끝
//			-----------------------------------------------
			ans = Integer.MAX_VALUE; 
			
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0; // 중간 합
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						sum += High[j];
					}
			}//j
			
			if(sum>= B && sum <ans)
				ans = sum;
			}//i	
			System.out.println("#"+tc+" "+(ans-B));
		} // tc

	}//main
	
}