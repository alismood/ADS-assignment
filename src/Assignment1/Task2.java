package Assignment1;

import java.util.Scanner;

public class Task2 {
        public static int sum(Scanner sc, int n) {
            if (n == 0) {
                return 0;
            }

            int x = sc.nextInt();
            return x + sum(sc, n - 1);
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt(); // количество элементов

            int total = sum(sc, n);
            double average = (double) total / n;
            System.out.println(average);
        }
    }