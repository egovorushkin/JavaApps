package Lesson3;

class A{
    protected void finalize(){
        System.out.println("finalize()");
    }
}

public class ExampleFinalize {
    public static void main(String[] args) {
        A [] a = new A[1000000];
        for (int i = 0; i < a.length ; i++) {
            a[i] = new A();
        }
    }
}

