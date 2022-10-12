<%@page import="entidade.PessoaLogin"%>
<%@page import="dao.PessoaLoginDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Usuario"%>
<%@page import="dao.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Sistema Aplicação Web JSP</title>
        <link rel="stylesheet" type="text/css" href="assets/css/login.css">
    </head>
    <body>
   
        <%-- Vamos recuperar o atribudo 'alertMsg' de acao.java --%>
        <% 
            String message = (String)request.getAttribute("alertMsg"); 
            if (message == null) {
                message = "";
            }
        %>
        
        <%-- Alert em JavaScript --%>
        <script type="text/javascript">
            var msg = "<%=message%>";
            if (msg !== "") {
                alert(msg);
            }
        </script>

        <form name="formLogin" method="post" action="acao?param=login">
            <div class="container">
                <div class="form-box">
                    <div>
                        <h1>Login</h1>
                    </div>
                    <div>
                        <input type="text" name="usuario" placeholder="Usuário" class="form-input">
                    </div>
                    <div>
                        <input type="password" name="senha" placeholder="Senha" class="form-input">
                    </div>
                    <div class="select-estiloso">
                        <select name="tipousuario">
                           <option value="Padrão">Usuário Padrão</option>
                           <option value="Administrador">Usuário Administrador</option>
                        </select>
                    </div>
                    <div>
                        <input type="submit" value="Entrar" class="form-btn">
                    </div>
                    <div style="font-size: 20px; margin-top: 10%;">
                        Não é Cadastrado? <a href="cadastroLogin.jsp">Crie uma Conta</a>
                    </div>
                </div>
            </div>
        </form>
    </body>      
</html>
