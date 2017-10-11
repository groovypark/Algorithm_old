package BOJ7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //가로
        int n = sc.nextInt(); //세로
        int visited[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }
        int map[][] = new int[n][m];
        int days = 0;
        int emptySize = 0;
        Queue<Point> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1){
                    q.add(new Point(i,j));
                }
                if (map[i][j] == -1){
                    emptySize++;
                }
            }
        }
        if (q.size() == m * n - emptySize){
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                if (cur.y<0 || cur.x<0 || cur.y>=n || cur.x>=m){
                    continue;
                }
                if (visited[cur.y][cur.x] != -1 || map[cur.y][cur.x] == -1) {
                    continue;
                }
                visited[cur.y][cur.x] = days;
                q.add(new Point(cur.y+1, cur.x));
                q.add(new Point(cur.y, cur.x+1));
                q.add(new Point(cur.y-1, cur.x));
                q.add(new Point(cur.y, cur.x-1));
            }
            days++;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] > ans) {
                    ans = visited[i][j];
                }
                if (visited[i][j] == -1 && map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);

    }
    static class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
