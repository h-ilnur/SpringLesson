package ru.khairullin.spring.day01.lab10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created by ilnur on 06/04/15.
 */
public class DestroyMethodPrototypeWarningBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.isPrototype() && beanDefinition.getDestroyMethodName() != null) {
                System.out.println("WARN: Destroy method won't run");
            }

        }
    }

}
