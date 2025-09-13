package examen.presentation.tablero;

import javax.swing.*;

import examen.logic.*;
import examen.Application;
import com.github.lgooddatepicker.components.DatePicker;

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
    private JButton crearButton1;
    private JTextField descTareaFld;
    private JTextField textField1;

    public View() {
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate()){
                    controller.crearProyecto();
                }
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
            case Model.PROYECTOS:
                int[] cols = {ProyectosTableModel.CODIGO, ProyectosTableModel.DESCRIPCION, ProyectosTableModel.ENCARGADO, ProyectosTableModel.TAREAS};
                proyectos.setModel(new ProyectosTableModel(cols,model.getProyectos()));
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
        }else {
            usersCombo.setBackground(null);
            usersCombo.setToolTipText(null);
        }
        if (descFld.getText().isEmpty()) {
            valid = false;
            descFld.setBackground(Application.BACKGROUND_ERROR);
        }else {
            descFld.setBackground(null);
            descFld.setToolTipText(null);
        }
        if(!valid){
            JOptionPane.showMessageDialog(mainPanelTablero, "Asegurese de llenar todos los espacios");
        }
        return valid;
    }

    public JPanel getMainPanelTablero() {return mainPanelTablero;}
    public User getSelectedUser() {return (User) usersCombo.getSelectedItem();}
    public String getDesc() {return descFld.getText();}
}
