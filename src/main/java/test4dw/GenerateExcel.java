package test4dw;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by zg on 2017/10/26.
 */
public class GenerateExcel {
    /**
     * (2003 xls后缀 导出)
     *
     * @return void 返回类型
     * @author xsw
     * @2016-12-7上午10:44:00
     */
    public static void createXLS() throws IOException {
        //excel模板路径
        File fi = new File("D:\\test2.xlsx");
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
        //读取excel模板
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        //读取了模板内所有sheet内容
        HSSFSheet sheet = wb.getSheetAt(0);
        //如果这行没有了，整个公式都不会有自动计算的效果的
        sheet.setForceFormulaRecalculation(true);

        //在相应的单元格进行赋值
        HSSFCell cell = sheet.getRow(11).getCell(6);//第11行 第6列
        cell.setCellValue(1);
        HSSFCell cell2 = sheet.getRow(11).getCell(7);
        cell2.setCellValue(2);
        sheet.getRow(12).getCell(6).setCellValue(12);
        sheet.getRow(12).getCell(7).setCellValue(12);
        //修改模板内容导出新模板
        FileOutputStream out = new FileOutputStream("D:/export.xls");
        wb.write(out);
        out.close();
    }

    /**
     * (2007 xlsx后缀 导出)
     *
     * @return void 返回类型
     * @author xsw
     * @2016-12-7上午10:44:30
     */
    public static void createXLSX() throws IOException {
        //excel模板路径
        File fi = new File("C:/Users/毛/Desktop/test2.xlsx");
        InputStream in = new FileInputStream(fi);
        //读取excel模板
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取了模板内所有sheet内容，读取第一个sheet
        XSSFSheet sheet = wb.getSheetAt(0);
        //设置居中
        CellStyle styleCenter = wb.createCellStyle();
        styleCenter.setAlignment(HorizontalAlignment.CENTER);
        //如果这行没有了，整个公式都不会有自动计算的效果的
        sheet.setForceFormulaRecalculation(true);

        //在相应的单元格进行赋值
        for (int i = 0; i < 14; i++) {//14*100*100
            //从第3行开始填充
            XSSFRow row = sheet.createRow(i + 2);
            //当日值
            row.createCell(6).setCellValue(2);
            //本月累计
            row.createCell(7).setCellValue(10);
            //上月累计
            row.createCell(8).setCellValue(22);
            //去年同期月累计
            row.createCell(9).setCellValue(14);
            //TODO 如果动态获取当列名称困难，可以暂存需要计算的数据进行计算
            //累计环比，设置合计公式
//            row.createCell(10).setCellType(HSSFCell.CELL_TYPE_FORMULA);
            row.createCell(10).setCellFormula("ROUND((H" + (i + 3) + "-I" + (i + 3) + ")/I" + (i + 3) + ", 2)");
            //累计同比，设置合计公式
//            row.createCell(11).setCellType(HSSFCell.CELL_TYPE_FORMULA);
            row.createCell(11).setCellFormula("ROUND((H" + (i + 3) + "-J" + (i + 3) + ")/J" + (i + 3) + ", 2)");
        }
        //要求结果隐藏上月累计和去年同期累计
        sheet.setColumnHidden(8, true);
        sheet.setColumnHidden(9, true);
        //修改模板内容导出新模板
        FileOutputStream out = new FileOutputStream("C:/Users/毛/Desktop/export.xlsx");
        wb.write(out);
        out.close();
    }

    public static String generateExcel(String json) throws IOException, ExecutionException, InterruptedException {
        String basePath = "D:/";
        String resultPath = "";
        try {
            String sourceDir = basePath + File.separator + "12321321";
            File dir = new File(sourceDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String sourceFilename = "test" + ".xls";

            Workbook wb = new HSSFWorkbook();
            File sourceFile = new File(sourceDir + File.separator + sourceFilename);
            FileOutputStream fileOut = new FileOutputStream(sourceFile);
            int rowNum = 0;
            //创建sheet
            Sheet sheet1 = wb.createSheet("test");
            //设置默认列宽
            sheet1.setDefaultColumnWidth(13);
            //设置居中
            CellStyle styleCenter = wb.createCellStyle();
            styleCenter.setAlignment(HorizontalAlignment.CENTER);

            Cell cellTitle = sheet1.createRow(rowNum++).createCell(0);
            cellTitle.setCellValue("test");
            cellTitle.setCellStyle(styleCenter);
            // 合并单元格，来放title
            sheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
            //String[][] values=condition.getValue();
            String[][] values = new String[10][10];
            values[0][0] = "100";
            values[0][1] = "101";
            values[1][0] = "100.23";
            values[1][1] = "100.11";
            for (String[] arrayTemp : values) {
                Row rowValue = sheet1.createRow(rowNum++);
                for (int i = 0; i < arrayTemp.length; i++) {
                    Cell cell = rowValue.createCell(i);
                    cell.setCellValue(arrayTemp[i]);
                }
            }

            //ExcelBean.Table table=bean.getTable();
            //String[][] tableTitle=table.getTitle();
            //String[][] tableValue=table.getValue();
            String[][] tableTitle = new String[10][10];
            String[][] tableValue = new String[10][10];
            tableValue[0][0] = "1612148.79";
            tableValue[0][1] = "10,111";
            tableValue[1][0] = "18,107.47";
            tableValue[1][1] = "10,011.11";

            //设置字体加粗和居中,用来给表头
            CellStyle styleBold = wb.createCellStyle();
            styleBold.setAlignment(HorizontalAlignment.CENTER);
            Font font = wb.createFont();
            font.setBold(true);
            styleBold.setFont(font);
            //给excel设置表格的头
            for (String[] arrayTemp : tableTitle) {
                Row row = sheet1.createRow(rowNum++);
                for (int i = 0; i < arrayTemp.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(arrayTemp[i]);
                }
            }


            //给excel设置表格的数据
            for (String[] arrayTemp : tableValue) {
                Row row = sheet1.createRow(rowNum++);
                for (int i = 0; i < arrayTemp.length; i++) {
                    Cell contentCell = row.createCell(i);
                    //contentCell.setCellStyle(styleCenter);
                    //contentCell.setCellValue(arrayTemp[i]);
                    String data = arrayTemp[i];
                    //Double d = Double.parseDouble(data.toString());
                    //contentCell.setCellValue(d);
                    Boolean isNum = false;//data是否为数值型
                    Boolean isInteger = false;//data是否为整数
                    Boolean isPercent = false;//data是否为百分数
                    if (data != null || "".equals(data)) {
                        data = data.replace(",", "");
                        //判断data是否为数值型
                        isNum = data.toString().matches("^(-?\\d+)(\\.\\d+)?$");
                        //判断data是否为整数（小数部分是否为0）
                        isInteger = data.toString().matches("^[-\\+]?[\\d]*$");
                        //判断data是否为百分数（是否包含“%”）
                        isPercent = data.toString().contains("%");
                    }
                    CellStyle dataStyle = wb.createCellStyle();
                    //如果单元格内容是数值类型，涉及到金钱（金额、本、利），则设置cell的类型为数值型，设置data的类型为数值类型
                    if (isNum && !isPercent) {
                        DataFormat df = wb.createDataFormat(); // 此处设置数据格式
                        if (isInteger) {
                            dataStyle.setDataFormat(df.getFormat("###,###,###,###,##0"));//数据格式只显示整数
                        } else {
                            dataStyle.setDataFormat(df.getFormat("###,###,###,###,##0.00"));//保留两位小数点
                        }
                        // 设置单元格格式
                        contentCell.setCellStyle(dataStyle);

                        // 设置单元格内容为double类型
                        Double d = Double.parseDouble(data.toString());
                        contentCell.setCellValue(d);
                    } else {
                        contentCell.setCellStyle(dataStyle);
                        // 设置单元格内容为字符型
                        contentCell.setCellValue(data);
                    }
                }
            }

            //写入excel
            wb.write(fileOut);
            fileOut.close();
            return resultPath;
        } catch (Exception e) {
            //log.error("执行excel生成和加密时出错:{}",e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        //excle 2003
        //createXLS();
        //excle 2007
        List<Map<String,String>> dataList = new ArrayList<>();
        Map<String,String> map1 = new HashMap<String,String>(){{put("date","20171120");
            put("proId","011");put("cityId","20171120");put("channelType","电子渠道");
            put("productType","2I2C产品");put("serviceType","4G业务");put("kpiCode","CKP_23323");
            put("drz","123");put("bylj","123");put("sylj","123");put("qntq","123");}};
        Map<String,String> map2 = new HashMap<String,String>(){{put("date","20171120");
            put("proId","011");put("cityId","20171120");put("channelType","电子渠道");
            put("productType","2I2C产品");put("serviceType","4G业务");put("kpiCode","CKP_23333");
            put("drz","123");put("bylj","123");put("sylj","123");put("qntq","123");}};
        dataList.add(map1);
        dataList.add(map2);


        createXLSX();

    }
}
