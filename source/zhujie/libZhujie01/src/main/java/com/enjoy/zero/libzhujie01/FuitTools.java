package com.enjoy.zero.libzhujie01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * [享学课堂] {@link https://enjoy.ke.qq.com}
 * 学无止境，让学习成为一种享受
 * TODO: 主讲Zero老师QQ 2124346685
 * TODO: 往期课程咨询芊芊老师QQ 2130753077
 * TODO: VIP课程咨询伊娜老师QQ 2133576719
 * 类说明:获取水果注解信息的工具类
 */
public class FuitTools {

    public static void getFruitInfo(Class<?> clazz) {

        // TODO: 使用反射获取所有字段
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println("水果名称: " + fruitName.value());
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println("fruitColor: " + fruitColor.fruitColor());
            } else if (field.isAnnotationPresent(FruitProducerFactory.class)) {
                FruitProducerFactory fruitProducerFactory = field.getAnnotation(FruitProducerFactory.class);
                System.out.println("fruitProducerFactory id: " + fruitProducerFactory.id() + " name: " + fruitProducerFactory.name() +
                        " address: " + fruitProducerFactory.address());
            }
        }
        System.out.println("=======");
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation: annotations){
            System.out.println("annotation: " + annotation);
        }

    }
}
