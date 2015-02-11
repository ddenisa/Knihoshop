package paz1c.knihy;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyKategoriaDao implements KategoriaDao {
    /*Napojenie sa na databazu . 
     Predpokladam ze databaza ma nazov paz1c, User :paz1c, Password :paz1c .
     Dalej predpokladam ze tabulka v databaze paz1c ma nazov kategoria .
     Tabulka kategoria ma tieto stlpce : id(int), nazov(varchar(20)).
    
     */

    private JdbcTemplate jdbcTemplate;
    
    private BeanPropertyRowMapper<Kategoria> mapovac
            = BeanPropertyRowMapper.newInstance(Kategoria.class);

    public DatabazovyKategoriaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*Metoda vrati vsetky polozky ulozene v databaze , tym ze ich vyselektuje z databazy*/
    @Override
    public List<Kategoria> dajVsetkyKategorie() {
        return jdbcTemplate.query("select * from kategoria", mapovac);
    }

    /*Metoda ulozi novu kategoriu do databazy*/
    @Override
    public void save(Kategoria kategoria) {
        if (kategoria.getId() == null) {
            Map<String, Object> objekty = new HashMap<String, Object>();
            objekty.put("nazov", kategoria.getNazov());

            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

            insert.setGeneratedKeyName("id");

            insert.setTableName("kategoria");
            Number id = insert.executeAndReturnKey(objekty);
            kategoria.setId(id.longValue());
        } else {
            String sql = "UPDATE kategoria SET nazov = ?  WHERE id = ?";

            jdbcTemplate.update(sql,
                    kategoria.getNazov());

        }
    }

    @Override
    public void odstranit(Kategoria kategoria
    ) {
        jdbcTemplate.update("DELETE FROM kategoria WHERE id = ?", kategoria.getId());

    }

    @Override
    public List<Kategoria> kategoriaPodlaId(Long id) {
        return jdbcTemplate.query("select * from kategoria where id LIKE (select kategoria_id from kniha where id LIKE ?)", mapovac, id);
    }

   
}