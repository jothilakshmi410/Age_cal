package com.anna.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Agecal
 */
@WebServlet("/Agecal")
public class Agecal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Agecal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

      //we will display the current date
		//Date objdate = null;
      String title = "Age Difference";
     String strUname = request.getParameter("uname");
     String strdob = request.getParameter("dob");
     
    
     
     try {
    	 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	 Date date = formatter.parse(strdob);
    	 Instant instant = date.toInstant();
         ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
         LocalDate givenDate = zone.toLocalDate();
         Period objdiff = Period.between(givenDate, LocalDate.now());
         
           String docType =
       	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
       	         
       	      out.println(docType +
       	         "<html>\n" +
       	            "<head><title>" + title + "</title></head>\n" +
       	            "<body bgcolor = \"#f0f0f0\">\n" +
       	               "<h1 align = \"center\">" + title + "</h1>\n" +
       	               "<ul>\n" +
       	                  "  <b>Name</b>: "+ strUname + "<br>"+"\n<br>"
       	                  + "  <li><b>Current Date</b>: "+ " "+LocalDate.now() + "<br>"+"\n<br>"
       	                  +"  <li><b>Current Age</b>: "+ " " +"<br>"+ objdiff.getYears() +"  "+"<b>Years</b> "+" , "+ objdiff.getMonths() +" "+ "  <b>Months</b> "+" , "+ objdiff.getDays()+" "+"<b>Days</b> "
       	                 + "\n" +
       	               "</ul>\n" +
       	            "</body>" +
       	         "</html>"
       	      );
           
    	 
 	} catch (ParseException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
   
 
     
   
     
      

		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
