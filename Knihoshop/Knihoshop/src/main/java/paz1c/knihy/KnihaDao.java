package paz1c.knihy;

import java.util.List;

public interface KnihaDao {

    List<Kniha> dajVsetkyKnihy();

    List<Kniha> hladatPodlaNazvu(String filter);
    
    List<Kniha> hladatPodlaAutora(String filter);
    
    List<Kniha> hladajPodlaId(Long id);
    
    void save(Kniha kniha);

    public void odstranit(Kniha kniha);
    
}
