package com.sist.server;
import java.util.*;
public class Room {
    Vector<Server.Client> userVc=
    		  new Vector<Server.Client>();
    String roomName,roomJJang;
    int current;
    int inwon;
    
    public Room(String rn,int in)
    {
    	roomName=rn;
    	inwon=in;
    	current++;
    }
    
}
