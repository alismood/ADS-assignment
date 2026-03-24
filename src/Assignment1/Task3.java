package Assignment1;

import java.util.Scanner;

public class Task3 {
    public static boolean prime(int n, int x){
        if (x == 1){
            return true;
        }
        if(n % x == 0 && x != n){
            return false;
        }
        else {
            return prime(n, x-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(prime(n,n));
        if(prime(n,n)){
            System.out.println("Prime");
        }
        else {
            System.out.println("Composite");
        }
    }
}
