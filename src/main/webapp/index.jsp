<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Tweets</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
</head>

<body>
    <div>All tweets</div>
    <div>
            <form action="/twitter/" method="post">
                <input name="tweetline" value="" autofocus><br/>
                <input type="hidden" name="action" value="tweet">
                <input type="submit" value="tweet">
            </form>
    </div>


    <table>
        <tr>
            <td>Number</td>
            <td>Name</td>
        </tr>

        <c:forEach var="tweet" items="${tweets}" >
            <tr>
                <td>${tweet.name}</td>
                <td>${tweet.text}</td>
            </tr>
        </c:forEach>
    </table>




</body>


</html>
