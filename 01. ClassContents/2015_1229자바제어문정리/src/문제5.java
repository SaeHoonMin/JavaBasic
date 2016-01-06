
public class ¹®Á¦5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=2;i<=9;i+=3)
        {
        	for(int j=1;j<=9;j++)
        	{
        		for(int k=i;k<i+3&&k!=10;k++)
        		{
        			System.out.print(k+"*"+j+"="+k*j+"\t");
        		}
        		System.out.println();
        	}
        	System.out.println("\n\n");
        }
	}

}
