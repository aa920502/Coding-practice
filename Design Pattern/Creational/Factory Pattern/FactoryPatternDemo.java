// In Abstract Factory pattern, an interface is responsible for creating a factory 
// of related objects without explicitly specifying their classes. 
// Each generated factory can give the objects as per the Factory pattern.


public class FactoryPatternDemo{
	public static void main(String[] args){
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape shape1 = shapeFactory.getShape("circle");
		shape1.draw();
	}
} 