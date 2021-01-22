<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/exameForm.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Novo/Editar Exame</title>
</head>
<body>

<script type="text/javascript">
function enviarForm() {
	var dataDigitada = document.getElementById('data').value;
	dataDigitada = my_date(dataDigitada);
	var hoje = new Date();
	console.log(dataDigitada,hoje);
	if (hoje <= dataDigitada || !dataDigitada.getDate()) {
		document.getElementById('form').submit();
	} else {
		alert("Data deve ser maior que data atual!")
	}
}

 function my_date(date_string) {
      var date_components = date_string.split("/");
      var day = date_components[0];
      var month = date_components[1];
      var year = date_components[2];
      return new Date(year, month - 1, day);
    }
</script>

    <div align="center">
        <h1>Novo/Editar Exame</h1>
        
        <form:form id="form" action="saveExame" method="post" modelAttribute="exame">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td class="right" >Paciente*:</td>
                <td class="left">
                <form:input path="paciente" />
                <form:errors path="paciente" cssClass="error"></form:errors>
                </td>
            </tr>
            <tr>
            
                <td class="right" >Exame*:</td>
                <td class="left">
                <form:input path="exame" />
                <form:errors path="exame" cssClass="error"></form:errors>
                </td>
            </tr>
            <tr>
                <td class="right" >Data do Exame*:</td>
                <fmt:formatDate value="${exame.dataExame}" pattern="dd/MM/yyyy" var="myDate"/>
                <td class="left">
                <form:input id="data" type="text" mask="dd/mm/yyyy" path="dataExame" value="${myDate}" />
                <form:errors path="dataExame" cssClass="error"></form:errors>
                </td>
            </tr>
            <tr>
                <td class="right" >Observação/Resultado:</td>
                <td class="left"><form:input path="observacaoResultado" /></td>
            </tr>
            <tr>
                <td class="right" ></td>
                <td class="left">* Campos obrigatórios</td>
            </tr>
            
        </table>
        </form:form>
        <div style="width: 100%; margin-bottom: 2%;">
        
        </div>
        <tr>
                <td>
                <button class="button1" onclick="enviarForm()">Salvar</button>
<!--                 <input disabled="true" type="submit" value="Salvar"> -->
                </td>
                
            </tr>
            
            <form method="get" action="/crudProject">
            	<button class="button1 button2" >Voltar</button>
            </form>
            
    </div>
</body>
</html>