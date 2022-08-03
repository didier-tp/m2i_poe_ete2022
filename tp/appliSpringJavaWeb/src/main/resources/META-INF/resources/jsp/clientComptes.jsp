<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>clientComptes</title></head>
<body>
<h3>Client et ses comptes</h3>
numero: ${client.numero} <br/>
prenom: ${client.prenom} <br/>
nom: ${client.nom} <br/>
   <table border="1">
       <tr><th>numero</th><th>label</th><th>solde</th></tr>
       <c:forEach var="c" items="${client.comptes}">
          <tr>
             <td>${c.numero}</td><td>${c.label}</td><td>${c.solde}</td>
          </tr>
       </c:forEach>
   </table>
   <p> <a href="virement" >nouveau virement</a> </p>
</body>
</html>