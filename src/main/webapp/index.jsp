<%@include file="WEB-INF/pages/include.jsp"%>

<html>
<head>
    <title>Library online menu</title>
</head>
<body>

<div class="centerDiv" align="center" style="width: 1024px; margin: 0 auto;">
    <button id="findbyname" style="width: 100px">find book by name</button><br>
    <button id="findbyauthor" style="width: 100px">find book by author</button><br>
    <button id="findbynameauthor" style="width: 100px">find book by name and author</button><br>
    <button id="allbooks" style="width: 100px">all books</button><br>
</div>

<script>
    $('#findbyname').click(function () {
        location.href='findbyname';
    })
    $('#findbyauthor').click(function () {
        location.href='findbyauthor';
    })
    $('#findbynameauthor').click(function () {
        location.href='findbynameauthor';
    })
    $('#allbooks').click(function () {
        location.href='allbooks';
    })
</script>

</body>
</html>
