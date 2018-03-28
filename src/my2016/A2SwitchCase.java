package my2016;

import java.util.Scanner;

/**
 * Created by emi on 2016/2/26.
 */
public class A2SwitchCase {


    public static void main(String[] args) {
        A2SwitchCase s = new A2SwitchCase();
        Scanner sc = new Scanner(System.in);
        String cont = null;
        while (!"n".equals(cont)){
            System.out.println("输入一个数");
            int a = Integer.parseInt(sc.nextLine());
            s.testSwitch(a);
            System.out.println("输入n结束，其他继续");
            cont = sc.nextLine();
        }
    }

    private void testSwitch(int a) {
        switch (a) {
            case 1:
                System.out.println("1: " + a);
            case 2:
                System.out.println("2: " + a);
            case 3:
                System.out.println("3: " + a);
                break;
            case 4:
                System.out.println("4: " + a);
                break;
        }
    }
}
