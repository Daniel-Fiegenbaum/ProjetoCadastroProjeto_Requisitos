
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
    
    <% 
        //Recuperando o atributo produto cujo valor é um objeto do tipo pessoa
        //Se estou em uma edição quero recuperar este valor e mostrar no form pelo 'input value'
        Projeto p = (Projeto) request.getAttribute("projeto");

        //Se objeto p for null, estou inserindo novo registro (INSERT)
        if (p == null) {
            //Se p for null crio um novo objeto
            p = new Projeto();
            p.setId(0);
            p.setNomeProjeto("");
            p.setDescricaoProjeto("");
            p.setVersao(0);
            p.setNomeCliente("");
        }
    %>

    <main>
        <div class="title">
            <h2>Lista de Projetos</h2>
            <span>Projetos para Cadastro</span>
        </div>

        <div class="card">
            <form name="cadastroProjeto" method="post" action="acao?param=cadastroProjeto">
                <input type="hidden" name="id" value="<%= p.getId()%>"><br>
                <div class="lineInput">
                    <label>Nome Projeto</label>
                    <input type="text" id="nomeProjeto" name="nomeProjeto" placeholder="Nome do Projeto" value="<%= p.getNomeProjeto()%>" required>
                </div>
                <div class="lineInput">
                    <label>Descrição</label>
                    <input type="text" id="descricaoProjeto" name="descricaoProjeto" placeholder="Descrição do Projeto" value="<%= p.getDescricaoProjeto()%>" required>
                </div>
                <div class="lineInput">
                    <label>Versão</label>
                    <input type="number" id="versao" name="versao" placeholder="Versão do Projeto" value="<%= p.getVersao()%>" required>
                </div>
                <div class="lineInput">
                    <label>Cliente</label>
                    <input type="text" id="nomeCliente" name="nomeCliente" placeholder="Nome do Cliente" value="<%= p.getNomeCliente()%>" required>
                </div>

                <button>Salvar Projeto</button>
            </form>
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
                    <th class="center">Editar</th>
                    <th class="center">Excluir</th>
                </thead>
                
                <%
                    for (int i = 0; i < projetos.size(); i++) {
                %>
                <tbody>                 
                    <tr>
                        <td class="center"><%= projetos.get(i).getId()%></td>
                        <td class="center"><%= projetos.get(i).getNomeProjeto()%></td>
                        <td class="center"><%= projetos.get(i).getDescricaoProjeto()%></td>
                        <td class="center"><a href="cadastroRequisito.jsp"><button>Adicionar Requisito</button></a></td>
                        <td class="center"><%= projetos.get(i).getVersao()%></td>
                        <td class="center"><%= projetos.get(i).getNomeCliente()%></td>
                        <%-- Cria um link para o 'acao' por meio de um get com o respectivo 'param' + o Id do produto --%>
                        <td class="center"><a href="acao?param=updateProjeto&id=<%= projetos.get(i).getId()%>">Editar</a></td>
                        <td class="center"><a href="acao?param=deleteProjeto&id=<%= projetos.get(i).getId()%>">Excluir</a></td>
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