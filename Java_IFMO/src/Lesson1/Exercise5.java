package Lesson1;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число:  ");
        int num = scanner.nextInt();
        int x = 1;
        int y = 1;

        for (int i = 2; i < num; i++) {
            y = x + y;
            x = y - x;
        }

        System.out.println("Число Фибоначчи: " + y);
    }
}
