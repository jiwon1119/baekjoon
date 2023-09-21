import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int H = sc.nextInt(); // 층수
			int W = sc.nextInt(); // 각 층의 방 수
			int N = sc.nextInt(); // 몇 번째 손님
			int[][] arr = new int[W][H];
			int cnt = 0;
			int floor = 0;
			int num = 0;

			out: for (int j = 1; j <= W; j++) {
				for (int k = 1; k <= H; k++) {
					cnt++;
					if (cnt == N) {
						floor = k;
						num = j;
						break out;
					}
				}
			}

			System.out.print(floor);
			if (num < 10) {
				System.out.print("0" + num);
			} else {
				System.out.print(num);
			}
			System.out.println();
		} // tc
	}
}
