package com.line.utils;

import com.line.exception.ErrorCode;
import com.line.exception.ErrorCodeException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 获取到的List<Map>结果集转化为JavaBean工具类
 * @author suny
 * @date 2017-7-4
 * <pre>
 *  desc:
 * </pre>
 */
public class BeanUtils<T> {

    /**
     * 根据List<Map<String, Object>>数据转换为JavaBean数据
     * @param datas
     * @param beanClass
     * @return
     */
    public List<T> ListMap2JavaBean(List<Map<String, Object>> datas, Class<T> beanClass)  {
        // 返回数据集合
        List<T> list = null;
        // 对象字段名称
        String fieldname = "";
        // 对象方法名称
        String methodname = "";
        // 对象方法需要赋的值
        Object methodsetvalue = "";
        try {
            list = new ArrayList<T>();
            // 得到对象所有字段
            Field fields[] = beanClass.getDeclaredFields();
            // 遍历数据
            for (Map<String, Object> mapdata : datas) {
                // 创建一个泛型类型实例
                T t = beanClass.newInstance();
                // 遍历所有字段，对应配置好的字段并赋值
                for (Field field : fields) {
                    if(null != field) {
                        // 全部转化为大写
                        String dbfieldname = StringUtils.toMapKey(field.getName());
                        // 获取字段名称
                        fieldname = field.getName();
                        // 拼接set方法
                        methodname = "set" + StringUtils.capitalize(fieldname);
                        // 获取data里的对应值
                        methodsetvalue = mapdata.get(dbfieldname);
                        // 赋值给字段
                        Method m = beanClass.getDeclaredMethod(methodname, field.getType());
                        Object object = getMyType(methodsetvalue);
                        m.invoke(t, object);
                    }
                }
                // 存入返回列表
                list.add(t);
            }
        } catch (Exception e) {
            throw new ErrorCodeException(ErrorCode.REFLEX_ERR);
        }
        // 返回
        return list;
    }

    private Object getMyType(Object o) throws ClassNotFoundException {
        if(o instanceof BigInteger){
            o = ((BigInteger) o).longValue();
        }
        return o;
    }

}