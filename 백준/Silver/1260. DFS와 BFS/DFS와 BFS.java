import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Scanner sc = new Scanner(System.in);
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private int n, m, v; // 정점의 개수, 간선의 개수, 탐색을 시작할 정점 번호
    private ArrayList<Integer>[] graph; // 인접 리스트
    private boolean[] visited; // 방문 체크
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws IOException {
        init();
        dfs(v); // DFS 탐색
        bfs(v); // BFS 탐색
        System.out.println(sb); // 결과 출력
    }

    private void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호

        graph = new ArrayList[n+1]; // 인접리스트 초기회
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) { // 인접리스트 초기화
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작 정점
            int e = Integer.parseInt(st.nextToken()); // 도착 정점

            // 양방향 그래프
            graph[s].add(e);
            graph[e].add(s);
        }

        // 인접리스트들을 오름차순 정렬
        for(int i=1; i<=n; i++) {
            Collections.sort(graph[i]);
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for(int x : graph[v]) {
            if(!visited[x]) {
                dfs(x);
            }
        }
    }  

    private void bfs(int v) {
        sb.append("\n");
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur + " ");
            
            for(int x : graph[cur]) {
                if(!visited[x]) {
                    q.offer(x);
                    visited[x] = true;
                }
            }
        }
    }
}
