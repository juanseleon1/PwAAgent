
package com.besa.PwAAgent.db.model;

import java.io.Serializable;

import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "cdr")

@NamedQueries({
    @NamedQuery(name = "Cdr.findAll", query = "SELECT c FROM Cdr c"),
    @NamedQuery(name = "Cdr.findByMemoria", query = "SELECT c FROM Cdr c WHERE c.memoria = :memoria"),
    @NamedQuery(name = "Cdr.findByOrientacion", query = "SELECT c FROM Cdr c WHERE c.orientacion = :orientacion"),
    @NamedQuery(name = "Cdr.findByJuicio", query = "SELECT c FROM Cdr c WHERE c.juicio = :juicio"),
    @NamedQuery(name = "Cdr.findByVidaSocial", query = "SELECT c FROM Cdr c WHERE c.vidaSocial = :vidaSocial"),
    @NamedQuery(name = "Cdr.findByHogar", query = "SELECT c FROM Cdr c WHERE c.hogar = :hogar"),
    @NamedQuery(name = "Cdr.findByCuidadopersonal", query = "SELECT c FROM Cdr c WHERE c.cuidadopersonal = :cuidadopersonal"),
    @NamedQuery(name = "Cdr.findByMedicoPwaCedula", query = "SELECT c FROM Cdr c WHERE c.medicoPwaCedula = :medicoPwaCedula")})
public class Cdr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "memoria")
    private int memoria;
    @Basic(optional = false)
    @Column(name = "orientacion")
    private int orientacion;
    @Basic(optional = false)
    @Column(name = "juicio")
    private int juicio;
    @Basic(optional = false)
    @Column(name = "vida_social")
    private int vidaSocial;
    @Basic(optional = false)
    @Column(name = "hogar")
    private int hogar;
    @Basic(optional = false)
    @Column(name = "cuidadopersonal")
    private int cuidadopersonal;
    @Id
    @Basic(optional = false)
    @Column(name = "medico_pwa_cedula")
    private String medicoPwaCedula;
    @JoinColumn(name = "medico_pwa_cedula", referencedColumnName = "perfil_pwa_cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PwAMedicalContext PwAMedicalContext;

    public Cdr() {
    }

    public Cdr(String medicoPwaCedula) {
        this.medicoPwaCedula = medicoPwaCedula;
    }

    public Cdr(String medicoPwaCedula, int memoria, int orientacion, int juicio, int vidaSocial, int hogar, int cuidadopersonal) {
        this.medicoPwaCedula = medicoPwaCedula;
        this.memoria = memoria;
        this.orientacion = orientacion;
        this.juicio = juicio;
        this.vidaSocial = vidaSocial;
        this.hogar = hogar;
        this.cuidadopersonal = cuidadopersonal;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }

    public int getJuicio() {
        return juicio;
    }

    public void setJuicio(int juicio) {
        this.juicio = juicio;
    }

    public int getVidaSocial() {
        return vidaSocial;
    }

    public void setVidaSocial(int vidaSocial) {
        this.vidaSocial = vidaSocial;
    }

    public int getHogar() {
        return hogar;
    }

    public void setHogar(int hogar) {
        this.hogar = hogar;
    }

    public int getCuidadopersonal() {
        return cuidadopersonal;
    }

    public void setCuidadopersonal(int cuidadopersonal) {
        this.cuidadopersonal = cuidadopersonal;
    }

    public String getMedicoPwaCedula() {
        return medicoPwaCedula;
    }

    public void setMedicoPwaCedula(String medicoPwaCedula) {
        this.medicoPwaCedula = medicoPwaCedula;
    }

    public PwAMedicalContext getUserMedicalContext() {
        return PwAMedicalContext;
    }

    public void setPwAMedicalContext(PwAMedicalContext PwAMedicalContext) {
        this.PwAMedicalContext = PwAMedicalContext;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoPwaCedula != null ? medicoPwaCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Cdr)) {
            return false;
        }
        Cdr other = (Cdr) object;
        if ((this.medicoPwaCedula == null && other.medicoPwaCedula != null) || (this.medicoPwaCedula != null && !this.medicoPwaCedula.equals(other.medicoPwaCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Cdr[ medicoPwaCedula=" + medicoPwaCedula + " ]";
    }
    
}
