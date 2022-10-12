<%-- 
    Document   : listagemCadastro
    Created on : 13 de set. de 2022, 19:04:07
    Author     : Daniel Leonardo Fiegenbaum
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.PessoaLoginDAO"%>
<%@page import="dao.PessoaLoginDAO"%>
<%@page import="entidade.PessoaLogin"%>
<%@page import="entidade.PessoaLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="assets/css/listagemCadastro.css">
    </head>
    <body>

        <main>
            <div class="form-box">
                <div class="title">
                    <h3>Lista de Usuários</h3>
                </div>

                <%
                //Arraylist de produtos chamando ProdutoDAO().consultarProduto()
                ArrayList<PessoaLogin> pessoas = new PessoaLoginDAO().consultarPessoaLogin();
                %>

                <div class="content">
                    <table border="1">  
                        <thead>
                            <th class="center">ID</th>
                            <th class="center">Usuário</th>
                            <th class="center">Senha</th>
                            <th class="center">Email</th>
                            <th class="center">Tipo Usuário</th>
                            <th class="center">Editar</th>
                            <th class="center">Excluir</th>
                        </thead>

                        <%
                        for (int i = 0; i < pessoas.size(); i++) {
                        %>

                        <tbody>                 
                            <tr>
                                <td class="center"><%= pessoas.get(i).getId()%></td>
                                <td class="center"><%= pessoas.get(i).getUsuario()%></td>
                                <td class="center"><%= pessoas.get(i).getSenha()%></td>
                                <td class="center"><%= pessoas.get(i).getEmail()%></td>
                                <td class="center"><%= pessoas.get(i).getTipousuario()%></td>
                                <%-- Cria um link para o 'acao' por meio de um get com o respectivo 'param' + o Id do produto --%>
                                <td class="center"><a href="acao?param=updatePessoaLogin&id=<%= pessoas.get(i).getId()%>">Editar</a></td>
                                <td class="center"><a href="acao?param=deletePessoaLogin&id=<%= pessoas.get(i).getId()%>">Excluir</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <br>
                <div>
                    <a href="cadastroLogin.jsp"><input type="submit" value="Voltar" class="form-btn"></input></a>
    
                </div>
            </div>
        </main>
    </body>
</html>
