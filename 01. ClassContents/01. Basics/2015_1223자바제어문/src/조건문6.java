/*
 *    다중 조건문 
 *    형식) 
 *        if(조건문)   
 *          문장1
 *        else if(조건문)
 *          문장2
 *        else if(조건문)
 *          문장3
 *        else
 *          문장4
 *          
 *        if(조건문)   
 *          문장1
 *        ========
 *        if(조건문)
 *          문장2
 *        ========
 *        if(조건문)
 *          문장3
 *        
 *        else
 *          문장4
 */

public class 조건문6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int jumsu=85;
        char hak='A';
        if(jumsu>=90)// false
        	hak='A';
        else if(jumsu>=80) //true
        	hak='B';
        else if(jumsu>=70) //true
        	hak='C';
        else if(jumsu>=60) //true
        	hak='D';  // hak='D'
        else //false
        	hak='F';
        System.out.println(hak);
	}

}







