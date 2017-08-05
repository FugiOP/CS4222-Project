package Pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFacultyProject extends HttpServlet {
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
		String add = request.getParameter("add");
		request.setAttribute("add", add);
		request.getRequestDispatcher( "/WEB-INF/add.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formType = request.getParameter("formType");
		
		Connection c = null;
	      try
	      {
	          String url = "jdbc:postgresql://cs1.calstatela.edu/username";
	          String username = "username";
	          String password = "pw";

	          c = DriverManager.getConnection( url, username, password );
	          
			if(formType.equals("faculty")){
				String name = request.getParameter("name");
				String rspec = request.getParameter("rspec");
				String gender = request.getParameter("gender");
				String ssn = request.getParameter("ssn");
				String rank = request.getParameter("rank");
				String age = request.getParameter("age");
				
				String sql = "INSERT INTO public.faculty(name, rspec, gender, ssn, rank, age) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = c.prepareStatement( sql );
				
				pstmt.setString(1, name);
				pstmt.setString(2, rspec);
				pstmt.setString(3, gender);
				pstmt.setInt(4, Integer.valueOf(ssn));
				pstmt.setInt(5, Integer.valueOf(rank));
				pstmt.setInt(6, Integer.valueOf(age));
				pstmt.executeUpdate();
			}
			
			if(formType.equals("project")){
				String sponsor = request.getParameter("sponsorName");
				Date startDate = Date.valueOf(request.getParameter("startDate"));
				Date endDate = Date.valueOf(request.getParameter("endDate"));
				String budget = request.getParameter("budget");
				String pi = request.getParameter("pi");
				
				String sql = "INSERT INTO public.projects(sponsor_name, start_date, end_date, budget, pi) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pstmt = c.prepareStatement( sql );
				pstmt.setString(1, sponsor);
				pstmt.setDate(2, startDate);
				pstmt.setDate(3, endDate);
				pstmt.setInt(4, Integer.valueOf(budget));
				pstmt.setString(5, pi);
				pstmt.executeUpdate();
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
	      response.sendRedirect("main");
	}

}
