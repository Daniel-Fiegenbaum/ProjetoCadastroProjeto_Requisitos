package servlet;

import dao.LoginDAO;
import dao.PessoaLoginDAO;
import dao.ProjetoDAO;
import dao.RequisitoDAO;
import entidade.PessoaLogin;
import entidade.Projeto;
import entidade.Requisito;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class acao extends HttpServlet {
    
    //Declaração variáveis requisicao e resposta que vão ser usados mais abaixo
    //com visibilidade na classe toda
    HttpServletRequest requisicao;
    HttpServletResponse resposta;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //HttpServletResponse UTF-8 Encoding
        response.setContentType("text/html;charset=UTF-8");        
        
        requisicao = request; //recebe o parâmetro HttpServletRequest request
        resposta = response; // recebe o parâmetro HttpServletResponse response

        //Recupera para parametro o valor enviado por meio do 'param'        
        String parametro = request.getParameter("param");
        
        //doGET para update e delete PessoaLogin
        //Se parametro for igual a updatePessoa
        if (parametro.equals("updatePessoaLogin")) {
            //Recupera o parametro 'id' vindo do form
            int id = Integer.parseInt(requisicao.getParameter("id"));
            
            //Chama o método consultarPessoaLogin da classe ProdutoDAO, passando 'id' como parâmetro            
            PessoaLogin p = new PessoaLoginDAO().consultarPessoaLogin(id);
            
            //Seta para o atributo produto o valor do objeto PessoaLogin p
            //que é utilizado lá na request em cadPessoaLogin
            requisicao.setAttribute("usuario", p);
            
            //Encaminha o fluxo do browser para cadProduto
            encaminharPagina("cadastroLogin.jsp");
            
            
        
            //Se parametro for igual a deletePessoaLogin
        } else if (parametro.equals("deletePessoaLogin")) {
           int id = Integer.parseInt(request.getParameter("id"));

            //Chama o método excluir da classe PessoaLoginDAO, passando 'id' como parâmetro
           if (new PessoaLoginDAO().excluir(id)) {
               encaminharPagina("sucesso.jsp");
           } else {
               encaminharPagina("erro.jsp");
           }               
        }


         //doGET para update e delete Projeto
        //Se parametro for igual a updateProjeto
        if (parametro.equals("updateProjeto")) {
            //Recupera o parametro 'id' vindo do form
            int id = Integer.parseInt(requisicao.getParameter("id"));
            
            //Chama o método consultarPessoaLogin da classe ProjetoodutoDAO, passando 'id' como parâmetro            
            Projeto p = new ProjetoDAO().consultarProjeto(id);
            
            //Seta para o atributo produto o valor do objeto Projeto p
            //que é utilizado lá na request em cadProjeto
            requisicao.setAttribute("projeto", p);
            
            //Encaminha o fluxo do browser para cadProjeto
            encaminharPagina("cadastroProjetos.jsp");     
        
        //Se parametro for igual a deleteProjeto
        } else if (parametro.equals("deleteProjeto")) {
           int id = Integer.parseInt(request.getParameter("id"));

            //Chama o método excluir da classe ProjetoDAO, passando 'id' como parâmetro
           if (new ProjetoDAO().excluir(id)) {
               encaminharPagina("sucessoProjeto.jsp");
           } else {
               encaminharPagina("erroProjeto.jsp");
           }               
        }
        
        
         //doGET para update e delete Requisito
        //Se parametro for igual a updateRequisito
        if (parametro.equals("updateRequisito")) {
            //Recupera o parametro 'id' vindo do form
            int id = Integer.parseInt(requisicao.getParameter("id"));
            
            //Chama o método consultarRequisito da classe RequisitoDAO, passando 'id' como parâmetro            
            Requisito r = new RequisitoDAO().consultarRequisito(id);
            
            //Seta para o atributo produto o valor do objeto Requisito r
            //que é utilizado lá na request em cadastroRequisito
            requisicao.setAttribute("requisito", r);
            
            //Encaminha o fluxo do browser para cadRequisito
            encaminharPagina("cadastroRequisito.jsp");     
        
        //Se parametro for igual a deleteRequisito
        } else if (parametro.equals("deleteRequisito")) {
           int id = Integer.parseInt(request.getParameter("id"));

            //Chama o método excluir da classe RequisitoDAO, passando 'id' como parâmetro
           if (new RequisitoDAO().excluir(id)) {
               encaminharPagina("sucessoRequisito.jsp");
           } else {
               encaminharPagina("erroRequisito.jsp");
           }               
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //HttpServletResponse e HttpServletRequest UTF-8 Encoding
        response.setContentType("text/html;charset=UTF-8");               
        request.setCharacterEncoding("UTF-8");
        
        requisicao = request; //recebe o parâmetro HttpServletRequest request
        resposta = response; //recebe o parâmetro HttpServletResponse response

        //Recupera para parametro o valor enviado por meio do 'param'
        String parametro = request.getParameter("param");

        //Se parametro for 'login'
        if (parametro.equals("login")) {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String tipousuario = requisicao.getParameter("tipousuario");
            
            Usuario usuarios = new Usuario();
            usuarios.setUsuario(usuario);
            usuarios.setSenha(senha);
            usuarios.setTipousuario(tipousuario);
            
            LoginDAO login = new LoginDAO();
            
            if (login.logar(usuarios)) {
                if(usuarios.getTipousuario().equals("Administrador")){
                    encaminharPagina("cadastroProjetos.jsp");
                } else {
                    encaminharPagina("cadastroProjetoUser.jsp");
                }
            } else {
                //Vamos definir um atributo 'alertMsg' para utilizar index.jsp
                request.setAttribute("alertMsg", "Login invalido! Tente novamente.");                
                RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
                //O método include inclui o conteúdo na resposta.                
                rd.include(request, response);                
                //encaminharPagina("index.jsp");
            }
        }        
        
        //Se parametro for cadastroPessoal - Insert
        if (parametro.equals("cadastroLogin")) {
            int id = Integer.parseInt(requisicao.getParameter("id"));
            String usuario = requisicao.getParameter("usuario");
            String senha = requisicao.getParameter("senha");
            String email = requisicao.getParameter("email");
            String tipousuario = requisicao.getParameter("tipousuario");
            
            //Cria um novo objeto PessoaLogin e preenche com os valores recebidos
            PessoaLogin p = new PessoaLogin();
            p.setId(id);
            p.setUsuario(usuario);
            p.setSenha(senha);
            p.setEmail(email);
            p.setTipousuario(tipousuario);
            
            if (new PessoaLoginDAO().salvar(p)) {
                //Se voltar true
                encaminharPagina("sucesso.jsp");
            } else {
                //Se voltar false
                encaminharPagina("erro.jsp");
            }
        }
        
        //Se parametro for cadastroProjeto - Insert
        if (parametro.equals("cadastroProjeto")) {
            int id = Integer.parseInt(requisicao.getParameter("id"));
            String nomeProjeto = requisicao.getParameter("nomeProjeto");
            String descricaoProjeto = requisicao.getParameter("descricaoProjeto");
            int versao = Integer.parseInt(requisicao.getParameter("versao"));
            String nomeCliente = requisicao.getParameter("nomeCliente");
            
            //Cria um novo objeto PessoaLogin e preenche com os valores recebidos
            Projeto p = new Projeto();
            p.setId(id);
            p.setNomeProjeto(nomeProjeto);
            p.setDescricaoProjeto(descricaoProjeto);
            p.setVersao(versao);
            p.setNomeCliente(nomeCliente);
            
            if (new ProjetoDAO().salvar(p)) {
                //Se voltar true
                encaminharPagina("sucessoProjeto.jsp");
            } else {
                //Se voltar false
                encaminharPagina("erroProjeto.jsp");
            }
        }
        
        //Se parametro for cadastroRequisito - Insert
        if (parametro.equals("cadastroRequisito")) {
            int id = Integer.parseInt(requisicao.getParameter("id"));
            String nomeRequisito = requisicao.getParameter("nomeRequisito");
            String descricaoRequisito = requisicao.getParameter("descricaoRequisito");
            String prioridadeRequisito = requisicao.getParameter("prioridadeRequisito");
            String tipoRequisito = requisicao.getParameter("tipoRequisito");
            String complexidade = requisicao.getParameter("complexidade");
            int projeto_id = Integer.parseInt(requisicao.getParameter("projeto_id"));
            
            //Cria um novo objeto Requisito e preenche com os valores recebidos
            Requisito r = new Requisito();
            r.setId(id);
            r.setNomeRequisito(nomeRequisito);
            r.setDescricaoRequisito(descricaoRequisito);
            r.setPrioridadeRequisito(prioridadeRequisito);
            r.setTipoRequisito(tipoRequisito);
            r.setComplexidade(complexidade);
            r.setProjeto_id(projeto_id);
            
            if (new RequisitoDAO().salvar(r)) {
                //Se voltar true
                encaminharPagina("sucessoRequisito.jsp");
            } else {
                //Se voltar false
                encaminharPagina("erroRequisito.jsp");
            }
        }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //Método encaminharPagina
    private void encaminharPagina(String pagina) {
        try {
            //RequestDispatcher fornece a facilidade de despachar a solicitação para outro recurso
            RequestDispatcher rd = requisicao.getRequestDispatcher(pagina);
            //forward (solicitação de ServletRequest, resposta de ServletResponse)
            rd.forward(requisicao, resposta);
        } catch (Exception e) {
            System.out.println("Erro no encaminhamento: " + e);
        }
    }
    
}
