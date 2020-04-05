package GUI;


import wszystko.Item;

import java.util.List;

public class DisplayObjectTableModel extends CustomTableModel<Item> {


    public DisplayObjectTableModel() {
        super();
    }

    public DisplayObjectTableModel(List<Item> rows) {
        super(rows);
    }


    @Override
    protected Object getValueAt(Item product, int columnIndex) {
        Object tmp;
        if (columnIndex == 0) {
            tmp = product.getName();
        } else if (columnIndex == 1) {
            tmp = product.getState();
        } else
            tmp = product.getMass();
        return tmp;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0 )
        return "Nazwa produktu";
        else if(column==1)
            return "Stan";
        else
            return"Masa" ;
    }
}
