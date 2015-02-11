import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import paz1c.knihy.DatabazovyVydavatelstvoDao;
import paz1c.knihy.Vydavatelstvo;
import org.springframework.jdbc.core.JdbcTemplate;
import paz1c.knihy.DaoFactory;
import paz1c.knihy.KategoriaDao;
import paz1c.knihy.VydavatelstvoDao;

public class DatabazovyVydavatelstvoDaoTest {
    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }
    
    @Test
    public void testDajVsetkyKategorie() {
        VydavatelstvoDao vydavatelstvoDao = DaoFactory.INSTANCE.getVydavatelstvoDao();
        List<Vydavatelstvo> vydavatelstvo = vydavatelstvoDao.dajVsetkyVydavatelstva();
        assertEquals(1, vydavatelstvo.size());        
    }
    
     @Test
    public void testsave(Vydavatelstvo vydavatelstvo) {
   
       VydavatelstvoDao vydavatelstvoDao = DaoFactory.INSTANCE.getVydavatelstvoDao();
       List<Vydavatelstvo> listvydavatelstvo = vydavatelstvoDao.dajVsetkyVydavatelstva();
       vydavatelstvoDao.save(vydavatelstvo);
       List<Vydavatelstvo> listvydavatelstvo2 = vydavatelstvoDao.dajVsetkyVydavatelstva();
       assertEquals(listvydavatelstvo2.size(), listvydavatelstvo.size()+1); 
  
    }
    
     @Test
    public void testodstranit(Vydavatelstvo vydavatelstvo) {
   
      VydavatelstvoDao vydavatelstvoDao = DaoFactory.INSTANCE.getVydavatelstvoDao();
       List<Vydavatelstvo> listvydavatelstvo = vydavatelstvoDao.dajVsetkyVydavatelstva();
       vydavatelstvoDao.odstranit(vydavatelstvo);
       List<Vydavatelstvo> listvydavatelstvo2 = vydavatelstvoDao.dajVsetkyVydavatelstva();
       assertEquals(listvydavatelstvo2.size()+1, listvydavatelstvo.size()); 
  
    }
    
}