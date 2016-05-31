# Spring Example

Spring home page: https://spring.io/

Spring is inversion of control container framework for Java. 

This Example demonstrates the Hello World Example of Spring. 

## Prerequisite

* Maven 

## Example List

* SimpleSpringAppl
 * Simple Spring Example Using XML Configuration
* SimpleSpringApplJavaBasedConfig
 * Simple Spring Example Using Java Based Configuration
* SimpleSpringApplWithAnnotation
 * Simple Spring Example With Annotation
* SimpleSpringApplWithComponentScan
 * Simple Spring Example WIth Auto-Scan

## Spring 

In Spring, the object are managed by the SPring IoC container represented by ApplicationContext.

**ClassPathXmlApplicationContext**

ClassPathXmlApplicationContext is an implementation of ApplicationContext for standalone XML application context. 

**@Autowired**

Autowired annotation provides the same feature of property in configuration.

**@Component**

Component annotation indicates that the class is Spring bean. (@Component is introduced in Spring 2.5)

**@Configuration**

Configuration indicates that the class is a source of bean definition of Spring IoC container.

**@Bean**

Bean annotation explicity declare a sigle bean. It is noted that the declaration is not in Class Level.(@Bean is introduced in Spring 3.0)
