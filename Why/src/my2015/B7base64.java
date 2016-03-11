package my2015;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class B7base64 {

	
	// 加密
		public static String getBase64(String str) {
			byte[] b = null;
			String s = null;
			try {
				b = str.getBytes("utf8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (b != null) {
				s = new BASE64Encoder().encode(b);
			}
			return s;
		}

		// 解密
		public static String getFromBase64(String s) {
			byte[] b = null;
			String result = null;
			if (s != null) {
				BASE64Decoder decoder = new BASE64Decoder();
				try {
					b = decoder.decodeBuffer(s);
					result = new String(b, "utf8");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		
		/** 
		* BASE64解密 
		*  
		* @param key 
		* @return 
		* @throws Exception 
		*/  
		public static String decryptBASE64(String key){  
		   byte[] bt;
			try {
				bt = (new BASE64Decoder()).decodeBuffer(key);
				return new String(bt, "GB2312");
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}  
		}  
		 
		/** 
		* BASE64加密 
		*  
		* @param key 
		* @return 
		* @throws Exception 
		*/  
		public static String encryptBASE64(String key){  
			byte[] bt = key.getBytes();
		   return (new BASE64Encoder()).encodeBuffer(bt);  
		}  
		
		
		public static void main(String[] args) {
			String a = "JTdCJTIyZGF0YSUyMiUzQSU1QiU1RCUyQyUyMmVycm9yTXNnJTIyJTNBJTIySlNPTk9iamVjdCU1\r\nQiU1QyUyMmJpbmRNYWMlNUMlMjIlNUQlMjBub3QlMjBmb3VuZC4lMjIlMkMlMjJyZXN1bHRDb2Rl\r\nJTIyJTNBJTIyMCUyMiUyQyUyMnN1Y2Nlc3NNc2clMjIlM0ElMjIlMjIlN0Q=\r\n";
//			String a1 = a.replace("\\r\\n", "");
			System.out.println(a);
//			System.out.println(B7base64.decryptBASE64(a));
//			String aa= "JTdCJTIyZGF0YSUyMiUzQSU1QiU1RCUyQyUyMmVycm9yTXNnJTIyJTNBJTIyVFBWLTEwMDMlM0El\r\ndTRFMUEldTUyQTEldTYzQTUldTUzRTMldThDMDMldTc1MjgldTVGMDIldTVFMzgldUZGMENKU09O\r\nT2JqZWN0JTVCJTVDJTIyYWNjZXNzVG9rZW4lNUMlMjIlNUQlMjBub3QlMjBmb3VuZC4lMjIlMkMl\r\nMjJyZXN1bHRDb2RlJTIyJTNBJTIyMCUyMiUyQyUyMnN1Y2Nlc3NNc2clMjIlM0ElMjIlMjIlN0Q=\r\n";
			String b = B7base64.getFromBase64(a);
			System.out.println(b);
			String c = URLDecoder.decode(b);
			System.out.println(c);
			
		}
}
