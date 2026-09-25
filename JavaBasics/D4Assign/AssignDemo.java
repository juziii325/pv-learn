package JavaBasics.D4Assign;

public class AssignDemo {
    public static void main(String[] args){
         int a = 10;
        System.out.println(a);

        a += 5;
        System.out.println(a);

        a -= 3;
        System.out.println(a);

        a *= 2;
        System.out.println(a);

        a /= 4;
        System.out.println(a);

        a %= 3;
        System.out.println(a);

        int b = 1;
        System.out.println("b++:"+b++);
        System.out.println(b);
        System.out.println("++b:"+(++b));
        System.out.println(b);

        int c = 1;
        System.out.println("c--:"+c--);
        System.out.println(c);
        System.out.println("--c:"+--c);
        System.out.println(c);
    }
}
