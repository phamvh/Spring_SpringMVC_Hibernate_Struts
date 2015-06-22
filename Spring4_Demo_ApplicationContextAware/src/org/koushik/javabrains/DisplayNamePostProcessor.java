package org.koushik.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * This class is registered as a bean in spring.xml. This tell spring that
 * there is a post processor after a bean is created (factoried) and the method
 * public void postProcessBeanFactory is called after every bean is created.
 * There are two method: one is called BEFORE the properties of the bean are set
 * Another is called AFTER the properties of the bean are set.
 *
 */
public class DisplayNamePostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessAfterInitialization(). Bean name is "+beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessBeforeInitialization(). Bean name is "+beanName);
		return bean;
	}

}


























