package my2013.my2013071015;

public class TestExcept0808 {
	
	
	public void doTest(){
		int i=-1;
		try{
			i=10;
			i/=0;
		System.out.println("try: "+i);
		}catch (Exception e) {
			i=0;
			System.out.println("catch: "+i);
		}finally{
			i++;
			System.out.println("final: "+i);
		}
		System.out.println("outer: "+i);
	}
	
	public static void main(String[] args) {
		TestExcept0808 te = new TestExcept0808();
		te.doTest();
	}
}
