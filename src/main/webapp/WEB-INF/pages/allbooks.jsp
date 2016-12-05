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
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${books}" var="book">
                <tr>
                    <th>${book.name}</th>
                    <th>${book.authorList}</th>
                    <th><button class="download">Download</button></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div align="center" style="width: 1024px; margin: 0 auto;">
        <form id="addBook">
            <input id="name" name="name" type="text" placeholder="Name">
        </form>
        <button id="addBookButton" style="margin-top: 2px">Add book</button>
    </div>

    <script>
        $(document).ready(function () {

            var table = $('#table_id').DataTable();

            $('#addBookButton').click(function () {

                $.ajax({
                    type: 'POST',
                    url: 'allbooks',
                    dataType: 'json',
                    data: {
                        name: $('#name').val()
                    },

                    success: function (result) {
                        var er = result.errorTitle == undefined;

                        if (er) {
                            alert("Done!");
                            table.row.add([
                                result.name
                            ]).draw(false);

                        } else {
                            alert(result.errorTitle + '\n ' + result.errorMsg);
                        }

                    },
                    error: function (result) {
                        alert(result.errorTitle + '\n ' + result.errorMsg);
                    }
                })
            })

//            $('.editbtn').click(function(){
//                $(this).html($(this).html() == 'edit' ? 'modify' : 'edit');
//            });

            $('.download').click(function () {

                    $.ajax({
//                    data: {
////                        name: $('#table_id').fnGetData($(this))
//                        name: $('#table_id').dataTable().row(this).data().name
//                    },

                     success: function (result) {

                         var er = result.errorTitle == undefined;
//                         var $row = $(this);
//                         var name = $row.find('name').value();

                         if (er) {
//                            alert("Done, download!" + $(this).parent().children(0).val());
//                             alert("Done, download!" + $(this).text);
                             alert($(this).parent().prev('th').val());

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








