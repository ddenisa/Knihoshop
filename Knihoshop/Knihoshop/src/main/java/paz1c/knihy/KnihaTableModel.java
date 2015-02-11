package paz1c.knihy;


import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KnihaTableModel extends AbstractTableModel {
    private static final int POCET_STLPCOV = 4;
    
    private static final String[] NAZVY_STLPCOV = { "Nazov", "Autor","Recenzia","Cena" };
    
    private static final Class[] TYPY_STLPCOV = { 
        String.class,
        String.class,
        String.class,
        BigDecimal.class
            
    };
    
    private KnihaDao knihaDao = DaoFactory.INSTANCE.getKnihaDao();
    
    private List<Kniha> kniha = new LinkedList<>();
    
    private List<Kniha> knihyVKosiku = new LinkedList<>();
   
    
    @Override
    public int getRowCount() {
        return kniha.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kniha vybranaKniha = kniha.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return vybranaKniha.getNazov();
            case 1:
                return vybranaKniha.getAutor();
            case 2:
                return vybranaKniha.getRecenzia();
             case 3:
                return vybranaKniha.getCena(); 
            default:
                return "???";
        }
    }
    
    public void dajNazov(String nazov){
        kniha = knihaDao.hladatPodlaNazvu(nazov);
        fireTableDataChanged();
    }
    
    public void dajAutora(String autor){
        kniha = knihaDao.hladatPodlaAutora(autor);
        fireTableDataChanged();
    }
    
    public void obnov() {
        kniha = knihaDao.dajVsetkyKnihy();
        fireTableDataChanged();
    }
    
    public void dajKnihuSTymtoIdDoKosika(Long id, List<Kniha> zoznam){        
        kniha = zoznam;
        fireTableDataChanged();        
    }
    
    public Kniha dajPodlaCislaRiadku(int riadok) {
        return kniha.get(riadok);
    }
    

    @Override
    public String getColumnName(int column) {
        return NAZVY_STLPCOV[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return TYPY_STLPCOV[columnIndex];
    }
    
    
    
    
}