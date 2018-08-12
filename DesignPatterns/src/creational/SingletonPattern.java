package creational;
/*
 * This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. 
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 */
class SingleObject 
{
	   //create an object of SingleObject
	   private static SingleObject instance = new SingleObject();

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private SingleObject(){}

	   //Get the only object available
	   public static SingleObject getInstance(){
	      return instance;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
}
public class SingletonPattern 
{
	public static void main(String[] args) {
		//illegal construct
	      //Compile Time Error: The constructor SingleObject() is not visible
	      //SingleObject object = new SingleObject();

	      //Get the only object available
	      SingleObject object = SingleObject.getInstance();

	      //show the message
	      object.showMessage();
	}

}
