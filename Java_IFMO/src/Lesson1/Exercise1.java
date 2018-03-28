package Lesson1;

public class Exercise1 {

    public static void main(String[] args) {
        double array1[] = new double[10];
        for(int i = 0; i < array1.length; i++){
            array1[i] = (double) Math.random()*1;
            System.out.println(array1[i]);
        }
        System.out.println("-----------------------------------");

        double min = array1[array1.length-1];
        for (double i: array1){
            if (min > i) {
                min = i;
            }
        }
        System.out.println("Min: " + min);

        double max = array1[0];
        for (double i: array1){
            if (max < i) {
                max = i;
            }
        }
        System.out.println("Max: " + max);

        double avg = 0;
        double sum = 0;
        for (int i = 0; i < array1.length ; i++) {
            sum = sum + array1[i];
        }

        avg = sum / array1.length;
        System.out.println("Avg: " + avg);
    }
}