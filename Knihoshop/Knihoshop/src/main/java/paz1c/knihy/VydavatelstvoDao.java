package paz1c.knihy;

import java.util.List;

public interface VydavatelstvoDao {

    List<Vydavatelstvo> dajVsetkyVydavatelstva();

    void save(Vydavatelstvo vydavatelstvo);

    public void odstranit(Vydavatelstvo vydavatelstvo);
    
    List<Vydavatelstvo> vydavatelstvoPodlaId(Long id);
    
    
}