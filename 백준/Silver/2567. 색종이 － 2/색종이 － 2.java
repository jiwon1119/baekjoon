import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();    //색종이의 개수
        int[][] arr= new int[102][102];	//색종이가 가장자리에 위치할 경우를 대비하여 2칸씩 크게 
        
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();        
            
            for (int j = y; j < y+10; j++) {
                for (int k = x;  k< x+10; k++) {
                    arr[j][k]=1;
                }
            }
        }//입력 끝

        int cnt=0;
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                if (arr[i][j] == 1) {
                    if (arr[i - 1][j] == 0)
                        cnt++;
                    if (arr[i + 1][j] == 0)
                        cnt++;
                    if (arr[i][j - 1] == 0)
                        cnt++;
                    if (arr[i][j + 1] == 0)
                        cnt++;
                }
            }
        
		}
        System.out.println(cnt);
    }
}