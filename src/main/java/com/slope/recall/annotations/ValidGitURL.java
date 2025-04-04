package com.slope.recall.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * validates git url (avatar, org..) for users api
 * 
 * @urlFormat required format for url https://api.github.com/users/{username}
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.RECORD_COMPONENT})
public @interface ValidGitURL {
    String urlFormat() default "https://api.github.com/users/{username}";
}
