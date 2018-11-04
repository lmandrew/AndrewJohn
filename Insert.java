//Insert.java
<html>
    <head>
        <script type="text/javaScript">
        function vall()
        {
            alert("Created Successfully");
            return true;
        }
        </script>
            
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        <form onsubmit="vall()">
            
            <p>Enter Details Of New Student</p>
            Name:<input type="text" name="sname"><br><br>
             Phone Number:<input type="text" name="sphno"><br><br>
             DOB:<input type="text" name="spid"><br><br>
             gender:<input type="text" name="gen"><br><br>
             address:<input type="text" name="spname"><br><br>
             E-mail id:<input type="text" name="ssal"><br><br>
             sid:<input type="text" name="stid"><br><br>
             <input type="submit" value="update">
             
             
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
                     String name=request.getParameter("sname");
         String id=request.getParameter("stid");
         String phno=request.getParameter("sphno");
         String pid=request.getParameter("spid");
         String pname=request.getParameter("spname");   
         String sal=request.getParameter("ssal");
         String s=request.getParameter("gen");
         
       
       String sqlquery="insert into emp(sname,sid,phno,dob,address,email,gender) values('"+name+",'"+id+",'"+phno+",'"+pid+",'"+pname+",'"+sal+",'"+s+")";
        rs=st.executeQuery(sqlquery);
      
        RequestDispatcher rd = request.getRequestDispatcher("Admindisp.html");
       rd.forward(request,response);
        
            
       
        out.close();
        }
        
        
        catch(Exception e){
            System.err.println(e);
        }
%>
