package GUI;
import wszystko.FulfillmentCenter;

import java.util.List;

public class DisplayObjectTableModel2 extends CustomTableModel<FulfillmentCenter> {

    public DisplayObjectTableModel2() {
        super();
    }

    public DisplayObjectTableModel2(List<FulfillmentCenter> rows) {
        super(rows);
    }

    @Override
    protected Object getValueAt(FulfillmentCenter center, int columnIndex) {
        Object tmp;
        if (columnIndex == 0) {
            tmp = center.getStorage_name();
        } else if (columnIndex == 1) {
            tmp = center.getStorage_place();
        } else
            tmp = center.getStorage_capacity();
        return tmp;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0 )
            return "Nazwa magazynu";
        else if(column==1)
            return "Miejscowosc";
        else
            return"Całkowita pojemnosc" ;
    }
}
