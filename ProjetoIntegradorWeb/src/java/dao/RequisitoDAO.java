/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Requisito;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniel Leonardo Fiegenbaum
 */
public class RequisitoDAO {
    public boolean salvar(Requisito r) {
        try {
            //Cria a conexao
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();     
            
            String sql = "";

            //Se getId for 0 será um INSERT
            if (r.getId() == 0) {

                sql
                        = "insert into requisito values ("
                        +"default,"
                        +"'" + r.getNomeRequisito() + "',"
                        +"'" + r.getDescricaoRequisito() + "',"
                        +"'" + r.getPrioridadeRequisito() + "',"
                        +"'" + r.getTipoRequisito() + "',"
                        +"'" + r.getComplexidade() + "',"
                        +"'" + r.getProjeto_id()+ "')";
                System.out.println("SQL: " + sql);

            //Caso contrário será um UPDATE
            } else {
                sql
                        = "update requisito "
                        + "set nomeRequisito = '" + r.getNomeRequisito() + "', "
                        + "descricaoRequisito = '" + r.getDescricaoRequisito() + "', "
                        + "prioridadeRequisito = '" + r.getPrioridadeRequisito() + "', "
                        + "tipoRequisito = '" + r.getTipoRequisito() + "', "
                        + "complexidade = '" + r.getComplexidade() + "', "
                        + "projeto_id = '" + r.getProjeto_id() + "' "
                        + "where id = " + r.getId();
                System.out.println("SQL: " + sql);
            }
            
            //Método executeUpdate - Executa a instrução SQL fornecida
            //pode ser uma instrução INSERT, UPDATE ou DELETE
            //Valor de retorno: Um int que indica o número de linhas afetadas 
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar requisito: " + e);
            return false;
        }
    }
       
    //Método consultarRequisito - todos os Requisitos
    //Retorna arraylist de Requisito
    public ArrayList<Requisito> consultarRequisito(){
        
        ArrayList<Requisito> requisitos = new ArrayList();
        
        try {
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select * "
                    + "from requisito "
                    + "order by id";
                    
            System.out.println("SQL: " + sql);

            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet                     
            ResultSet resultado = st.executeQuery(sql);
            
            while (resultado.next()) {
                Requisito r = new Requisito();
                r.setId(resultado.getInt("id"));
                r.setNomeRequisito(resultado.getString("nomeRequisito"));
                r.setDescricaoRequisito(resultado.getString("descricaoRequisito"));
                r.setPrioridadeRequisito(resultado.getString("prioridadeRequisito"));
                r.setTipoRequisito(resultado.getString("tipoRequisito"));
                r.setComplexidade(resultado.getString("complexidade"));
                r.setProjeto_id(resultado.getInt("projeto_id"));
                requisitos.add(r);
            }
        } catch(Exception e) {
            System.out.println("Erro ao consultar Projeto: " + e);
        }
        
        return requisitos;
    }
    
    //Método consultarRequisito - apenas Requisito com o id informado    
    //Retorna objeto Requisito
    public Requisito consultarRequisito(int id){
        
        Requisito r = null;
        
        try {            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select * "
                    + "from requisito "
                    + "where id = " + id;
                    
            System.out.println("SQL: " + sql);
            
            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet                     
            ResultSet resultado = st.executeQuery(sql);
            
            while(resultado.next()){
                r = new Requisito();
                r.setId(resultado.getInt("id"));
                r.setNomeRequisito(resultado.getString("nomeRequisito"));
                r.setDescricaoRequisito(resultado.getString("descricaoRequisito"));
                r.setPrioridadeRequisito(resultado.getString("prioridadeRequisito"));
                r.setTipoRequisito(resultado.getString("tipoRequisito"));
                r.setComplexidade(resultado.getString("complexidade"));
                r.setProjeto_id(resultado.getInt("projeto_id"));
            }
        } catch(Exception e) {
            System.out.println("Erro ao consultar Requisito: " + e);
        }
      
        return r;
    }    
    
    //Método excluir - retorna boolean
    public boolean excluir(int id) {
                
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "delete from requisito "
                    + "where id = " + id;
                    
            System.out.println("SQL: " + sql);

            //Método executeUpdate - Executa a instrução SQL fornecida
            //pode ser uma instrução INSERT, UPDATE ou DELETE
            //Valor de retorno: Um int que indica o número de linhas afetadas             
            int resultado = st.executeUpdate(sql);
            
            return true;
        
        } catch(Exception e) {
            System.out.println("Erro ao excluir Requisito: " + e);
            return false;
        }
        
    }
}
