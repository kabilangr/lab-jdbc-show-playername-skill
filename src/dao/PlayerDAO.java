package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO
{
	public List<Player> getAllPlayers() throws SQLException, ClassNotFoundException, IOException
	{
		List<Player> list=new ArrayList<Player>();
		ConnectionManager ob=new ConnectionManager();
		Statement st=ob.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from player order by name asc");
		Player p=null;
		SkillDAO s1=new SkillDAO();
		Skill s=null;
		while(rs.next())
		{
			s=s1.getSkillBylD(rs.getLong("skill_id"));
			p=new Player(rs.getLong("id"),rs.getString("name"),rs.getString("country"),s);
			list.add(p);
		}
		ob.getConnection().close();
		return list;
	}
}
