<%@ include file="/WEB-INF/jsp/include.jsp"%>

<c:url var="add"    value="/message/add" />
<c:url var="remove" value="/message/removeAll" />
<c:url var="list"   value="/message/list" />

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