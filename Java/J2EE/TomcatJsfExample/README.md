# Tomcat Jsf Example

**Prerequisite**
* Maven
* JSF 2.0
* Tomcat 7

## Managed Bean 

Managed Bean is regular Java Bean Class. It can be assessed by JSF Page. 

In JSF 1.x, managed bean has to register in faces-config.xml

In JSF 2.x, managed bean can be easily registered using annotations. 

The scope defines how long the bean live. 

* @RequestScoped	
* @NoneScoped	
* @ViewScoped	
* @SessionScoped	
* @ApplicationScoped	
* @CustomScoped	

JSF is a simple static Dependency Inject Framework. The inject can be through the annotation @ManagedProperty
