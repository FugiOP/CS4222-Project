package Pack;

import java.io.IOException;
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

public class Action extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssn = request.getParameter("ssn");
		String pno = request.getParameter("pno");
		String action = request.getParameter("action");

		ArrayList<Integer> fdetails = new ArrayList<>();
		ArrayList<String> pdetails = new ArrayList<>();
		String fname = null;
		
		Connection c = null;
	      try
	      {
	          String url = "jdbc:postgresql://cs1.calstatela.edu/cs4222s03";
	          String username = "cs4222s03";
	          String password = "cpeJd5oF";

	          c = DriverManager.getConnection( url, username, password );
	          Statement stmt = c.createStatement();
	         
	          //Faculty actions
	          if(action.equals("fdetails")){
	        	  ResultSet rs = stmt.executeQuery( "select * from faculty where ssn = '"+ssn+"'" );
		          while( rs.next() )
		          {
		        	  fname=rs.getString("name");
		          }
		          rs = stmt.executeQuery("select * from worked_on_coi where faculty_name = '"+fname+"'");
		          while(rs.next()){
		        	  fdetails.add(rs.getInt("pno"));
		          }
	          }
	          if(action.equals("fremove")){
	        	  String name = "";
	        	  ResultSet rs = stmt.executeQuery("SELECT * FROM faculty where ssn = '"+ssn+"'");
	        	  while(rs.next()){
	        		  name = rs.getString("name");
	        	  }
	        	  stmt.executeUpdate("DELETE FROM faculty where ssn = '"+ssn+"'");
	        	  stmt.executeUpdate("DELETE FROM projects where  pi= '"+name+"'");
	        	  stmt.executeUpdate("DELETE FROM worked_on_coi where faculty_name = '"+name+"'");
	        	  response.sendRedirect("main");
	          }
	          
	          //Project actions
	          if(action.equals("pdetails")){
	        	  ResultSet rs = stmt.executeQuery( "select * from worked_on where pno = '"+pno+"'" );
		          while( rs.next() )
		          {
		        	  pdetails.add(rs.getString("student_name"));
		          }
	          }
	          if(action.equals("premove")){
	        	  stmt.executeUpdate("DELETE FROM projects where pno = '"+pno+"'");
	        	  stmt.executeUpdate("DELETE FROM worked_on where pno = '"+pno+"'");
	        	  stmt.executeUpdate("DELETE FROM worked_on_coi where pno = '"+pno+"'");
	        	  response.sendRedirect("main");
	          }
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
		
		//faculty actions-----
		if(action.equals("fdetails")){
			request.getSession().setAttribute("fname", fname);
			request.getSession().setAttribute("fdetails", fdetails);
			request.getRequestDispatcher( "/WEB-INF/fdetails.jsp" ).forward(request, response );
		}
		
		//project actions-----
		if(action.equals("pdetails")){
			request.getSession().setAttribute("pdetails", pdetails);
			request.getSession().setAttribute("pnum", pno);
			request.getRequestDispatcher( "/WEB-INF/pdetails.jsp" ).forward(request, response );
		}
	}

}
