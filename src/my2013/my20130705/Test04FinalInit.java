package my2013.my20130705;

public class Test04FinalInit {
    private int a1 = 10;
    private int a2;
    private final int a3 = 30;
    private final int a4;
//    private static Test04FinalInit t1 = new Test04FinalInit();  //------------------------------这里是怎么个情况？
    private static int i1;
    private static int i2 = 2;
    
    public Test04FinalInit() {
        a4 = 40;
        System.out.println(i1 + "  " + i2 + "  " + a1 + "  " + a2);
        i1++;i2++;
        a1 = 11;
        a2 = 21;
        System.out.println(i1 + "  " + i2 + "  " + a1 + "  " + a2);
    }
    public void expressConvert(){
    	String s ="3+4";
    	int i=0;
    	i=Integer.valueOf(s);
    	System.out.println("express convert:     " +s+i);
    }
    
    public static void main(String[] args)  {
        System.out.println("aaaaaaaa");
        System.out.println(Test04FinalInit.i1);	//-------------------------------------为什么是1？
    	System.out.println(Test04FinalInit.i2);  //-------------------------------------为什么是2？其顺序？
        Test04FinalInit t2 = new Test04FinalInit();
        System.out.println("t2.i1 = " + t2.i1);
        System.out.println("t2.i2 = " + t2.i2);
        System.out.println("\n\n");
        t2.expressConvert();
    }
    
}

/*首先执行给t1,i1,i2分别给予初始值null,0,0，
再执行
	Test04FinalInit t1 =new Test04FinalInit(),   这样i1++,i2++被执行，i1,i2都变为1，
执行完毕后接着执行
	int i1;   i1,i2的值仍然是1，1,
当执行
	int i2 = 2时i2被赋予了值，     即i1 = 1,i2=2;
再执行
	Test04FinalInit t2 = new Test04FinalInit(),i1，i2再执行＋＋，
	此时i1 ＝2，i2 ＝3，输出i1，i2，
结果就是：t2.i1 = 2，t2.i2 = 3。 
通过上面的代码我们可以认为系统默认值的给予比通过等号的赋予先执行。*/



//对单个类加载，JVM加载阶段（编译阶段）:
//
//	1、给静态变量分配内存空间
//
//	2、用默认值初始化静态变量
//
//	3、按照静态变量和静态块的申明顺序执行初始化
//
//	4、如果创建对象 执行下面的；否则，直接结束
//
//	5、先给所有实例成员分配内存空间并用默认值初始化(final 类型不初始化)
//
//	6、按顺序执行实例块和变量
//
//	7、执行构造方法


//1.final修饰的成员变量没有默认值
//        2.final初始化可以在三个地方
//        (1)声明的时候初始化
//        (2)构造函数里初始化
//        (3)要是没有static修饰的话可以在非静态块里初始化,要是有static修饰的话可以在静态块里初始化
//        3.使用final成员前要确保已经初始化


//当一个属性被修饰为final,而非static的时候,它属于类的实例对象的资源,
//      当类被加载进内存的时候这个属性并没有给其分配内存空间, 而只是定义了一个变量a,
//只有当类被实例化的时候这个属性才被分配内存空间,而实例化的时候同时执行了构造函数,
//      所以属性被初始化了,也就符合了当它被分配内存空间的时候就需要初始化,以后不再改变的条件.


//此外 使用final修饰的类，不能被继承
//使用final修饰的方法，不能被重写

