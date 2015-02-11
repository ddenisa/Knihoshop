package paz1c.knihy;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyVydavatelstvoDao implements VydavatelstvoDao {
    /*Napojenie sa na databazu . 
     Predpokladam ze databaza ma nazov paz1c, User :paz1c, Password :paz1c .
     Dalej predpokladam ze tabulka v databaze paz1c ma nazov vydavatelstvo .
     Tabulka vydavatelstvo ma tieto stlpce : id(int), nazov(varchar(20)).
    
     */

    private JdbcTemplate jdbcTemplate;
    
    private BeanPropertyRowMapper<Vydavatelstvo> mapovac
            = BeanPropertyRowMapper.newInstance(Vydavatelstvo.class);

    public DatabazovyVydavatelstvoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /*Metoda vrati vsetky polozky ulozene v databaze , tym ze ich vyselektuje z databazy*/
    @Override
    public List<Vydavatelstvo> dajVsetkyVydavatelstva() {
        return jdbcTemplate.query("select * from vydavatelstvo", mapovac);
    }

    /*Metoda ulozi nove vydavatelstvo do databazy*/
    @Override
    public void save(Vydavatelstvo vydavatelstvo) {
        if (vydavatelstvo.getId() == null) {
            Map<String, Object> objekty = new HashMap<String, Object>();
            objekty.put("nazov", vydavatelstvo.getNazov());

            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

            insert.setGeneratedKeyName("id");

            insert.setTableName("vydavatelstvo");
            Number id = insert.executeAndReturnKey(objekty);
            vydavatelstvo.setId(id.longValue());
        } else {
            String sql = "UPDATE vydavatelstvo SET nazov = ?  WHERE id = ?";

            jdbcTemplate.update(sql,
                    vydavatelstvo.getNazov());

        }
    }

    @Override
    public void odstranit(Vydavatelstvo vydavatelstvo
    ) {
        jdbcTemplate.update("DELETE FROM vydavatelstvo WHERE id = ?", vydavatelstvo.getId());

    }

    @Override
    public List<Vydavatelstvo> vydavatelstvoPodlaId(Long id) {
        return jdbcTemplate.query("select * from vydavatelstvo where id LIKE (select vydavatelstvo_id from kniha where id LIKE ?)", mapovac, id);
    }
}