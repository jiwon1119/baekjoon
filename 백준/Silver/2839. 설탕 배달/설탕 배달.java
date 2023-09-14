import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;	//설탕 포대 개수 셀 cnt
		int tmp = n;	//나머지 값 담을 tmp

		while (true) {
			if ((tmp % 5) != 0) {
				tmp = tmp - 3;
				cnt++;
			} else if ((tmp % 5) == 0 ) {
				cnt += (tmp / 5);
				break;
			}
            
			if(tmp<0) {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
}
