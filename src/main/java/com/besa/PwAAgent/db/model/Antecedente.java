
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "antecedente")

@NamedQueries({
    @NamedQuery(name = "Antecedente.findAll", query = "SELECT a FROM Antecedente a"),
    @NamedQuery(name = "Antecedente.findById", query = "SELECT a FROM Antecedente a WHERE a.id = :id"),
    @NamedQuery(name = "Antecedente.findByEtiqueta", query = "SELECT a FROM Antecedente a WHERE a.etiqueta = :etiqueta"),
    @NamedQuery(name = "Antecedente.findByValor", query = "SELECT a FROM Antecedente a WHERE a.valor = :valor")})
public class Antecedente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "etiqueta")
    private String etiqueta;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @JoinTable(name = "regla_x_antecedente", joinColumns = {
        @JoinColumn(name = "antecedente_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "regla_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Regla> reglaList;

    public Antecedente() {
    }

    public Antecedente(Integer id) {
        this.id = id;
    }

    public Antecedente(Integer id, String etiqueta, double valor) {
        this.id = id;
        this.etiqueta = etiqueta;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    public List<Regla> getReglaList() {
        return reglaList;
    }

    public void setReglaList(List<Regla> reglaList) {
        this.reglaList = reglaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedente)) {
            return false;
        }
        Antecedente other = (Antecedente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Antecedente[ id=" + id + " ]";
    }
    
}
