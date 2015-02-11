
package paz1c.knihy;

import javax.swing.RowFilter;

public class KnihaPodlaNazvuRowFilter extends RowFilter {
    private static final int STLPEC_NAZOV = 0;
    
    private String nazov = "";
    
    @Override
    public boolean include(Entry entry) {
        String nazov = entry.getStringValue(STLPEC_NAZOV);
        return nazov.contains(this.nazov);
    }
    
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }
}