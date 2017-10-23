import java.util.*;
import java.io.*;

public class Main_A {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "A-large.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int cases = in.nextInt();
        int result = 0;
        for (int z = 1; z <= cases; z++) {
            int a = in.nextInt();
            int n = in.nextInt();
            int p = in.nextInt();
            result = 1;
            int i=0;
            while (i < n) {
                for (int j = 0; j < n; j++) {
                    result = result * a % p;
                    if (result==0){
                        break;
                    }
                    if (result==0){
                        break;
                    }
                }
                i++;
            }
            bw.write("Case #" + z + ": " + result + "\n");
        }
        in.close();
        bw.close();
    }
}