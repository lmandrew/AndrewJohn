//AdminOptions.java

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/AdminOptions"})
public class AdminOptions extends HttpServlet {

      protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
  try{
            
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String a=request.getParameter("option");
        int option=Integer.parseInt(a);
        String stid=request.getParameter("sid");
        RequestDispatcher rd;
        switch(option)
        {
            case 1:
                rd=request.getRequestDispatcher("Search.java");
               try{ rd.forward(request,response);}catch(Exception e){}
                break;
            case 2:    
                rd=request.getRequestDispatcher("Update.java");
                try{ rd.forward(request,response);}catch(Exception e){}
                break;
            case 3:    
                rd=request.getRequestDispatcher("Delete.java");
                try{ rd.forward(request,response);}catch(Exception e){}
                break; 
            case 4:
                rd=request.getRequestDispatcher("Insert.java");
                try{ rd.forward(request,response);}catch(Exception e){}
                break;
  
        }
      } 
             catch(Exception e){
                           //
                           }
}
}