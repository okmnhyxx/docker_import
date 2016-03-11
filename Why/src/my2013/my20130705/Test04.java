package my2013.my20130705;

public class Test04  {
    private static Test04 t1 = new Test04();  //------------------------------这里是怎么个情况？
    private static int i1;
    private static int i2 = 2;
    
    public Test04() {
        i1++;i2++;
    }
    public void expressConvert(){
    	String s ="3+4";
    	int i=0;
    	i=Integer.valueOf(s);
    	System.out.println("express convert:     " +s+i);
    }
    
    public static void main(String[] args)  {
    	System.out.println(Test04.i1);	//-------------------------------------为什么是1？
    	System.out.println(Test04.i2);  //-------------------------------------为什么是2？其顺序？
        Test04 t2 = new Test04();
        System.out.println("t2.i1 = " + t2.i1);
        System.out.println("t2.i2 = " + t2.i2);
        System.out.println("\n\n");
        t2.expressConvert();
    }
    
}

/*首先执行给t1,i1,i2分别给予初始值null,0,0，
再执行
	Test04 t1 =new Test04(),   这样i1++,i2++被执行，i1,i2都变为1，
执行完毕后接着执行
	int i1;   i1,i2的值仍然是1，1,
当执行
	int i2 = 2时i2被赋予了值，     即i1 = 1,i2=2;
再执行
	Test04 t2 = new Test04(),i1，i2再执行＋＋，
	此时i1 ＝2，i2 ＝3，输出i1，i2，
结果就是：t2.i1 = 2，t2.i2 = 3。 
通过上面的代码我们可以认为系统默认值的给予比通过等号的赋予先执行。*/



//对单个类，JVM加载阶段（编译阶段）: 
//
//	1、给静态变量分配内存空间
//
//	2、用默认值初始化静态变量
//
//	3、按照静态变量和静态块的申明顺序执行初始化
//
//	4、如果创建对象；否则，直接结束
//
//	5、先给所有实例成员分配内存空间并用默认值初始化
//
//	6、按顺序执行实例块和变量
//
//	7、执行构造方法