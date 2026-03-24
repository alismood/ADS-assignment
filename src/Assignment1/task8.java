package Assignment1;

import java.util.Scanner;
import java.util.SimpleTimeZone;
public class task8 {
    public static boolean isDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }
        char c = s.charAt(index);
        if (c < '0' || c > '9') {
            return false;
        }
        return isDigits(s, index + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isDigits(s, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
