package examen.presentation.tablero;

import javax.swing.*;

import examen.logic.*;
import examen.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {
    Model model;
    Controller controller;
    private JButton crearButton;
    private JTextField descFld;
    private JComboBox usersCombo;
    private JTable proyectos;
    private JTable tareas;
    private JLabel proyectoSeleccionado;
    private JPanel mainPanelTablero;

    public View() {
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validate();
            }
        });
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.USERS:
                llenarComboBox();
                break;
            case Model.CURRENT:
                break;
        }
        this.mainPanelTablero.revalidate();
    }

    private void llenarComboBox() {
        if (model == null || model.getUsers() == null) return;
        for (User user : model.getUsers()) {
            usersCombo.addItem(user);
        }
    }

    private boolean validate() {
        boolean valid = true;
        if (usersCombo.getSelectedItem() == null){
            valid = false;
            usersCombo.setBackground(Application.BACKGROUND_ERROR);
        }
        if (descFld.getText().isEmpty()) {
            valid = false;
            descFld.setBackground(Application.BACKGROUND_ERROR);
        }
        if(!valid){
            JOptionPane.showMessageDialog(mainPanelTablero, "Asegurese de llenar todos los espacios");
        }
        return valid;
    }

    public JPanel getMainPanelTablero() {
        return mainPanelTablero;
    }
}
