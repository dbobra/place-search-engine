<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail Information</title>
</head>
<body>
 <div align="center">
      <h1>Detail Information of Place</h1>
         <form action="<%=request.getContextPath()%>/search/save" method="POST">
           <table border = "0">
              <tr>
                  
                   <td width="100"></td>
                   <td width="100"><h2>Name</h2></td>
                   <td width="150"><h2>Address</h2></td>
                   <td width="150"><h2>Rating</h2></td>
                   <td width="150"><h2>City</h2></td>
                   <td width="150"><h2>State</h2></td>
                   <td width="150"><h2>Country</h2></td>
                   <td width="150"><h2>Postal Code</h2></td>
                   <td width="150"><h2>Maps URL</h2></td>
                   <td width="150"><h2>Website</h2></td>
                   <td width="150"><h2>Phone NO.</h2></td>
             </tr>
              <tr>
                   <td><div><img src=${googleDTO.icon} alt="Image not display"></div></td>
                   <td>${googleDTO.keyword}</td>
                   <td>${googleDTO.address}</td>
                   <td>${googleDTO.rating}</td>
                   <td>${googleDTO.city}</td>
                   <td>${googleDTO.state}</td>
                   <td>${googleDTO.country}</td>
                   <td>${googleDTO.postcode}</td>
                   <td><a href=${googleDTO.mapsUrl} >See Map </a></td>
                   <td><a href=${googleDTO.website}> See website </a></td>
                   <td>${googleDTO.phoneNumber}</td>
                   
              </tr>
                 <tr>
               <div align="center">
                  <td colspan="2" align="center"><input type="submit" value="SAVE DETAIL" />
                  <input type="hidden" name="referenceId" value=${googleDTO.referenceId} />
                  <input type="hidden" name="sensor" value="false" />
                  </td>
                 </div>
               </tr>
              <tr>
              </tr>
           </table>
        </form>
       </div>
</body>
</html>