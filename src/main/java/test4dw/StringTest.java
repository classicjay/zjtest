package test4dw;

import java.util.StringTokenizer;

/**
 * <p>Title: BONC -  StringTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class StringTest {
    public static void main(String[] args) {
        StringBuffer sumValue = new StringBuffer();
        sumValue.append("a");
        sumValue.append("|");
        sumValue.append("b");
        sumValue.append("|");
        sumValue.append("c");
        sumValue.append("|");
        sumValue.append(0);
        sumValue.append("|");
        sumValue.append(null+"|");
        System.out.println(sumValue.toString());
        StringTokenizer stK = new StringTokenizer(sumValue.toString(),"|");

        while (stK.hasMoreTokens()){
            System.out.println(stK.nextToken());
            System.out.println(null!=stK.nextToken());
        }
    }
}
