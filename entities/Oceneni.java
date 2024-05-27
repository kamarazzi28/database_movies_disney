package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Oceneni")
public class Oceneni {

    @Id
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String kategorie;

    @Column(nullable = false)
    private String nazevCeny;

    @Column(nullable = false)
    private Date rok;

    @ManyToOne
    @JoinColumn(name = "id_filmy", nullable = false)
    private Filmy filmy;

    @ManyToOne
    @JoinColumn(name = "id_herci", nullable = false)
    private Herci herci;

    // Constructors, Getters and Setters

    public Oceneni() {
    }

    public Oceneni(String kategorie, String nazevCeny, Date rok, Filmy filmy, Herci herci) {
        this.kategorie = kategorie;
        this.nazevCeny = nazevCeny;
        this.rok = rok;
        this.filmy = filmy;
        this.herci = herci;
    }

    public long getId() {return id;}

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getNazevCeny() {
        return nazevCeny;
    }

    public void setNazevCeny(String nazevCeny) {
        this.nazevCeny = nazevCeny;
    }

    public Date getRok() {
        return rok;
    }

    public void setRok(Date rok) {
        this.rok = rok;
    }

    public Filmy getFilmy() {
        return filmy;
    }

    public void setFilmy(Filmy filmy) {
        this.filmy = filmy;
    }

    public Herci getHerci() {
        return herci;
    }

    public void setHerci(Herci herci) {
        this.herci = herci;
    }
}
