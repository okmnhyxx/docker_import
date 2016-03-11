package other;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * md5加密
 * 
 * @author yunni.lu
 */
public class MD5Util {
	
	private static final String key0 = "qrcode$!&key";  
    private static final Charset charset = Charset.forName("UTF-8");  
    private static byte[] keyBytes = key0.getBytes(charset); 
	
	/***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        StringBuffer hexValue = new StringBuffer();

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        System.out.println("----------md5----" + inStr + ":----------------------------------" + hexValue.toString());
        return hexValue.toString().toUpperCase();
    }
    
    //加密
    public static String keyencode(String enc){  
        byte[] b = enc.getBytes(charset);  
        for(int i=0,size=b.length;i<size;i++){  
            for(byte keyBytes0:keyBytes){  
                b[i] = (byte) (b[i]^keyBytes0);  
            }  
        }  
        return new String(b);  
    }  
      
    //解密
    public static String keydecode(String dec){  
        byte[] e = dec.getBytes(charset);  
        byte[] dee = e;  
        for(int i=0,size=e.length;i<size;i++){  
            for(byte keyBytes0:keyBytes){  
                e[i] = (byte) (dee[i]^keyBytes0);  
            }  
        }  
        return new String(e);  
    }  
    

	public static void main(String[] args) {
		System.out.print(MD5Util.string2MD5("111111"));
	}
}