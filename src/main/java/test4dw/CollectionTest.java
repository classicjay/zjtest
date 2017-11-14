package test4dw;

import java.util.*;

/**
 * <p>Title: BONC -  CollectionTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class CollectionTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add(null);
//
//        Set<String> set = new HashSet<>();
//        set.addAll(list);
//        Object[] sumArr = set.toArray();
//        for (int i=0;i<sumArr.length;i++){
//            System.out.println(sumArr[i]);
//        }
//
//
//        //subList使用
//        List<String> List1 = new ArrayList<>();
//        List1.add("a");
//        List1.add("b");
//        List1.add("c");
//        List1.add("d");
//
//        List1.subList(4,List1.size()).clear();
//
//        System.out.println(List1);
//
//
//
//
//
//        List<String> allProvList = Arrays.asList(new String[] {"011","013","018","019","010","091","090","097","017","076","031","034","036","030","038","075","071","074","051","059","050","083","081","085","086","079","084","087","070","088","089"});
//        List<String> provList31 = allProvList.subList(0,6);
//        System.out.println(allProvList.size());
//        System.out.println(provList31.size());


        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("ord","2");
        Map<String,String> map2 = new HashMap<>();
        map2.put("ord","1");
        Map<String,String> map3 = new HashMap<>();
        map3.put("ord","3");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        System.out.println(list);
        Collections.sort(list, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return o1.get("ord").compareTo(o2.get("ord"));
            }
        });
        System.out.println(list);

    }
}
