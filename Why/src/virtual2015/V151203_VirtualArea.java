package virtual2015;

/**
 * Created by emi on 2015/12/3.
 *
 */
public class V151203_VirtualArea {
	
//	public static final int INT1 = 9;
	
	
	private void testStr() {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hel" + "lo";
		String s4 = "Hel" + new String("lo");
		String s5 = new String("Hello");
		String s6 = s5.intern();
		String s7 = "H";
		String s8 = "ello";
		String s9 = s7 + s8;
		          
		System.out.println("s1 == s2: " + (s1 == s2));  //
		System.out.println("s1 == s3: " + (s1 == s3));  // 
		System.out.println("s1 == s4: " + (s1 == s4));  //
		System.out.println("s1 == s9: " + (s1 == s9));  //
		System.out.println("s4 == s5: " + (s4 == s5));  //
		System.out.println("s1 == s6: " + (s1 == s6));  //
	}
	
	public void testBoxBase() {
		int i1 = 7;
		int i2 = 7;
		int i3 = 127;
		int i4 = 127;
		int i5 = 128;//在虚拟机栈
		int i6 = 128;
		double d1 = 100.00;
		double d2 = 100.00;
		Integer i7 = 127;//在常量池中?
		Integer i8 = 127;
		Integer i9 = 128;//说明在堆中
		Integer i10 = 128;
		Double d3 = 100.00D;//说明在堆中
		Double d4 = 100.00D;
		
		
		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i3 == i4: " + (i3 == i4));
		System.out.println("i5 == i6: " + (i5 == i6));
		System.out.println("d1 == d2: " + (d1 == d2));
		System.out.println("i7 == i8: " + (i7 == i8));
		System.out.println("i9 == i10: " + (i9 == i10));//
		System.out.println("d3 == d4: " + (d3 == d4));//
	}

	/**
	 * 常量池中的字符串常量与堆中的String对象有什么区别呢？为什么直接定义的字符串同样可以调用String对象的各种方法呢？
	 */
	public void testString() {
		String s1 = new String("myString");//使用关键字new
		String s2 = "myString";//直接定义
		String s3 = "my" + "String";//串联生成
	}
	
	public static void main(String[] args) {
		V151203_VirtualArea c = new V151203_VirtualArea();
		c.testStr();
		c.testBoxBase();
	}

}
//testStr:
/*首先说明一点，在java 中，直接使用==操作符，比较的是两个字符串的引用地址，并不是比较内容，比较内容请用String.equals()。
 *s1 == s2这个非常好理解，s1、s2在赋值时，均使用的字符串字面量，说白话点，就是直接把字符串写死，在编译期间，这种字面量会直接放入class文件的常量池中，从而实现复用，载入运行时常量池后，s1、s2指向的是同一个内存地址，所以相等。
 *s1 == s3这个地方有个坑，s3虽然是动态拼接出来的字符串，但是所有参与拼接的部分都是已知的字面量，在编译期间，这种拼接会被优化，编译器直接帮你拼好，因此String s3 = "Hel" + "lo";在class文件中被优化成String s3 = "Hello";，所以s1 == s3成立。
 *s1 == s4当然不相等，s4虽然也是拼接出来的，但new String("lo")这部分不是已知字面量，是一个不可预料的部分，编译器不会优化，必须等到运行时才可以确定结果，结合字符串不变定理，鬼知道s4被分配到哪去了，所以地址肯定不同。
 *s1 == s9也不相等，道理差不多，虽然s7、s8在赋值的时候使用的字符串字面量，但是拼接成s9的时候，s7、s8作为两个变量，都是不可预料的，编译器毕竟是编译器，不可能当解释器用，所以不做优化，等到运行时，s7、s8拼接成的新字符串，在堆中地址不确定，不可能与方法区常量池中的s1地址相同。
 *s1 == s6这两个相等完全归功于intern方法，s5在堆中，内容为Hello ，intern方法会尝试将Hello字符串添加到常量池中，并返回其在常量池中的地址，因为常量池中已经有了Hello字符串，所以intern方法直接返回地址；而s1在编译期就已经指向常量池了.//不完全对
*/
/**总结：
 * 字符串：其引用存在虚拟机栈，编译期已经创建好（直接用双引号定义的）的就存储在常量池中，运行期（new出来的）才能确定的就存储在堆中。
           必须要关注编译期的行为，才能更好的理解常量池。
           运行时常量池中的常量，基本来源于各个class文件中的常量池。
           程序运行时，除非手动向常量池中添加常量(比如调用intern方法)，否则jvm不会自动添加常量到常量池。
 */


//testBoxBase:
/**
 * 基础类型数据：引用和变量值存在虚拟机栈，常量①值存在常量池中，
 * 包装类：引用存在虚拟机栈中，值都存在常量池中（例如：Integer i =10，虽然包装类自动装拆箱②，但仍然存在常量池中）。这里要说明一点：基于减少创建对象次数和节省内存考虑，[-128,127]之间的数据都存在缓存中。
 * java中基本类型的包装类的大部分都实现了常量池技术，这些类是Byte,Short,Integer,Long,Character,Boolean,另外两种浮点数类型的包装类则没有实现。另外Byte,Short,Integer,Long,Character这5种整型的包装类也只是在对应值小于等于127时才可使用对象池，也即对象不负责创建和管理大于127的这些类的对象。
 */


//testString
/**
 * new String("string"):
 * 		这种方式通过关键字new定义过程：在程序编译期，编译程序先去字符串常量池检查，是否存在“myString”,如果不存在，则在常量池中开辟一个内存空间存放“myString”；如果存在的话，则不用重新开辟空间，保证常量池中只有一个“myString”常量，节省内存空间。
 * 		然后在内存堆中开辟一块空间存放new出来的String实例，在栈中开辟一块空间，命名为“s1”，存放的值为堆中String实例的内存地址，这个过程就是将引用s1指向new出来的String实例。
 * = "myString"：
 * 		在程序编译期，编译程序先去字符串常量池检查，是否存在“myString”，如果不存在，则在常量池中开辟一个内存空间存放“myString”；如果存在的话，则不用重新开辟空间。然后在栈中开辟一块空间，命名为“s1”，存放的值为常量池中“myString”的内存地址。
 * 		常量池中的字符串常量与堆中的String对象有什么区别呢？为什么直接定义的字符串同样可以调用String对象的各种方法呢？如果首次出现时，除了在常量池开辟空间外，还会在堆中开辟空间吗？
 */
/**
 * 在解析阶段，虚拟机发现字符串常量"myString"，它会在一个内部字符串常量列表中查找，如果没有找到，那么会在堆里面创建一个包含字符序列[myString]的String对象s1，然后把这个字符序列和对应的String对象作为名值对( [myString], s1 )保存到内部字符串常量列表中。
 * 如果虚拟机后面又发现了一个相同的字符串常量myString，它会在这个内部字符串常量列表内找到相同的字符序列，然后返回对应的String对象的引用。维护这个内部列表的关键是任何特定的字符序列在这个列表上只出现一次。
 */


//1.程序计数器（寄存器）：最快的存储区， 由编译器根据需求进行分配，我们在程序中无法控制
//2.虚拟机栈：存放基本类型的变量数据和对象的引用，但对象本身不存放在栈中，而是存放在堆（new 出来的对象）或者常量池中（字符串常量对象存放在常量池中。）,通俗的栈，指的是：虚拟机栈（或虚拟机栈中的局部变量表部分）。
//3.静态常量池(class文件中常量池)：class文件中的常量池不仅仅包含字符串(数字)字面量，还包含类、方法的信息，占用class文件绝大部分空间。
//4.运行时常量池:则是jvm虚拟机在完成类装载操作后，将class文件中的常量池载入到内存中，并保存在方法区中，我们常说的常量池，就是指方法区中的运行时常量池。
	/***
	 * 这个区域和class文件里的constant_pool是相对应的。这个区域是包含在方法区里的，不过，对于JVM的操作而言，它是一个核心的角色。因此在JVM规范里特别提到了它的重要性。除了包含每个类和接口的常量，它也包含了所有方法和变量的引用。
	 * 简而言之，当一个方法或者变量被引用时，JVM通过运行时常量区来查找方法或者变量在内存里的实际地址。
	 */
	/**
	 * 常量池(constant pool)指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据。它包括了关于类、方法、接口等中的常量，也包括字符串常量。常量池还具备动态性，运行期间可以将新的常量放入池中.
	 * 虚拟机为每个被装载的类型维护一个常量池，池中为该类型所用常量的一个有序集合，包括直接常量(string、integer和float常量)和对其他类型、字段和方法的符号引用。
	 */
//5.方法区（非堆）：存储被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。包含常量池。
	/***
	 * 在Oracle 的HotSpot JVM里，方法区被称为永久区或者永久代③（PermGen）。是否对方法区进行垃圾回收对JVM的实现是可选的。
	 */
//.java动态编译（见3.4）：编译时，如果发现对其它类方法的调用或者对其它类字段的引用的话，记录进class文件中的，只能是一个文本形式的符
//.这里我们主要关心栈，堆和常量池，对于栈和常量池中的对象可以共享，对于堆中的对象不可以共享。栈中的数据大小和生命周期是可以确定的，当没有引用指向数据时，这个数据就会消失。堆中的对象的由垃圾回收器负责回收，因此大小和生命周期不需要确定，具有很大的灵活性。

//	--- 栈帧(stack frame)：每当一个方法在JVM上执行的时候，都会创建一个栈帧，并且会添加到当前线程的JVM堆栈上。当这个方法执行结束的时候，这个栈帧就会被移除。每个栈帧里都包含有当前正在执行的方法所属类的本地变量数组，操作数栈，以及运行时常量池的引用。本地变量数组的和操作数栈的大小都是在编译时确定的。因此，一个方法的栈帧的大小也是固定不变的。
//	--- 局部变量数组(Local variable array)：这个数组的索引从0开始。索引为0的变量表示这个方法所属的类的实例。从1开始，首先存放的是传给该方法的参数，在参数后面保存的是方法的局部变量。
//	--- 操作数栈(Operand stack)：方法实际运行的工作空间。每个方法都在操作数栈和局部变量数组之间交换数据，并且压入或者弹出其他方法返回的结果。操作数栈所需的最大空间是在编译期确定的。因此，操作数栈的大小也可以在编译期间确定。





/*** ①java常量：
 * 1.方法一采用接口(Interface)的中变量默认为static final的特性。
 * 2.方法二采用了Java 5.0中引入的Enum类型。
 * 3.方法三采用了在普通类中使用static final修饰变量的方法。
 * 4.方法四类似方法三，但是通过函数来获取常量。*/

/*** ②java自动装箱：
 * 在JDK5.0之前是不允许直接将基本数据类型的数据直接赋值给其对应地包装类的，如：Integer i = 5;
 * 但是在JDK5.0中支持这种写法，因为编译器会自动将上面的代码转换成如下代码：Integer i=Integer.valueOf(5);
 * 这就是Java的装箱.JDK5.0也提供了自动拆箱. Integer i = 5;  int j = i;  */

/*** ③JVM的新生代、老年代、永久代：
 * 所谓的新生代和老年代是针对于分代收集算法来定义的，新生代又分为Eden和Survivor两个区。加上老年代就这三个区。
 * 数据会首先分配到Eden区当中（当然也有特殊情况，如果是大对象那么会直接放入到老年代（大对象是指需要大量连续内存空间的java对象）。），当Eden没有足够空间的时候就会触发jvm发起一次Minor GC。
 * 如果对象经过一次Minor GC还存活，并且又能被Survivor空间接受，那么将被移动到Survivor空间当中。并将其年龄设为1，对象在Survivor每熬过一次Minor GC，年龄就加1，
 * 当年龄达到一定的程度（默认为15）时，就会被晋升到老年代中了，当然晋升老年代的年龄是可以设置的。
 *
 * 在Oracle 的HotSpot JVM里，方法区被称为永久区或者永久代③（PermGen）。
 */

