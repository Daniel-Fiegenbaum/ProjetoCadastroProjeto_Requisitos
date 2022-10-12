/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author User
 */
public class Requisito {
    int id;
    String nomeRequisito;
    String descricaoRequisito;
    String prioridadeRequisito;
    String tipoRequisito;
    String complexidade;
    int projeto_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRequisito() {
        return nomeRequisito;
    }

    public void setNomeRequisito(String nomeRequisito) {
        this.nomeRequisito = nomeRequisito;
    }

    public String getDescricaoRequisito() {
        return descricaoRequisito;
    }

    public void setDescricaoRequisito(String descricaoRequisito) {
        this.descricaoRequisito = descricaoRequisito;
    }

    public String getPrioridadeRequisito() {
        return prioridadeRequisito;
    }

    public void setPrioridadeRequisito(String prioridadeRequisito) {
        this.prioridadeRequisito = prioridadeRequisito;
    }

    public String getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(String tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }
    
    public int getProjeto_id() {
        return projeto_id;
    }

    public void setProjeto_id(int projeto_id) {
        this.projeto_id = projeto_id;
    }

}
