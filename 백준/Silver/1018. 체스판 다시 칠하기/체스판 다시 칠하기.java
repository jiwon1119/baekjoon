import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		char[][] compare1 = new char[8][8];
		char[][] compare2 = new char[8][8];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();

		}
//		System.out.println(Arrays.deepToString(arr));

		// 체스판1
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					compare1[i][j] = 'W';
				} else if (i % 2 == 1 && j % 2 == 1) {
					compare1[i][j] = 'W';
				} else {
					compare1[i][j] = 'B';
				}
			}
		}

		// 체스판2
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					compare2[i][j] = 'B';
				} else if (i % 2 == 1 && j % 2 == 1) {
					compare2[i][j] = 'B';
				} else {
					compare2[i][j] = 'W';
				}
			}
		}
//			System.out.println(Arrays.deepToString(compare1));
		int min = 999999;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt1 = 0;
				int cnt2 = 0;
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						if (arr[r + i][c + j] != compare1[r][c]) {
							cnt1++;
						}
						if (arr[r + i][c + j] != compare2[r][c]) {
							cnt2++;
						}

					}
				}
//				System.out.println(cnt1);
//				System.out.println(cnt2);
				min = Math.min(min, cnt1);
				min = Math.min(min, cnt2);
			}
		}

		System.out.println(min);

	}
}