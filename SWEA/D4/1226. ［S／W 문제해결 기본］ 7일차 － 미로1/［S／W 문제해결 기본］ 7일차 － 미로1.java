import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static boolean possible; // 도착 가능 여부를 저장하는 변수임
	static int[][] arr; // 미로 정보를 저장하는 2차원 배열임
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우 이동을 위한 행 방향 배열임
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우 이동을 위한 열 방향 배열임

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine()); // tc
			arr = new int[16][16];
			possible = false; // 도착 가능 여부 초기화함
			int startX = 0; // 시작 위치의 행 초기화함
			int startY = 0; // 시작 위치의 열 초기화함

			for (int i = 0; i < 16; i++) {
				String carr = br.readLine();

				for (int j = 0; j < 16; j++) {
					arr[i][j] = carr.charAt(j) - '0';
					if (arr[i][j] == 2) { // 시작 위치를 찾으면 해당 좌표를 저장함
						startX = i;
						startY = j;
					}
				}

			} // 입력 끝

			dfs(startX, startY); // DFS로 미로 탐색 시작함

			if (possible)
				System.out.println("#" + t + " " + 1); // 도착 가능하면 1 출력임
			else
				System.out.println("#" + t + " " + 0); // 도착 불가능하면 0 출력임

		} // tc
	}// main

	static void dfs(int i, int j) {
		arr[i][j] = 1; // 현재 위치 방문표시함

		for (int d = 0; d < 4; d++) {
			int x = i + dr[d]; // 다음 이동할 행 계산함
			int y = j + dc[d]; // 다음 이동할 열 계산함

			if (arr[x][y] == 0) {
				dfs(x, y); // 빈 공간이면 이동 가능하므로 재귀 호출함
			}
			if (arr[x][y] == 3) {
				possible = true; // 도착 지점을 찾으면 가능한 미로 경로가 있다고 표시함
			}
		}

	}// dfs
}