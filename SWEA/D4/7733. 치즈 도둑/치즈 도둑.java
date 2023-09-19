import java.util.Scanner;

public class Solution {
	static int N, max, min, num; // N: 격자 크기, max: 최댓값, min: 최솟값, num: 현재 탐색 중인 날짜
	static int[][] arr; // 치즈 높이 정보를 담은 배열
	static boolean[][] visited; // 방문 여부를 저장하는 배열
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			max = Integer.MIN_VALUE; // 최댓값 초기화
            min = Integer.MAX_VALUE; // 최솟값 초기화

            // 격자 정보 입력과 동시에 최댓값과 최솟값 갱신(효율성을 위해  해당하는 날짜만 탐색하기 위함)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (max < arr[i][j])
                        max = arr[i][j];
                    if (min > arr[i][j])
                        min = arr[i][j];
				}
			} // 입력 끝
			
			int maxCount = 0; // 최대 치즈 뭉치 개수 초기화

			// 날짜 k를 min-1부터 max까지 순회하면서 탐색
			// 하나도 안 먹었을 떄도 생각해야 해서 min-1부터,
			// max일 때는 다 먹었으니까 뭉치가 0개. 그러니까 범위에 포함시키지 않는다.
			for (int k = min-1; k < max; k++) {
				visited = new boolean[N][N]; // 방문 여부 배열 초기화
				num = k; // 현재 탐색 중인 날짜 num에 저장
                int count = 0; // 현재 날짜에서의 치즈 뭉치 개수 초기화

                // 전체 격자를 순회하면서 DFS 탐색 수행
                for (int i = 0; i < N; i++) {
                	for (int j = 0; j < N; j++) {
                		if (arr[i][j] > k && !visited[i][j]) {
                			count++;
                			dfs(i, j);		
						}			
					}
				}
	
				// 현재 높이에서의 치즈 뭉치 개수가 최대값인지 확인하고 갱신
	            if (maxCount < count)
	                maxCount = count;
			}
			
			System.out.println("#" + tc + " " + maxCount); // 결과 출력
			
		} // tc
		sc.close(); 
	}// main

	// 깊이 우선 탐색 (DFS) 함수
	static void dfs(int i, int j) {
		visited[i][j] = true; // 현재 위치를 방문한 것으로 표시
		
		// 상하좌우로 이동하면서 탐색
        for (int d = 0; d < 4; d++) {
            int x = i + dr[d]; // 다음 행 위치 계산
            int y = j + dc[d]; // 다음 열 위치 계산
         // 다음 위치가 격자 내에 있고, 높이가 현재 탐색 중인 높이보다 크고 아직 방문하지 않았다면 DFS 탐색 수행
            if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] > num && !visited[x][y])
                dfs(x, y);
        }
	}// dfs
}