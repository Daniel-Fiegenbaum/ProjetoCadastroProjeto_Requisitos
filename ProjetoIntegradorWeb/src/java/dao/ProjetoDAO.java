/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Projeto;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniel Leonardo Fiegenbaum
 */
public class ProjetoDAO {
    public boolean salvar(Projeto p) {
        try {
            //Cria a conexao
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();     
            
            String sql = "";

            //Se getId for 0 será um INSERT
            if (p.getId() == 0) {

                sql
                        = "insert into projeto values ("
                        +"default,"
                        +"'" + p.getNomeProjeto() + "',"
                        +"'" + p.getDescricaoProjeto() + "',"
                        +"'" + p.getVersao() + "',"
                        +"'" + p.getNomeCliente() + "')";
                System.out.println("SQL: " + sql);

            //Caso contrário será um UPDATE
            } else {
                sql
                        = "update projeto "
                        + "set nomeProjeto = '" + p.getNomeProjeto() + "', "
                        + "descricaoProjeto = '" + p.getDescricaoProjeto() + "', "
                        + "versao = '" + p.getVersao() + "', "
                        + "nomeCliente = '" + p.getNomeCliente() + "' "
                        + "where id = " + p.getId();
                System.out.println("SQL: " + sql);
            }

            //Método executeUpdate - Executa a instrução SQL fornecida
            //pode ser uma instrução INSERT, UPDATE ou DELETE
            //Valor de retorno: Um int que indica o número de linhas afetadas 
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar projeto: " + e);
            return false;
        }
    }
       
    //Método consultarPessoaLogin - todos os PessoaLogin
    //Retorna arraylist de PessoaLogin
    public ArrayList<Projeto> consultarProjeto(){
        
        ArrayList<Projeto> projetos = new ArrayList();
        
        try {
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select * "
                    + "from projeto "
                    + "order by id";
                    
            System.out.println("SQL: " + sql);

            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet                     
            ResultSet resultado = st.executeQuery(sql);
            
            while (resultado.next()) {
                Projeto p = new Projeto();
                p.setId(resultado.getInt("id"));
                p.setNomeProjeto(resultado.getString("nomeProjeto"));
                p.setDescricaoProjeto(resultado.getString("descricaoProjeto"));
                p.setVersao(resultado.getInt("versao")); 
                p.setNomeCliente(resultado.getString("nomeCliente")); 
                projetos.add(p);
            }
        } catch(Exception e) {
            System.out.println("Erro ao consultar Projeto: " + e);
        }
        
        return projetos;
    }
    
    //Método consultarProduto - apenas PessoaLogin com o id informado    
    //Retorna objeto PessoaLogin
    public Projeto consultarProjeto(int id){
        
        Projeto p = null;
        
        try {            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select * "
                    + "from projeto "
                    + "where id = " + id;
                    
            System.out.println("SQL: " + sql);
            
            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet                     
            ResultSet resultado = st.executeQuery(sql);
            
            while(resultado.next()){
                p = new Projeto();
                p.setId(resultado.getInt("id"));
                p.setNomeProjeto(resultado.getString("nomeProjeto"));
                p.setDescricaoProjeto(resultado.getString("descricaoProjeto"));
                p.setVersao(resultado.getInt("versao"));
                p.setNomeCliente(resultado.getString("nomeCliente"));
            }
        } catch(Exception e) {
            System.out.println("Erro ao consultar Projeto: " + e);
        }
      
        return p;
    }    
    
    //Método excluir - retorna boolean
    public boolean excluir(int id) {
                
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "delete from projeto "
                    + "where id = " + id;
                    
            System.out.println("SQL: " + sql);

            //Método executeUpdate - Executa a instrução SQL fornecida
            //pode ser uma instrução INSERT, UPDATE ou DELETE
            //Valor de retorno: Um int que indica o número de linhas afetadas             
            int resultado = st.executeUpdate(sql);
            
            return true;
        
        } catch(Exception e) {
            System.out.println("Erro ao excluir Projeto: " + e);
            return false;
        }
        
    }
}
