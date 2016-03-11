package my2015;

import java.math.BigDecimal;

public class C1Ifsum {
	
	public void testSum() {
		System.out.println("aaaa");
		double originalCharge = 0.02;
		double postage = 0.1;
		int philips = 11;
		double charge = 0.01;
		double sumCharge = new BigDecimal(originalCharge + postage).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		double sumPay = new BigDecimal(charge + philips/100.0).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(sumCharge);
		System.out.println(sumPay);
		if(sumCharge != sumPay) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
	}
	
	private void testBigDecimal() {
		BigDecimal charge = new BigDecimal(0.01);
		Integer total_fee = 1;
		double totalFeeDouble = total_fee/100.0;
		BigDecimal totalFeeBig = new BigDecimal(totalFeeDouble);
		if(0 != charge.compareTo(totalFeeBig)) {
			throw new RuntimeException("total_fee: " + total_fee + ",charge: " + charge + ",totalFeeBig: " + totalFeeBig.doubleValue() + ",this.charge.compareTo(totalFeeBig): " + charge.compareTo(totalFeeBig));
		} else {
			System.out.println(" --- 0 --- ");
		}
		
	}
	
	
	public static void main(String[] args) {
		C1Ifsum c = new C1Ifsum();
		c.testBigDecimal();
	}

}
