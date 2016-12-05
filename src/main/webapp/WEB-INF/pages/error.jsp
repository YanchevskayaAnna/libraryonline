<%@include file="include.jsp" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div class="centerDiv" align="center" style="width: 1024px; margin: 0 auto;">
    <h1>${errorTitle}</h1>
    <p>${errorMsg}</p>
    <form action="login">
        <input type="submit" value="Back" />
    </form>
</div>
</body>
</html>
