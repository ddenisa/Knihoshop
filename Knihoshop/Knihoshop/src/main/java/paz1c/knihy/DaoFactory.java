package paz1c.knihy;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.getProperties;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum DaoFactory {
    INSTANCE;
    
    private KnihaDao knihaDao;
    
    private KategoriaDao kategoriaDao;
    
    private VydavatelstvoDao vydavatelstvoDao;
    
    private JdbcTemplate jdbcTemplate;
    
    private DataSource dataSource;
    
    public KnihaDao getKnihaDao() {
        if(this.knihaDao == null) {
            this.knihaDao = new DatabazovyKnihaDao(getJdbcTemplate());
        }
        return this.knihaDao;
    }
    
    public KategoriaDao getKategoriaDao() {
        if(this.kategoriaDao == null) {
            this.kategoriaDao = new DatabazovyKategoriaDao(getJdbcTemplate());
        }
        return this.kategoriaDao;
    }
    
    public VydavatelstvoDao getVydavatelstvoDao() {
        if(this.vydavatelstvoDao == null) {
            this.vydavatelstvoDao = new DatabazovyVydavatelstvoDao(getJdbcTemplate());
        }
        return this.vydavatelstvoDao;
    }
    
    public JdbcTemplate getJdbcTemplate() {
        if(this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return this.jdbcTemplate;
    }

    //public DataSource getDataSource() {
      //  if(this.dataSource == null) {
        //    Properties properties = getProperties();
          //  if("test".equals(properties.get("rezim"))) {
            //    System.out.println("Aplikacia bezi v testovacom rezime!");
              //  
                //SQLServerDataSource dataSource = new SQLServerDataSource();
               // dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=paz1c");
               // dataSource.setUser("paz1c");
               // dataSource.setPassword("paz1c");
               // this.dataSource = dataSource;                
            //} else {            
              //  SQLServerDataSource dataSource = new SQLServerDataSource();
                //dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=paz1c");
            //    dataSource.setUser("paz1c");
              //  dataSource.setPassword("paz1c");
                //this.dataSource = dataSource;
            //}
        //}
       // return this.dataSource;
   // }
    
    private DataSource getDataSource() {
        if (this.dataSource == null) {
            SQLServerDataSource dataSource = new SQLServerDataSource();
                dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=paz1c");
                dataSource.setUser("paz1c");
                dataSource.setPassword("paz1c");
                this.dataSource = dataSource;
        }
        return this.dataSource;
    }
    
    private Properties getProperties() {
        try {
            String propertiesFile;
            
            if("true".equals(System.getProperty("testovaciRezim"))) {
                propertiesFile = "/knihoshop-test.properties";
            } else {
                propertiesFile = "/knihoshop.properties";
            }
            
            System.out.println("Nacitavam konfiguraciu z " + propertiesFile);
            
            InputStream in
                    = DaoFactory.class.getResourceAsStream(propertiesFile);

            Properties properties = new Properties();
            properties.load(in);
            
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Nenasiel sa konfiguracny subor");
        }
    }
    
   
}