package com.stone.dagger.demo.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * desc   :
 * author : stone
 * email  : aa86799@163.com
 * time   : 23/02/2017 15 27
 */
@Scope
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RUNTIME)
@interface ActivityScope {
}

/*
javax.inject.Singleton
自动使用@Scope
 */
//@Scope
//@Documented
//@Retention(RUNTIME)
//public @interface Singleton {
//}