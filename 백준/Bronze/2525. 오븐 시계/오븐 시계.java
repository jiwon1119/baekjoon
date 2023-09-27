import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 시
		int B = sc.nextInt(); // 분
		int C = sc.nextInt(); // 요리시간

		int h = 0;
		int m = 0;

		if (B + C >= 60) { // 분의 합이 60보다 크거나 같고
			h = A + (B + C) / 60; // 시는 원래 시 + 분의 합 나누기 60
			if ((B + C) % 60 == 0) { // 60으로 나누어 떨어지면
				m = 0;
			} else {
				m = (B + C) % 60;
			}
			if (h >= 24) {
				h -= 24;
			}
		} else {
			h = A;
			m = B + C;
		}
		System.out.printf("%d %d", h, m);
	}
}