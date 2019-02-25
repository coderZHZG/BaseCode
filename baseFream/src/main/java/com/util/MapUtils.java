package com.util;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.apache.ibatis.type.SimpleTypeRegistry.isSimpleType;

public class MapUtils {

    //缓存类的字段
    private static Map<String,List<Field>> cache = new HashMap<>();


    /**
     * 深层次将对象转变为Map递归下去
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public static Map<String, Object> reflectBeanToMap(Object bean) throws Exception {
        List<Field> fields = listAllFields(bean.getClass());
        if (fields == null || fields.size() == 0)
            return null;
        Map<String, Object> map = new HashMap<>();
        for (Field field : fields) {
            String name = field.getName();
            Object value = field.get(bean);
            if (StringUtils.isEmpty(value))
                continue;
            if (isSimpleType(field.getType())) {// 如果为基本类型
                map.put(name, value);
            } else {
                Map<String, Object> tempMap = reflectBeanToMap(value);
                map.put(name, tempMap);
            }
        }
        return map;
    }

    /**
     * 列出该类及其子类下面所以得非静态字段
     *
     * @param clazz
     * @return
     */
    public static List<Field> listAllFields(Class clazz) {
        List<Field> result = cache.get(clazz.getName());
        if(result!=null)
            return result;
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0)
            return null;
        result = new LinkedList<>();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()))
                continue;
            field.setAccessible(true);
            result.add(field);
        }
        if (clazz.getSuperclass() != null) {
            List<Field> temps = listAllFields(clazz.getSuperclass());
            if(temps!=null)
                result.addAll(temps);
        }
        cache.put(clazz.getName(), result);
        return result;
    }


}
