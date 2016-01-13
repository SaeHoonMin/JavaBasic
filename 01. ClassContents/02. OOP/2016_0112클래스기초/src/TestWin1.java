import javax.swing.JButton;
import javax.swing.JFrame;

public class TestWin1 {
	
	JFrame f = new JFrame();
	JButton jb = new JButton();
	
	TestWin1()
	{
		f.setSize(800,600);
		f.setVisible(true);
		f.add(jb);
		jb.setText("haha");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestWin1 t = new TestWin1();
	}

}
