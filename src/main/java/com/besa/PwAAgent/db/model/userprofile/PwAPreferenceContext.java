
package com.besa.PwAAgent.db.model.userprofile;

import java.io.Serializable;
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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "perfil_preferencia")

@NamedQueries({
    @NamedQuery(name = "PwAPreferenceContext.findAll", query = "SELECT p FROM PwAPreferenceContext p"),
    @NamedQuery(name = "PwAPreferenceContext.findByPerfilPwaCedula", query = "SELECT p FROM PwAPreferenceContext p WHERE p.perfilPwaCedula = :perfilPwaCedula"),
    @NamedQuery(name = "PwAPreferenceContext.findByNombrePreferido", query = "SELECT p FROM PwAPreferenceContext p WHERE p.nombrePreferido = :nombrePreferido"),
    @NamedQuery(name = "PwAPreferenceContext.findByGustoKaraoke", query = "SELECT p FROM PwAPreferenceContext p WHERE p.gustoKaraoke = :gustoKaraoke"),
    @NamedQuery(name = "PwAPreferenceContext.findByGustoMusica", query = "SELECT p FROM PwAPreferenceContext p WHERE p.gustoMusica = :gustoMusica"),
    @NamedQuery(name = "PwAPreferenceContext.findByGustoBaile", query = "SELECT p FROM PwAPreferenceContext p WHERE p.gustoBaile = :gustoBaile"),
    @NamedQuery(name = "PwAPreferenceContext.findByBrilloPreferido", query = "SELECT p FROM PwAPreferenceContext p WHERE p.brilloPreferido = :brilloPreferido"),
    @NamedQuery(name = "PwAPreferenceContext.findByVolPreferido", query = "SELECT p FROM PwAPreferenceContext p WHERE p.volPreferido = :volPreferido")})
public class PwAPreferenceContext extends PreferenceContext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perfil_pwa_cedula")
    private String perfilPwaCedula;
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
    @Column(name = "gusto_baile")
    private double gustoBaile;
    @Basic(optional = false)
    @Column(name = "brillo_preferido")
    private int brilloPreferido;
    @Basic(optional = false)
    @Column(name = "vol_preferido")
    private int volPreferido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<PreferenciaXCuento> preferenciaXCuentoList;
    @JoinColumn(name = "perfil_pwa_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PerfilPwa perfilPwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<ActXPreferencia> actXPreferenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<PreferenciaXBaile> preferenciaXBaileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaPreferenceContext", fetch = FetchType.EAGER)
    private List<PreferenciaXCancion> preferenciaXCancionList;

    public PwAPreferenceContext() {
    }

    public PwAPreferenceContext(String perfilPwaCedula) {
        this.perfilPwaCedula = perfilPwaCedula;
    }

    public PwAPreferenceContext(String perfilPwaCedula, String nombrePreferido, double gustoKaraoke, double gustoMusica, double gustoBaile, int brilloPreferido, int volPreferido) {
        this.perfilPwaCedula = perfilPwaCedula;
        this.nombrePreferido = nombrePreferido;
        this.gustoKaraoke = gustoKaraoke;
        this.gustoMusica = gustoMusica;
        this.gustoBaile = gustoBaile;
        this.brilloPreferido = brilloPreferido;
        this.volPreferido = volPreferido;
    }

    public String getPerfilPwaCedula() {
        return perfilPwaCedula;
    }

    public void setPerfilPwaCedula(String perfilPwaCedula) {
        this.perfilPwaCedula = perfilPwaCedula;
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

    public PerfilPwa getPerfilPwa() {
        return perfilPwa;
    }

    public void setPerfilPwa(PerfilPwa perfilPwa) {
        this.perfilPwa = perfilPwa;
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
        hash += (perfilPwaCedula != null ? perfilPwaCedula.hashCode() : 0);
        return hash;
    }

}
