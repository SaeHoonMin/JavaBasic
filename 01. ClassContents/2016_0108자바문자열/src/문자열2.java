//split
public class 문자열2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "admin,1234,남자,대기실";
		String [] res  =  data.split(",");
		String [] title = {"ID","PW","SEX","LOC"};
		for(int i=0;i<res.length;i++)
			System.out.println(title[i] + " : "+res[i]);
	}

}
