import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import paz1c.knihy.DatabazovyKategoriaDao;
import paz1c.knihy.Kategoria;
import org.springframework.jdbc.core.JdbcTemplate;
import paz1c.knihy.DaoFactory;
import paz1c.knihy.KategoriaDao;

public class DatabazovyKategoriaDaoTest {
    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }
   
    
    @Test
    public void testDajVsetkyKategorie() {
        KategoriaDao kategoriaDao = DaoFactory.INSTANCE.getKategoriaDao();
        List<Kategoria> kategoria = kategoriaDao.dajVsetkyKategorie();
        assertEquals(1, kategoria.size());        
    }
    
     @Test
    public void testsave(Kategoria kategoria) {
   
       KategoriaDao kategoriaDao = DaoFactory.INSTANCE.getKategoriaDao();
       List<Kategoria> listkategoria = kategoriaDao.dajVsetkyKategorie();
       kategoriaDao.save(kategoria);
       List<Kategoria> listkategoria2 = kategoriaDao.dajVsetkyKategorie();
       assertEquals(listkategoria2.size(), listkategoria.size()+1); 
  
    }
    
     @Test
    public void testodstranit(Kategoria kategoria) {
   
       KategoriaDao kategoriaDao = DaoFactory.INSTANCE.getKategoriaDao();
       List<Kategoria> listkategoria = kategoriaDao.dajVsetkyKategorie();
       kategoriaDao.odstranit(kategoria);
       List<Kategoria> listkategoria2 = kategoriaDao.dajVsetkyKategorie();
       assertEquals(listkategoria2.size()+1, listkategoria.size()); 
  
    }
    
}