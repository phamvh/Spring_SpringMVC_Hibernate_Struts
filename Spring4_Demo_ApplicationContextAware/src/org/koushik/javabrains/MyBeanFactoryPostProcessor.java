package org.koushik.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * First, note that this is for a factory of beans (not for a bean itself). A factory of bean, called
 * bean factory, is created once, mostly. It acts like a machine that produces different beans. Even if we
 * do NOT create a BeanFactory explicitly like this:
 *      BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
 * and instead, use:
 *      ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
 *      Triangle triangle1 = (Triangle)context.getBean("triangle");
 * 
 * the method postProcessBeanFactory() still gets called because ApplicationContext also acts like a bean factory.
 * Mostly (or always???), a bean factory is a singleton, thus we only see this method runs once.
 *
 * A good example of BeanFactoryPostProcessor is
 *      org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 * If this bean is defined in spring.xml (with the location of the properties file)
 * then we can use place-holders in the spring.xml, which link to the properties in a properties file.
 *
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		System.out.println("postProcessBeanFactory() is called!");
		
	}

}
