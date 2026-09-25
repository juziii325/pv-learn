package JavaBasics.D7Loop;

public class LoopDemo {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            System.out.println("第 " + i + " 次");
        }
        int sum=0;
        for(int i=1;i<=100;i++){
            sum+=i;
        }
        System.out.println("1加到100="+sum);
        int count = 3;
        while (count > 0) {
            System.out.println("倒计时 " + count);
            count--;}
        System.out.println("发射");
    }
}
