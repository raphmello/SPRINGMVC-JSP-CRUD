<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" -->
<!--    "http://www.w3.org/TR/html4/loose.dtd"> -->

<!-- <html> -->
<!--     <head> -->
<!--         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!--         <title>Home</title> -->
<!--     </head> -->
<!--     <body> -->
<!--         <h1>Hello World!</h1> -->
<!--         <p>This is the homepage!</p> -->
<!--     </body> -->
<!-- </html>  -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/home.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Contact Manager Home</title>
    </head>
    <body>
    
    <script type="text/javascript">
    function orderPaciente () {
    	document.getElementById('formPaciente').submit();
    }
    function orderExame () {
    	document.getElementById('formExame').submit();
    }
    </script>
    
        <div class="flexDiv">
            <h1>EXAMES</h1>
            
            <div class="header1">
            <form method="get" action="newExame">
            	<button class="button1" >Novo Exame</button>
            </form>
   
            <small>Ordenar por: </small>
            
            <button class="button1 button2" onclick="orderPaciente()" >Paciente</button>
          	<button class="button1 button2" onclick="orderExame()" >Exame</button>
	            
	            <form id="formPaciente" method="get" action="/crudProject/">
	            	<input class="hidden" name="order" value="paciente"></input>
	            </form>
	            <form id="formExame" method="get" action="/crudProject/">
	            	<input class="hidden" name="order" value="exame"></input>
	            </form>
       		</div>
           
            <table>
                <th>No</th>
                <th>Paciente</th>
                <th>Exame</th>
                <th>Data do Exame</th>
                <th>Observação/Resultado</th>
                <th>Ações</th>
                 
                <c:forEach var="exame" items="${listExame}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${exame.paciente}</td>
                    <td>${exame.exame}</td>
                    <fmt:formatDate value="${exame.dataExame}" pattern="dd/MM/yyyy" var="myDate"/>
                    <td>${myDate}</td>
                    <td>${exame.observacaoResultado}</td>
                    <td>
                        <a class="fa fa-edit"  href="editExame?id=${exame.id}"></a>
                      
                        <a class="fa fa-close" href="deleteExame?id=${exame.id}"></a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>