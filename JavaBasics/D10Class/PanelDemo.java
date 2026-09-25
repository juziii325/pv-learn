package JavaBasics.D10Class;

public class PanelDemo {
    public static void main(String[] args) {//一个 .java 文件里最多只能有一个 public 类，而且必须跟文件名同名
        Panel p1 = new Panel("A1-01", 540);
        Panel p2 = new Panel("A1-02", 320);

        p1.show();
        p2.show();

        System.out.println(p1.isAbnormal());
        System.out.println(p2.isAbnormal());
        System.out.println("一共创建了 " + Panel.count + " 块组件");
    }//没有 static → 属于"每一个对象"，所以必须用 对象.名字 访问。
}    //有 static → 属于"这个类本身"，所以用 类名.名字 访问。
class Panel {
    String name;
    int power;
    static int count = 0;

    Panel(String n, int p) {//构造方法：名字必须跟类名一样，而且没有返回类型；造对象时自动跑一遍，用来"初始化
        name = n;
        power = p;
        count++;
    }

    void show() {
        System.out.println("组件 " + name + "，功率 " + power);
    }

    boolean isAbnormal() {
        return power < 400;//有返回值的方法，你得对它交出来的东西做点什么；不然白算。
    }
}