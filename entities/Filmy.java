package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "filmy", schema = "public", catalog = "ishmukam")
public class Filmy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filmy")
    private int idFilmy;

    @Basic
    @Column(name = "nazev_filmu")
    private String nazevFilmu;

    @Basic
    @Column(name = "datum_vydani")
    private Date datumVydani;

    @Basic
    @Column(name = "zanr")
    private String zanr;

    @Basic
    @Column(name = "prodeje")
    private int prodeje;

    @ManyToOne
    @JoinColumn(name = "nazev_studia", referencedColumnName = "nazev_studia", nullable = false)
    private DisneyStudia disneyStudiaByNazevStudia;

    // Getters and Setters

    public long getIdFilmy() {
        return idFilmy;
    }

    public void setIdFilmy(int idFilmy) {
        this.idFilmy = idFilmy;
    }

    public String getNazevFilmu() {
        return nazevFilmu;
    }

    public void setNazevFilmu(String nazevFilmu) {
        this.nazevFilmu = nazevFilmu;
    }

    public Date getDatumVydani() {
        return datumVydani;
    }

    public void setDatumVydani(Date datumVydani) {
        this.datumVydani = datumVydani;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public int getProdeje() {
        return prodeje;
    }

    public void setProdeje(int prodeje) {
        this.prodeje = prodeje;
    }

    public DisneyStudia getDisneyStudiaByNazevStudia() {
        return disneyStudiaByNazevStudia;
    }

    public void setDisneyStudiaByNazevStudia(DisneyStudia disneyStudiaByNazevStudia) {
        this.disneyStudiaByNazevStudia = disneyStudiaByNazevStudia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filmy that = (Filmy) o;

        if (idFilmy != that.idFilmy) return false;
        if (prodeje != that.prodeje) return false;
        if (nazevFilmu != null ? !nazevFilmu.equals(that.nazevFilmu) : that.nazevFilmu != null) return false;
        if (datumVydani != null ? !datumVydani.equals(that.datumVydani) : that.datumVydani != null) return false;
        if (zanr != null ? !zanr.equals(that.zanr) : that.zanr != null) return false;

        return disneyStudiaByNazevStudia != null ? disneyStudiaByNazevStudia.equals(that.disneyStudiaByNazevStudia) : that.disneyStudiaByNazevStudia == null;
    }

    @Override
    public int hashCode() {
        int result = idFilmy;
        result = 31 * result + (nazevFilmu != null ? nazevFilmu.hashCode() : 0);
        result = 31 * result + (datumVydani != null ? datumVydani.hashCode() : 0);
        result = 31 * result + (zanr != null ? zanr.hashCode() : 0);
        result = 31 * result + prodeje;
        result = 31 * result + (disneyStudiaByNazevStudia != null ? disneyStudiaByNazevStudia.hashCode() : 0);
        return result;
    }
}
