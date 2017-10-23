import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main_C {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "C-large.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];
            for (int j = 0; j < N; j++) {
                map[j] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int ans = solve(map);
            bw.write("Case #" + (i+1) + ": " + ans + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static int solve(int[][] map) {
        if (map.length == 1 && map[0].length == 1) {
            return 0;
        }
        int minOfMap = INF;
        Point pointOfMin = new Point(-1, -1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (minOfMap > map[i][j]) {
                    pointOfMin = new Point(i, j);
                    minOfMap = map[i][j];
                }
            }
        }
        int ret = minOfMap;
        if (map.length > 1 && pointOfMin.y > 0) {
            int[][] splicedMatrix1 = Arrays.copyOfRange(map, 0, pointOfMin.y);
            int[][] splicedMatrix2 = Arrays.copyOfRange(map, pointOfMin.y, map.length);
            ret = Math.max(ret, minOfMap + solve(splicedMatrix1) + solve(splicedMatrix2));
        }
        if (map.length > 1 && pointOfMin.y < map.length-1) {
            int[][] splicedMatrix1 = Arrays.copyOfRange(map, 0, pointOfMin.y+1);
            int[][] splicedMatrix2 = Arrays.copyOfRange(map, pointOfMin.y+1, map.length);
            ret = Math.max(ret, minOfMap + solve(splicedMatrix1) + solve(splicedMatrix2));
        }
        if (map[0].length > 1 && pointOfMin.x > 0) {
            int[][] splicedMatrix1 = new int[map.length][pointOfMin.x];
            int[][] splicedMatrix2 = new int[map.length][map[0].length - pointOfMin.x];
            for (int i = 0; i < map.length; i++) {
                splicedMatrix1[i] = Arrays.copyOfRange(map[i], 0, pointOfMin.x);
                splicedMatrix2[i] = Arrays.copyOfRange(map[i], pointOfMin.x, map[0].length);
            }
            ret = Math.max(ret, minOfMap + solve(splicedMatrix1) + solve(splicedMatrix2));
        }
        if (map[0].length > 1 && pointOfMin.x < map[0].length-1) {
            int[][] splicedMatrix1 = new int[map.length][pointOfMin.x+1];
            int[][] splicedMatrix2 = new int[map.length][map[0].length - pointOfMin.x -1];
            for (int i = 0; i < map.length; i++) {
                splicedMatrix1[i] = Arrays.copyOfRange(map[i], 0, pointOfMin.x+1);
                splicedMatrix2[i] = Arrays.copyOfRange(map[i], pointOfMin.x+1, map[0].length);
            }
            ret = Math.max(ret, minOfMap + solve(splicedMatrix1) + solve(splicedMatrix2));
        }

        return ret;
    }
    static class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}