package virtual2015;

/**
 * Created by emi on 2015/12/7.
 * 2-4 虚拟机栈溢出测试
 * VM args: -Xss128k
 * cd ws_eclipse\Why\src 或 cd ws_eclipse/Why/src/
 * javac -encoding UTF-8 virtual2015\V151207_JavaVMStackSOF.java 或 javac -encoding UTF-8 virtual12015/V151207_JavaVMStackSOF.java
 * java virtual2015/V151207_JavaVMStackSOF
 */
public class V151207_JavaVMStackSOF {

    private int stackLength;

    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        V151207_JavaVMStackSOF oom = new V151207_JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
//            System.out.println("stack length: " + oom.stackLength);
            throw new RuntimeException("stack length: " + oom.stackLength);
        }
    }
}

/**
 * 无论是栈帧太大还是虚拟机栈太小，当内存无法分配的时候，都会造成StackOverflowError
 */