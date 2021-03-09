package t;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AnnotationTool {

    /**
     * 获取打了Desc注解的字典属性列表
     * @return 字典属性列表
     */
    public static <T> List<FixedVo> getFixedVoList(Class<T> c) {
        if (c == null) {
            return Collections.emptyList();
        }
        try {
            T cls = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            List<FixedVo> fixedVoList = new LinkedList<FixedVo>();
            for (Field field : fields) {
                Excel desc = field.getAnnotation(Excel.class);
                if (desc != null) {
                    FixedVo vo = new FixedVo();
                    //vo.setKey(field.getInt(cls));
                    vo.setValue(desc.name());
                    vo.setRemark(field.getName());
                    fixedVoList.add(vo);
                }
            }
            return fixedVoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
