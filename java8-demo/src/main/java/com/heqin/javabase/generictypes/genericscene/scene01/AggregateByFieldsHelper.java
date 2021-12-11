package com.heqin.javabase.generictypes.genericscene.scene01;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://javainterview.gitee.io/luffy/2021/08/19/01-Java%E5%9F%BA%E7%A1%80/02.%20%E6%B3%9B%E5%9E%8B/
 * <p>
 * 候选者：回到我所讲的组件吧，背景是这样的：我这边有个需求，需要根据某些字段进行聚合。
 * 候选者：换到 SQL 其实就是select sum(column1),sum(column2) from table group by field1,field2
 *
 * @Author heqin
 * @Date 2021/11/3 19:46
 */
public class AggregateByFieldsHelper<T> {

    private static final Logger logger = LoggerFactory.getLogger(AggregateByFieldsHelper.class);

    private List<String> groupByKeys;

    private List<String> sumValues;

    private Map<Object, T> primaryMap = new HashMap<>();

    // 传入 需要group by 和 sum 的字段名
    public AggregateByFieldsHelper(List<String> groupByKeys, List<String> sumValues) {
        this.groupByKeys = groupByKeys;
        this.sumValues = sumValues;
    }

    public Map<Object, T> getPrimaryMap() {
        return primaryMap;
    }

    public void excute(T e) {
        // 从pojo 取出需要group by 的字段 list
        List<Object> key = buildPrimaryKey(e);

        // primaryMap 是存储结果的Map
        T value = primaryMap.get(key);

        // 如果从存储结果找到有相应记录
        if (value != null) {
            for (String sumValue : sumValues) {
                // 反射获取对应的字段，做累加处理
                Field field = getDeclaredField(sumValue, e);
                field.setAccessible(true);
                try {
                    if (field.get(e) instanceof Integer) {
                        field.set(value, (Integer) field.get(e) + (Integer) field.get(value));
                    } else if (field.get(e) instanceof Long) {
                        field.set(value, (Long) field.get(e) + (Long) field.get(value));
                    } else {
                        throw new RuntimeException("类型异常,请处理异常");
                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            // group by 字段 第一次进来
            try {
                T e2Copy = ObjectUtil.cloneByStream(e);
                primaryMap.put(key, (T) e2Copy);
            } catch (Exception ex) {
                logger.info("first put value error {}", e);
            }
        }
    }

    private List<Object> buildPrimaryKey(T e) {
        List<Object> list = new ArrayList<>();
        Class<?> clazz = e.getClass();
        list.add(clazz);
        Field[] declaredFields = clazz.getDeclaredFields();
        for (String groupByKey : groupByKeys) {
            for (Field field : declaredFields) {
                if (groupByKey.equals(field.getName())) {
                    list.add(groupByKey);
                    try {
                        field.setAccessible(true);
                        Object fieldValue = field.get(e);
                        list.add(fieldValue);
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return list;
    }

    private Field getDeclaredField(String name, T e) {
        Class<?> clazz = e.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField(name);
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        }
        return field;
    }
}
