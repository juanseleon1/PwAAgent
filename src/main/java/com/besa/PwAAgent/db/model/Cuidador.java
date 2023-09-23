
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;

import com.besa.PwAAgent.db.model.userprofile.PerfilPwa;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "cuidador")

@NamedQueries({
    @NamedQuery(name = "Cuidador.findAll", query = "SELECT c FROM Cuidador c"),
    @NamedQuery(name = "Cuidador.findByNombreUsuario", query = "SELECT c FROM Cuidador c WHERE c.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Cuidador.findByContrasena", query = "SELECT c FROM Cuidador c WHERE c.contrasena = :contrasena"),
    @NamedQuery(name = "Cuidador.findByNombre", query = "SELECT c FROM Cuidador c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cuidador.findByCorreo", query = "SELECT c FROM Cuidador c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cuidador.findByCelular", query = "SELECT c FROM Cuidador c WHERE c.celular = :celular")})
public class Cuidador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuidadorNombreUsuario", fetch = FetchType.EAGER)
    private List<PerfilPwa> perfilPwaList;

    public Cuidador() {
    }

    public Cuidador(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Cuidador(String nombreUsuario, String contrasena, String nombre, String correo, String celular) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public List<PerfilPwa> getPerfilPwaList() {
        return perfilPwaList;
    }

    public void setPerfilPwaList(List<PerfilPwa> perfilPwaList) {
        this.perfilPwaList = perfilPwaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuidador)) {
            return false;
        }
        Cuidador other = (Cuidador) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Cuidador[ nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
