import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N= sc.nextInt();
			int M= sc.nextInt();
			int[][] arr= new int[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				int x= sc.nextInt();
				int y= sc.nextInt();
				arr[x][y]=1;
				arr[y][x]=1;
			}
			
			int cnt=0;
			for(int i=1; i<=N-2; i++) {
				for(int j=i+1; j<=N-1; j++) {
					for(int k=j+1; k<=N; k++) {
						if(arr[i][j]==1 && arr[j][k]==1 && arr[i][k] ==1) {
							cnt++;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}//tc
	}
}