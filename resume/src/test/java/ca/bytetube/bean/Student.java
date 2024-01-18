package ca.bytetube.bean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

public class Student extends Person<String, Integer> implements Inter1<Integer,Double,Long>,
        Inter2<String, Date> {
    public static void main(String[] args) {
//        String className = this.getClass().getName();
//        System.out.println(className);
        Student student = new Student();
        //ca.bytetube.bean.Person<java.lang.String, java.lang.Integer>
        student.printSuperGenericType();
    }

    public void printSuperGenericType() {
        ParameterizedType superclassType = (ParameterizedType) this.getClass().getGenericSuperclass();
        System.out.println(superclassType);
        Type[] actualTypeArguments = superclassType.getActualTypeArguments();
        for (Type arg :actualTypeArguments) {
            System.out.println(arg);
        }

    }

    public void printInterGenericType() {
        Type[] genericInterfacesTpes = this.getClass().getGenericInterfaces();
        for (Type type :genericInterfacesTpes) {
            ParameterizedType interfaceType = (ParameterizedType)type;
            Type[] actualTypeArguments = interfaceType.getActualTypeArguments();
            for (Type arg :actualTypeArguments) {
                System.out.println(arg);
            }
        }
    }

}
