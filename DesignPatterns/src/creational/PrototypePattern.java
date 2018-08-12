package creational;

import java.util.Hashtable;

/*
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.
 * This pattern involves implementing a prototype interface which tells to create a clone of the current object. 
 * This pattern is used when creation of object directly is costly.
 */
abstract class Shape3 implements Cloneable 
{	   
	   private String id;
	   protected String type;
	   
	   abstract void draw();
	   
	   public String getType(){
	      return type;
	   }
	   
	   public String getId() {
	      return id;
	   }
	   
	   public void setId(String id) {
	      this.id = id;
	   }
	   
	   public Object clone() {
	      Object clone = null;
	      
	      try {
	         clone = super.clone();
	         
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }
}
class Rectangle3 extends Shape3 
{
	   public Rectangle3(){
	     type = "Rectangle";
	   }

	   @Override
	   public void draw() {
	      System.out.println("Inside Rectangle::draw() method.");
	   }
}
class Square3 extends Shape3 
{
	   public Square3(){
	     type = "Square";
	   }

	   @Override
	   public void draw() {
	      System.out.println("Inside Square::draw() method.");
	   }
}
class Circle3 extends Shape3 
{
	   public Circle3(){
	     type = "Circle";
	   }

	   @Override
	   public void draw() {
	      System.out.println("Inside Circle::draw() method.");
	   }
}
//---------
class ShapeCache 
{	
	   private static Hashtable<String, Shape3> shapeMap  = new Hashtable<String, Shape3>();

	   public static Shape3 getShape(String shapeId) {
	      Shape3 cachedShape = shapeMap.get(shapeId);
	      return (Shape3) cachedShape.clone();
	   }

	   // for each shape run database query and create shape
	   // shapeMap.put(shapeKey, shape);
	   // for example, we are adding three shapes
	   
	   public static void loadCache() {
	      Circle3 circle = new Circle3();
	      circle.setId("1");
	      shapeMap.put(circle.getId(),circle);

	      Square3 square = new Square3();
	      square.setId("2");
	      shapeMap.put(square.getId(),square);

	      Rectangle3 rectangle = new Rectangle3();
	      rectangle.setId("3");
	      shapeMap.put(rectangle.getId(), rectangle);
	   }
}
//---------
public class PrototypePattern 
{
	public static void main(String[] args) {
		ShapeCache.loadCache();

	      Shape3 clonedShape = (Shape3) ShapeCache.getShape("1");
	      System.out.println("Shape : " + clonedShape.getType());		

	      Shape3 clonedShape2 = (Shape3) ShapeCache.getShape("2");
	      System.out.println("Shape : " + clonedShape2.getType());		

	      Shape3 clonedShape3 = (Shape3) ShapeCache.getShape("3");
	      System.out.println("Shape : " + clonedShape3.getType());

	}

}
