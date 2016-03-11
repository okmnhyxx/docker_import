package think;


/**
 * @author yunni.lu
 * 1  16 15 14 13            00 01 02 03 04
 * 2  17 24 23 12            10 11 12 13 14
 * 3  18 25 22 11            20 21 22 23 24
 * 4  19 20 21 10            30 31 32 33 34
 * 5  6  7  8  9             40 41 42 43 44
 */
public class A1CircleRectangle {
	
	
	private void doRect() {
		int len = 5;
		int[][] rectArr = new int[len][len];
		for(int i = 0; i < len; i++) {
			
			for(int j = 0,sumCount = 1; j < len; j ++,sumCount ++ ) {
				
				if(i > j ) {
					if(i <= (len-1)/2) {
						
					}
					rectArr[i][j] = sumCount;
				} else if(i == j) {
					
				} else if ( i < j) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		A1CircleRectangle a = new A1CircleRectangle();
		a.doRect();
		
	}
	

}
