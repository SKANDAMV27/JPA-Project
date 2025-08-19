<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <html>
 <head>
 <title>Display</title>
 </head>
 <body>
  <c:forEach items="${errors}" var="error">
                 <div class="field-error">${error.defaultMessage}</div>
               </c:forEach>
 </body>
 </html>