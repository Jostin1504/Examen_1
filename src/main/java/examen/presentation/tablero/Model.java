package examen.presentation.tablero;

import examen.logic.User;
import examen.logic.Proyecto;
import examen.logic.Tarea;
import examen.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {
    Proyecto current;
    Tarea tarea;
    List<Proyecto> proyectos;
    List<Tarea> tareas;
    List<User> users;

    public static final String CURRENT = "current";
    public static final String PROYECTOS = "proyectos";
    public static final String TAREAS = "tareas";
    public static final String TAREA = "tarea";
    public static final String USERS = "users";

    public Model(){
        current = new Proyecto();
        tarea = new Tarea();
        proyectos = new ArrayList<>();
        tareas = new ArrayList<>();
        users = new ArrayList<>();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
        firePropertyChange(PROYECTOS);
        firePropertyChange(TAREAS);
        firePropertyChange(TAREA);
        firePropertyChange(USERS);
    }

    public Proyecto getCurrent() {
        return current;
    }
    public Tarea getTarea() { return tarea; }

    public void setCurrent(Proyecto current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
        firePropertyChange(TAREA);
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public List<User>  getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        firePropertyChange(USERS);
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
        firePropertyChange(PROYECTOS);
    }

    public List<Tarea> getTareas() {return tareas;}
    public void setTareas(List<Tarea> partidos) {
        this.tareas = partidos;
        firePropertyChange(TAREAS);
    }
}
