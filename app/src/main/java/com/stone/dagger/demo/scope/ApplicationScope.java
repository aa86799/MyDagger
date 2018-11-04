package com.stone.dagger.demo.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * desc     :
 * author   : stone
 * homepage : http://stone86.top
 * email    : aa86799@163.com
 * time     : 2018/11/4 10 10
 */
@Scope
@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface ApplicationScope {
}
