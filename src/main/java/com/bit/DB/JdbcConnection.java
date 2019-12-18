package com.bit.DB;

public class JdbcConnection {
	Connection con;
	Statement st;
	ResultSet rs;
	HashMap hp;
	public HashMap readDB() {
		try {___
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BTC190621E", "root", "");
		 st=con.createStatement();
		 rs=st.executeQuery("select id,name from table1");
		 hp=new HashMap();
		while(rs.next())
		{
			String k=rs.getString("id");
			String v=rs.getString("name");
			hp.put(k, v);
		}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(con!=null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(st!=null)
			{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(rs!=null)
			{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return hp;
	}

}
