package whynot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: BONC -  SortDimensionTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class SortDimensionTest {
    public static void main(String[] args) {
        List<String> dimensionList = new ArrayList<>();
        dimensionList.add("90AAAAAA");
        dimensionList.add("30AAAAAA");
        System.out.println(dimensionList);
        String sortedDim = sortDimensionList(Arrays.asList(new String[]{"20AAAAAA", "30AAAAAA", "40AAAAAA", "90AAAAAA", "**"}),dimensionList);
        System.out.println(sortedDim);
    }
    private static String sortDimensionList(List<String> standardList,List<String> dimensionList){
        StringBuffer stringBuffer = new StringBuffer();
        for (String standardDim:standardList){
            if (dimensionList.contains(standardDim)){
                if (stringBuffer.length()==0){
                    stringBuffer.append(standardDim);
                }else {
                    stringBuffer.append("-");
                    stringBuffer.append(standardDim);
                }
            }
        }
        return stringBuffer.toString();
    }
}
