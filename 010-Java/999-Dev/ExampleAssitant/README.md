# ITTechoffice Example Assistant Project

## Functionality
* Maven Project Support
	* git does commit empty folder while folder structure of maven project contain empty project. It make git support for maven project by add .gitkeey file to main/resources, test/java and test/resources folders.
	* files in targets are generated after maven build and it should ignore when git commit.  
