package s3622499_Assignment3;

public class Loop {

	public static void main(String[] args) {
		int n = 10;
		   for (int i = n; i >= 1; i--)
		      for (int j = 1; j <= n; j++)  {
		         System.out.print(i);
		         System.out.print(" * ");
	                 System.out.print(j);
	                 System.out.print(" = ");
	                 System.out.print(i * j);	
	                 System.out.println();
	              }
		   n = 5;
		   for (int i = 1; i <= 5; i++)  {
		      System.out.print(" * ");
		      for (int j = 1; j<= i; j++)
			    System.out.print(" * ");
		   }
		   System.out.println();
		   
		   n = 5;
           for (int i = 1; i <= n; i++)  {
              System.out.print(" * ");
           for (int j = 1; j <= n; j++)  {
              if (j > 2) continue;
                 System.out.println(" * ");
           }
        }
        int m = 10;
        do {
      	    System.out.println(m);;
        	   	m = m + 1;
        } while (m < 10);
        
        /*int i = 1;
        while(i < 6) {
        		for(int j = 1; j <= i; j++) {
        			System.out.print(j + " ");
        		}
        		System.out.println();
        		i++;
        }*/
        
        for(int k = 1; k <= 5; k++) {
        		for(int j = 1; j <= k; j++) {
        			System.out.print(j + " ");
        		}
        		System.out.println();
        }
        
        int num = 1;
        for(int p = 0; p < 20; p++) {
        		System.out.print(num + " ");
        		num *= 2;
        }
           
           
	}
	

}
