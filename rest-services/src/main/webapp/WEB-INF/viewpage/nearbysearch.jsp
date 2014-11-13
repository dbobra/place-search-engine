<html>
<head>
<title>Place Information</title>
</head>
<body>
    <div align="center">
        <form action="<%=request.getContextPath()%>/search/nearbyresultdisplay" method="get">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Place Information</h2></td>
                </tr>
                <tr>
                    <td>Place</td>
                    <td><input type="text" name="keyword" value=${googleDTO.keyword}  readonly></td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td>
                        <input type="text" name="latitude" placeholder="latitude"  />
                        <input type="text" name="longitude" placeholder="longitude" />
                    
                    </td>
                </tr>
                <tr>
                    <td>Radius</td>
                    <td><input type="text"  name="radius" /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="sensor" value="false" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="FIND" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>