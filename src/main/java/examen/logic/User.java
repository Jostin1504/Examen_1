package examen.logic;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlID
    @XmlElement
    private String id;

    @XmlElement
    private String name;

    @XmlElement
    private String email;


    // Constructor vacío
    public User() {
        this.id = "";
        this.name = "";
        this.email = "";
    }

    // Constructor con parámetros
    public User(String id, String nombre, String email) {
        this.id = id;
        this.name = nombre;
        this.email = email;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return name; }
    public void setNombre(String nombre) { this.name = nombre; }

    public String getGanados() { return email; }
    public void setGanados(String ganados) { this.email = ganados; }


    @Override
    public String toString() {
        return name;
    }
}
