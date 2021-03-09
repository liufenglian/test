package t;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 收件
* */
@Data
public class ReceiptScanInfoExportDTO{
    @Excel(name = "Quét số đơn đặt hàng")
    private String billCode;
    @Excel(name = "Người nhận")
    private String  dispatchOrSendManName;
    @Excel(name = "Điểm đến")
    private String  destinationOutletName;
    @Excel(name = "Thời gian quét")
    @JsonFormat(pattern =  "yyyy-MM-dd HH:mm:ss")
    private String scanDate;
    @Excel(name = "Quét chấm")
    private String scanSiteName;
    @Excel(name = "Quét mọi người")
    private String scanManName;
    @Excel(name = "Trạng thái dữ liệu",replace = {"sự khởi tạo_0", "Để được xác nhận_1","Xác minh thành công_2","Xác minh không hoàn thành_3","Được tải lên_4","Tải lên thành công_5","Tải lên thất bại_6"} )
    private String dataStatus;
}
