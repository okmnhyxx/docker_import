package my2013.my2013071620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileDemo18 {
	
	public void panel2File1(){
		File file  = new File("F:\\doc\\test1.txt");
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			System.out.println("please input something to insert to test1.txt:\t");
			String str = bin.readLine();
			while(!(str.equals("??"))){
				System.out.println(str);
				bw.append(str);
				bw.newLine();
				str = bin.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void file2Screen2() throws IOException{
		File file = new File("I:\\墨香\\倾尽一生\\孤独.txt");
		try {
//			BufferedReader bf = new BufferedReader(new FileReader(file));
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("I:\\墨香\\倾尽一生\\孤独.txt"),"UTF-8"));
			 String msg = null;
             while((msg = bf.readLine())!=null) {
            	 System.out.println(msg);
             }
             System.out.println(" ---------------------------- end -----------------------------");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" --- err ");
		}
//		System.out.println(" --- ok ");
	}
	
	public static void main(String[] args) throws IOException {
		FileDemo18 fd = new FileDemo18();
//		fd.panel2File1();
		fd.file2Screen2();
	}
		
	

}
