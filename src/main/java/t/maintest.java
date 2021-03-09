package t;

import java.util.List;

public class maintest {

    public static void main(String[] args) {
        List<FixedVo> voList = AnnotationTool.getFixedVoList(ReceiptScanInfoExportDTO.class);
        StringBuffer stringBuffer = new StringBuffer();
        for (FixedVo vo : voList) {
            stringBuffer.append(vo.toString());
        }
        System.out.println("{"+stringBuffer.toString().substring(0,stringBuffer.toString().length()-1)+"}");
    }
}
