package Lesson1;

public class Exercise4 {

    public static void main(String[] args) {
        for (int i = 2; i < 100 ; i++) {
            int j;
            for(j = 2; (i % j) > 0; j++) {
            }
            if(j == i) System.out.print(i + "\t");
        }
    }
}
