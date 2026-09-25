package JavaBasics.D6If;

public class IfDemo {
    public static void main(String[] args) {
        int voltage = 620;

        if(voltage > 700) {
            System.out.println("电压偏高");}
        else if(voltage > 600) {
            System.out.println("电压正常");}
        else{
            System.out.println("电压偏低");}

        int temp = 45;
        if (temp >= 60 && voltage > 600) {
            System.out.println("高温且电压正常");}
        else {
            System.out.println("条件不满足"); }
    }
}
