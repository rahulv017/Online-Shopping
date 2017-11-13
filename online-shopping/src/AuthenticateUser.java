

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.xml.bind.DatatypeConverter;

import com.online.shopping.DAO.Dao.Conn;

public class AuthenticateUser {
	

	 
	 String authkey;
	 Conn con;
	public AuthenticateUser() {
		
		
		
	}
	
	public Boolean getAuthenticate(String authkey)
	{
		String decoded = new String(DatatypeConverter.parseBase64Binary(authkey));
		StringTokenizer token=new StringTokenizer(decoded,":");
		String username=token.nextToken();
		String password=token.nextToken();
		
		Statement stat = null;
		String query="Select username,password from user";
		try {
			//dbConnection = getDBConnection();
			

			System.out.println(query);

			// execute select SQL stetement
			ResultSet rs = stat.executeQuery(query);
            int flag=0;
			while (rs.next()) {
                  flag=1;
                  return true;

			}
			if(flag==0)
			{
				return false;
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			

		}
		return false;
	}

}
