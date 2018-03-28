package Lesson2;

public class Vector {
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void lenghtVector(){
        double a = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        System.out.println("a = " + a);
    }

    public static void scalarVector(Vector a, Vector b){
        double ab = a.x * b.x + a.y * b.y + a.z * b.z;
        System.out.println("ab = " + ab);
    }

    public static void proizvedVector(Vector a, Vector b){
        double x = a.y * b.z - a.z * b.y;
        double y = a.z * b.x - a.x * b.z;
        double z = a.x * b.y - a.y * b.x;
        System.out.println("[a,b] = (" + x + ", " + y + ", " + z + ")");
    }

    public cosVector(Vector a, Vector b) {
        return proizvedVector(Vector a, Vector b)/(lenghtVector(Vector a)* lenghtVector(Vector a));
    }

    public static void plusMinusVector(Vector a, Vector b){
        double x = a.x + b.x;
        double y = a.y + b.y;
        double z = a.z + b.z;
        System.out.println("[a + b] = (" + x + ", " + y + ", " + z + ")");

        double x1 = a.x - b.x;
        double y1 = a.y - b.y;
        double z1 = a.z - b.z;
        System.out.println("[a - b] = (" + x + ", " + y + ", " + z + ")");
    }

    public static Vector generateVector(int n){
        Vector[] v = new Vector[n];
        for (int i = 0; i < n; i++) {
            v[i] =
        }
    }

    public static void main(String[] args) {
        Vector vectorA = new Vector(5,6,1);
        Vector vectorB = new Vector(2,2,2);
        vectorA.lenghtVector();

        scalarVector(vectorA, vectorB);
        proizvedVector(vectorA, vectorB);
        plusMinusVector(vectorA, vectorB);

    }

}
}
