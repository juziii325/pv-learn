package JavaBasics.D14List;

import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        // 1. 建一个"能装组串编号"的列表
        ArrayList<String> codes = new ArrayList<>();//尖括号叫泛型，意思是「这个列表只准装这种货」。
        codes.add("G1-01");                      //里面放包装版包装类型，Integer/Double/Boolean/Character
        codes.add("G1-02");
        codes.add("G1-03");

        System.out.println("一共 " + codes.size() + " 个组串");
        System.out.println("第 1 个：" + codes.get(0));
        System.out.println("最后 1 个：" + codes.get(codes.size() - 1));
        System.out.println("整个列表：" + codes);

        // 2. 电流单独存一份，和上面的编号一一对应
        ArrayList<Double> currents = new ArrayList<>();
        currents.add(9.5);
        currents.add(0.4);
        currents.add(8.1);

        // 3. 求总和、平均
        double sum = 0;
        for (double c : currents) {
            sum = sum + c;
        }
        System.out.println("电流总和 " + sum);
        System.out.println("平均电流 " + (sum / currents.size()));

        // 4. 挑出异常的（电流小于 1.0 算异常）
        ArrayList<String> badCodes = new ArrayList<>();
        for (int i = 0; i < currents.size(); i++) {
            if (currents.get(i) < 1.0) {
                badCodes.add(codes.get(i));
            }
        }
        System.out.println("异常组串：" + badCodes);
        System.out.println("异常数量 " + badCodes.size());

        // 5. 删除 + 修改
        codes.remove("G1-02");
        System.out.println("删掉 G1-02 后：" + codes);
        codes.set(0, "G1-09");
        System.out.println("把第 1 个改成 G1-09 后：" + codes);

        // 6. 逐个打印
        for (String s : codes) {
            System.out.println("组串 " + s);
        }
    }
}