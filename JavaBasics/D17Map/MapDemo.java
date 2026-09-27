package JavaBasics.D17Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Double> currents = new HashMap<>();
        currents.put("G1-01", 9.5);
        currents.put("G1-02", 0.4);
        currents.put("G1-03", 8.1);

        System.out.println("一共 " + currents.size() + " 条");
        System.out.println("G1-02 的电流：" + currents.get("G1-02"));
        System.out.println("G9-99 的电流：" + currents.get("G9-99"));//不存在的键不会报错所以要确认
        System.out.println("有这个编号吗：" + currents.containsKey("G1-03"));
        System.out.println("整个表：" + currents);//顺序乱的，用LinkedHashMap可以保持顺序

        System.out.println("--- 逐个看 ---");
        for (Map.Entry<String, Double> e : currents.entrySet()) {//Map.Entry<K, V> 意思是"表里的一条记录"。getKey() 拿键、getValue()
            System.out.println(e.getKey() + " -> " + e.getValue());//entrySet()意思是"取出一整套行"，把表一行两个东西变成集合
        }

        System.out.println("--- 只挑异常的 ---");
        for (Map.Entry<String, Double> e : currents.entrySet()) {
            if (e.getValue() < 1.0) {
                System.out.println("异常组串：" + e.getKey());
            }
        }

        System.out.println("--- 改一个 ---");
        currents.put("G1-02", 9.0);//put已经存在的键=改值
        System.out.println("改完后 G1-02：" + currents.get("G1-02"));
        System.out.println("一共还是 " + currents.size() + " 条");
    }
}
//HashMap<键类型, 值类型>，用 put(键, 值) 放，用 get(键) 取。注意尖括号里是两个类型。
//get 查不到返回 null，用之前先 containsKey 或用 getOrDefault。
//HashMap 的顺序是乱的，要顺序就换 LinkedHashMap。
//put 已存在的键 = 修改（条数不变），返回值是"被替换掉的旧值"。
//遍历要用 entrySet()，每轮拿一个 Map.Entry，用 getKey() / getValue() 分别取。