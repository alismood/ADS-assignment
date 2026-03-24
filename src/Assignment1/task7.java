package Assignment1;

import java.util.Scanner;

public class task7 {
    public static void reverse(Scanner sc, int n){
        if (n == 0){
            return;
        }
        int x = sc.nextInt();
        reverse(sc, n -1 );
        System.out.println(x);
        return;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        reverse(sc, n);
    }
}
