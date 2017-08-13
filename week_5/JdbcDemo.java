import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
public class JdbcDemo
{
	public static void main(String[] args)
	{
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test";
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			Statement st = con.createStatement();
			ResultSet rt = null;
			int rows = st.executeUpdate("CREATE TABLE sheet(name CHAR(10),number INT)");
			if (rows != -1)
			{
				st.executeUpdate("INSET sheet (name,number) values ('wang',120),('zhang',130)");
				rt = st.executeQuery("SELECT * FROM sheet");
				while (rt.next())
				{
					System.out.println(rt.getString(1)+":"+rt.getInt(2));
				}
				st.executeUpdate("DELETE FROM sheet WHERE number=120");
				rt=st.executeQuery("SELECT * FROM sheet");
				while (rt.next())
				{
					System.out.println(rt.getString(1)+":"+rt.getInt(2));
				}
				st.executeUpdate("UPDATE sheet set name='sun',number=150");
				rt=st.executeQuery("SELECT * FROM sheet");
				while (rt.next())
				{
					System.out.println(rt.getString(1)+":"+rt.getInt(2));
				}
			}
			if (rt != null)
			{
				try
				{
					rt.close();
				}
				catch(SQLException e)
				{
					System.out.println("error");
				}
			}
			if (st != null)
			{
				try
				{
					st.close();
				}
				catch(SQLException e)
				{
					System.out.println("error");
				}
			}
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					System.out.println("error");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}