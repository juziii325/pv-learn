package JavaBasics.D9Method;

public class MethodDemo {
    public static void main(String[] args) {
        printTitle();

        int total = add(3, 5);
        System.out.println(total);

        double avg = average(10, 20, 30);
        System.out.println(avg);

        System.out.println(isOverLimit(82));

        printTitle();
    }

    static void printTitle() {
        System.out.println("=== 光伏诊断 ===");
    }

    static int add(int a,int b){
        return a+b;
    }
    static double average(int a,int b,int c){
        return (a+b+c)/3.0;
    }
    static boolean isOverLimit(double value){
        return value>80;
    }
}