package easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelExportUtils {
    /**
     * 选择列导出（单sheet）
     * @param fileNameUrl 文件导出服务器路径
     * @param sheetName sheet名称
     * @param dataList 数据list（map封装）
     * @param excelRows 导出的选择的列
     * @param title 标题(为空就传null)
     */
    public static void exportExcel(String fileNameUrl, String sheetName, List<Map<String,Object>> dataList, List<ExcelExportDTO> excelRows, String title) throws Exception{
        // 使用easypoi中的ExcelExportEntity对象存储要导出的列
        List<ExcelExportEntity> entityList = new ArrayList<>();
        excelRows.forEach(item->{
            ExcelExportEntity exportEntity = new ExcelExportEntity(item.getLineName(), item.getFieldName());
            exportEntity.setHeight(item.getHeight());
            exportEntity.setWidth(item.getWidth());
            entityList.add(exportEntity);
        });
        // 执行方法
        ExportParams exportParams = new ExportParams(null, sheetName, ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entityList ,dataList);
        String fileName = fileNameUrl;
        File file = new File(fileName);
        try{
            FileOutputStream fout = new FileOutputStream(file);
            workbook.write(fout);
            fout.close();
        }catch (Exception e){
            log.error("导出失败-----------------------------------");
            throw new Exception("导出失败！");
        }
    }

    /**
     * 多sheet导出
     * @param fileNameUrl 文件导出服务器路径
     * @param multiSheetDTOList 多sheet中的属性
     */
    public static void exportMultiSheetExcel(String fileNameUrl, List<MultiSheetDTO> multiSheetDTOList) throws Exception{
        try{
            Workbook workbook = new HSSFWorkbook();
            // 遍历sheet
            for (MultiSheetDTO multiSheetDTO:multiSheetDTOList){
                ExcelExportService server = new ExcelExportService();
                ExportParams exportParams = new ExportParams(multiSheetDTO.getTitle(), multiSheetDTO.getSheetName(), ExcelType.XSSF);
                List<ExcelExportEntity> entityList = new ArrayList<>();
                multiSheetDTO.getExcelRows().forEach(item->{
                    ExcelExportEntity exportEntity = new ExcelExportEntity(item.getLineName(), item.getFieldName());
                    exportEntity.setHeight(item.getHeight());
                    exportEntity.setWidth(item.getWidth());
                    entityList.add(exportEntity);
                });
                server.createSheetForMap(workbook, exportParams, entityList, multiSheetDTO.getDataList());
            }
            FileOutputStream fos = new FileOutputStream(fileNameUrl);
            workbook.write(fos);
            fos.close();
        }catch (Exception e){
            log.error("导出失败-----------------------------------");
            throw new Exception("导出失败！");
        }
    }


    public static void main(String[] args) {
        String fileNameUrl = "C:/Users/liufenglian9212/Desktop/工作文档/价格分析表.xls";
        List<Map<String,Object>> dataList = new ArrayList<>();
        Map<String,Object> data = new HashMap<>();
      /*  data.put("goodsName","奥特曼玩具");*/
       /* data.put("goodsNum","2");*/
        dataList.add(data);
        List<ExcelExportDTO> excelRows = new ArrayList<>();
        ExcelExportDTO excelExportDTO = new ExcelExportDTO();
       // excelExportDTO.setFieldName("goodsName");
        excelExportDTO.setLineName("商品名称");
        ExcelExportDTO excelExportDTO1 = new ExcelExportDTO();
        //excelExportDTO1.setFieldName("goodsNum");
        excelExportDTO1.setLineName("商品數量");
        excelRows.add(excelExportDTO1);
        excelRows.add(excelExportDTO);

        String title = "test";
        try {
            exportExcel(fileNameUrl,"test",dataList,excelRows,title);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}


