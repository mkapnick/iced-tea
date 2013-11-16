package scene.visual.dynamic.described;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vehicle extends MovingSprite
{
   public Vehicle(String imageName)
   {
       super(imageName);
       addKeyTime(500, 0.0, 350.0, 0, 1.0, this.content);
       addKeyTime(8500, 500.0, 200.0, 0.00, 1.0, null);

   }

}
