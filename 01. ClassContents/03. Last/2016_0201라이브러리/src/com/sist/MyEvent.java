package com.sist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyEvent implements ActionListener{
    MainClass m;
    public MyEvent(MainClass m) {
		this.m=m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==m.b)
		{
			String sex=m.box.getSelectedItem().toString();
			System.out.println("선택된 성별:"+sex);
		}
	}

}
