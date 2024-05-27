package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "sequely", schema = "public", catalog = "ishmukam")
public class Sequely {
    @Id
    @Column(name = "id_sequel")
    private int idSequel;

    @Basic
    @Column(name = "nazev_sequel")
    private String nazevSequel;

    @Basic
    @Column(name = "datum_vydani")
    private Date datumVydani;

    @ManyToOne
    @JoinColumn(name = "id_filmy", referencedColumnName = "id_filmy", nullable = false)
    private Filmy filmyByIdFilmy;

    // Getters and Setters

    public int getIdSequel() {
        return idSequel;
    }

    public void setIdSequel(int idSequel) {
        this.idSequel = idSequel;
    }

    public String getNazevSequel() {
        return nazevSequel;
    }

    public void setNazevSequel(String nazevSequel) {
        this.nazevSequel = nazevSequel;
    }

    public Date getDatumVydani() {
        return datumVydani;
    }

    public void setDatumVydani(Date datumVydani) {
        this.datumVydani = datumVydani;
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

        Sequely that = (Sequely) o;

        if (idSequel != that.idSequel) return false;
        if (nazevSequel != null ? !nazevSequel.equals(that.nazevSequel) : that.nazevSequel != null) return false;
        if (datumVydani != null ? !datumVydani.equals(that.datumVydani) : that.datumVydani != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSequel;
        result = 31 * result + (nazevSequel != null ? nazevSequel.hashCode() : 0);
        result = 31 * result + (datumVydani != null ? datumVydani.hashCode() : 0);
        return result;
    }
}
