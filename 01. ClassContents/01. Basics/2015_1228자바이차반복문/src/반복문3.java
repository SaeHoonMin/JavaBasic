/*
 *    2*1=1     -----     9*1=9
 *    2*2
 *    2*3
 *    --
 *    --
 *    2*9=18              9*9=81
 *    
 *    2*1=2  3*1=3  4*1=4
 *    
 *    5*1=5  6*1=6  7*1=7
 *    
 *    8*1=8  9*1=9  ==> 6줄 완성 
 */
public class 반복문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=9;i++)
        {
        	for(int j=2;j<=9;j++)
        	{
        		System.out.print(j+"*"+i+"="+i*j+"\t");
        	}
        	System.out.println();
        }
	}

}



