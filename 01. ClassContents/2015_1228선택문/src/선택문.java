/*
 *   ���ప 1���� ��� 
 *   switch~case : ���� if���� ���� 
 *   ����)
 *       switch(����/����)
 *       {
 *          case ����/����:
 *            ���๮�� 
 *            break;
 *          case ����/����:
 *            ���๮�� 
 *            break;
 *          case ����/����:
 *            ���๮�� 
 *            break;
 *          case ����/����:
 *            ���๮�� 
 *            break;
 *          default:
 *            ���๮�� 
 *       }
 */
// 3���� ������ �޾Ƽ� ���� ��� 
import java.util.Scanner;
public class ���ù� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ���� 3�� �ޱ� 
		// switch~case�� �̿��ؼ� ���� ��� 
		Scanner scan=new Scanner(System.in);
		System.out.print("��������:");
		int kor=scan.nextInt();
		System.out.print("��������:");
		int eng=scan.nextInt();
		System.out.print("��������:");
		int math=scan.nextInt();
		int avg=(kor+eng+math)/3;
		
		switch(avg/10)
		{
		case 10:
		case 9: // if(avg==9 || avg==10)
			System.out.println("A����");
			break;
		case 8:
			System.out.println("B����");
			break;
		case 7:
			System.out.println("C����");
			break;
		case 6:
			System.out.println("D����");
			break;
		default:
			System.out.println("F����");
		}
		
	}

}




