package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;

public class Main
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException
	{
		List<Player> l=new ArrayList<Player>();
		PlayerDAO play=new PlayerDAO();
		l=play.getAllPlayers();
		Player ob=null;
		Skill s=null;
		for(int i=0;i<l.size();i++)
		{
			ob=l.get(i);
			s=ob.getSkill();
			System.out.println(ob.getPlayerld()+" "+ob.getName()+" "+ob.getCountry()+" "+s.getSkillName());
		}
	}
}
