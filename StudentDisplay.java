


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentDisplay extends HttpServlet {

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path="c:\\ajay\\desktop\\pro\\database.accdb";
        String urll="jdbc:ucanaccess://"+path;
        Connection con = DriverManager.getConnection(urll);
           Statement st = con.createStatement();*/
            String name1=request.getParameter("uname");
            String pass1=request.getParameter("upass");
           PreparedStatement p = con.prepareStatement("select sname,pass from student where name=? and pass=?");
            p.setString(1,name1);
            p.setString(2, pass1);
            
            
            ResultSet rs = p.executeQuery();
            boolean temp=rs.next();
            if(temp)
            {
                String sqlquery= "select * from student where sname='"+name1+"' and pass='"+pass1+"';
           rs= st.executeQuery(sqlquery);

           if(rs.next())
           {
out.println("<html>" +"<head>" +"<title></title>" +"<link rel='stylesheet' href='style1.css' </head>" +"<body>");
out.println("<form action='student.html'>");
out.println("<div style='padding-left:500px;' id='disp'>");
//out.println('hi, '+name1);
//out.println("<img src='person.png' height='200' width='200' style='padding-top: //25px;'>"+"<br><br>");
out.println("Student ID:       "+rs.getString(5)+"<br><br>");
out.println("Name:      "+rs.getString(4)+"<br><br>");
out.println("DOB:      "+rs.getString(7)+"<br><br>");
out.println("Gender:        "+rs.getString(2)+"<br><br>");
out.println("Email Id:        "+rs.getString(6)+"<br><br>");
out.println("Phone Number:      "+rs.getString(3)+"<br><br>");
out.println("Address:       "+rs.getString(8)+"<br><br>");
out.println("       <input type='submit' value ='logout'");
out.println("</div>");
out.println("</body>");
out.println("</form>");
 out.println("</html>");
           }
           
         
}
            
        out.close();
        }
        
        
        catch(Exception e){
            System.err.println(e);
        }
    }



}
