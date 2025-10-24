import java.io.*;
import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        
        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt(); // N명의 사람
        int k = sc.nextInt(); // 순서대로 제거할 K번째 번호

        for(int i=1; i<=n; i++) {
            q.offer(i); // 1 ~ n 큐에 삽입
        }

        sb.append("<");
        while(!q.isEmpty()) { // 큐가 비어있지 않으면 계속 실행
            
            // 1 ~ K-1번째 사람들은 뽑고 뒤로 다시 보냄
            for(int i=0; i<k-1; i++) {
                q.offer(q.poll());
            }

            // K번째 사람 제거
            sb.append(q.poll());

            // 큐가 비어있을시 출력 마무리
            sb.append(q.size() == 0 ? ">" : ", ");
        }
        System.out.println(sb);
    }
}
