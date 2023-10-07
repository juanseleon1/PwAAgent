
package com.besa.PwAAgent.db.model.userprofile;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import com.besa.PwAAgent.db.model.ActXPreferencia;
import com.besa.PwAAgent.db.model.PreferenciaXBaile;
import com.besa.PwAAgent.db.model.PreferenciaXCancion;
import com.besa.PwAAgent.db.model.PreferenciaXCuento;

import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.PreferenceContext;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_preferencia")

@NamedQueries({
        @NamedQuery(name = "PwAPreferenceContext.findAll", query = "SELECT p FROM PwAPreferenceContext p"),
        @NamedQuery(name = "PwAPreferenceContext.findByPwAProfileCedula", query = "SELECT p FROM PwAPreferenceContext p WHERE p.PwAProfileCedula = :PwAProfileCedula"),
        @NamedQuery(name = "PwAPreferenceContext.findByNombrePreferido", query = "SELECT p FROM PwAPreferenceContext p WHERE p.nombrePreferido = :nombrePreferido"),
        @NamedQuery(name = "PwAPreferenceContext.findByGustoKaraoke", query = "SELECT p FROM PwAPreferenceContext p WHERE p.gustoKaraoke = :gustoKaraoke"),
        @NamedQuery(name = "PwAPreferenceContext.findByGustoMusica", query = "SELECT p FROM PwAPreferenceContext p WHERE p.gustoMusica = :gustoMusica"),
        @NamedQuery(name = "PwAPreferenceContext.findByGustoBaile", query = "SELECT p FROM PwAPreferenceContext p WHERE p.gustoBaile = :gustoBaile"),
        @NamedQuery(name = "PwAPreferenceContext.findByBrilloPreferido", query = "SELECT p FROM PwAPreferenceContext p WHERE p.brilloPreferido = :brilloPreferido"),
        @NamedQuery(name = "PwAPreferenceContext.findByVolPreferido", query = "SELECT p FROM PwAPreferenceContext p WHERE p.volPreferido = :volPreferido") })
public class PwAPreferenceContext extends PreferenceContext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perfil_pwa_cedula")
    private String PwAProfileCedula;
    @Basic(optional = false)
    @Column(name = "nombre_preferido")
    private String nombrePreferido;
    @Basic(optional = false)
    @Column(name = "gusto_karaoke")
    private double gustoKaraoke;
    @Basic(optional = false)
    @Column(name = "gusto_musica")
    private double gustoMusica;
    @Basic(optional = false)
    @Column()
    private double gustoEjercicio;
    @Column()
    private double gustoLeer;
    @Basic(optional = false)
    @Column(name = "gusto_baile")
    private double gustoBaile;
    @Basic(optional = false)
    @Column(name = "brillo_preferido")
    private int brilloPreferido;
    @Basic(optional = false)
    @Column(name = "vol_preferido")
    private int volPreferido;
    @ManyToOne
    private Religion religion;
    @Basic
    private LocalTime lastSpiritualActivity;
    @Basic
    private int nivelReligioso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<PreferenciaXCuento> preferenciaXCuentoList;
    @JoinColumn(name = "perfil_pwa_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PwAProfile PwAProfile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<ActXPreferencia> actXPreferenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<PreferenciaXBaile> preferenciaXBaileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<PreferenciaXCancion> preferenciaXCancionList;

    public PwAPreferenceContext() {
    }

    public PwAPreferenceContext(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public PwAPreferenceContext(String PwAProfileCedula, String nombrePreferido, double gustoKaraoke,
            double gustoMusica, double gustoBaile, int brilloPreferido, int volPreferido) {
        this.PwAProfileCedula = PwAProfileCedula;
        this.nombrePreferido = nombrePreferido;
        this.gustoKaraoke = gustoKaraoke;
        this.gustoMusica = gustoMusica;
        this.gustoBaile = gustoBaile;
        this.brilloPreferido = brilloPreferido;
        this.volPreferido = volPreferido;
    }

    public String getPwAProfileCedula() {
        return PwAProfileCedula;
    }

    public void setPwAProfileCedula(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public String getNombrePreferido() {
        return nombrePreferido;
    }

    public void setNombrePreferido(String nombrePreferido) {
        this.nombrePreferido = nombrePreferido;
    }

    public double getGustoKaraoke() {
        return gustoKaraoke;
    }

    public void setGustoKaraoke(double gustoKaraoke) {
        this.gustoKaraoke = gustoKaraoke;
    }

    public double getGustoMusica() {
        return gustoMusica;
    }

    public void setGustoMusica(double gustoMusica) {
        this.gustoMusica = gustoMusica;
    }

    public double getGustoBaile() {
        return gustoBaile;
    }

    public void setGustoBaile(double gustoBaile) {
        this.gustoBaile = gustoBaile;
    }

    public int getBrilloPreferido() {
        return brilloPreferido;
    }

    public void setBrilloPreferido(int brilloPreferido) {
        this.brilloPreferido = brilloPreferido;
    }

    public int getVolPreferido() {
        return volPreferido;
    }

    public void setVolPreferido(int volPreferido) {
        this.volPreferido = volPreferido;
    }

    public List<PreferenciaXCuento> getPreferenciaXCuentoList() {
        return preferenciaXCuentoList;
    }

    public void setPreferenciaXCuentoList(List<PreferenciaXCuento> preferenciaXCuentoList) {
        this.preferenciaXCuentoList = preferenciaXCuentoList;
    }

    public PwAProfile getPwAProfile() {
        return PwAProfile;
    }

    public void setPwAProfile(PwAProfile PwAProfile) {
        this.PwAProfile = PwAProfile;
    }

    public List<ActXPreferencia> getActXPreferenciaList() {
        return actXPreferenciaList;
    }

    public void setActXPreferenciaList(List<ActXPreferencia> actXPreferenciaList) {
        this.actXPreferenciaList = actXPreferenciaList;
    }

    public List<PreferenciaXBaile> getPreferenciaXBaileList() {
        return preferenciaXBaileList;
    }

    public void setPreferenciaXBaileList(List<PreferenciaXBaile> preferenciaXBaileList) {
        this.preferenciaXBaileList = preferenciaXBaileList;
    }

    public List<PreferenciaXCancion> getPreferenciaXCancionList() {
        return preferenciaXCancionList;
    }

    public void setPreferenciaXCancionList(List<PreferenciaXCancion> preferenciaXCancionList) {
        this.preferenciaXCancionList = preferenciaXCancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (PwAProfileCedula != null ? PwAProfileCedula.hashCode() : 0);
        return hash;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public LocalTime getLastSpiritualActivity() {
        return lastSpiritualActivity;
    }

    public void setLastSpiritualActivity(LocalTime lastSpiritualActivity) {
        this.lastSpiritualActivity = lastSpiritualActivity;
    }

    public int getNivelReligioso() {
        return nivelReligioso;
    }

    public void setNivelReligioso(int nivelReligioso) {
        this.nivelReligioso = nivelReligioso;
    }

    public double getGustoEjercicio() {
        return gustoEjercicio;
    }

    public void setGustoEjericio(double gustoEjericio) {
        this.gustoEjercicio = gustoEjericio;
    }

    public double getGustoLeer() {
        return gustoLeer;
    }

    public void setGustoLeer(double gustoLeer) {
        this.gustoLeer = gustoLeer;
    }

    @Override
    public String toString() {
        return "PwAPreferenceContext [PwAProfileCedula=" + PwAProfileCedula + ", nombrePreferido=" + nombrePreferido
                + ", gustoKaraoke=" + gustoKaraoke + ", gustoMusica=" + gustoMusica + ", gustoEjercicio="
                + gustoEjercicio + ", gustoLeer=" + gustoLeer + ", gustoBaile=" + gustoBaile + ", brilloPreferido="
                + brilloPreferido + ", volPreferido=" + volPreferido + ", religion=" + religion
                + ", lastSpiritualActivity=" + lastSpiritualActivity + ", nivelReligioso=" + nivelReligioso
                + ", preferenciaXCuentoList=" + preferenciaXCuentoList + ", PwAProfile=" + PwAProfile
                + ", actXPreferenciaList=" + actXPreferenciaList + ", preferenciaXBaileList=" + preferenciaXBaileList
                + ", preferenciaXCancionList=" + preferenciaXCancionList + "]";
    }


    

}
