<%@include file="include.jsp" %>
<html>
<head>
    <title>All books</title>
</head>
<body>

    <c:set var="books" value="${books}"/>
    <c:set var="newBook" value="${newBook}"/>

    <div align="center" style="width: 1024px; margin: 30px auto;">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th>Name</th>
                <th>Author</th>
                <th>Download</th>
                <th>Read online</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${books}" var="book">
                <tr>
                    <th>${book.name}</th>
                    <th>${book.authorList}</th>
                    <th><button class="download">Download</button></th>
                    <th><button class="readonline">Read online</button></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <%--<div align="center" style="width: 1024px; margin: 0 auto;">--%>
        <%--<form id="addBook">--%>
            <%--<input id="name" name="name" type="text" placeholder="Name">--%>
        <%--</form>--%>
        <%--<button id="addBookButton" style="margin-top: 2px">Add book</button>--%>
    <%--</div>--%>

    <script>
        $(document).ready(function () {

            var table = $('#table_id').DataTable();

//            $('#addBookButton').click(function () {
//
//                $.ajax({
//                    type: 'POST',
//                    url: 'allbooks',
//                    dataType: 'json',
//                    data: {
//                        name: $('#name').val()
//                    },
//
//                    success: function (result) {
//                        var er = result.errorTitle == undefined;
//
//                        if (er) {
//                            alert("Done!");
//                            table.row.add([
//                                result.name
//                            ]).draw(false);
//
//                        } else {
//                            alert(result.errorTitle + '\n ' + result.errorMsg);
//                        }
//
//                    },
//                    error: function (result) {
//                        alert(result.errorTitle + '\n ' + result.errorMsg);
//                    }
//                })
//            })

            $('.download').click(function () {

                    $.ajax({

                     success: function (result) {

                         var er = result.errorTitle == undefined;

                         if (er) {
                            alert("Done, download!");

                        } else {
                            alert(result.errorTitle + '\n ' + result.errorMsg);
                        }

                    },
                    error: function (result) {
                        alert(result.errorTitle + '\n ' + result.errorMsg);
                    }
                })
            })

            $('.readonline').click(function () {

                $.ajax({

                    success: function (result) {

                        var er = result.errorTitle == undefined;

                        if (er) {
                            alert("Read online!");

                        } else {
                            alert(result.errorTitle + '\n ' + result.errorMsg);
                        }

                    },
                    error: function (result) {
                        alert(result.errorTitle + '\n ' + result.errorMsg);
                    }
                })
            })
        });

    </script>

</body>
</html>








