package dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	public Skill getSkillBylD(Long id) throws SQLException, ClassNotFoundException, IOException
	{
		ConnectionManager ob=new ConnectionManager();
		Statement st=ob.getConnection().createStatement();
		ResultSet rs=st.executeQuery("Select * from skill");
		Skill skill=null;
		while(rs.next())
		{
			if(rs.getLong("id")==id)
			{
				skill=new Skill(id,rs.getString("name"));
			}
			}
		ob.getConnection().close();
	return skill;
	}
}
