package paz1c.knihy;


import java.math.BigDecimal;

public class Kniha {
    private Long id;
    
    private String nazov;
            
    private String autor;
    
    private String recenzia;
            
    private BigDecimal cena;
    
    private Long kategoria_id;
    
    private Long vydavatelstvo_id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
    
    public String getRecenzia() {
        return recenzia;
    }

    public void setRecenzia(String recenzia) {
        this.recenzia = recenzia;
    }
 
    public Long getKategoria_id() {
        return kategoria_id;
    }

    public void setKategoria_id(Long kategoria_id) {
        this.kategoria_id = kategoria_id;
    }
    public Long getVydavatelstvo_id() {
        return vydavatelstvo_id;
    }

    public void setVydavatelstvo_id(Long vydavatelstvo_id) {
        this.vydavatelstvo_id = vydavatelstvo_id;
    }
}