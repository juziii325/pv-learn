package JavaBasics.D12Exercise;

public class GroupDemo {
    public static void main(String[] args){
        StringGroup G1=new StringGroup ("G1-01",9.5,20);
        StringGroup G2=new StringGroup ("G1-02",8.2,20);
        System.out.println(G1.getCode+"电流："+G1.getCurrent+" 组件数："+G1.getModuleCount);
        System.out.println(G2.getCode+"电流："+G2.getCurrent+" 组件数："+G2.getModuleCount);
        System.out.println("一共登记了"+StringGroup.getCount()+"个组串");
        G1.setCurrent(-5);
        G1.setModuleCount(0);
        G1.setAbnormal(true);
        System.out.println(G1.getCode+"电流："+G1.getCurrent+" 组件数："+G1.getModuleCount);
    }
}
public class StringGroup{
    private String code;
    private double current;
    private int moduleCount;
    private boolean abnormal;
    private static int count=0;

    public StringGroup(String code,double current,int moduleCount){
        this.code=code;
        setCurrent(current);
        setModuleCount(moduleCount);
        setAbnormal(boolean);
        this.count=count++;
    }
    public String getCode(){return code;}
    public double getCurrent(){return current;}
    public int getModuleCount(){return moduleCount;}
    public static int getCount(){return count;}
   
    public void setCurrent(){
        if (current>0){
            return current;}
        else{
            System.out.println("电流不能为负，已按 0 处理");
            return 0;}
        
    public void setModuleCount(){
        if (moduleCount<1){ 
             System.out.println("组件数不能小于 1,已按 1 处理");
             return 1;}
        else{
            ruturn moduleCount;
        }
        }
    }
}