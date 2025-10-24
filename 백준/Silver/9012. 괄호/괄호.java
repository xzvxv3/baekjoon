import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            String str = br.readLine(); // 검사할 괄호 문자열
            check(str); // VPS인지 판단
        }
        System.out.println(sb);
    }

    private static void check(String str) {
        // 괄호 다룰 스택 생성
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == '(') stack.push(x); // '('라면, 삽입
            else { // ')' 일 경우
                if(stack.size() == 0) { // 스택이 비어있다면, VPS 아님
                    sb.append("NO\n");
                    return; // 종료
                }
                else stack.pop(); // '('을 만났다면, '(' 제거
            }
        }

        // 괄호 체크 끝난 후, 스택이 비어있다면 VPS
        sb.append(stack.size() == 0 ? "YES\n" : "NO\n");
    }
}
