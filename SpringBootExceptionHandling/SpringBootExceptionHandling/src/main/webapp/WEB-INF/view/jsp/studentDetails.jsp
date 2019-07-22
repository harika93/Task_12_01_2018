<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
		<c:choose>
			<c:when test="${not empty student }">
				<p>Name: ${student.studentName }</p>
				<p>Roll: ${student.studentRollNo }</p>
			</c:when>
			<c:otherwise>
				Something went wrong
			</c:otherwise>
		</c:choose>
	</body>
</html>