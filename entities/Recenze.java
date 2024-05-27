package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recenze", schema = "public", catalog = "ishmukam")
public class Recenze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recenze")
    private int idRecenze;

    @Basic
    @Column(name = "hodnoceni")
    private Integer hodnoceni;

    @ManyToOne
    @JoinColumn(name = "id_filmy", referencedColumnName = "id_filmy", insertable = false, updatable = false)
    private Filmy filmyByIdFilmy;

    public int getIdRecenze() {
        return idRecenze;
    }

    public void setIdRecenze(int idRecenze) {
        this.idRecenze = idRecenze;
    }

    public Integer getHodnoceni() {
        return hodnoceni;
    }

    public void setHodnoceni(Integer hodnoceni) {
        this.hodnoceni = hodnoceni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recenze that = (Recenze) o;

        if (idRecenze != that.idRecenze) return false;
        if (!Objects.equals(hodnoceni, that.hodnoceni)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecenze;
        result = 31 * result + (hodnoceni != null ? hodnoceni.hashCode() : 0);
        return result;
    }

    public Filmy getFilmyByIdFilmy() {
        return filmyByIdFilmy;
    }

    public void setFilmyByIdFilmy(Filmy filmyByIdFilmy) {
        this.filmyByIdFilmy = filmyByIdFilmy;
    }
}
