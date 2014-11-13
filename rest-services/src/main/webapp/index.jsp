<html>
<head>
<title>Place Search Engine</title>
</head>
<body>
    <div align="center">
        <form action="search/nearbysearch${searchparameter}" method="post">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Place Search Engine</h2></td>
                </tr>
                <tr>
                   <td><input type="text" name="keyword" /></td>
                </tr>
                <tr>
                    <td>
                        <select name="searchparameter" >
                                <option value="">---SELECT---</option>
                                <option value="nearbysearch">Near by search</option>
                                <option value="textsearch">Text search</option>
                                <option value="radarsearch">Radar Search</option>
                                
                         </select>
                    
                    </td>
                </tr>
                <tr>
                    <td><input type="hidden" name="sensor" value="false"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Search" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>