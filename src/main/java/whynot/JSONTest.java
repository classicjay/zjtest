package whynot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * <p>Title: BONC -  JSONTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class JSONTest {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        //map->String方法一
        JSONObject jsonObject = JSONObject.fromObject(map);
        String str = jsonObject.toString();
        System.out.println(str);
        //map->String方法二
        String json = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);


        JSONObject jsObj = new JSONObject();
        jsObj.put("username","zhangsan");
        jsObj.put("password","lisi");

    }
}
