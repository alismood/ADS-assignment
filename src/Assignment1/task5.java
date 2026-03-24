package Assignment1;

import java.util.Scanner;

public class task5 {
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        return factorial(n-1) + factorial(n-2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
