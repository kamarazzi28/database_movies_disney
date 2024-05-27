package entities;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "reziser", schema = "public", catalog = "ishmukam")
public class Reziser {
    @Id
    @Column(name = "id_reziser")
    private int idReziser;

    @Basic
    @Column(name = "jmeno_rezisera")
    private String jmenoRezisera;

    @Basic
    @Column(name = "url_wiki_stranky")
    private String urlWikiStranky;

    @Basic
    @Column(name = "datum_narozeni")
    private Date datumNarozeni;

    @ManyToOne
    @JoinColumn(name = "je_nadrizeny", referencedColumnName = "id_reziser")
    private Reziser reziserByJeNadrizeny;

    @OneToMany(mappedBy = "reziserByJeNadrizeny")
    private Collection<Reziser> rezisersByIdReziser;

    @ManyToOne
    @JoinColumn(name = "id_filmy", referencedColumnName = "id_filmy", nullable = false)
    private Filmy filmyByIdFilmy;

    // Getters and Setters

    public int getIdReziser() {
        return idReziser;
    }

    public void setIdReziser(int idReziser) {
        this.idReziser = idReziser;
    }

    public String getJmenoRezisera() {
        return jmenoRezisera;
    }

    public void setJmenoRezisera(String jmenoRezisera) {
        this.jmenoRezisera = jmenoRezisera;
    }

    public String getUrlWikiStranky() {
        return urlWikiStranky;
    }

    public void setUrlWikiStranky(String urlWikiStranky) {
        this.urlWikiStranky = urlWikiStranky;
    }

    public Date getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(Date datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public Reziser getReziserByJeNadrizeny() {
        return reziserByJeNadrizeny;
    }

    public void setReziserByJeNadrizeny(Reziser reziserByJeNadrizeny) {
        this.reziserByJeNadrizeny = reziserByJeNadrizeny;
    }

    public Collection<Reziser> getRezisersByIdReziser() {
        return rezisersByIdReziser;
    }

    public void setRezisersByIdReziser(Collection<Reziser> rezisersByIdReziser) {
        this.rezisersByIdReziser = rezisersByIdReziser;
    }

    public Filmy getFilmyByIdFilmy() {
        return filmyByIdFilmy;
    }

    public void setFilmyByIdFilmy(Filmy filmyByIdFilmy) {
        this.filmyByIdFilmy = filmyByIdFilmy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reziser that = (Reziser) o;

        if (idReziser != that.idReziser) return false;
        if (jmenoRezisera != null ? !jmenoRezisera.equals(that.jmenoRezisera) : that.jmenoRezisera != null)
            return false;
        if (urlWikiStranky != null ? !urlWikiStranky.equals(that.urlWikiStranky) : that.urlWikiStranky != null)
            return false;
        if (datumNarozeni != null ? !datumNarozeni.equals(that.datumNarozeni) : that.datumNarozeni != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReziser;
        result = 31 * result + (jmenoRezisera != null ? jmenoRezisera.hashCode() : 0);
        result = 31 * result + (urlWikiStranky != null ? urlWikiStranky.hashCode() : 0);
        result = 31 * result + (datumNarozeni != null ? datumNarozeni.hashCode() : 0);
        return result;
    }
}
