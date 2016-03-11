package my2015;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class B2DoubleFormat {
//	double f = 111231;
//	double f = 0;
	double f = 555.777777;
    public void m1() {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    /**
     * DecimalFormat转换最简便
     */
    public void m2() {
        DecimalFormat df = new DecimalFormat("#0.00");
//        double a = df.format(f);
        System.out.println(df.format(f));
    }
    /**
     * String.format打印最简便
     */
    public void m3() {
        System.out.println(String.format("%.2f", f));
    }
    public void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }
    
    private void doDoubleCal() {
    	double a = 1.11;
    	int b = (int)(a*100);
    	System.out.println("a: " + a + " --- b: " + b);
    }
    
    private void toDouble() {

    	int a = 1;
    	double b = 10 + a/100.0;
    	System.out.println(b);
    }
    
    public void int2double(int i) {
    	double d = i/100.0;
    	BigDecimal bd = new BigDecimal(i);
//    	bd.setScale(2, BigDecimal.ROUND_HALF_UP);
    	System.out.println(i + "/100.0 = " + d + ",----------------" + bd.compareTo(new BigDecimal(d)));
    	
    }
    
    
    public static void main(String[] args) {
    	B2DoubleFormat b = new B2DoubleFormat();
//        b.m1();
//        b.m2();
//        b.m3();
//        b.m4();
//    	b.doDoubleCal();
//    	b.toDouble();
    	for(int i = 777;i < 1200; i++) {
    		b.int2double(i);
    	}
    	
    }
}
