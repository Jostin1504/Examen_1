package examen.presentation.tablero;

import examen.presentation.AbstractTableModel;
import examen.logic.Proyecto;
import java.util.List;

public class ProyectosTableModel extends AbstractTableModel<Proyecto> implements javax.swing.table.TableModel {
    public ProyectosTableModel(int[] cols, List<Proyecto> rows) {
        super(cols, rows);
    }

    public static final int CODIGO = 0;
    public static final int DESCRIPCION = 1;
    public static final int ENCARGADO = 2;
    public static final int TAREAS = 3;

    @Override
    protected void initColNames() {
        colNames = new String[4];
        colNames[CODIGO] = "Código";
        colNames[DESCRIPCION] = "Descripción";
        colNames[ENCARGADO] = "Encargado";
        colNames[TAREAS] = "# Tareas";
    }

    @Override
    protected Object getPropetyAt(Proyecto e, int col) {
        switch (cols[col]) {
            case CODIGO:
                return e.getCodigo();
            case DESCRIPCION:
                return e.getDescripcion();
            case ENCARGADO:
                return e.getResponsable();
            case TAREAS:
                return e.getNumTareas();
            default:
                return "";
        }
    }
}
