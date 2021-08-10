package easypoi;

import cn.afterturn.easypoi.entity.vo.MapExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import cn.afterturn.easypoi.excel.ExcelExportUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelExportUtils {
    /**
     * 选择列导出（单sheet）
     *
     * @param fileNameUrl 文件导出服务器路径
     * @param sheetName   sheet名称
     * @param dataList    数据list（map封装）
     * @param excelRows   导出的选择的列
     * @param title       标题(为空就传null)
     */
    public static void exportExcel(String fileNameUrl, String sheetName, List<Map<String, Object>> dataList, List<ExcelExportDTO> excelRows, String title) throws Exception {
        // 使用easypoi中的ExcelExportEntity对象存储要导出的列
        List<ExcelExportEntity> entityList = new ArrayList<>();
        excelRows.forEach(item -> {
            ExcelExportEntity exportEntity = new ExcelExportEntity(item.getLineName(), item.getFieldName());
            exportEntity.setHeight(item.getHeight());
            exportEntity.setWidth(item.getWidth());
            entityList.add(exportEntity);
        });
        // 执行方法
        ExportParams exportParams = new ExportParams(null, sheetName, ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entityList, dataList);
        String fileName = fileNameUrl;
        File file = new File(fileName);
        try {
            FileOutputStream fout = new FileOutputStream(file);
            workbook.write(fout);
            fout.close();
        } catch (Exception e) {
            log.error("导出失败-----------------------------------");
            throw new Exception("导出失败！");
        }
    }

    /**
     * 多sheet导出
     *
     * @param fileNameUrl       文件导出服务器路径
     * @param multiSheetDTOList 多sheet中的属性
     */
    public static void exportMultiSheetExcel(String fileNameUrl, List<MultiSheetDTO> multiSheetDTOList) throws Exception {
        try {
            Workbook workbook = new HSSFWorkbook();
            // 遍历sheet
            for (MultiSheetDTO multiSheetDTO : multiSheetDTOList) {
                ExcelExportService server = new ExcelExportService();
                ExportParams exportParams = new ExportParams(multiSheetDTO.getTitle(), multiSheetDTO.getSheetName(), ExcelType.XSSF);
                List<ExcelExportEntity> entityList = new ArrayList<>();
                multiSheetDTO.getExcelRows().forEach(item -> {
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
        } catch (Exception e) {
            log.error("导出失败-----------------------------------");
            throw new Exception("导出失败！");
        }
    }


    public static void main(String[] args) {
        String fileNameUrl = "C:/Users/liufenglian9212/Desktop/工作文档/价格分析表.xls";
     /*   List<Map<String,Object>> dataList = new ArrayList<>();
        Map<String,Object> data = new HashMap<>();
        data.put("goodsName","奥特曼玩具");
        data.put("goodsNum", "12");
        dataList.add(data);
        List<ExcelExportDTO> excelRows = new ArrayList<>();
        ExcelExportDTO excelExportDTO = new ExcelExportDTO();
        excelExportDTO.setFieldName("goodsName");
        excelExportDTO.setLineName("商品名称");
        ExcelExportDTO excelExportDTO1 = new ExcelExportDTO();
        excelExportDTO1.setFieldName("goodsNum");
        excelExportDTO1.setLineName("商品數量");
        excelRows.add(excelExportDTO1);
        excelRows.add(excelExportDTO);


        String title = "test";
        try {
            exportExcel(fileNameUrl,"test",dataList,excelRows,title);
        }catch (Exception e){
            System.out.println(e);
        }*/


        List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
        excelentity.setNeedMerge(true);
        entity.add(excelentity);
        ExcelExportEntity  entity1 = new ExcelExportEntity("性别", "sex");
        entity1.setNeedMerge(true);
        entity.add(entity1);
        excelentity = new ExcelExportEntity(null, "students");
        List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
        temp.add(new ExcelExportEntity("课程", "cou"));
        temp.add(new ExcelExportEntity("老师", "tu"));
        excelentity.setList(temp);
        entity.add(excelentity);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("name", "1" + i);
            map.put("sex", "2" + i);

            List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<>();
            map1.put("cou",i);
            map1.put("tu",i+"tu");
            Map<String, Object> map2 = new HashMap<>();
            map2.put("cou",i);
            map2.put("tu",i+"tu");
            Map<String, Object> map3 = new HashMap<>();
            map3.put("cou",i);
            map3.put("tu",i+"tu");
            tempList.add(map1);
            tempList.add(map2);
            tempList.add(map3);
            map.put("students", tempList);
            list.add(map);
        }

        ExportParams exportParams = new ExportParams(null, "123123", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entity, list);
        String fileName = fileNameUrl;
        File file = new File(fileName);
        try {
            FileOutputStream fout = new FileOutputStream(file);
            workbook.write(fout);
            fout.close();
        } catch (Exception e) {
            log.error("导出失败-----------------------------------");
        }

    }
}


