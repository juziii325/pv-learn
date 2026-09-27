package JavaBasics.D22Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//Lambda 和 Stream
public class LambdaDemo {
    public static void main(String[] args) {
        List<StringGroup> groups = new ArrayList<>();
        groups.add(new StringGroup("G1-01", 9.5));
        groups.add(new StringGroup("G1-02", 13.2));
        groups.add(new StringGroup("G1-03", 0.4));
        groups.add(new StringGroup("G1-04", 12.6));
        groups.add(new StringGroup("G1-05", 8.8));

        System.out.println("=== 1. 老写法：手动 for 筛 ===");
        List<StringGroup> bad1 = new ArrayList<>();
        for (StringGroup g : groups) {
            if (g.getCurrent() < 5.0) {
                bad1.add(g);
            }
        }
        for (StringGroup g : bad1) {
            System.out.println("异常：" + g.getCode() + " 电流 " + g.getCurrent());
        }

        System.out.println();
        System.out.println("=== 2. Stream 写法：同一件事 ===");
        List<StringGroup> bad2 = groups.stream()//把 List 接上流水线
                .filter(g -> g.getCurrent() < 5.0)//只留符合条件的
                .collect(Collectors.toList());
        for (StringGroup g : bad2) {
            System.out.println("异常：" + g.getCode() + " 电流 " + g.getCurrent());
        }

        System.out.println();
        System.out.println("=== 3. 只要编号，不要对象 ===");
        List<String> codes = groups.stream()
                .map(g -> g.getCode())//把对象换成它的编号。：把每个元素换成另一个东西（这里是"对象 → 编号字符串"）。它是变身。
                .collect(Collectors.toList());
        System.out.println("全部编号：" + codes);

        System.out.println();
        System.out.println("=== 4. 先筛再取，串起来 ===");
        List<String> badCodes = groups.stream()
                .filter(g -> g.getCurrent() < 5.0)
                .map(g -> g.getCode())
                .collect(Collectors.toList());
        System.out.println("异常编号：" + badCodes);

        System.out.println();
        System.out.println("=== 5. 统计 ===");
        long n = groups.stream().filter(g -> g.getCurrent() < 5.0).count();
        System.out.println("异常个数：" + n);
        double max = groups.stream().mapToDouble(g -> g.getCurrent()).max().orElse(0);
        System.out.println("最大电流：" + max);
        double sum = groups.stream().mapToDouble(g -> g.getCurrent()).sum();
        System.out.println("电流合计：" + sum);
        double avg = groups.stream().mapToDouble(g -> g.getCurrent()).average().orElse(0);
        System.out.println("平均电流：" + avg);
//sum()/average()/max() 只能对"数字流水线"用。StringGroup 是对象，流水线上装不下"数字"这个身份，所以要先调 mapToDouble 把流水线改成装 double 的。
//.average()：平均。返回的不是 double，而是 OptionalDouble——一个"可能没结果的盒子"，因为空流水线求平均没有答案。所以你必须再点一个 .orElse(0)，意思是"有结果就用结果，没有就当我 0"。输出 平均电流：8.9。
        System.out.println();
        System.out.println("=== 6. 判断有没有 / 是不是全部都 ===");
        boolean any = groups.stream().anyMatch(g -> g.getCurrent() > 12.0);
        //.anyMatch(条件)：只要有一个满足就返回 true
        System.out.println("有没有超过 12 的：" + any);
        boolean all = groups.stream().allMatch(g -> g.getCurrent() > 5.0);
        //.allMatch(条件)：全部满足才 true
        System.out.println("是不是全部都大于 5：" + all);

        System.out.println();
        System.out.println("=== 7. 排序 ===");
        List<StringGroup> sorted = groups.stream()
                .sorted((x, y) -> Double.compare(x.getCurrent(), y.getCurrent()))//.sorted() 里要你给一条"谁在前谁在后"的规则。
                .collect(Collectors.toList());//升序
        for (StringGroup g : sorted) {
            System.out.println(g.getCode() + " -> " + g.getCurrent());
        }

        System.out.println();
        System.out.println("=== 8. 排序后只取前 2 个 ===");
        List<String> top2 = groups.stream()
                .sorted((x, y) -> Double.compare(y.getCurrent(), x.getCurrent()))
                .map(g -> g.getCode() + "(" + g.getCurrent() + ")")
                .limit(2)//.limit(2)：只保留流水线的前 2 个，
                .collect(Collectors.toList());
        System.out.println("电流最高的两个：" + top2);

        System.out.println();
        System.out.println("=== 9. 数组也能转 Stream ===");
        String[] lines = { "G1-01,9.5", "G1-02,13.2", "G1-03,0.4" };
        long cnt = Arrays.stream(lines)//List 用的是 .stream()，数组没有这个方法，要用工具类 Arrays 的 Arrays.stream(数组名)。别搞混。
                .map(s -> s.split(",")[1])//"G1-01,9.5".split(",") 切成 ["G1-01", "9.5"]，[1] 取第二个（下标从 0 数），得到 "9.5"。
                .mapToDouble(Double::parseDouble)//方法引用 + 变身连击。Double.parseDouble 是第 43 课后面提到过的"把字符串变成小数"的工具（把 "9.5" 变成 9.5）。因为这一句只干"参数直接传给这个方法"，所以能写成 Double::parseDouble，等价于 s -> Double.parseDouble(s)。
                .filter(v -> v < 5.0)
                .count();
        System.out.println("低电流的行数：" + cnt);

        System.out.println();
        System.out.println("=== 10. 不可改的列表 List.of ===");
        List<String> types = List.of("热斑", "积灰", "PID");
        System.out.println("固定列表：" + types);
        try {
            types.add("老化");
        } catch (Exception e) {
            System.out.println("想加东西失败了：" + e);
        }
    }
}

class StringGroup {
    private String code;
    private double current;

    public StringGroup(String code, double current) {
        this.code = code;
        this.current = current;
    }

    public String getCode() {
        return code;
    }

    public double getCurrent() {
        return current;
    }
}