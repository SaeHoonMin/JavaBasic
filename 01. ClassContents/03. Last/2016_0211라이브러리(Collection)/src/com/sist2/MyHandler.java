package com.sist2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
// SAX(Simple API for XML) , DOM(Document Object Model) 
public class MyHandler extends DefaultHandler{
    Map<String,I> map=new HashMap<String,I>();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String key=attributes.getValue("id");
				String clsName=attributes.getValue("class");
				Class cls=Class.forName(clsName);
				I i=(I)cls.newInstance();
				map.put(key, i);
			}
		}catch(Exception ex){}
	}
    
}




