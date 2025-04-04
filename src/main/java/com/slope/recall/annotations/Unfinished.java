package com.slope.recall.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.slope.recall.data.Priority;

/**
 * mark code as unfinished like a todo
*/
// @Unfinished // can self reference
// @Unfinished("annotating self") // with value bcz no default

@Documented
@Inherited // inheretied by subclasses
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unfinished {

    String value();
    String[] owners() default "";
    Priority priority() default Priority.MEDIUM;
}
