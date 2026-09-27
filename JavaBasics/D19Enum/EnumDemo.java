package JavaBasics.D19Enum;

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. 枚举怎么用 ===");
        FaultType t = FaultType.HOT_SPOT;//枚举不能new
        System.out.println("我选中的是：" + t);
        System.out.println("它等于热斑吗：" + (t == FaultType.HOT_SPOT));
        System.out.println("它等于积灰吗：" + (t == FaultType.DUST));

        System.out.println();
        System.out.println("=== 2. 遍历全部 ===");
        for (FaultType ft : FaultType.values()) {//values返回一个数组
            System.out.println(ft + " 排在第 " + ft.ordinal() + " 位");//ft.ordinal() 是排在第几位，从 0 开始数
        }

        System.out.println();
        System.out.println("=== 3. 带属性的枚举 ===");
        System.out.println("热斑 中文名：" + FaultType.HOT_SPOT.getLabel());
        System.out.println("热斑 风险等级：" + FaultType.HOT_SPOT.getLevel());
        System.out.println("积灰 中文名：" + FaultType.DUST.getLabel());
        System.out.println("积灰 风险等级：" + FaultType.DUST.getLevel());

        System.out.println();
        System.out.println("=== 4. 用枚举做判断 ===");
        for (FaultType ft : FaultType.values()) {
            System.out.println(ft.getLabel() + " -> " + reviewAdvice(ft));
        }

        System.out.println();
        System.out.println("=== 5. 文字转枚举 ===");
        FaultType fromText = FaultType.valueOf("HOT_SPOT");//把选项名字符串换成对应的枚举值。
        System.out.println("HOT_SPOT 转回来：" + fromText.getLabel());
    }//前端传过来的是文字 "DUST"，后端要转成枚举才能做判断

    static String reviewAdvice(FaultType ft) {
        switch (ft) {//如果等于 A 就干这个，等于 B 就干那个"
            case HOT_SPOT://case 写全名 —— 编译不过
                return "必须人工复核（A 类）";
            case DUST:
                return "自动派单（B 类）";
            case PID:
                return "必须人工复核（A 类）";
            case AGING:
                return "自动派单（B 类）";
            default:
                return "未分类，交人工判断";//最后 default: 兜底（都不匹配时走它）
        }
    }
}

enum FaultType {//选项名不能有空格和横杠，分号只在最后一个选项后面写，前面三个是逗号。
    HOT_SPOT("热斑", "高"),
    DUST("积灰", "低"),
    PID("PID 衰减", "中"),
    AGING("组件老化", "中");

    private final String label;//final 是新的关键字：：一旦赋值就不能再改
    private final String level;

    FaultType(String label, String level) {//构造方法不用写 public，必须是 private 或默认，因为外面不许 new 它。
        this.label = label;
        this.level = level;
    }

    public String getLabel() {
        return label;
    }

    public String getLevel() {
        return level;
    }
}