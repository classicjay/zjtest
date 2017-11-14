package test4dw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: BONC -  DateTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class DateTest {

    public static boolean hourBetweenTimes(String time1, String time2) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss ZZZZ", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1;
        Date date2;
        long days = 0;
        long hours = 0;
        long mins = 0;
        long secs = 0;
        try {
            date1 = sdf.parse(time1);
            date2 = sdf.parse(time2);
            long timeVal1 = date1.getTime();
            long timeVal2 = date2.getTime();
            long diff;
            if (timeVal1<timeVal2){
                diff = timeVal2 - timeVal1;
            }else {
                diff = timeVal1 - timeVal2;
            }
            days = diff/(24 * 60 * 60 * 1000);
            hours = (diff / (60 * 60 * 1000) - days * 24);
            mins = ((diff / (60 * 1000)) - days * 24 * 60 - hours * 60);
            secs = (diff / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - mins * 60);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (hours >= 1){
            return true;
        }else {
            return false ;
        }


    }

    public static void main(String[] args) {

        SimpleDateFormat esFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String esString = "2017-10-30T16:03:19+08:00";

        String oraString = "2017-10-30 16:03:19.0";
        SimpleDateFormat oraFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        Date date = new Date();
        try {
            date = oraFormat.parse(oraString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String resString = esFormat.format(date);
        System.out.println(resString);

//        String oraString = "2017-10-30 16:03:19.023";
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//        Date date = new Date();
//        try {
//            date = sdf1.parse(oraString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println("转换为"+calendar.getTime());

    }
}
