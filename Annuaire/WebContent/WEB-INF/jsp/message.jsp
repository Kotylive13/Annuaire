<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="add"    value="/actions/message/add" />
<c:url var="remove" value="/actions/message/removeAll" />
<c:url var="list"   value="/actions/message/list" />

<html>
<body>
    <h1>Messages</h1>

    <form action="${add}" method="POST">
    <p>
        <input name="text" size="10"/>
        <input type="submit" value="Add"/> | 
        <a href="${list}">List</a> |
        <a href="${remove}">Remove All</a>
    </p>
    </form>

    <ul>
        <c:forEach items="${messages}" var="m">
            <li>${m.number} : ${m.text}</li>
        </c:forEach>
    </ul>
</body>
</html>