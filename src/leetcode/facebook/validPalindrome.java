package leetcode.facebook;

public class validPalindrome {

	public boolean isPalindrome(String s) {
        System.out.println(s);
        s = s.toLowerCase();
        System.out.println(s);
        int i=0;
        int j=s.length()-1;
        while(i<=j) {
        	
//        	if(s.charAt(i)-'a'>25 || s.charAt(i)-'a'<0) i++;
//        	if(s.charAt(j)-'a'>25 || s.charAt(j)-'a'<0) j--;
//        	
//        	if(s.charAt(i)-'0'>9 || s.charAt(i)-'0'<0) i++;
//        	if(s.charAt(j)-'0'>9 || s.charAt(j)-'0'<0) j--;
        	
        	System.out.println("i = "+i+", j = "+j);
        	
        	if(!((s.charAt(i)-'a'<=25 && s.charAt(i)-'a'>=0) || ( s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)) ||
					!((s.charAt(j) - 'a' <= 25 && s.charAt(j) - 'a' >= 0)
							|| (s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9))) {

				if (!((s.charAt(i) - 'a' <= 25 && s.charAt(i) - 'a' >= 0)
						|| (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9))) {
					i++;
					System.out.println("i++");
				}
				if (!((s.charAt(j) - 'a' <= 25 && s.charAt(j) - 'a' >= 0)
						|| (s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9))) {
					j--;
					System.out.println("j--");
				}
			}
        	else {
        		if((s.charAt(i)-'a'<=25 && s.charAt(i)-'a'>=0) && (s.charAt(j)-'a'<=25 && s.charAt(j)-'a'>=0) ||
            			(( s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9) &&  (s.charAt(j)-'0'>=0 && s.charAt(j)-'0'<=9))) {
            		 if(s.charAt(i)!=s.charAt(j)) return false;
            		 else {

             			i++;
             			j--;
             			
             		
    				}
            	}
            	else {
            		return false;
            	}
        	}
        	
//        	if((s.charAt(i)-'a'<=25 && s.charAt(i)-'a'>=0) && (s.charAt(j)-'a'<=25 && s.charAt(j)-'a'>=0) && s.charAt(i)!=s.charAt(j))
//        		return false;
//        	
//        	if(( s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9) &&  (s.charAt(j)-'0'>=0 && s.charAt(j)-'0'<=9) && s.charAt(i)!=s.charAt(j))
//        		return false;
//        	
//        	i++;
//        	j--;
        	
//        	if((s.charAt(i)-'a'<=25 && s.charAt(i)-'a'>=0) && (s.charAt(j)-'a'<=25 && s.charAt(j)-'a'>=0) && (s.charAt(i)!=s.charAt(j)))
//        		return false;
        	
        	
        	
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
		String s = "0P";
		System.out.println(new validPalindrome().isPalindrome(s));
	}

}
