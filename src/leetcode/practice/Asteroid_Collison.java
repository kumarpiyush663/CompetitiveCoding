package leetcode.practice;

import java.util.*;

public class Asteroid_Collison {
	
public int[] asteroidCollision(int[] a) {
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<a.length;i++){
            if(stack.isEmpty()) stack.push(a[i]);
            else if(a[i]>0) {
                stack.push(a[i]);
            }            
            else{
                int lastElem = Integer.MAX_VALUE;
                while(!stack.isEmpty()){
                    if(stack.peek()>0 && stack.peek() < Math.abs(a[i])){                        
                        lastElem = a[i];
                        stack.pop();
                        
                    }
                    else if(stack.peek()>0 && stack.peek() == Math.abs(a[i])){
                        lastElem = Integer.MAX_VALUE;
                        stack.pop();
                        break;
                    }
                    else if(stack.peek()>0 && stack.peek() > Math.abs(a[i])){
                        lastElem = Integer.MAX_VALUE;
                        break;
                        
                    }
                    else{
                        lastElem = Integer.MAX_VALUE;
                        stack.push(a[i]);
                        break;
                    }
                }
                
                if(lastElem!=Integer.MAX_VALUE) stack.push(a[i]);
                
            }
            
        }
        int []result = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()) result[i--]= stack.pop();
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
