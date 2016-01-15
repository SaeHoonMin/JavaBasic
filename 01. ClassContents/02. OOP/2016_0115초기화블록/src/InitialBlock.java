
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
 *	초기화 블록 : 멤버변수에 대한 초기값 부여
 */

public class InitialBlock {
	String [] sawon = new String[5];
	{
		try{
			File file = new File("C:\\myfile.txt");
			FileReader fw = new FileReader(file);
			int i=0;
			String str="";
			char [] buffer = new char [1024];
			while((i=fw.read(buffer,0,1024))!=-1)
			{
				str += new String(buffer);
			}		
			StringTokenizer st = new StringTokenizer(str,"\n");
			int a=0;
			while(st.hasMoreTokens())
			{
				sawon[a] = st.nextToken();
				a++;
			}
		}catch (Exception ex){System.out.println(ex.getMessage());}
	}
	public static void main(String[] args){
		InitialBlock aa = new InitialBlock();
		for(String str : aa.sawon)
			System.out.println(str);
	}
}
