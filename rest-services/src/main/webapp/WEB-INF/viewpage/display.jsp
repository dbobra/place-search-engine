<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search result</title>
</head>
<body>
 <div align="center">
      <h1>Places Search </h1>
         <form action="<%=request.getContextPath()%>/search/detailsearch" method="GET">
           <table border = "0">
              <tr>
                  
                   <td width="100"></td>
                   <td width="100"></td>
                   <td width="100"><h2>Name</h2></td>
                   <td width="150"><h2>Types</h2></td>
                   <td width="150"><h2>Address</h2></td>
                   
             </tr>
           <c:forEach  items="${listPlacesSearch}" var="googleDTO">
              <tr>
                   <td><input type="radio" name="referenceId" value=${googleDTO.referenceId} >
                   <td><div><img src=${googleDTO.icon} alt="Image not display"></div></td>
                   <td>${googleDTO.keyword}</td>
                   <td>${googleDTO.types}</td>
                   <td>${googleDTO.address}
                    <input type="hidden" name="reference" value=${googleDTO.referenceId}> 
                    
                    
              </tr>
         </c:forEach>
               <tr>
               <div align="center">
                  <td colspan="2" align="center"><input type="submit" value="FIND DETAIL" />
                  <input type="hidden" name="sensor" value="false"></td></td>
                 
               </tr>
               </div>
        </table>
        </form>
       </div>
</body>
</html>