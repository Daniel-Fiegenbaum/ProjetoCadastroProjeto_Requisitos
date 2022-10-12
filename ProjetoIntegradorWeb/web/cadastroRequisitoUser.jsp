<%-- 
    Document   : cadastroRequisito
    Created on : 18 de set. de 2022, 01:26:50
    Author     : User
--%>

<%@page import="dao.ProjetoDAO"%>
<%@page import="entidade.Projeto"%>
<%@page import="dao.RequisitoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Requisito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/cadastro.css">
        <title>JSP Page</title>
    </head>
    <script>
        // essa funcao captura o valor da combo e atribui a um INPUT
        function pegaValor() {
            var projetos = document.getElementById("projeto_id");
            document.getElementById("campo").value = projetos.options[projetos.selectedIndex].value;
        }
    </script>
    <body>
    <header>
        <h1>Cadastro de Requisitos</h1>
        <div class="right">
            <a href="index.jsp" style="margin-right: -1700px;"><button style="background-color: #000;">Sair</button></a>
        </div>
    </header>

    <main>
        <div class="title">
            <h2>Requisitos</h2>
            <span>Requisitos | Permissão Usuário Padrão</span>
        </div>
        <br>
        <div>
            <a href="cadastroProjetoUser.jsp"><button>Voltar</button></a>
            <a href="relatorioUser.jsp"><button>Gerar Relatório</button></a>
        </div>
        <%
           //Arraylist de projetos chamando ProjetooDAO().consultarProjeto()
           ArrayList<Requisito> requisitos = new RequisitoDAO().consultarRequisito();
        %>

        <div class="content">
            <table border="1">
                <thead>
                    <th class="center">ID</th>
                    <th class="center">Projeto</th>
                    <th class="center">Nome Requisito</th>
                    <th class="center">Descrição</th>
                    <th class="center">Prioridade</th>
                    <th class="center">Complexidade</th>
                    <th class="center">Tipo</th>
                </thead>
                
                <%
                    for (int i = 0; i < requisitos.size(); i++) {
                %>
                <tbody>                 
                    <tr>    
                        <td class="center"><%= requisitos.get(i).getId()%></td>
                        <td class="center"><%= requisitos.get(i).getProjeto_id()%></td>
                        <td class="center"><%= requisitos.get(i).getNomeRequisito()%></td>
                        <td class="center"><%= requisitos.get(i).getDescricaoRequisito()%></td>
                        <td class="center"><%= requisitos.get(i).getPrioridadeRequisito()%></td>
                        <td class="center"><%= requisitos.get(i).getComplexidade()%></td>
                        <td class="center"><%= requisitos.get(i).getTipoRequisito()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </main>
  
</body>
</html>
