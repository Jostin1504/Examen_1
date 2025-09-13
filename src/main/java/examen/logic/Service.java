package examen.logic;

import jakarta.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import examen.data.Data;

public class Service {
    private static Service theInstance;
    private Data datos;

    public static Service instance() {
        if (theInstance == null) theInstance = new Service();
        return theInstance;
    }

    private Service() {
        cargarDatos();
    }


    private void cargarDatos() {
        try {
            File file = new File("data.xml");
            if (file.exists()) {
                JAXBContext context = JAXBContext.newInstance(Data.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                datos = (Data) unmarshaller.unmarshal(file);
            } else {
                datos = new Data();
            }

        } catch (Exception e) {
            e.printStackTrace();
            datos = new Data();
        }
    }

    public void crearProyecto(String c, String d, User u){
        List<Tarea> tareas = new ArrayList<>();
        Proyecto proyecto = new Proyecto(c, d, u, tareas);
        datos.getProyectos().add(proyecto);
        guardarDatos();
    }

    public void crearTarea(String numero, String desc, String fecha, String prio, String estado, User resp, Proyecto p) {
        Tarea tarea = new Tarea(numero, desc, fecha, prio, estado, resp);
        p.getTareas().add(tarea);
        guardarDatos();
    }

    public Proyecto read(Proyecto e) throws Exception {
        return datos.getProyectos().stream()
                .filter(i -> i.getCodigo().equals(e.getCodigo()))
                .findFirst()
                .orElseThrow(() -> new Exception("Equipo no existe"));
    }

    public void guardarDatos() {
        try {
            jakarta.xml.bind.JAXBContext context = jakarta.xml.bind.JAXBContext.newInstance(Data.class);
            jakarta.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(datos, new File("data.xml"));
        } catch (Exception e) {
        }
    }


    public Data getDatos() {
        return datos;
    }


}
