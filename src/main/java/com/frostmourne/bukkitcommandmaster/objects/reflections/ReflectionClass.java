package com.frostmourne.bukkitcommandmaster.objects.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionClass<T> {

    private final Class<? extends T> clazz;

    public Class<? extends T> getClazz() {
        return clazz;
    }

    public ReflectionClass(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public T newInstance(Object... objects){
        Class<?>[] array = Arrays.stream(objects).map(Object::getClass).toArray(Class[]::new);
        Constructor<? extends T> declaredConstructor = null;
        try {
            declaredConstructor = this.clazz.getDeclaredConstructor(array);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objects);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object invoke(T inst,String methodName,Object... objects){
        Class<?>[] array = Arrays.stream(objects).map(Object::getClass).toArray(Class[]::new);
        try {
            Method declaredMethod = clazz.getDeclaredMethod(methodName, array);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(inst,objects);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object get(T inst,String fieldName){
        try {
            Field declaredField = clazz.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField.get(inst);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void set(T inst,String fieldName,Object value){
        try {
            Field declaredField = clazz.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            declaredField.set(inst,value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
