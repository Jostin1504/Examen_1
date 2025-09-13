package examen.presentation.tablero;

import examen.presentation.AbstractTableModel;
import examen.logic.Tarea;
import java.util.List;

public class TareasTableModel extends AbstractTableModel<Tarea> implements javax.swing.table.TableModel {
    public TareasTableModel(int[] cols, List<Tarea> rows) {
        super(cols, rows);
    }

    public static final int NUMERO = 0;
    public static final int DESCRIPCION = 1;
    public static final int VENCE = 2;
    public static final int PRIORIDAD = 3;
    public static final int ESTADO = 4;
    public static final int RESPONSABLE = 5;

    @Override
    protected void initColNames() {
        colNames = new String[6];
        colNames[NUMERO] = "Número";
        colNames[DESCRIPCION] = "Descripción";
        colNames[VENCE] = "Vence";
        colNames[PRIORIDAD] = "Prioridad";
        colNames[ESTADO] = "Estado";
        colNames[RESPONSABLE] = "Responsable";

    }

    @Override
    protected Object getPropetyAt(Tarea e, int col) {
        switch (cols[col]) {
            case NUMERO:
                return e.getNumero();
            case DESCRIPCION:
                return e.getDescripcion();
            case VENCE:
                return e.getFecha();
            case PRIORIDAD:
                return e.getPrioridad();
            case ESTADO:
                return e.getEstado();
            case RESPONSABLE:
                return e.getResponsable();
            default:
                return "";
        }
    }
}
