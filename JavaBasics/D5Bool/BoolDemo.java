package JavaBasics.D5Bool;

public class BoolDemo {
    public static void main(String[] args){
        int a=7;
        int b=2;
        System.out.println("a>b:"+(a>b));
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
         
        boolean sunny=true;
        boolean windy=false;
        System.out.println(sunny&&windy);
        System.out.println(sunny||windy);
        System.out.println(!sunny);
        System.out.println(!windy);
    }
}
