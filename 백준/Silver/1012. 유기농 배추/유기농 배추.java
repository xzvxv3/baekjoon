import java.io.*;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int[][] map;
    private boolean[][] visited;
    private int T, n, m, k;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException  {
        T = Integer.parseInt(br.readLine()); // Test Case

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m]; // 배추 맵
            visited = new boolean[n][m]; // 방문 여부
            
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1; // 배추 설정
            }

            int ans = find(); // 배추흰지렁이 몇마리 필요한지 찾기

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

    private int find() {
        int cnt = 0; // 배추흰지렁이 수 

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) { // 배추가 있고, 방문하지 않은곳이라면
                    dfs(i, j); // 탐색 시작 
                    cnt++; // 배추흰지렁이 + 1
                }
            }
        }
        return cnt; // 배추흰지렁이 반환
    }

    private void dfs(int x, int y) {

        visited[x][y] = true; // 배추 방문

        for(int d=0; d<4; d++) { // 사방면 탐색
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 벗어나거나, 방문했거나, 배추가 아니라면 PASS
            if(!rangeCheck(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

            // 다음 탐색
            dfs(nx, ny);
        }
    }

    private boolean rangeCheck(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
    
}
