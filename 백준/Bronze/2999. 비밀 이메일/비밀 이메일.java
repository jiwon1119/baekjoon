import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		StringTokenizer st;

		String letter = sc.next(); // 편지내용
		int n = letter.length(); // 글자의 길이 n

		int R = 0; // 행
		int C = 0; // 열
		// R<=C이고, R*C=N인 R과 C를 고른다.
		// 만약, 그러한 경우가 여러 개일 경우, R이 큰 값을 선택한다.
		// R이 큰 값을 선택하기 위해 n부터 --하면서 반복문을 돌고
		// 조건에 만족하는 값을 찾으면 break;시켜준다.
		for (int r = n; r > 0; r--) {
			// n이 r로 나누어 떨어지고 나눠지는 수보다 같거나 작을 때
			if (n % r == 0) {
				R = r; // R은 그 때의 r
				C = n / r; // C는 그 때의 나워지는 수
				if (R <= C)	// R이 C 이하이면
				break;	// R값이 최대인 R, C를 찾았으므로 break
			}
		}

		char[][] arr = new char[R][C];
		
		int cnt = 0; //

//		st= new StringTokenizer(letter);
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
				arr[j][i] = letter.charAt(cnt++);
			}
		} // 만들어 놓은 매열에 letter를 charAt(cnt++)해주며 배열에 저장

		// 읽는순서로 출력
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
		sc.close();
	}
}