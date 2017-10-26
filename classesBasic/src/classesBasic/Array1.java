package classesBasic;

import java.util.*;
public class Array1
{  
   public static void main(String args[])
   {
      int qty[] = new int[5];

      for (int i = 0; i < qty.length; i++)
         qty[i] = i+1;
      
      for (int i = 0; i < qty.length; i++)
          System.out.print(" " + qty[i]);
      
      System.out.println("");
      
      for (int i = 0; i < 4; i++)
         qty[i+1] += qty[i];
         
      for (int i = 0; i < qty.length; i++)
         System.out.print(" " + qty[i]);
         
      System.out.println();		
   }
}
