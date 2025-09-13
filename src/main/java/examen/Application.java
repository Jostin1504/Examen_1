package examen;

import examen.logic.Service;

public class Application {
    public static void main(String[] args) {
        System.out.println(Service.instance().getDatos().getUsers());

    }
}
