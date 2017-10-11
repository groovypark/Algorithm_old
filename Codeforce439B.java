import java.util.Scanner;

public class Codeforce439B  {
    public static void main(String[] args) {

        long a;
        long b;
        long result = 1;
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        long count = b-a;

        if (a == 0) {
            a = 1;
        }

        for (int i=0; i<count; i++){
            if (result == 0) {
                break;
            }
            result *= (b%10);
            result %= 10;
            b--;
        }


        System.out.println(result%10);

        sc.close();
    }
}
