package com.slope.recall.annotations;

import java.util.Arrays;
import org.springframework.stereotype.Component;

import com.slope.recall.data.GitHubUser;

import lombok.extern.slf4j.Slf4j;

/**
 * an eg implem with reflection for {@code ValidGitURL} annotation
 */
@Slf4j
@Component
public class FindGitAnnotation {
    // todo AOP to intercept on creation of instance 
    private FindGitAnnotation() {
        // for (var bean : context.getBeanDefinitionNames()) {
        //     log.info(bean.getClass().getName());      
        // }
        // var autowireBeanFactory = context.getAutowireCapableBeanFactory(); 
        // if (autowireBeanFactory instanceof SingletonBeanRegistry){
        //     for (var singletonBeans : ((SingletonBeanRegistry)autowireBeanFactory).getSingletonNames()) {
        //         log.info(singletonBeans);
        //     }
        // }
        // log.info("//////////////");
        // var provider = new ClassPathScanningCandidateComponentProvider(false);
        //     provider.addIncludeFilter(new AnnotationTypeFilter(ValidGitURL.class));

        // var test = provider.findCandidateComponents("com.slope.recall")
        // .stream()
        // .filter(b -> b instanceof AnnotatedBeanDefinition)
        // .map(b -> ((AnnotatedBeanDefinition)b).getMetadata().getAnnotationAttributes(ValidGitURL.class.getCanonicalName()))
        // .collect(Collectors.toList());
        // log.info("list ? {}", test.size());
        log.info("looking for fields with @ValidGitURL");
        Arrays.stream(GitHubUser.class.getRecordComponents())
        .filter(f-> f.isAnnotationPresent(ValidGitURL.class))
        .forEach(field -> {
            log.info("class {} field {}", field, field.getDeclaringRecord());
        });
        
    }
}
