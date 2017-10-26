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
      
   // use an array initialiser to create and initialise the elements in the array
      // with specific values quickly and easily
      int vals1[] = {31,23,56,28,33};
      
      // the second array needs to be the same size as the first one.
      int vals2[] = new int[vals1.length];

      int j = 0;
      
      for (int i=0; i < vals1.length; i++)
         if ( vals1[i] % 2 == 1)
             vals2[j++] = vals1[i];	

      for (int k=0; k < j; k++)
         System.out.print(" " + vals2[k]);
   }
}
