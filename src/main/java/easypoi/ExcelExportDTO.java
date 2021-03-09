package easypoi;

public class ExcelExportDTO {

    private String lineName;

    private String fieldName;

    private Double width = 20D;

    private Double height = 10D;

    public ExcelExportDTO(){}

    public ExcelExportDTO(String lineName, String fieldName) {
        this.lineName = lineName;
        this.fieldName = fieldName;
    }

    public ExcelExportDTO(String lineName, String fieldName, Double width, Double height) {
        this.lineName = lineName;
        this.fieldName = fieldName;
        this.width = width;
        this.height = height;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}
