package easypoi;

import lombok.Data;

@Data
public class ExcelExportDTO {

    private String lineName;

    private String fieldName;

    private boolean  needMerge =false;

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


}
