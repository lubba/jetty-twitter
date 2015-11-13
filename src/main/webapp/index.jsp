
<html>
<head>
    <title>Tweets</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
</head>

<body>
    <div>All tweets</div>

    <table>
        <tr>
            <td>Number</td>
            <td>Name</td>
            <td>Text</td>
        </tr>

        <c:forEach var="tweet" items="${tweets}">
            <tr>
                <td>${tweet.number}</td>
                <td>${tweet.name}</td>
                <td>${tweet.text}</td>
            </tr>
        </c:forEach>
    </table>

    <div>
        <form action="/serverapp/" method="post">
            <input name="tweetline" value="" autofocus><br/>
            <input type="hidden" name="action" value="tweet">
            <input type="submit" value="tweet">
        </form>
    </div>
</body>

</html>
