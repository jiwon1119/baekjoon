import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[100][100];
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int w = y; w < y + 10; w++) {
				for (int h = x; h < x + 10; h++) {
					arr[w][h] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += arr[i][j];
			}
		}
		
		System.out.println(sum);
	}
}