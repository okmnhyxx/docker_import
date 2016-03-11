package my2015;

public class B1LongNull {
	
	private void compare() {
//		Long a = null;
//		Long b = 1L;
		Object maxObj = 0.0;
		Double maxDou = Double.parseDouble((String) maxObj);
//		Long maxLong = maxDou.longValue();
		System.out.println("-----------------" + maxDou);
//		System.out.println("-----------------" + maxLong);
//		if(b>a) {
//			System.out.println("0L > null");
//		}
	}
	
	public static void main(String[] args) {
		B1LongNull b = new B1LongNull();
//		b.compare();
		b.convert();
	}
	
	private void convert() {
		Object maxo = 0.0;
		Double maxd = Double.parseDouble(maxo.toString());
		Long maxl = maxd.longValue();
		System.out.println(maxd);
		System.out.println(maxl);
	}
}
