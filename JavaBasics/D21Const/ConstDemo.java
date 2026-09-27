package JavaBasics.D21Const;

public class ConstDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. 常量直接用 ===");
        System.out.println("软件版本：" + AppConfig.VERSION);
        System.out.println("电流阈值：" + AppConfig.CURRENT_THRESHOLD);
        System.out.println("最大重试次数：" + AppConfig.MAX_RETRY);

        System.out.println();
        System.out.println("=== 2. 常量拿来算 ===");
        double current = 12.6;
        if (current > AppConfig.CURRENT_THRESHOLD) {
            System.out.println("组串电流 " + current + " 超过阈值 " + AppConfig.CURRENT_THRESHOLD);
        } else {
            System.out.println("正常");
        }

        System.out.println();
        System.out.println("=== 3. 常量属于类，不属于对象 ===");
        StringGroup g1 = new StringGroup("G1-01", 9.5);
        StringGroup g2 = new StringGroup("G1-02", 12.6);
        System.out.println("g1 看到的阈值：" + StringGroup.LIMIT);//StringGroup.LIMIT，不是 g1.LIMIT
        System.out.println("g2 看到的阈值：" + StringGroup.LIMIT);
        g1.check();
        g2.check();

        System.out.println();
        System.out.println("=== 4. 对象计数器也常用常量思路 ===");
        g1.showCount();
        g2.showCount();

        System.out.println();
        System.out.println("=== 5. 常量还能是别的类型 ===");
        System.out.println("开关：" + AppConfig.REVIEW_REQUIRED);
        System.out.println("名称：" + AppConfig.APP_NAME);
    }
}

class AppConfig {
    public static final String APP_NAME = "光伏老化诊断系统";
    public static final String VERSION = "1.0.0";
    public static final double CURRENT_THRESHOLD = 12.0;
    public static final int MAX_RETRY = 3;
    public static final boolean REVIEW_REQUIRED = true;

    private AppConfig() {//构造方法写成 private——构造方法一旦私有，外面谁写 new AppConfig() 都编不过，是"工具类 / 常量类"的标准做法。
    }
}

class StringGroup {
    public static final double LIMIT = 12.0;
    private static int count = 0;

    private String code;
    private double current;

    public StringGroup(String code, double current) {
        this.code = code;
        this.current = current;
        count++;
    }

    public void check() {
        if (current > LIMIT) {//直接用 LIMIT 不带类名，因为是在 StringGroup 里用，省掉前缀。（跨类用就必须写 类名.常量名。）
            System.out.println(code + " 超限，需要复核");
        } else {
            System.out.println(code + " 正常");
        }
    }

    public void showCount() {
        System.out.println("目前一共造了 " + count + " 个组串对象");
    }
}
//final 数组的内容能被改，final 锁的是"变量指向哪个对象，数组名指向一块内存，它不锁对象里面的内容