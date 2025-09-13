package examen;

import examen.logic.Service;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static final Color BACKGROUND_ERROR = new Color(255, 102, 102);

    public static void main(String[] args) {

        JFrame window = new JFrame(" ");
        JTabbedPane tabbedPane = new JTabbedPane();
        window.setContentPane(tabbedPane);
        window.setTitle("Campeonato de Futbol");
        examen.presentation.tablero.Model equiposmodel = new examen.presentation.tablero.Model();
        examen.presentation.tablero.View equiposView = new examen.presentation.tablero.View();
        examen.presentation.tablero.Controller equiposController = new examen.presentation.tablero.Controller(equiposView, equiposmodel);
        tabbedPane.addTab("Tablero", equiposView.getMainPanelTablero());

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 500); // O usa window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
