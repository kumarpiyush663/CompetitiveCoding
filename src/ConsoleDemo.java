import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ConsoleDemo {
  public static void main(String[] args) {
	  
//	  System.out.println("Ȅ");
    String[] data = { "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510", 
        "\u2502Welcome   \u2502",
        "\u2502To        \u2502",
        "\u2502WorkFlow  \u2502",
        "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518" };
    for (String s : data) {
      System.out.println(s);
    }
    
    String[] data_exp = { "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510", 
            "\u2502Mind Ur   \u2502",
            "\u2502Own       \u2502",
            "\u2502Exception \u2502",
            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518" };
    
    String[] data_e = { "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510", 
            "\u2502May Ur     \u2502",
            "\u2502Code       \u2502",
            "\u2502Rest In GIT\u2502",
            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518" };    
        for (String s : data_exp) {
          System.out.println(s);
        }
        
        
        
        for(int i=0;i<data_exp.length;i++) {
        	System.out.println(data[i]+" "+data_exp[i]);
        }
        
        for (String s : data_e) {
            System.out.println(s);
          }
        
        
        String textInBold = "Java_Prof_Level";
        System.out.println("\033[0;1m" + textInBold);
        
        System.out.println("\u001B[1m textInBold");
        System.out.println(" BLACK_BOLD");
        System.out.println(ConsoleColors.BLACK_BOLD+" BLACK_BOLD");
        System.out.println(ConsoleColors.RED + "RED COLORED" +
        		ConsoleColors.RESET + " NORMAL"+ConsoleColors.BLUE_BACKGROUND+" BLUE BACKGROUND"+ConsoleColors.RESET+ConsoleColors.RED_BOLD+" RED BOLD"+ConsoleColors.GREEN_UNDERLINED+" GREEN_UNDERLINED"+ConsoleColors.WHITE_BOLD+" WHITE_BOLD");
        
        
        System.out.println();
        
        int a =10, b = 0, c = 10; 
        
        // The encoded string after removing first 31 characters 
        // Its individual characters determine how many spaces 
        // or exclamation marks to draw consecutively. 
        String s1="TFy!QJu ROo TNn(ROo)SLq SLq ULo+UHs UJq TNn*RPn/QP,\n"
        + "bEWS_JSWQAIJO^NBELPeHBFHT}TnALVlBLOFAkHFOuFETpHCStHAUFAgcEAelc,\n"
        + "lcn^r^r\\tZvYxXyT|S~Pn SPm SOn TNn ULo0ULo#ULo-WHq!WFs XDt!"; 
          
        // read each character of encoded string 
        a=s1.charAt(b); 
          
        while (a != 0) 
        { 
        	if(a>=7) System.out.print(ConsoleColors.RED);
        	if(a>=3&& a<7) System.out.print(ConsoleColors.WHITE);
        	if(a<3) System.out.print(ConsoleColors.GREEN);
            if (b < 170) 
            { 
                a = s1.charAt(b); 
                b++; 
                while (a-- > 64) 
                { 
                      
                    if (++c=='Z') 
                    { 
                          
                        c/=9;  
                          
                        System.out.print((char)(c)); 
                    } 
                    else
                        System.out.print((char)(33 ^ (b & 0x01))); 
                    
                    
                } 
                System.out.print(ConsoleColors.RESET);
            } 
            else
                break; 
            
            
        } 
        
//        System.out.println("\033[3mText goes here\033[0m");
//        PrintWriter out;
//		try {
//			out = new PrintWriter(new FileWriter("myFile.html"));
//			out.println("<u><i>my output</i></u>");
//	        out.flush();
//	        out.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//    for (String s : data) {
//      System.console().writer().println(s);
//    }
  }
}