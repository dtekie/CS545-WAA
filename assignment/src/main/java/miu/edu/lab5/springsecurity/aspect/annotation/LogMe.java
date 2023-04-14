package miu.edu.lab5.springsecurity.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface LogMe {
}
