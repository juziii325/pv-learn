package JavaBasics.D12Exercise;

public class GroupDemo {
    public static void main(String[] args){
        StringGroup G1=new StringGroup ("G1-01",9.5,20);
        StringGroup G2=new StringGroup ("G1-02",8.2,20);
        System.out.println(G1.getCode()+"电流："+G1.getCurrent()+" 组件数："+G1.getModuleCount());
        System.out.println(G2.getCode()+"电流："+G2.getCurrent()+" 组件数："+G2.getModuleCount());
        System.out.println("一共登记了"+StringGroup.getCount()+"个组串");
        G1.setCurrent(-5);
        G1.setModuleCount(0);
        G1.setAbnormal(true);
        System.out.println(G1.getCode()+"电流："+G1.getCurrent()+" 组件数："+G1.getModuleCount());
        System.out.println("--- 把 G1 的电流改小 ---");
        G1.setCurrent(0.3);
        System.out.println(G1.getCode() + " 电流 " + G1.getCurrent() + " 异常 " + G1.isAbnormal());
        System.out.println("--- 把 G1 的电流改回正常 ---");
        G1.setCurrent(8.8);
        System.out.println(G1.getCode() + " 电流 " + G1.getCurrent() + " 异常 " + G1.isAbnormal());
    }//getter 是方法，不是字段 → 括号不能省。
}
class StringGroup{//只能有一个public类！！！！
    private String code;
    private double current;
    private int moduleCount;
    private boolean abnormal;
    private static int count=0;

    public StringGroup(String code,double current,int moduleCount){
        this.code=code;
        setCurrent(current);
        setModuleCount(moduleCount);
        //setAbnormal(abnormal);直接删掉，默认false
        count++;//static 计数器只写 count++; → 加 this. 和不加 this. 都能编译，但 this.count = count++; 会让计数器永远停在 0。
    }
    public String getCode(){return code;}
    public double getCurrent(){return current;}
    public int getModuleCount(){return moduleCount;}
    public boolean isAbnormal(){ return abnormal; }//开门
    public static int getCount(){return count;}
   
    public void setCurrent(double current){//括号里的东西叫参数（形式参数），意思是「告诉我这个方法是靠什么信息干活的」，方法体里要「用」这个值
        if (current>0){
            this.current = current;}
        else{
            System.out.println("电流不能为负，已按 0 处理");
            this.current = 0;}
        this.abnormal = this.current < 1.0;
        }
    public void setModuleCount(int moduleCount){//
        if (moduleCount<1){ 
            System.out.println("组件数不能小于 1,已按 1 处理");
            this.moduleCount=1;}
        else{
            this.moduleCount=moduleCount;
        }
        }
    public void setAbnormal(boolean abnormal){ this.abnormal = abnormal;} //开门
    //setter 是「void + 一个参数 + 不 return」 → 你把 setter 写成了 getter 的形状（没参数、还 return 值）。
}