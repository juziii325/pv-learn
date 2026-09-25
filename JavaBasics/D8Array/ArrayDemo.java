package JavaBasics.D8Array;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] powers={10,20,30,40,50};

        System.out.println(powers.length);
        System.out.println(powers[0]);
        System.out.println(powers[4]);
        System.out.println(powers[powers.length - 1]);
        //Python 那种"负数从后面数"的用法，Java 里不存在。想取最后一个，得写 powers[powers.length - 1]


        for (int i = 0; i < powers.length; i++) {
            System.out.println("第 " + i + " 个：" + powers[i]);
        }

        int sum = 0;
        for (int i = 0; i < powers.length; i++) {
            sum += powers[i];
        }
        System.out.println("总和 = " + sum);

        String[] names = {"组件", "组串", "逆变器"};
        for(String n:names){
            System.out.println(n);
            //把 names 里的每个元素，依次取出来叫 n，执行一遍"。比普通的 for 短，但拿不到下标 i。要下标就用普通 for。
        }
    }
}
