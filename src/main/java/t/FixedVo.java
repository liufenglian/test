package t;

public class FixedVo {
    public String value;
    public String remark;



    public String getValue() {
        return value;
    }

    public String getRemark() {
        return remark;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return '"'+remark+'"'+":"+'"'+value+'"'+",";
    }

}
