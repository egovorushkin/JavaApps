package Lesson1;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Please give me number: ");
        int num = scanner.nextInt();

        System.out.print("Please give me pow: ");
        int pow = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <num ; i++) {
            sum += Math.pow(i,pow);
        }

        System.out.println("Answer: " + sum);
    }
}
