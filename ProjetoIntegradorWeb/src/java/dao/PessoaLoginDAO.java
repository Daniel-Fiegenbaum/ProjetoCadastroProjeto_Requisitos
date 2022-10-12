/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.PessoaLogin;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniel Leonardo Fiegenbaum
 */
public class PessoaLoginDAO {
    //Método salvar - retorna Boolean
    public boolean salvar(PessoaLogin p) {
        try {
            //Cria a conexao
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();     
            
            String sql = "";

            //Se getId for 0 será um INSERT
            if (p.getId() == 0) {

                sql
                        = "insert into usuario values ("
                        +"default,"
                        +"'" + p.getUsuario() + "',"
                        +"'" + p.getSenha() + "',"
                        +"'" + p.getEmail() + "',"
                        +"'" + p.getTipousuario() + "')";
                System.out.println("SQL: " + sql);

            //Caso contrário será um UPDATE
            } else {
                sql
                        = "update usuario "
                        + "set usuario = '" + p.getUsuario() + "', "
                        + "senha = '" + p.getSenha() + "', "
                        + "email = '" + p.getEmail() + "', "
                        + "tipousuario = '" + p.getTipousuario() + "' "
                        + "where id = " + p.getId();
                System.out.println("SQL: " + sql);
            }
            
            //Método executeUpdate - Executa a instrução SQL fornecida
            //pode ser uma instrução INSERT, UPDATE ou DELETE
            //Valor de retorno: Um int que indica o número de linhas afetadas 
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuario: " + e);
            return false;
        }
    }
       
    //Método consultarPessoaLogin - todos os PessoaLogin
    //Retorna arraylist de PessoaLogin
    public ArrayList<PessoaLogin> consultarPessoaLogin(){
        
        ArrayList<PessoaLogin> pessoas = new ArrayList();
        
        try {
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select * "
                    + "from usuario "
                    + "order by id";
                    
            System.out.println("SQL: " + sql);

            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet                     
            ResultSet resultado = st.executeQuery(sql);
            
            while (resultado.next()) {
                PessoaLogin p = new PessoaLogin();
                p.setId(resultado.getInt("id"));
                p.setUsuario(resultado.getString("usuario"));
                p.setSenha(resultado.getString("senha"));
                p.setEmail(resultado.getString("email"));
                p.setTipousuario(resultado.getString("tipousuario"));                
                pessoas.add(p);
            }
        } catch(Exception e) {
            System.out.println("Erro ao consultar PessoaLogin: " + e);
        }
        
        return pessoas;
    }
    
    //Método consultarProduto - apenas PessoaLogin com o id informado    
    //Retorna objeto PessoaLogin
    public PessoaLogin consultarPessoaLogin(int id){
        
        PessoaLogin p = null;
        
        try {            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select * "
                    + "from usuario "
                    + "where id = " + id;
                    
            System.out.println("SQL: " + sql);
            
            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet                     
            ResultSet resultado = st.executeQuery(sql);
            
            while(resultado.next()){
                p = new PessoaLogin();
                p.setId(resultado.getInt("id"));
                p.setUsuario(resultado.getString("usuario"));
                p.setSenha(resultado.getString("senha"));
                p.setEmail(resultado.getString("email"));
                p.setTipousuario(resultado.getString("tipousuario"));
                
            }

            
        } catch(Exception e) {
            System.out.println("Erro ao consultar PessoaLogin: " + e);
        }
      
        return p;
    }    
    
    //Método excluir - retorna boolean
    public boolean excluir(int id) {
                
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "delete from usuario "
                    + "where id = " + id;
                    
            System.out.println("SQL: " + sql);

            //Método executeUpdate - Executa a instrução SQL fornecida
            //pode ser uma instrução INSERT, UPDATE ou DELETE
            //Valor de retorno: Um int que indica o número de linhas afetadas             
            int resultado = st.executeUpdate(sql);
            
            return true;
        
        } catch(Exception e) {
            System.out.println("Erro ao excluir PessoaLogin: " + e);
            return false;
        }
        
    }
}
