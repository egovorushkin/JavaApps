package Lesson1;

public class Exercise6 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,6,8,7,6,5,4,5};
        int nElems = 0;
        int j;
        int num;
        nElems = 15;

        // вывод элементов
        for (j = 0; j < nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println("");

        num = 6;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == num)
                break;
        }
        for (int k = j; k < nElems - 1; k++)
            arr[k] = arr[k + 1];
        nElems--;

        for (j = 0; j < nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println("");

    }
}