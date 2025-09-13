package examen.presentation.tablero;

import examen.logic.Tarea;
import examen.logic.Proyecto;
import examen.logic.User;
import examen.logic.Service;
import java.util.List;

public class Controller {
    View view;
    Model model;



    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
        model.addPropertyChangeListener(view);
        model.setUsers(Service.instance().getDatos().getUsers());
        model.setProyectos(Service.instance().getDatos().getProyectos());
    }

    public void crearProyecto(){
        Service.instance().crearProyecto(view.getCode(),view.getDesc(), view.getSelectedUser());
        model.setProyectos(Service.instance().getDatos().getProyectos());
    }

    public void crearTarea() {
        Service.instance().crearTarea(view.getNum(), view.getDescT(), view.getVence(), view.getPrio(), view.getEstado(), view.getSelectedUser(), model.getCurrent());
        model.setTareas(model.getCurrent().getTareas());
    }

    public void clear(){
        model.setCurrent(new Proyecto());
    }

    public List<Proyecto> getProyectos(){
        return Service.instance().getDatos().getProyectos();
    }
    public List<User> getUsers(){
        return Service.instance().getDatos().getUsers();
    }
}
