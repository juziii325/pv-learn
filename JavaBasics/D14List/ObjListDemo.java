package JavaBasics.D14List;

import java.util.ArrayList;

public class ObjListDemo {
    public static void main(String[] args) {
        ArrayList<Result> results = new ArrayList<>();
        results.add(new Result("G1-01", 9.5, false));
        results.add(new Result("G1-02", 0.4, true));
        results.add(new Result("G1-03", 8.1, false));

        System.out.println("诊断结果共 " + results.size() + " 条");

        int badCount = 0;
        for (Result r : results) {
            System.out.println(r.getCode() + " 电流 " + r.getCurrent() + " 异常 " + r.isAbnormal());
            if (r.isAbnormal()) {
                badCount++;
            }
        }
        System.out.println("异常条数 " + badCount);

        // 按编号找一条
        Result found = null;
        for (Result r : results) {
            if (r.getCode().equals("G1-02")) {//字符串比较用 .equals()，永远不要用 ==
                found = r;
            }
        }
        if (found != null) {
            System.out.println("找到了：" + found.getCode() + " 电流 " + found.getCurrent());
        }
    }
}

class Result {
    private String code;
    private double current;
    private boolean abnormal;

    public Result(String code, double current, boolean abnormal) {
        this.code = code;
        setCurrent(current);
        this.abnormal = abnormal;
    }

    public String getCode() { return code; }
    public double getCurrent() { return current; }
    public boolean isAbnormal() { return abnormal; }

    public void setCurrent(double current) {
        if (current < 0) {
            this.current = 0;
        } else {
            this.current = current;
        }
    }
}
//static 只能用在"类的东西"上