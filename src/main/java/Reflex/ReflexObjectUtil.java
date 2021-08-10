package Reflex;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class ReflexObjectUtil {
    private static List<Object> packagingClass = new ArrayList<>();
    static {
        packagingClass.add(Byte.class);
        packagingClass.add(Short.class);
        packagingClass.add(Integer.class);
        packagingClass.add(Long.class);
        packagingClass.add(Float.class);
        packagingClass.add(Double.class);
        packagingClass.add(Character.class);
        packagingClass.add(Boolean.class);
        packagingClass.add(String.class);
    }

    /**
     * 将指定对象的属性 全部转换成 目标对象的String类型
     *
     * @param sourceObj 来源对象
     * @param desObj 目标对象
     * @return
     */
    public static Object sourceObjFieldToDesObjFieldStr(Object sourceObj, Object desObj) {
        // 获取来源类对象
        Class sourceObjClass = sourceObj.getClass();
        /* 来源类中的所有属性集合 */
        Field[] sourceObjClassDeclaredFields = sourceObjClass.getDeclaredFields();

        // 获取目标类对象
        Class desObjClass = desObj.getClass();
        /* 目标类中的所有属性集合 */
        Field[] desObjClassDeclaredFields = desObjClass.getDeclaredFields();

        for (int i = 0; i < sourceObjClassDeclaredFields.length; i++) {
            Field sourceObjClassDeclaredField = sourceObjClassDeclaredFields[i];
            // 设置属性可访问
            sourceObjClassDeclaredField.setAccessible(true);
            // 获取来源类的属性值
            Object sourceVal = null;
            try {
                sourceVal = sourceObjClassDeclaredField.get(sourceObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (null !=sourceVal) {
                for (int j = 0; j < desObjClassDeclaredFields.length; j++) {
                    try {
                        Field desObjClassDeclaredField = desObjClassDeclaredFields[j];
                        // 设置属性可访问
                        desObjClassDeclaredField.setAccessible(true);
                        // 属性名相同
                        if (desObjClassDeclaredField.getName().equals(sourceObjClassDeclaredField.getName())) {
                            // 获取来源类属性的对象类型
                            Class<?> type = sourceObjClassDeclaredField.getType();
                            // 如果是基本类型/包装类型/BigDecimal 直接转换为 String
                            if (type.isPrimitive() || packagingClass.contains(type)|| type.equals(BigDecimal.class)) {
                                sourceVal = String.valueOf(sourceVal);
                            } else if (type.equals(Date.class)) {
                                Date date = (Date) sourceVal;
                                //sourceVal = ThreadSafeDateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
                            }
                            // 设置目标类的属性值
                            desObjClassDeclaredField.set(desObj, sourceVal);
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return desObj;
    }

    /**
     * 单个对象的某个键的值
     *
     * @param obj 对象
     * @param key 键
     * @return Object 键在对象中所对应得值 没有查到时返回空字符串
     */
    public static Object getValueByKey(Object obj, String key) {
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            try {

                if (f.getName().endsWith(key)) {
                    System.out.println("单个对象的某个键的值==反射==" + f.get(obj));
                    return f.get(obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        // 没有查到时返回空字符串
        return "";
    }

    /**
     * 多个（列表）对象的所有键值
     *
     * @param object
     * @return
     */
    public static List<Map<String, Object>> getKeysAndValues(List<Object> object) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Object obj : object) {
            Class userCla;
            // 得到类对象
            userCla = (Class) obj.getClass();
            /* 得到类中的所有属性集合 */
            Field[] fs = userCla.getDeclaredFields();
            Map<String, Object> listChild = new HashMap<String, Object>();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                Object val = new Object();
                try {
                    val = f.get(obj);
                    // 得到此属性的值
                    listChild.put(f.getName(), val);// 设置键值
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            list.add(listChild);// 将map加入到list集合中
        }
        System.out.println("多个（列表）对象的所有键值====" + list.toString());
        return list;
    }

    /**
     * 多个（列表）对象的某个键的值
     *
     * @param object
     * @param key
     * @return
     */
    public static List<Object> getValuesByKey(List<Object> object, String key) {
        List<Object> list = new ArrayList<Object>();
        for (Object obj : object) {
            // 得到类对象
            Class userCla = (Class) obj.getClass();
            /* 得到类中的所有属性集合 */
            Field[] fs = userCla.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                try {
                    if (f.getName().endsWith(key)) {
                        list.add(f.get(obj));
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("多个（列表）对象的某个键的值列表====" + list.toString());
        return list;
    }
}
