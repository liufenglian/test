package easypoi;

import java.util.List;
import java.util.Map;

public class MultiSheetDTO {

    /**
     * sheet名称
     */
    private String sheetName;

    /**
     * 导出数据
     */
    private List<Map<String,Object>> dataList;

    /**
     * 导出列属性
     */
    private List<ExcelExportDTO> excelRows;

    /**
     * title
     */
    private String title;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<Map<String, Object>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }

    public List<ExcelExportDTO> getExcelRows() {
        return excelRows;
    }

    public void setExcelRows(List<ExcelExportDTO> excelRows) {
        this.excelRows = excelRows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
