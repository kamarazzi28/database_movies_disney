package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "herci", schema = "public", catalog = "ishmukam")
public class Herci {
    @Id
    @Column(name = "id_herci")
    private int idHerci;

    @Basic
    @Column(name = "jmeno_herce")
    private String jmenoHerce;

    @Basic
    @Column(name = "url_wiki_stranky")
    private String urlWikiStranky;

    @Basic
    @Column(name = "datum_narozeni")
    private Date datumNarozeni;

    @ManyToOne
    @JoinColumn(name = "id_filmy", referencedColumnName = "id_filmy", nullable = false)
    private Filmy filmyByIdFilmy;

    // Getters and Setters

    public int getIdHerci() {
        return idHerci;
    }

    public void setIdHerci(int idHerci) {
        this.idHerci = idHerci;
    }

    public String getJmenoHerce() {
        return jmenoHerce;
    }

    public void setJmenoHerce(String jmenoHerce) {
        this.jmenoHerce = jmenoHerce;
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

        Herci herci = (Herci) o;

        if (idHerci != herci.idHerci) return false;
        if (!Objects.equals(jmenoHerce, herci.jmenoHerce)) return false;
        if (!Objects.equals(urlWikiStranky, herci.urlWikiStranky)) return false;
        if (!Objects.equals(datumNarozeni, herci.datumNarozeni)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHerci;
        result = 31 * result + (jmenoHerce != null ? jmenoHerce.hashCode() : 0);
        result = 31 * result + (urlWikiStranky != null ? urlWikiStranky.hashCode() : 0);
        result = 31 * result + (datumNarozeni != null ? datumNarozeni.hashCode() : 0);
        return result;
    }
}
