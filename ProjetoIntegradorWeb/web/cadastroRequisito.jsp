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
    <style>
        select{
            width: 100%;
            text-align: center;
            padding: 10px 15px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

    </style>
    <body>
    <header>
        <h1>Cadastro de Requisitos</h1>
        <div class="right">
            <a href="index.jsp" style="margin-right: -1700px;"><button style="background-color: #000;">Sair</button></a>
        </div>
    </header>
        
    <% 
        //Recuperando o atributo produto cujo valor é um objeto do tipo pessoa
        //Se estou em uma edição quero recuperar este valor e mostrar no form pelo 'input value'
        Requisito r = (Requisito) request.getAttribute("requisito");
        
        //Se objeto p for null, estou inserindo novo registro (INSERT)
        if (r == null) {
            //Se p for null crio um novo objeto
            r = new Requisito();
            r.setId(0);
            r.setNomeRequisito("");
            r.setDescricaoRequisito("");
            r.setPrioridadeRequisito("");
            r.setTipoRequisito("");
            r.setComplexidade("");
        }
    %>
    

    <main>
        <div class="title">
            <h2>Requisitos</h2>
            <span>Lista de Requisitos</span>
        </div>

        <div class="card">
            <form name="cadastroRequisito" method="post" action="acao?param=cadastroRequisito">
                <input type="hidden" name="id" value="<%= r.getId()%>"><br>
                <div class="lineInput">
                    <label>Requisito</label>
                    <input type="text" name="nomeRequisito" value="<%= r.getNomeRequisito()%>" placeholder="Nome do Requisito" required>
                </div>
                <div class="lineInput">
                    <label>Descrição</label>
                    <input type="text" name="descricaoRequisito" placeholder="Descrição do Requisito" value="<%= r.getDescricaoRequisito()%>" required>
                </div>
                <div class="lineInput">
                    <label>Prioridade</label>
                    <select name="prioridadeRequisito" value="<%= r.getPrioridadeRequisito()%>" required>
                        <option value="Baixa">Baixa</option>
                        <option value="Média">Média</option>
                        <option value="Alta">Alta</option>
                    </select>
                </div>
                <div class="lineInput">
                    <label>Complexidade</label>
                    <select name="complexidade" value="<%= r.getComplexidade()%>" required>
                        <option value="Baixa">Baixa</option>
                        <option value="Média">Média</option>
                        <option value="Alta">Alta</option>
                    </select>
                </div>
                <div class="lineInput">
                    <label>Tipo</label>
                    <select name="tipoRequisito" value="<%= r.getTipoRequisito()%>" required>
                        <option value="Funcional">Funcional</option>
                        <option value="Não Funcional">Não Funcional</option>
                    </select>
                </div>
                <div class="lineInput">
                    <select name="projeto_id" id="projeto_id" onchange="pegaValor()" required>
                        <%
                          ArrayList projetos = new ProjetoDAO().consultarProjeto();
                            for (int i = 0; i < projetos.size(); i++) {
                                Projeto p = (Projeto) projetos.get(i);
                        %>
                        <option value="<%= p.getId()%>">
                            <%= p.getNomeProjeto()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    
                </div>
                <button>Salvar Requisito</button>
            </form>
            <br>
            <a href="cadastroProjetos.jsp"><button>Voltar</button></a>
            <a href="relatorio.jsp"><button>Gerar Relatório</button></a>
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
                    <th class="center">Editar</th>
                    <th class="center">Excluir</th>
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
                        <%-- Cria um link para o 'acao' por meio de um get com o respectivo 'param' + o Id do produto --%>
                        <td class="center"><a href="acao?param=updateRequisito&id=<%= requisitos.get(i).getId()%>">Editar</a></td>
                        <td class="center"><a href="acao?param=deleteRequisito&id=<%= requisitos.get(i).getId()%>">Excluir</a></td>
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
