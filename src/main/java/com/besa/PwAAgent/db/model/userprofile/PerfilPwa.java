
package com.besa.PwAAgent.db.model.userprofile;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.besa.PwAAgent.db.model.Cuidador;
import com.besa.PwAAgent.db.model.EstadoCivil;
import com.besa.PwAAgent.db.model.Familiar;
import com.besa.PwAAgent.db.model.NivelEducativo;
import com.besa.PwAAgent.db.model.RegistroActividad;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "perfil_pwa")

@NamedQueries({
    @NamedQuery(name = "PerfilPwa.findAll", query = "SELECT p FROM PerfilPwa p"),
    @NamedQuery(name = "PerfilPwa.findByCedula", query = "SELECT p FROM PerfilPwa p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "PerfilPwa.findByNombre", query = "SELECT p FROM PerfilPwa p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PerfilPwa.findByApellido", query = "SELECT p FROM PerfilPwa p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "PerfilPwa.findByFechaNacimiento", query = "SELECT p FROM PerfilPwa p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "PerfilPwa.findByPaisNacimiento", query = "SELECT p FROM PerfilPwa p WHERE p.paisNacimiento = :paisNacimiento"),
    @NamedQuery(name = "PerfilPwa.findByProfesion", query = "SELECT p FROM PerfilPwa p WHERE p.profesion = :profesion"),
    @NamedQuery(name = "PerfilPwa.findByEdad", query = "SELECT p FROM PerfilPwa p WHERE p.edad = :edad"),
    @NamedQuery(name = "PerfilPwa.findByTieneProgramaEjercicio", query = "SELECT p FROM PerfilPwa p WHERE p.tieneProgramaEjercicio = :tieneProgramaEjercicio")})
public class PerfilPwa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "pais_nacimiento")
    private String paisNacimiento;
    @Basic(optional = false)
    @Column(name = "profesion")
    private String profesion;
    @Basic(optional = false)
    @Column(name = "edad")
    private BigInteger edad;
    @Basic(optional = false)
    @Column(name = "tiene_programa_ejercicio")
    private boolean tieneProgramaEjercicio;
    @ManyToMany(mappedBy = "perfilPwaList", fetch = FetchType.EAGER)
    private List<Familiar> familiarList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfilPwa", fetch = FetchType.EAGER)
    private PwAPreferenceContext PwAPreferenceContext;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilPwa", fetch = FetchType.EAGER)
    private List<RegistroActividad> registroActividadList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfilPwa", fetch = FetchType.EAGER)
    private PwAMedicalContext PwAMedicalContext;
    @JoinColumn(name = "cuidador_nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuidador cuidadorNombreUsuario;
    @JoinColumn(name = "estado_civil_tipo_ec", referencedColumnName = "tipo_ec")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoCivil estadoCivilTipoEc;
    @JoinColumn(name = "nivel_educativo_tipo_ne", referencedColumnName = "tipo_ne")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private NivelEducativo nivelEducativoTipoNe;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfilPwa", fetch = FetchType.EAGER)
    private PwAExerciseProfile PwAExerciseProfile;

    public PerfilPwa() {
    }

    public PerfilPwa(String cedula) {
        this.cedula = cedula;
    }

    public PerfilPwa(String cedula, String nombre, String apellido, Date fechaNacimiento, String paisNacimiento, String profesion, BigInteger edad, boolean tieneProgramaEjercicio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
        this.profesion = profesion;
        this.edad = edad;
        this.tieneProgramaEjercicio = tieneProgramaEjercicio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    public boolean getTieneProgramaEjercicio() {
        return tieneProgramaEjercicio;
    }

    public void setTieneProgramaEjercicio(boolean tieneProgramaEjercicio) {
        this.tieneProgramaEjercicio = tieneProgramaEjercicio;
    }

    
    public List<Familiar> getFamiliarList() {
        return familiarList;
    }

    public void setFamiliarList(List<Familiar> familiarList) {
        this.familiarList = familiarList;
    }

    public PwAPreferenceContext getPwAPreferenceContext() {
        return PwAPreferenceContext;
    }

    public void setPwAPreferenceContext(PwAPreferenceContext PwAPreferenceContext) {
        this.PwAPreferenceContext = PwAPreferenceContext;
    }

    
    public List<RegistroActividad> getRegistroActividadList() {
        return registroActividadList;
    }

    public void setRegistroActividadList(List<RegistroActividad> registroActividadList) {
        this.registroActividadList = registroActividadList;
    }

    public PwAMedicalContext getUserMedicalContext() {
        return PwAMedicalContext;
    }

    public void setPwAMedicalContext(PwAMedicalContext PwAMedicalContext) {
        this.PwAMedicalContext = PwAMedicalContext;
    }

    public Cuidador getCuidadorNombreUsuario() {
        return cuidadorNombreUsuario;
    }

    public void setCuidadorNombreUsuario(Cuidador cuidadorNombreUsuario) {
        this.cuidadorNombreUsuario = cuidadorNombreUsuario;
    }

    public EstadoCivil getEstadoCivilTipoEc() {
        return estadoCivilTipoEc;
    }

    public void setEstadoCivilTipoEc(EstadoCivil estadoCivilTipoEc) {
        this.estadoCivilTipoEc = estadoCivilTipoEc;
    }

    public NivelEducativo getNivelEducativoTipoNe() {
        return nivelEducativoTipoNe;
    }

    public void setNivelEducativoTipoNe(NivelEducativo nivelEducativoTipoNe) {
        this.nivelEducativoTipoNe = nivelEducativoTipoNe;
    }

    public PwAExerciseProfile getExerciseProfile() {
        return PwAExerciseProfile;
    }

    public void setExerciseProfile(PwAExerciseProfile PwAExerciseProfile) {
        this.PwAExerciseProfile = PwAExerciseProfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilPwa)) {
            return false;
        }
        PerfilPwa other = (PerfilPwa) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.PerfilPwa[ cedula=" + cedula + " ]";
    }
    
}
