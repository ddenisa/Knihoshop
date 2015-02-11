
package paz1c.knihy;

import javax.swing.RowFilter;

public class KnihaPodlaAutoraRowFilter extends RowFilter {
    private static final int STLPEC_AUTOR = 0;
    
    private String autor = "";
    
    @Override
    public boolean include(RowFilter.Entry entry) {
        String autor = entry.getStringValue(STLPEC_AUTOR);
        return autor.contains(this.autor);
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}