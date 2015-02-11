package paz1c.knihy;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyKnihaDao implements KnihaDao {
  
    private JdbcTemplate jdbcTemplate;
    
    private BeanPropertyRowMapper<Kniha> mapovac
            = BeanPropertyRowMapper.newInstance(Kniha.class);

    public DatabazovyKnihaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    

    /*Metoda vrati vsetky polozky ulozene v databaze , tym ze ich vyselektuje z databazy*/
    @Override
    public List<Kniha> dajVsetkyKnihy() {
        return jdbcTemplate.query("select * from kniha", mapovac);
    }

    /*Metoda vrati vsetky polozky ktore v sebe maju filter*/
    @Override
    public List<Kniha> hladatPodlaNazvu(String filter) {
        filter = filter.trim();
        filter = "%" + filter + "%";

        return jdbcTemplate.query("select * from kniha where nazov like ?", mapovac, filter);
    }

    /*Metoda vrati vsetky polozky ktore v sebe maju filter*/
    @Override
    public List<Kniha> hladatPodlaAutora(String filter) {
        filter = filter.trim();
        filter = "%" + filter + "%";

        return jdbcTemplate.query("select * from kniha where autor like ?", mapovac, filter);
    }
    
    @Override
    public List<Kniha> hladajPodlaId(Long id){
        return jdbcTemplate.query("select * from kniha where id like ?", mapovac, id);
    }    

    /*Metoda ulozi novu knihu do databazy*/
    @Override
    public void save(Kniha kniha) {
        if (kniha.getId() == null) {
            Map<String, Object> objekty = new HashMap<String, Object>();
            objekty.put("nazov", kniha.getNazov());
            objekty.put("autor", kniha.getAutor());
            objekty.put("cena", kniha.getCena());
            objekty.put("recenzia", kniha.getRecenzia());

            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

            insert.setGeneratedKeyName("id");

            insert.setTableName("kniha");
            Number id = insert.executeAndReturnKey(objekty);
            kniha.setId(id.longValue());
        } else {
            String sql = "UPDATE kniha SET nazov = ? ,autor = ? ,cena = ?,recenzia=?  WHERE id = ?";

            jdbcTemplate.update(sql,
                    kniha.getNazov(),
                    kniha.getAutor(),
                    kniha.getCena(),
                    kniha.getRecenzia(),
                    kniha.getId());
        }
    }

    @Override
    public void odstranit(Kniha kniha) {
        jdbcTemplate.update("DELETE FROM kniha WHERE id = ?",kniha.getId());
    }


}
