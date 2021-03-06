package md5;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;  

/** 
 * MD5加密工具类 
 * <功能详细描述> 
 *  
 * @author  chenlujun 
 * @version  [版本号, 2014年10月1日] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */  
public abstract class MD5Tools  
{  
    public final static String MD5(String pwd) {  
        //用于加密的字符  
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = pwd.getBytes();  
               
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
               
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
               
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
               
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }  
               
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    }  
    public static void main(String[] args) {
    	String md5=MD5Tools.MD5("123456");
//    	System.out.println(md5);
//    	System.out.println(DigestUtils.md5Hex("123456").toUpperCase());
    	System.out.println(DigestUtils.sha256("123456"));
    //	String bse=Base64.encode("123456".getBytes());
    //	System.out.println(bse);
    //	System.out.println(new String(Base64.decode(bse)));
    	System.out.println(Md5Crypt.md5Crypt("123456".getBytes())); 
    	
	}
}  