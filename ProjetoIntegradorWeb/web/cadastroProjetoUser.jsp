
<%@page import="dao.ProjetoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="assets/css/cadastro.css">
</head>
<body>
    <header>
        <h1>Cadastro de Projetos</h1>
        <div class="right">
            <a href="index.jsp" style="margin-right: -1700px;"><button style="background-color: #000;">Sair</button></a>
        </div>
    </header>

    <main>
        <div class="title">
            <h2>Lista de Projetos</h2>
            <br>
            <span>Projetos para Cadastro | Permissão Usuário Padrão</span>
        </div>
                
        <%
           //Arraylist de projetos chamando ProjetooDAO().consultarProjeto()
           ArrayList<Projeto> projetos = new ProjetoDAO().consultarProjeto();
        %>        

        <div class="content">
            <table border="1">
                <thead>
                    <th class="center">ID</th>
                    <th class="center">Nome Projeto</th>
                    <th class="center">Descrição</th>
                    <th class="center">Adicionar Requisito</th>
                    <th class="center">Versão</th>
                    <th class="center">Cliente</th>
                </thead>
                
                <%
                    for (int i = 0; i < projetos.size(); i++) {
                %>
                <tbody>                 
                    <tr>
                        <td class="center"><%= projetos.get(i).getId()%></td>
                        <td class="center"><%= projetos.get(i).getNomeProjeto()%></td>
                        <td class="center"><%= projetos.get(i).getDescricaoProjeto()%></td>
                        <td class="center"><a href="cadastroRequisitoUser.jsp"><button>Visualizar Requisitos</button></a></td>
                        <td class="center"><%= projetos.get(i).getVersao()%></td>
                        <td class="center"><%= projetos.get(i).getNomeCliente()%></td>
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