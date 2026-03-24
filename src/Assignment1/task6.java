package Assignment1;

import java.util.Scanner;

public class task6 {
    public static int power1(int n, int p){
        if (p == 0){
            return 1;
        }
        return n * power1(n, p -1 );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(power1(n, p));
    }
}
