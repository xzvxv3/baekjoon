import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y, dis;

        Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private int n, m; // 미로의 행, 열
    private int[][] map; // 미로 맵
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        new Main().run();        
    }

    public void run() throws IOException {
        init();
        bfs();

        // 시작 (0, 0) -> 도착 (n-1, m-1)
        System.out.println(map[n-1][m-1]); // 도착 지점
    }

    private void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        // visited 배열은 생성하지 않음.
        // 1로 된 곳만 지나가게 하면 되기 때문

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }

    private void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1)); // 초기 시작점 (0, 0)

        while(!q.isEmpty()) {
            Point cur = q.poll(); // 현재 위치

            for(int d=0; d<4; d++) { // 사방면 탐색
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // 배열 범위 벗어나거나, 1로 된 곳이 아니면 PASS
                if(!rangeCheck(nx, ny) || map[nx][ny] != 1) continue;

                // 이동거리 + 1
                map[nx][ny] = cur.dis + 1;
                q.offer(new Point(nx, ny, map[nx][ny]));
            }
        }
    }

    private boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}

/* 풀이2: 큐의 요소를 배열로
private void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {0, 0});

    while(!q.isEmpty()) {
        int[] cur = q.poll();

        for(int d=0; d<4; d++) {
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];

            if(!rangeCheck(nx, ny)) continue;
            if(map[nx][ny] != 1) continue;
            
            map[nx][ny] = map[cur[0]][cur[1]] + 1;
            q.offer(new int[] {nx, ny}); 
        }
    }
}
*/