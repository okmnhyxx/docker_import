package my2018;

/**
 * @author kexia.lu on 2018/1/24.
 */
public class A1Bitwise {

    public static void main(String[] args) {
        A1Bitwise a = new A1Bitwise();
        a.testDisplacement();
    }

    private void testDisplacement() {
        int positiveNum = 9; //00001001
        int negativeNum = -9; //11110111 //在计算机中，负数以其正值的补码形式表达。补码为反码+1
        int positiveRight = positiveNum >> 1; //00000100 = 4
        int negativeRight = negativeNum >> 1; //11111011           00000100 00000101(取反后+1) ， 11111010 00000101(减1后取反)
        System.out.println("positiveRight、negativeRight：" + positiveRight + "、" + negativeRight);

        int positiveLeft = positiveNum << 1; //00010010 = 18
        int negativeLeft = negativeNum << 1; //11101110 = -18       00010001 00010010(取反后+1) ，11101101 00010010(减1后取反)
        System.out.println("positiveLeft、negativeLeft：" + positiveLeft + "、" + negativeLeft);

        System.out.println("positiveNum、positiveRight、positiveLeft：" +
                Integer.toBinaryString(positiveNum) + "、" + Integer.toBinaryString(positiveRight) + "、" + Integer.toBinaryString(positiveLeft));
        System.out.println("negativeNum、negativeRight、negativeLeft：" +
                Integer.toBinaryString(negativeNum) + "、" + Integer.toBinaryString(negativeRight) + "、" + Integer.toBinaryString(negativeLeft));
    }
}

//异或（XOR）：异或运算符是用符号“^”相同为0，不同为1。
//负二进制，负数以其正值的补码形式表达。补码为反码+1
//负二进制转十进制： 先转成正二进制（ 取反后+1 或 减1后取反，）