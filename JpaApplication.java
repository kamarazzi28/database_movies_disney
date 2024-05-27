import entities.DisneyStudia;
import entities.Filmy;
import services.DisneyStudiaService;
import services.FilmyService;

import java.sql.Date;
import java.util.List;

public class JpaApplication {

    public static void main(String[] args)  {
        FilmyService filmyService = new FilmyService();
        DisneyStudiaService disneyStudiaService = new DisneyStudiaService();

        // 1. Insert Operation
        String studioName = "Disney Studios LA";
        DisneyStudia disneyStudia = disneyStudiaService.findById(studioName);
        if (disneyStudia == null) {
            disneyStudia = new DisneyStudia();
            disneyStudia.setNazevStudia(studioName);
            disneyStudia.setDatumZalozeni(Date.valueOf("1923-10-16"));
            disneyStudia.setStat("USA");
            disneyStudia.setMesto("Burbank");
            disneyStudia.setUlice("500 S Buena Vista St");
            disneyStudia.setUrl("https://www.disneyla.com");

            disneyStudiaService.save(disneyStudia);
        } else {
            System.out.println("DisneyStudia already exists: " + disneyStudia.getNazevStudia());
        }

        Filmy filmy = new Filmy();
        filmy.setNazevFilmu("Brand new film about DBS");
        filmy.setDatumVydani(new Date(System.currentTimeMillis()));
        filmy.setZanr("Drama");
        filmy.setProdeje(2800);
        filmy.setDisneyStudiaByNazevStudia(disneyStudia);
        filmyService.save(filmy);
        System.out.println("Inserted Film: " + filmyService.findById((long) filmy.getIdFilmy()).getNazevFilmu());

        // 2. Update Operation
        filmy.setProdeje(2880301);
        filmyService.save(filmy);
        System.out.println("Updated Film Sales: " + filmyService.findById((long) filmy.getIdFilmy()).getProdeje());

        // 3. Delete Operation
        filmyService.delete(filmy);
        System.out.println("Deleted Film: " + (filmyService.findById((long) filmy.getIdFilmy()) == null ? "Success" : "Failed"));


        // 4. Parent Fields
        List<Filmy> films = filmyService.findAll();
        for (Filmy f : films) {
            System.out.println("Film: " + f.getNazevFilmu() + ", Studio: " + f.getDisneyStudiaByNazevStudia().getNazevStudia());
        }

//      CP4 - transaction
        filmyService.performTransactionalOperations();

//      Drama films
        List<Filmy> dramaFilms = filmyService.findByGenre("Drama");
        for (Filmy dramaFilm : dramaFilms) {
            System.out.println("Drama Film: " + dramaFilm.getNazevFilmu());
        }
    }


}

