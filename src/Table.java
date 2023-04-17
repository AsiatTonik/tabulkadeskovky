import javax.swing.table.AbstractTableModel;
import java.util.List;
public class Table extends AbstractTableModel{



        private List<Deskovky1> seznam;

        public Table(List<Deskovky1> seznam) {
            this.seznam = seznam;
        }

        @Override
        public int getRowCount() {
            return seznam.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Deskovky1 deskovky = seznam.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return deskovky.getNazev();
                case 1:
                    return deskovky.isZakoupeno();
                case 2:
                    return deskovky.getOblibenost();
                default:
                    throw new IllegalArgumentException("Neplatný index sloupce: " + columnIndex);
            }
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Název";
                case 1:
                    return "Zakoupeno";
                case 2:
                    return "Oblíbenost";
                default:
                    throw new IllegalArgumentException("Neplatný " + columnIndex);
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return Boolean.class;
                case 2:
                    return Integer.class;
                default:
                    throw new IllegalArgumentException("Neplatný " + columnIndex);
            }
        }

        public Deskovky1 getDeskovkaAt(int rowIndex) {
            return seznam.get(rowIndex);
        }
    }

