package whynot;


import java.util.*;

/**
 * <p>Title: BONC -  list2set</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class List2SetTest {

    public  static void  main(String[] args )
    {
        List currNames = new ArrayList();
        List aliNames = new ArrayList();

        currNames.add("a");
        currNames.add("b");
        currNames.add("c");
        currNames.add("d");
        currNames.add("e");
        currNames.add("f");
        currNames.add("g");
        currNames.add("h");
        currNames.add(null);
        currNames.add("j");

        aliNames.add("1");
        aliNames.add("2");
        aliNames.add("3");
        aliNames.add("4");
        aliNames.add("5");
        aliNames.add("6");
        aliNames.add("7");
        aliNames.add("8");
        aliNames.add("9");
        aliNames.add("0");







//        Set currNamesSet= new HashSet();
//        //把list放到set里,为了去重
//        currNamesSet.addAll(currNames);
//
//        //放到set去重后的字母数组
//        Object[] cnsset = currNamesSet.toArray();
//        //直接由list转换的字母数组
//        Object[] cns = currNames.toArray();
//        Object[] ans = aliNames.toArray();
//        Map m = new HashMap();
//        for(int i=0;i<cns.length;i++)
//            m.put(cns[i],ans[i]);
//        //cns可能有重复
//        System.out.println("map:"+m);
//
//        for(int i=0;i<cnsset.length;i++)
//        {
//            String tmp = (String)m.get(cnsset[i]);
//            cnsset[i]=tmp;
//        }


//        for(int i=0;i<cnsset.length;i++)
//            System.out.println(cnsset[i]);


//
//        Object[] sumAliasArr = unifyOrder(currNames,aliNames);
//        for(int i=0;i<sumAliasArr.length;i++)
//        {
//            System.out.println("******单个别名"+sumAliasArr[i].toString());
//        }



        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");
        stringBuffer.append("2");
        System.out.println(stringBuffer.toString());
        stringBuffer.setLength(0);
        System.out.println(stringBuffer.toString());




    }

//    static Object[] unifyOrder(List<String> sumFieldList,List<String> sumFieldAliasList){
//        Set<String> fieldSet = new HashSet<>();
//        fieldSet.addAll(sumFieldList);
//        Object[] fieldSetArr = fieldSet.toArray();
//        Object[] fieldListArr = sumFieldList.toArray();
//        Object[] aliListArr = sumFieldAliasList.toArray();
//
//        Map<String,String> map = new HashMap<>();
//        for (int i=0;i<fieldListArr.length;i++){
//            map.put(fieldListArr[i].toString(),aliListArr[i].toString());
//        }
//        for (int i=0;i<fieldSetArr.length;i++){
//            String tmp = map.get(fieldSetArr[i]);
//            fieldSetArr[i] = tmp;
//        }
//        //返回别名数组
//        return fieldSetArr;
//    }


//    static Object[] unifyOrder(List<String> sumFieldList,List<String> sumFieldAliasList){
//        Set<String> fieldSet = new HashSet<>();
//        fieldSet.addAll(sumFieldList);
////        Object[] fieldSetArr = fieldSet.toArray();
//        Object[] fieldListArr = sumFieldList.toArray();
//        Object[] aliListArr = sumFieldAliasList.toArray();
//
//        System.out.println(fieldListArr.length);
//        System.out.println(aliListArr.length);
//
//        Map<String,String> map = new HashMap<>();
//        List<String> indexList = new ArrayList<>();
//        for (int i=0;i<fieldListArr.length;i++){
//            System.out.println("fieldListArr[i]"+fieldListArr[i]);
//            if (null == fieldListArr[i]){
//                indexList.add(String.valueOf(i));
//                map.put("IndexMark"+i,aliListArr[i].toString());
//            }else {
//                map.put(fieldListArr[i].toString(),aliListArr[i].toString());
//            }
//
//        }
//        System.out.println("map"+map);
//        System.out.println("indexLsit"+indexList);
//        for (int i=0;i<fieldSetArr.length;i++){
//            System.out.println("fieldSetArr"+fieldSetArr[i]);
//            String tmp = new String();
//            if (null == fieldSetArr[i]){
//                tmp = map.get("IndexMark"+indexList.get(i));
//            }else {
//                tmp = map.get(fieldSetArr[i]);
//            }
//
//            fieldSetArr[i] = tmp;
//        }
//        //返回别名数组
//        return fieldSetArr;
//    }
}
