package whynot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: BONC -  CalendarTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class CalendarTest {
    //Calendar日历的使用

    public static void main(String[] args) {
        //倒退12个月
        List<String> paramDateList = new ArrayList<>();
        String xhDate = "2017-10-18";
        for (int i =0;i<12;i++){
//            System.out.println(xhDate);
            paramDateList.add(xhDate);
            xhDate = getDateOfLastMonth(xhDate);
        }
        System.out.println(paramDateList);

        //倒序排列
        for (int j=paramDateList.size()-1;j>=0;j--){
            String date = paramDateList.get(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = new Date();
            try {
                parseDate = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar c = Calendar.getInstance();
            c.setTime(parseDate);
            System.out.println(c.get(Calendar.MONTH)+1+"月");
        }
    }

    public static String getDateOfLastMonth(Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = (Calendar) date.clone();
        //求上月同期
//        lastDate.add(Calendar.MONTH, -1);
        //当前时间月份加一，设置天是月份的第一天，再减一天就是当月的最后一天
        lastDate.add(Calendar.MONTH, -1);
        lastDate.add(Calendar.MONTH,1);
        lastDate.set(Calendar.DAY_OF_MONTH,1);
        lastDate.add(Calendar.DATE,-1);
        return sdf.format(lastDate.getTime());

    }

    public static String getDateOfLastMonth(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateStr);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            return getDateOfLastMonth(c);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format(yyyy-MM-dd):"+dateStr);
        }
    }
}
