import java.io.*;
import java.util.*;

public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringBuilder sb = new StringBuilder();
    private StringTokenizer st;
    private int n, m;
    private HashMap<String, Integer> map1 = new HashMap<>(); // 이름 - 번호 도감
    private HashMap<Integer, String> map2 = new HashMap<>(); // 번호 - 이름 도감 
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            init(); 
            find();   
        } catch(IOException e) {
            return;    
        }

        System.out.println(sb);
    }

    private void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        m = Integer.parseInt(st.nextToken()); // 문제의 개수

        for(int i=1; i<=n; i++) {
            String name = br.readLine();
            map1.put(name, i); // 이름 - 번호
            map2.put(i, name); // 번호 - 이름
        }
    }

    private void find() throws IOException {
        for(int i=0; i<m; i++) {
            String tmp = br.readLine();

            // 이름이 입력됐다면, 번호를 출력
            // 번호가 입력됐다면, 이름을 출력
            if(Character.isDigit(tmp.charAt(0))) {
                sb.append(map2.get(Integer.parseInt(tmp)));
            }
            else {
                sb.append(map1.get(tmp));
            }
            sb.append("\n");
        }
    }
}