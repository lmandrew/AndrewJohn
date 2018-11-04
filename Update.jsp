//Update.jsp
<html>
    <head>
        <script type="text/javaScript">
        function vall()
        {
            alert("Modified successfully");
            return true;
        }
        </script>
            
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        <form onsubmit="vall()">
            
            <p>Enter New Details</p>
            <form>
            Name:<input type="text" name="sname"><br><br>
             Phone Number:<input type="text" name="sphno"><br><br>
             DOB:<input type="text" name="spid"><br><br>
             gender:<input type="text" name="gen"><br><br>
             address:<input type="text" name="spname"><br><br>
             E-mail id:<input type="text" name="ssal"><br><br>
             
             <input type="submit" value="update">
             </form>
             
    </body>
</html>

<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
    try{
            
        response.setContentType("text/html");
        
       
      
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path="c:\\ajay\\desktop\\pro\\database.accdb";
        String urll="jdbc:ucanaccess://"+path;
        Connection con = DriverManager.getConnection(urll);
           Statement st = con.createStatement();
            
            
            ResultSet rs; 
            String sqlquery= "select * from student ";
           rs= st.executeQuery(sqlquery);
out.println("<html>" +"<head>" +"<title></title>" +"</head>" +"<body>");
out.println("<form>");
out.println("<div style='padding-left:650px;' id='disp'>");
out.println("<table border='1' cellspacing='0'");
 out.println("<tr> <td><b> Name</b></td>");
	     out.println("<td><b>Student ID </b></td>");
	     out.println("<td><b>DOB</b></td>");
             out.println("<td><b>Gender</b></td>");	
	     out.println("<td><b>email</b></td>");
	     out.println("<td><b>phno</b></td>");
             out.println("<td><b>Address</b></td>");
             out.println("</tr>");
             while(rs.next())
           {

out.println("<tr>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("<td>"+rs.getString(5)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("<td>"+rs.getString(6)+"</td>");
out.println("<td>"+rs.getString(7)+"</td>");
out.println("<td>"+rs.getString(8)+"</td>");
out.println("</tr>");
out.println("</div>");
out.println("</body>");
out.println("</form>");
 out.println("</html>");
           }
  
         String name=request.getParameter("sname");
         String id=request.getParameter("stid");
         String phno=request.getParameter("sphno");
         String pid=request.getParameter("spid");
         String pname=request.getParameter("spname");   
         String sal=request.getParameter("ssal");
         String s=request.getParameter("gen");
         
        sqlquery="delete from student where id='"+id+"'";
        rs=st.executeQuery(sqlquery);
        //deletes the row
        //and inserts the updated row
        sqlquery="insert into emp(sname,sid,phno,dob,address,email,gender) values('"+name+",'"+id+",'"+phno+",'"+pid+",'"+pname+",'"+sal+",'"+s+")";
        rs=st.executeQuery(sqlquery);
      
        RequestDispatcher rd = request.getRequestDispatcher("Admindisp.html");
       rd.forward(request,response);
        
            
       
        out.close();
        }
        
        
        catch(Exception e){
            System.err.println(e);
        }
%>
