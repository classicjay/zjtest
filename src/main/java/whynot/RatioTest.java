package whynot;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * <p>Title: BONC -  RatioTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class RatioTest {

    //计算占比
    private static String calculateRatio(String numerator,String demoninator){
        DecimalFormat df = new DecimalFormat("######0.00");
        df.setRoundingMode(RoundingMode.UP);
        String result = new String();
        if (numerator.equals("0")||demoninator.equals("0")){
            return "-";
        }else {
            Double numeVal = Double.parseDouble(numerator);
            Double denomiVal = Double.parseDouble(demoninator);
            result = df.format(numeVal/denomiVal*100);
            return result+"%";
        }

    }
}
