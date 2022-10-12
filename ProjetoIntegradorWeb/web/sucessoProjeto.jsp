<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <%-- meta refresh para redirecionar para cadProduto.jsp depois de 2s --%>
        <meta http-equiv="refresh" content="2;url=cadastroProjetos.jsp" />
        <link rel="stylesheet" type="text/css" href="assets/css/sucesso.css">
        <title>Sistema Aplicação Web JSP</title>
    </head>
    <style>
        
    </style>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <h1 id="main-title">Ação Realizada com Sucesso!</h1>
        <div id="score-container">
            <h1>Sua ação foi realizada com Sucesso!<i class="fa fa-check"></i></h1>
            <a href="cadastroProjetos.jsp"><button id="voltar">Voltar</button></a>
        </div>
    </body>
</html>
