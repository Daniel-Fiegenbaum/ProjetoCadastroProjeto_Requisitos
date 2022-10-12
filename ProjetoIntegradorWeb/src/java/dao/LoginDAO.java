package dao;

import apoio.ConexaoBD;
import entidade.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
    
    //Método logar
    public boolean logar(Usuario usuario){
        
        boolean retorno = false;
        
        try {
            //Cria a conexao 
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql 
                    = "select usuario, senha from usuario "
                    + "where usuario='"+usuario.getUsuario()+"' "
                    + "and senha='"+usuario.getSenha()+"' "
                    + "and tipousuario='"+usuario.getTipousuario()+"'";
                    
            System.out.println("SQL: " + sql);
            
            //Executa a instrução SQL fornecida e retorna um objeto SQLResultSet 
            //ResultSet é uma tabela de dados que representa um conjunto de resultados
            ResultSet resultado = st.executeQuery(sql);
            
            // O método next move o cursor para a próxima linha 
            //e retorna false quando não há mais linhas no ResultSetUsuario.
            if (resultado.next()) {
                retorno = true;
                System.out.println("Login feito com sucesso!");
            }            
        
        } catch(Exception e) {
            System.out.println("Erro ao buscar usuario: " + e);
        }
        
        return retorno;        
    }
}
