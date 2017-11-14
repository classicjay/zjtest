package test4dw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * <p>Title: BONC -  DecimalTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class DecimalTest {
    public static void main(String[] args) {

//       System.out.println(5/2);
//
//		BigDecimal bigDecimal = new BigDecimal("1048576.1024");
//		System.out.println(bigDecimal.equals("1048576.1024"));


//		String a = "12.12%";
//		String b = "25.54";

//		String a = "abc";
//		System.out.println(a+".*");

//		int a = 20;
//		int b = 30;
//		float c= (float)a/(float)b;
//
//		DecimalFormat df = new DecimalFormat("#0.00");
//
//
//		double dou = 25.2;
//		System.out.println((int)dou);
//
//
//		int i = 12;
//		System.out.println(String.format("%04d",i));
//        System.out.println(String.format("%(,d",i));





        DecimalFormat decimalFormat = new DecimalFormat("#0.00000");
        decimalFormat.setRoundingMode(RoundingMode.UP);
        String a = "711132345130.37246457457";
        String b = "711132345130.37246457457";
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        System.out.println(bigDecimal.doubleValue()+bigDecimal1.doubleValue());
        System.out.println(decimalFormat.format(bigDecimal.doubleValue()+bigDecimal1.doubleValue()));
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.doubleValue());

        System.out.println(bigDecimal.add(bigDecimal1)+"|");
        System.out.println(bigDecimal.add(bigDecimal1).doubleValue());





        String string = "123124354534";
        String string1 = "1234235346345643231";
        System.out.println(Double.parseDouble(string)+Double.parseDouble(string1));
        System.out.println(BigDecimal.valueOf(Double.parseDouble(string)+Double.parseDouble(string1)));
        System.out.println(BigDecimal.valueOf(Double.parseDouble(string)).doubleValue()+BigDecimal.valueOf(Double.parseDouble(string1)).doubleValue());
    }
}
