package finalProject;

public class Calculator {
//Arithmitic, Modulus, Power
   //Add 
   public static double addition(double x, double y){
      double z = x + y;
      return z;
   }
   //Subtract 
   public static double subtraction(double x, double y){
      double z = x - y;
      return z;
   }
   //Multiply 
   public static double multiplication(double x, double y){
      double z = x * y;
      return z;
   }
   //Divide 
   public static double division(double x, double y){
      double z = x / y;
      return z;
   }
   //Modulus 
   public static double modulus(double x, double y){
      double z = x % y;
      return z;
   }
   //Power 
   public static double power(double x, double y){
      double z = Math.pow(x,y);
      return z;
   }
   //Square Root
   public static double squareRoot(double x){
      double z = Math.sqrt(x);
      return z;
   } 
//------------------
}
