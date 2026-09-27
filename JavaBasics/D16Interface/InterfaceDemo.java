package JavaBasics.D16Interface;

import java.util.ArrayList;

public class InterfaceDemo {
    public static void main(String[] args) {
        ArrayList<Diagnosable> devices = new ArrayList<>();
        devices.add(new StringGroup("G1-01", 9.5));
        devices.add(new StringGroup("G1-02", 0.4));
        devices.add(new Inverter("INV-01", 100.0, 6));
        devices.add(new CombinerBox("BX-01", 8));
//都写 implements Diagnosable，所以都能装进 <Diagnosable> 这个列表。
        for (Diagnosable d : devices) {
            System.out.println(d.diagnose());
        }
    }
}

interface Diagnosable {//接口，能力清单：只规定"必须会做什么"，不管"怎么做的"。
    String diagnose();//抽象方法，只有"名字+参数+返回类型"

    default String level() {//默认做法
        return "普通";
    }
}

class StringGroup implements Diagnosable {//implements（实现）意思是「我来履行这份合同」：
    private String code;
    private double current;

    public StringGroup(String code, double current) {
        this.code = code;
        this.current = current;
    }

    public String getCode() { return code; }
    public double getCurrent() { return current; }

    @Override
    public String diagnose() {//默认public
        if (current < 1.0) {
            return "组串 " + code + "：电流偏低（" + current + "A），疑似遮挡或积灰，" + level();
        }
        return "组串 " + code + "：正常（" + current + "A），" + level();
    }
}

class Inverter implements Diagnosable {
    private String code;
    private double power;
    private int mpptCount;

    public Inverter(String code, double power, int mpptCount) {
        this.code = code;
        this.power = power;
        this.mpptCount = mpptCount;
    }

    @Override
    public String diagnose() {
        return "逆变器 " + code + "：功率 " + power + " kW，MPPT " + mpptCount + " 路，" + level();
    }

    @Override
    public String level() {
        return "重要";
    }
}

class CombinerBox implements Diagnosable {
    private String code;
    private int branchCount;

    public CombinerBox(String code, int branchCount) {
        this.code = code;
        this.branchCount = branchCount;
    }

    @Override
    public String diagnose() {
        return "汇流箱 " + code + "：支路 " + branchCount + " 路，" + level();
    }
}
//interface = 一份能力清单，只写"必须会什么"，不写"怎么做"。
//class X implements Y，接口里的方法必须全部实现，漏一个就编译不过（未覆盖…抽象方法）。
//接口不能 new；实现时方法必须写 public（接口里天生 public，权限不能变小）。
//一个类能 implements 多个接口，但只能 extends 一个类。
//default 方法有 { }，是"默认做法"，实现类可以不改写。
//多态 = 同一个调用、不同对象不同反应 —— 靠它才能写出 for (Diagnosable d : list) 这种不写 if-else 的代码。
//「是一种」用 extends，「会做某事」用 implements。