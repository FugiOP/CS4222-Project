package Pack;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
        	Class.forName("org.postgresql.Driver");
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  ArrayList<FacultyModel> flist = new ArrayList<>();
	  ArrayList<ProjectModel> plist = new ArrayList<>();
	  
	  Connection c = null;
      try
      {
          String url = "jdbc:postgresql://cs1.calstatela.edu/username";
          String username = "username";
          String password = "pw";

          c = DriverManager.getConnection( url, username, password );
          Statement stmt = c.createStatement();
         
          ResultSet rs = stmt.executeQuery( "select * from faculty" );
          
          while( rs.next() )
          {
              FacultyModel entry = new FacultyModel( rs.getString( "name" ),rs.getInt("ssn"),rs.getInt("age"),rs.getString("gender"),rs.getString("rspec"),rs.getInt("rank"));
              flist.add(entry);
          }
          
          ResultSet rs2 = stmt.executeQuery("select * from projects");
          
          while(rs2.next()){
        	  ProjectModel entry = new ProjectModel(rs2.getInt("pno"),rs2.getString("sponsor_name"),rs2.getDate("start_date"),rs2.getDate("end_date"),rs2.getString("budget"),rs2.getString("pi"));
        	  plist.add(entry);
          }
          request.getSession().setAttribute("plist", plist);
          request.getSession().setAttribute("flist", flist);
      }
      catch( SQLException e )
      {
          throw new ServletException( e );
      }
      finally
      {
	      try
	      {
	          if( c != null ) c.close();
	      }
	      catch( SQLException e )
	      {
	          throw new ServletException( e );
	      }
	}
	  request.getRequestDispatcher( "/WEB-INF/mainview.jsp" ).forward(request, response );
	  
  }
}
