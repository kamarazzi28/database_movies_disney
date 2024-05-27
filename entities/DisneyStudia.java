package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "disney_studia", schema = "public", catalog = "ishmukam")
public class DisneyStudia {
    @Id
    @Column(name = "nazev_studia")
    private String nazevStudia;
    @Basic
    @Column(name = "datum_zalozeni")
    private Date datumZalozeni;
    @Basic
    @Column(name = "stat")
    private String stat;
    @Basic
    @Column(name = "mesto")
    private String mesto;
    @Basic
    @Column(name = "ulice")
    private String ulice;
    @Basic
    @Column(name = "url")
    private String url;

    public String getNazevStudia() {
        return nazevStudia;
    }

    public void setNazevStudia(String nazevStudia) {
        this.nazevStudia = nazevStudia;
    }

    public Date getDatumZalozeni() {
        return datumZalozeni;
    }

    public void setDatumZalozeni(Date datumZalozeni) {
        this.datumZalozeni = datumZalozeni;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisneyStudia that = (DisneyStudia) o;

        if (nazevStudia != null ? !nazevStudia.equals(that.nazevStudia) : that.nazevStudia != null) return false;
        if (datumZalozeni != null ? !datumZalozeni.equals(that.datumZalozeni) : that.datumZalozeni != null)
            return false;
        if (stat != null ? !stat.equals(that.stat) : that.stat != null) return false;
        if (mesto != null ? !mesto.equals(that.mesto) : that.mesto != null) return false;
        if (ulice != null ? !ulice.equals(that.ulice) : that.ulice != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        int result = nazevStudia != null ? nazevStudia.hashCode() : 0;
        result = 31 * result + (datumZalozeni != null ? datumZalozeni.hashCode() : 0);
        result = 31 * result + (stat != null ? stat.hashCode() : 0);
        result = 31 * result + (mesto != null ? mesto.hashCode() : 0);
        result = 31 * result + (ulice != null ? ulice.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
