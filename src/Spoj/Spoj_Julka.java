package Spoj;

import java.math.BigInteger;

public class Spoj_Julka {
	
	
	
	// Returns Factorial of N 
    static BigInteger factorial(int N) 
    { 
        // Initialize result 
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE 
  
        // Multiply f with 2, 3, ...N 
        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        System.out.println(f.toString().length());
        return f; 
    } 
  
    // Driver method 
    public static void main(String args[]) throws Exception 
    { 
        int N = 100; 
        System.out.println(factorial(N)); 
    } 

}
