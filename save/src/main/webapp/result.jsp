<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <html>
 <head>
 <title>Display</title>
 </head>
 <body>
 <h1>${name}</h1>
 <h2>${email}</h2>
 <h3>${age}</h3>
 <h4>${number}</h4>
<c:forEach items="${errors}" var="error">
                      <div class="field-error">${error.defaultMessage}</div>
                    </c:forEach>
 </body>
 </html>