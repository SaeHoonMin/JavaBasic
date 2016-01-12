import javax.swing.JOptionPane;

public class 멤버변수2 {
	static int hakbun;
	static int kor,eng,math;
	public static void main(String [] args)
	{
		while(true){
			try{
				String str = JOptionPane.showInputDialog("국어점수 : ");
				kor = Integer.parseInt(str);
				str = JOptionPane.showInputDialog("영어점수 : ");
				eng = Integer.parseInt(str);
				str = JOptionPane.showInputDialog("수학점수 : ");
				math = Integer.parseInt(str);
				
				String result = "총점 : " + (kor+eng+math)+"\n"
								+"평균 : " + ((kor+eng+math)/3);
				JOptionPane.showMessageDialog(null, result);

			}catch (NumberFormatException e) {
				continue;
			}
			break;
		}
	}
}
