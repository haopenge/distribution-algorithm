package com.uu.mybatis.official.util;

import com.google.common.collect.Lists;
import com.uu.mybatis.official.domain.ModifyModel;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Yann.Long on 2015/9/23.
 */
@Slf4j
public class ModelHelper {

    public static <T> void buildCreateAndModify(T model, ModifyModel modifyModel) {
        Class<?> tClass = model.getClass();

        boolean isCreate = true;

        Field ctimeField = null;
        ctimeField = getField(modifyModel.getCreateTime(), tClass);
        if (ctimeField == null) {
            ctimeField = getField(modifyModel.getCTime(), tClass);
        }
        if (ctimeField == null) {
            return;
        }

        try {
            Field idField = getField(modifyModel.getId(), tClass);

            ctimeField.setAccessible(true);
            Date createdTime = (Date) ctimeField.get(model);

            if (createdTime != null && createdTime.getTime() > 0) {
                isCreate = false;
            }

            if (idField != null){
                idField.setAccessible(true);
                Object id = idField.get(model);
                if (id != null){
                    if (!"0".equals(String.valueOf(id))){
                        isCreate = false;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }


        List<Field> fields = Lists.newArrayList();
        getAllFields(fields, tClass);
        //List<Field> fields = Arrays.asList(tClass.getDeclaredFields());
        for (Field field : fields) {
            Type t = field.getType();
            field.setAccessible(true);
            try {
                if (isCreate) {
                    if (field.getName().equals(modifyModel.getCId())) {
                        field.set(model, modifyModel.getEmployeeId());
                    }
                    if (field.getName().equals(modifyModel.getCName())) {
                        field.set(model, modifyModel.getEmployeeName());
                    }
                    if (field.getName().equals(modifyModel.getCTime())) {
                        field.set(model, (modifyModel.getOpTime()==null?new Date():modifyModel.getOpTime()));
                    }
                    if (field.getName().equals(modifyModel.getCreatorId())) {
                        field.set(model, modifyModel.getEmployeeId());
                    }
                    if (field.getName().equals(modifyModel.getCreatorName())) {
                        field.set(model, modifyModel.getEmployeeName());
                    }
                    if (field.getName().equals(modifyModel.getCreateTime())) {
                        field.set(model, (modifyModel.getOpTime()==null?new Date():modifyModel.getOpTime()));
                    }
                }
                if (field.getName().equals(modifyModel.getMId())) {
                    field.set(model, modifyModel.getEmployeeId());
                }
                if (field.getName().equals(modifyModel.getMName())) {
                    field.set(model, modifyModel.getEmployeeName());
                }
                if (field.getName().equals(modifyModel.getMTime())) {
                    field.set(model, (modifyModel.getOpTime()==null?new Date():modifyModel.getOpTime()));
                }
                if (field.getName().equals(modifyModel.getModifierId())) {
                    field.set(model, modifyModel.getEmployeeId());
                }
                if (field.getName().equals(modifyModel.getModifierName())) {
                    field.set(model, modifyModel.getEmployeeName());
                }
                if (field.getName().equals(modifyModel.getUpdateTime())) {
                    field.set(model, (modifyModel.getOpTime()==null?new Date():modifyModel.getOpTime()));
                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public static <T> void buildModify(T model, ModifyModel modifyModel) {
        Class<?> tClass = model.getClass();
        List<Field> fields = Lists.newArrayList();
        getAllFields(fields, tClass);
        for (Field field : fields) {
            Type t = field.getType();
            field.setAccessible(true);
            try {

                if (field.getName().equals(modifyModel.getMId())) {
                    field.set(model, modifyModel.getEmployeeId());
                }
                if (field.getName().equals(modifyModel.getMName())) {
                    field.set(model, modifyModel.getEmployeeName());
                }
                if (field.getName().equals(modifyModel.getMTime())) {
                    field.set(model, (modifyModel.getOpTime()==null?new Date():modifyModel.getOpTime()));
                }
                if (field.getName().equals(modifyModel.getModifierId())) {
                    field.set(model, modifyModel.getEmployeeId());
                }
                if (field.getName().equals(modifyModel.getModifierName())) {
                    field.set(model, modifyModel.getEmployeeName());
                }
                if (field.getName().equals(modifyModel.getUpdateTime())) {
                    field.set(model, (modifyModel.getOpTime()==null?new Date():modifyModel.getOpTime()));
                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            fields = getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static Field getField(String fieldName, Class<?> clazz) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (clazz.getSuperclass() != null) {
                return getField(fieldName, clazz.getSuperclass());
            }
        }
        return null;
    }

}
