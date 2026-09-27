package JavaBasics.D13Extends;

public class ExtendsDemo {
    public static void main(String[] args) {
        Inverter inv = new Inverter("INV-01", 100.0, 6);
        StringGroup sg = new StringGroup("G1-01", 9.5, 20);
        inv.show();
        sg.show();
        System.out.println("设备总数：" + Device.getCount());
        System.out.println("逆变器算不算设备？" + (inv instanceof Device));
        //判断"这个对象是不是 Device 类型"
    }
}

class Device {
    private String code;
    private double power;
    private static int count = 0;

    public Device(String code, double power) {
        this.code = code;
        setPower(power);
        count++;
    }

    public String getCode() { return code; }
    public double getPower() { return power; }
    public static int getCount() { return count; }

    public void setPower(double power) {
        if (power < 0) {
            System.out.println("功率不能为负，已按 0 处理");
            this.power = 0;
        } else {
            this.power = power;
        }
    }

    public void show() {
        System.out.println("设备 " + code + "，功率 " + power + " kW");
    }
}

class Inverter extends Device {
    private int mpptCount;

    public Inverter(String code, double power, int mpptCount) {
        super(code, power);//调父类的构造方法，并且放在第一行
        this.mpptCount = mpptCount;
    }

    public int getMpptCount() { return mpptCount; }

    @Override//方法重写
    public void show() {
        System.out.println("逆变器 " + getCode() + "，功率 " + getPower() + " kW，MPPT 路数 " + mpptCount);
    }
}

class StringGroup extends Device {
    private int moduleCount;

    public StringGroup(String code, double power, int moduleCount) {
        super(code, power);
        this.moduleCount = moduleCount;
    }

    public int getModuleCount() { return moduleCount; }
}
//1. class 子类 extends 父类，父类放共同点，子类放独有点。Java 只能有一个父类。
//2. 子类构造方法第一行必须 super(...)，把参数交给父类构造方法；不写默认 super()，父类没无参构造就报错。
//3. 父类的 private 字段子类也读不到，走 getter（正式项目不用 protected）。
//4. 重写就写 @Override，不然方法名拼错了你永远发现不了。
//5. 子类对象"也是一种父类" → instanceof 为 true，可以赋给父类变量。