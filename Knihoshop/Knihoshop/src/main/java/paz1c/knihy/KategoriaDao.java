
package paz1c.knihy;

import java.util.List;

public interface KategoriaDao {

    List<Kategoria> dajVsetkyKategorie();

    void save(Kategoria kategoria);

    public void odstranit(Kategoria kategoria);
      
    List<Kategoria> kategoriaPodlaId(Long id);
}
