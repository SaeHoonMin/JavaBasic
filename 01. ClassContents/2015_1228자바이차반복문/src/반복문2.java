/*
 *    A
 *    BC
 *    DEF
 *    GHIJ
 *    
 *    A
 *    AB
 *    ABC
 *    ABCD
 *    
 *    1###
 *    #2##
 *    ##3#
 *    ###4
 */
public class ¹Ýº¹¹®2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch='A';
        for(int i=1;i<=4;i++)
        { 
        	ch='A';
        	for(int j=1;j<=i;j++)
        	{
        		System.out.print(ch++);
        	}
        	System.out.println();
        }
        
        for(int i=1;i<=4;i++)
        {
        	for(int j=1;j<=4;j++)
        	{
        		if(i==j)
        			System.out.print(i);
        		else
        			System.out.print("#");
        	}
        	System.out.println();
        }
	}

}
