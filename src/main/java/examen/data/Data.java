package examen.data;


import examen.logic.*;
import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    private List<User> users;

    @XmlElementWrapper(name = "proyectos")
    @XmlElement(name = "proyecto")
    private List<Proyecto> proyectos;


    public Data() {
        users = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> partidos) {this.users = partidos;}

  public List<Proyecto> getProyectos() {
      return proyectos;
  }
  public void setProyectos(List<Proyecto> equipos) {
      this.proyectos = equipos;
  }


}
