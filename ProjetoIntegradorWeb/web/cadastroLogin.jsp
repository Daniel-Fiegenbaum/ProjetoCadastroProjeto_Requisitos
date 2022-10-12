<%-- 
    Document   : cadastroLogin
    Created on : 11 de set. de 2022, 18:12:24
    Author     : Daniel Leonardo Fiegenbaum
--%>

<%@page import="entidade.PessoaLogin"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="assets/css/login.css">
    </head>
    <body>
            <% 
        PessoaLogin p = (PessoaLogin) request.getAttribute("usuario");

        //Se objeto p for null, estou inserindo novo registro (INSERT)
        if (p == null) {
            //Se p for null crio um novo objeto
            p = new PessoaLogin();
            p.setId(0);
            p.setUsuario("");
            p.setSenha("");
            p.setEmail("");
            p.setTipousuario("");
        }
    %>
    
        <main>
            <div class="container">
                <div class="form-box">
                    <form name="formCadastroLogin" method="post" action="acao?param=cadastroLogin">
                        <input type="hidden" name="id" value="<%= p.getId()%>"><br>
                        <div>
                            <h1>Cadastro do Usuário</h1>
                        </div>
                        <div>
                            <input type="text" name="usuario" placeholder="Informe o seu Login" value="<%= p.getUsuario()%>" class="form-input" required>
                        </div>
                        <div>
                            <input type="text" name="senha" placeholder="Informe a sua Senha" value="<%= p.getSenha()%>" class="form-input" required>
                        </div>
                        <div>
                            <input type="text" name="email" placeholder="Informe o seu E-mail" value="<%= p.getEmail()%>" class="form-input" required>
                        </div>
                        <div class="select-estiloso">
                            <select name="tipousuario" value="<%= p.getTipousuario()%>">
                               <option value="Padrão">Usuário Padrão</option>
                               <option value="Administrador">Usuário Administrador</option>
                            </select>
                        </div>
                        <div>
                            <input type="submit" value="Salvar" class="form-btn">
                        </div>
                    </form>
                    <br>
                    <div style="font-size: 14px;">
                        Você deseja consultar todos os usuários? <a href="listagemCadastro.jsp">Consulte</a>
                    </div>
                    <br>
                    <div style="font-size: 14px;">
                        Você já tem uma conta? <a href="index.jsp">Efetue o seu Login</a>
                    </div>       
                </div>
            </div>
        </main>
    </body>
</html>
