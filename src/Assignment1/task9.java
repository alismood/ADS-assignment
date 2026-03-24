package Assignment1;

import java.util.Scanner;

public class task9 {
    public static int countChars(String s) {
        if (s.equals("")) {
            return 0;
        }
        return 1 + countChars(s.substring(1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(countChars(s1));
    }
}
