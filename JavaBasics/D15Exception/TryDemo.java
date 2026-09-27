package JavaBasics.D15Exception;

public class TryDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. 除零 ===");
        try {
            int a = 10 / 0;
            System.out.println("这行不会执行 " + a);
        } catch (ArithmeticException e) {
            System.out.println("抓到异常：" + e.getMessage());//e.getMessage获取
        }
        System.out.println("程序继续往下走");

        System.out.println();
        System.out.println("=== 2. 数字转换失败 ===");
        String[] inputs = {"9.5", "8.1", "abc", "6.6"};
        for (String s : inputs) {
            try {
                double v = Double.parseDouble(s);//parseDouble 是把字符串变成小数的方法
                System.out.println(s + " -> 解析成功，值 " + v);
            } catch (NumberFormatException e) {
                System.out.println(s + " -> 不是合法数字，跳过");
            }
        }

        System.out.println();
        System.out.println("=== 3. finally 一定会执行 ===");
        System.out.println("结果 = " + divide(10, 2));
        System.out.println("结果 = " + divide(10, 0));

        System.out.println();
        System.out.println("=== 4. 多个 catch ===");
        Object[] things = {"G1-01", 42, null};//Object 什么都能装所以下面要声明
        for (Object o : things) {
            try {
                String s = (String) o;//(String)强制类型转换 —— 告诉 Java："把后面这个东西当成 String 来用"
                System.out.println("长度是 " + s.length());
            } catch (ClassCastException e) {
                System.out.println("类型不对，没法当字符串用");
            } catch (NullPointerException e) {
                System.out.println("这是个 null,什么都没有");//详细放前面
            }
        }
    }

    static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("除法出错，返回 -1");
            return -1;
        } finally {
            System.out.println("  [finally] divide(" + a + ", " + b + ") 收尾");
        }//不管 try 里成功还是出错，finally 里的代码都一定会执行，而且是在方法真正交还控制权之前执行。
    }
}
//"try {
//    Double.parseDouble("abc");
//} catch (Exception e) {
//    System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
//}e.getClass()拿到这个异常的"类型信息".getSimpleName() —— 取它的简单名（就是 NumberFormatException 这种，不带包名）e.getMessage() —— 具体说明
//输出NumberFormatException : For input string: "abc"
//不确定会抛什么的时候，先 catch (Exception e) 加打印，跑一次看清楚是什么，再回来改成精确的 catch。这也是排查线上问题的常用手段（写进日志里）。