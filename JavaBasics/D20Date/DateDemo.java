package JavaBasics.D20Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. 今天 ===");
        LocalDate today = LocalDate.now();//静态方法
        System.out.println("今天：" + today);
        System.out.println("年：" + today.getYear());
        System.out.println("月：" + today.getMonthValue());//getMonth() 返回的是 SEPTEMBER（英文枚举），getMonthValue() 返回的是 9（数字）
        System.out.println("日：" + today.getDayOfMonth());
        System.out.println("星期几：" + today.getDayOfWeek());

        System.out.println();
        System.out.println("=== 2. 自己造一天 ===");
        LocalDate d1 = LocalDate.of(2026, 9, 26);//of = 静态的"造一个"方法。
        System.out.println("造出来的：" + d1);
        System.out.println("和今天一样吗：" + d1.equals(today));

        System.out.println();
        System.out.println("=== 3. 加减天数 ===");
        System.out.println("今天往后 3 天：" + today.plusDays(3));
        System.out.println("今天往前 7 天：" + today.minusDays(7));//不改自己
        System.out.println("加完以后 today 变了吗：" + today);

        System.out.println();
        System.out.println("=== 4. 比先后 ===");
        LocalDate deadline = today.plusDays(5);
        System.out.println("今天在截止日之前吗：" + today.isBefore(deadline));
        System.out.println("今天在截止日之后吗：" + today.isAfter(deadline));
        System.out.println("差多少天：" + ChronoUnit.DAYS.between(today, deadline));//between 的顺序别写反，反着来是负数

        System.out.println();
        System.out.println("=== 5. 带时分秒 ===");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("现在：" + now);//.withNano(0) 就是"把纳秒部分抹成 0"
        System.out.println("时分秒：" + LocalTime.now().withNano(0));
        LocalDateTime start = LocalDateTime.of(2026, 9, 26, 8, 30, 0);
        LocalDateTime end = LocalDateTime.of(2026, 9, 26, 17, 45, 30);
        Duration dur = Duration.between(start, end);
        System.out.println("开始：" + start + "  结束：" + end);
        System.out.println("差几小时：" + dur.toHours());
        System.out.println("差几分钟：" + dur.toMinutes());

        System.out.println();
        System.out.println("=== 6. 格式化与解析 ===");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//一个"模式串"，规定时间要显示成什么样子。
        System.out.println("格式化后：" + now.format(fmt));//把时间变成字符串（存数据库、写日志、返给前端用这个）。
        DateTimeFormatter day = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("另一种格式：" + today.format(day));
        LocalDate parsed = LocalDate.parse("2026-09-26");//parse 不带格式化器时，只认 yyyy-MM-dd 这个标准写法
        System.out.println("解析回来：" + parsed);
        LocalDateTime parsed2 = LocalDateTime.parse("2026-09-26 17:45:30", fmt);//反过来，把字符串变回时间对象
        System.out.println("带时间解析：" + parsed2);

        System.out.println();
        System.out.println("=== 7. 判断数据够不够新 ===");
        LocalDate dataDate = today.minusDays(4);
        long gap = ChronoUnit.DAYS.between(dataDate, today);
        System.out.println("数据日期：" + dataDate + "，距今 " + gap + " 天");
        if (gap > 3) {
            System.out.println("数据太旧，不能用来诊断");
        } else {
            System.out.println("数据是新的，可以用");
        }
    }
}
//没懂
//| 你想干的事 | 怎么写 |
//| 现在日期 | `LocalDate.now()` |
//| 现在日期+时间 | `LocalDateTime.now()` |
//| 造一个 | `LocalDate.of(2026, 9, 26)`（月从 1） |
//| 取年/月/日 | `getYear()` / `getMonthValue()` / `getDayOfMonth()` |
//| 加减 | `plusDays(3)` / `minusDays(7)` ⚠️ 要接住 |
//| 改某部分 | `withNano(0)` / `withYear(2027)` ⚠️ 要接住 |
//| 比先后 | `a.isBefore(b)` / `a.isAfter(b)` |
//| 差几天 | `ChronoUnit.DAYS.between(a, b)` ⚠️ 顺序别反 |
//| 差几小时 | `Duration.between(a, b).toHours()` |
//| 变文字 | `dt.format(fmt)` |
//| 变对象 | `LocalDate.parse("2026-09-26")` ⚠️ 会抛异常 |
//| 模式串 | `DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")` |