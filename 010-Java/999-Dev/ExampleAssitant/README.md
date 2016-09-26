# ITTechoffice Example Assistant Project

## Functionality
* Maven Project Support
	* Git does commit empty folder while folder structure of maven project contain empty project. It make git support for maven project by add .gitkeey file to main/resources, test/java and test/resources folders.
	* Files in targets are generated after maven build and it should ignore when git commit.  
	* Maven Project contains pom.xml which has specifies the project name. Maven Project Name should be consistent with the project folder name.
* Eclipse Project Support
	* Eclipse Project contains .project file storing meta data of the project. It would specifies the project name. Eclipse Project Name should be consistent with the project folder name
