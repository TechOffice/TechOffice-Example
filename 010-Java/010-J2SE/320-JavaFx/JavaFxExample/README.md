# JavaFx Hello World Example

JavaFx provide a abstract class of Application. You can write a class extending Application then you can write your own custom start function provided primary stage object. 

launch function is also provided for you to execute your JavaFx Application.

## Prerequisite
* JDK 1.8

## Sample Code

Extending Application Abstract Class

```
public class Appl extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
	
```

