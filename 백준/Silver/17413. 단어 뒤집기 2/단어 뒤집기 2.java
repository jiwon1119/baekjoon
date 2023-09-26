import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 문자열을 '<'와  ' '(공백)과 '>'를 구분자로 사용하여 토큰화합니다.
        // 단, '<'와 '>' 문자 자체는 토큰으로 유지됩니다.
        StringTokenizer st = new StringTokenizer(sc.nextLine(), "< >", true);
        
        // 단어와 꺽쇠 안의 문자를 저장할 StringBuilder
        StringBuilder pre = new StringBuilder();
        
        // 최종 결과물을 저장할 StringBuilder
        StringBuilder ans = new StringBuilder();
        
        // 토큰을 하나씩 처리합니다.
        while (st.hasMoreTokens()) {		//토큰이 있는동안(없을때까지)
            String tk = st.nextToken();
            
            // 꺽쇠가 아닌 경우, 단어를 뒤집고 결과물에 추가합니다.
            if (!tk.equals("<") && !tk.equals(">")) {
                pre.append(tk);         // 토큰을 단어_저장소에 추가
                pre.reverse();            // 토큰을 뒤집습니다.
                ans.append(pre);          // 뒤집힌 토큰을 결과물에 추가합니다.
                pre.setLength(0);        // 단어_저장소를 비워줍니다.
            } else {	//꺽쇠를 만나면
                ans.append(tk);         // 꺽쇠는 그대로 결과물에 추가합니다.
                while (st.hasMoreTokens()) {	//토큰이 있는 동안
                    String inner = st.nextToken();	// 다음조각 inner
                    if (!inner.equals(">")) {	//inner가 닫는 괄호가 아니면
                        ans.append(inner);	//append한다.
                    } else {			//닫는 괄호면
                        ans.append(inner);	//append하고 	
                        break;		//반복문 break
                        //꺽쇠 안의 내용을 처리한 후 루프를 종료하여 토큰 처리를 계속할 수 있도록 하는 역할
                    }
                }
            }
        }
        
        // 최종 결과물을 출력합니다.
        System.out.println(ans);
        
        // 스캐너를 닫습니다.
        sc.close();
    }
}
