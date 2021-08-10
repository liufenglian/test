package t;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 收件
* */
@Data
public class ReceiptScanInfoExportDTO{
    @Excel(name = "运单号")
    private String billCode;

    @Excel(name = "寄件日期",format = "yyyy-MM-dd HH:mm:ss")
    private Date recEmpDate;

    @Excel(name = "运单状态")
    private String billStatusDesc;

    @Excel(name = "数据来源")
    private String orderSourceDesc;

    @Excel(name = "签收日期",format = "yyyy-MM-dd HH:mm:ss")
    private Date signEmpDate;

    @Excel(name = "是否退件")
    private String isRefundDesc;

    @Excel(name = "截留状态")
    private String interruptStatusDesc;

    @Excel(name = "是否问题件")
    private String isIssueDesc;

    @Excel(name = "是否签收")
    private String isSignDesc;

    @Excel(name = "取件员")
    private String recEmp;

    @Excel(name = "派送方式")
    private String deliveryType;

    @Excel(name = "头程单号")
    private String firstWayNo;

    @Excel(name = "转单号")
    private String deliveryNo;

    @Excel(name = "运输方式")
    private String shipType;

    @Excel(name = "快递类型")
    private String expressType;

    @Excel(name = "包装件数")
    private Integer packageQty;

    @Excel(name = "录单重量")
    private BigDecimal netWeight;

    @Excel(name = "付款方式")
    private String payType;

    @Excel(name = "运费")
    private BigDecimal freightFee;

    @Excel(name = "到付款")
    private BigDecimal fcAmount;

    @Excel(name = "代收货款手续费")
    private BigDecimal agentServiceCharge;

    @Excel(name = "代收货款")
    private BigDecimal agentAmount;

    @Excel(name = "寄件网点")
    private String recSite;

    @Excel(name = "寄件一级网点")
    private String firstLevelRecSiteDesc;

    @Excel(name = "录单网点")
    private String optReceiveSite;

    @Excel(name = "派件网点")
    private String dispSite;

    @Excel(name = "寄件人")
    private String shipperName;

    @Excel(name = "寄件人公司")
    private String shipperCompany;

    @Excel(name = "寄件人地址")
    private String shipperAddress;

    @Excel(name = "寄件人电话")
    private String shipperMobile;

    @Excel(name = "目的地网点")
    private String destinationSite;

    @Excel(name = "收件人")
    private String consigneeName;

    @Excel(name = "收件人公司")
    private String consigneeCompany;

    @Excel(name = "收件社/坊/镇")
    private String consigneeDistrict;

    @Excel(name = "收件市/郡/县")
    private String consigneeCity;

    @Excel(name = "收件省份")
    private String consigneeProvince;

    @Excel(name = "收件人地址")
    private String consigneeAddress;

    @Excel(name = "收件人电话")
    private String consigneeMobile;

    @Excel(name = "录单时间",format = "yyyy-MM-dd HH:mm:ss")
    private Date optReceiveDate;

    @Excel(name = "录单人")
    private String  optReceiveEmp;

    @Excel(name = "物品类型")
    private String packageType;
    @Excel(name = "安检规则")
    private String explainDesc;

    @Excel(name = "物品名称")
    private String name;

    @Excel(name = "备注")
    private String remark;


}
