package whynot;

import java.net.InetAddress;

/**
 * <p>Title: BONC -  IPAddressTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class IPAddressTest {
    public static void main(String[] args) {
        //获取本机ip
        InetAddress inetAddress = null;
        String localIp = new String();
        String localName = new String();
        try{
            inetAddress = inetAddress.getLocalHost();
            localIp = inetAddress.getHostAddress();//获取ip
            localName = inetAddress.getHostName();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ip"+localIp+"name"+localName);

    }
}
