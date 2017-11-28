package codejam;

import java.util.*;
import java.io.*;

public class CodeJam {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int a = in.nextInt();
        int n = in.nextInt();
        int p = in.nextInt();
        int result = a%p;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > 0; j--) {
                result = result * result % p;
            }
        }
        for (int i = 1; i <= cases; ++i) {
            System.out.println("Case #" + i + ": " + result);
        }
    }
}