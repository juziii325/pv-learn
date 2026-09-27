package JavaBasics.D18String;

public class StringDemo {
    public static void main(String[] args) {

        String code = "G1-02";
        System.out.println("长度：" + code.length());

        String a = "热斑";
        String b = "热斑";//"双引号直接写死"的文字共用同一份
        String c = new String("热斑");//强制另外造一份新的。内容一样，但是两个不同的东西
        System.out.println("a == b：" + (a == b));
        System.out.println("a == c：" + (a == c));
        System.out.println("a.equals(c)：" + a.equals(c));//a.equals(c) 出 true —— 它只比内容，不比"是不是同一个东西"。

        String type = "组串电流异常-热斑疑似";
        System.out.println("含热斑吗：" + type.contains("热斑"));
        System.out.println("以组串开头吗：" + type.startsWith("组串"));

        String id = "INV-01-MPPT-3";
        System.out.println("前 6 个字符：" + id.substring(0, 6));//0-5
        System.out.println("从第 7 个字符开始：" + id.substring(7));

        String line = "G1-01,9.5,正常";
        String[] parts = line.split(",");
        System.out.println("切成了 " + parts.length + " 段");//字符串 length() 带括号，数组 length 不带。
        System.out.println("第 1 段：" + parts[0]);
        System.out.println("第 2 段：" + parts[1]);
        System.out.println("第 3 段：" + parts[2]);

        String dirty = "   G1-03   ";
        System.out.println("原长度：" + dirty.length());
        System.out.println("trim 后长度：" + dirty.trim().length());//trim() 去掉两头的空格

        String text = "热斑 严重 热斑";
        System.out.println("替换后：" + text.replace("热斑", "遮挡"));
        System.out.println("原来那个变了吗：" + text);

        StringBuilder sb = new StringBuilder();
        sb.append("组串 ");
        sb.append("G1-01");
        sb.append(" 电流 ");
        sb.append(9.5);
        sb.append(" A");
        System.out.println(sb.toString());
    }
}