package Lesson1;

public class Exercise3 {
    public static void main(String[] args) {
        double array1[] = new double[10];
        System.out.println("Before sort");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (double) Math.random() * 1;
            System.out.println(array1[i]);
        }
        System.out.println("-------------------");
        System.out.println("After sort");
        for (int i = array1.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array1[j] > array1[j + 1]) {
                    double tmp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = tmp;
                }
            }
            System.out.println(array1[i]);
        }
    }
}
