import javax.swing.JOptionPane;

public class �������2 {
	static int hakbun;
	static int kor,eng,math;
	public static void main(String [] args)
	{
		while(true){
			try{
				String str = JOptionPane.showInputDialog("�������� : ");
				kor = Integer.parseInt(str);
				str = JOptionPane.showInputDialog("�������� : ");
				eng = Integer.parseInt(str);
				str = JOptionPane.showInputDialog("�������� : ");
				math = Integer.parseInt(str);
				
				String result = "���� : " + (kor+eng+math)+"\n"
								+"��� : " + ((kor+eng+math)/3);
				JOptionPane.showMessageDialog(null, result);

			}catch (NumberFormatException e) {
				continue;
			}
			break;
		}
	}
}
