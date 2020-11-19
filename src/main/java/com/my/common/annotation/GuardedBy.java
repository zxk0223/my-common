package com.my.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在使用加锁的类中，应该说明那些状态变量由那些锁保护的，以及那些锁被用于保护这些变量。
 * 通过说明那些变量由那些锁来保护，避免由于疏忽导致的错误
 * Created by zhuxiaokang on 2018/3/20.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface GuardedBy {

    /**
     * lock的可能取值包括：
     * GuardedBy("this")：表示在包含对象上的内置锁（被标注的方法或域是该对象的成员）
     * GuardedBy("fieldName")：表示与fieldName引用的对象相关联的锁，可以是隐式锁（不引用Lock的域），也可以是显示锁（引用Lock的域）
     * GuardedBy("Class Name.fieldName")：类似于GuardedBy("fieldName")，但指向在另一个类的静态域中持有的对象
     * GuardedBy("methodName()")：指通过调用命名方法返回的锁对象
     * GuardedBy("ClassName.class")：指命名类的类字面量对象
     * @return
     */
     String value();
}
