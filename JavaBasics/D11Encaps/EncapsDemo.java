package JavaBasics.D11Encaps;

public class EncapsDemo {
     public static void main(String[] args) {
        Panel p = new Panel("A1-01", 540);
        System.out.println(p.getName() + " 功率 " + p.getPower());

        p.setPower(-999);
        System.out.println("改成负数后：" + p.getPower());

        p.setPower(320);
        System.out.println("改成 320 后：" + p.getPower());
    }
}

class Panel {
    private String name;
    private int power;

    public Panel(String name, int power) {
        this.name = name;
        setPower(power);
    }

    public String getName() { return name; }
    public int getPower() { return power; }

    public void setPower(int power) {
        if (power < 0) {
            System.out.println("功率不能为负数，已按 0 处理");
            this.power = 0;
        } else {
            this.power = power;
        }
    }
}
