package application;


public class Functions {
	
//	private static double base;
//	private static double exponent;
//	private double result;
	
	
	
	public static double square(double baseIn)
	{
		
		return Math.pow(baseIn, 2);
		
	}
	
	public static double cube(double baseIn)
	{
		return Math.pow(baseIn, 3);
	}
	
	public static double squareRoot(double baseIn)
	{
		return Math.sqrt(baseIn);
	}
	public static double cubeRoot(double baseIn)
	{
		return Math.pow(baseIn, 1/3.0);
	}
	
	public static double factorial(double baseIn)
	{
		if(baseIn <= 1)
		{
			return 1;
		}
		else
		{
			return baseIn *factorial(baseIn-1);
		}
	}
	
	
}


