import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import paz1c.knihy.DaoFactory;
import paz1c.knihy.DatabazovyKnihaDao;
import paz1c.knihy.KategoriaDao;
import paz1c.knihy.Kniha;
import paz1c.knihy.KnihaDao;

public class DatabazovyKnihaDaoTest {
    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }
    
    @Test
    public void testDajVsetkyKnihy() {
        KnihaDao knihaDao = DaoFactory.INSTANCE.getKnihaDao();
        List<Kniha> kniha = knihaDao.dajVsetkyKnihy();
        assertEquals(1, kniha.size());        
    }
    
     @Test
    public void testsave(Kniha kniha) {
   
       KnihaDao knihaDao = DaoFactory.INSTANCE.getKnihaDao();
       List<Kniha> listkniha = knihaDao.dajVsetkyKnihy();
       knihaDao.save(kniha);
       List<Kniha> listkniha2 = knihaDao.dajVsetkyKnihy();
       assertEquals(listkniha2.size(), listkniha.size()+1); 
  
    }
    
     @Test
    public void testodstranit(Kniha kniha) {
   
       KnihaDao knihaDao = DaoFactory.INSTANCE.getKnihaDao();
       List<Kniha> listkniha = knihaDao.dajVsetkyKnihy();
       knihaDao.odstranit(kniha);
       List<Kniha> listkniha2 = knihaDao.dajVsetkyKnihy();
       assertEquals(listkniha2.size()+1, listkniha.size()); 
  
    }
    
    @Test
    public void testHladatPodlaNazvu(String filter) {
       /*Tento test treba doplnit , 
        zatial ma totiz nenapadol efektivny sposob ako to urobit */    
    }
    
     @Test
    public void testHladatPodlaAutora(String filter) {
         /*Tento test treba doplnit , 
        zatial ma totiz nenapadol efektivny sposob ako to urobit */        
    }
    
    
    
}

