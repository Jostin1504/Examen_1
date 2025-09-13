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
    private JButton crearButton1;
    private JTextField descTareaFld;
    private JTextField fechaFld;
    private JComboBox usersTareasComboBox;
    private JComboBox prioCombo;
    private JComboBox estCombo;
    private JPanel PanelCrearTareas;
    private JTextField textField2;
    private JTextField numeroFld;
    private JButton editarTareaButton;

    public View() {
        editarTareaButton.setVisible(false);
        PanelCrearTareas.setVisible(false);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validate()){
                    try {
                        controller.crearProyecto();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });
        proyectos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = proyectos.getSelectedRow();
                if (selectedRow >= 0) {
                    ProyectosTableModel tableModel = (ProyectosTableModel) proyectos.getModel();
                    Proyecto equipoSeleccionado = tableModel.getRowAt(selectedRow);
                    model.setCurrent(equipoSeleccionado);
                }
            }
        });
        tareas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tareas.getSelectedRow();
                if (selectedRow >= 0) {
                    TareasTableModel tableModel = (TareasTableModel) tareas.getModel();
                    Tarea equipoSeleccionado = tableModel.getRowAt(selectedRow);
                    model.setTarea(equipoSeleccionado);
                }
            }
        });
        crearButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateTareas()){
                    controller.crearTarea();
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
                proyectoSeleccionado.setText(model.getCurrent().toString());
                if(model.getCurrent() != null && !model.getCurrent().getCodigo().trim().isEmpty()){
                PanelCrearTareas.setVisible(true);}
                int[] cols = {TareasTableModel.NUMERO, TareasTableModel.DESCRIPCION, TareasTableModel.VENCE, TareasTableModel.PRIORIDAD, TareasTableModel.ESTADO, TareasTableModel.RESPONSABLE};
                tareas.setModel(new TareasTableModel(cols,model.getCurrent().getTareas()));
                break;
            case Model.TAREA:
                if(model.getTarea() != null && !model.getTarea().getNumero().trim().isEmpty()){
                    editarTareaButton.setVisible(true);}
            case Model.PROYECTOS:
                int[] cols2 = {ProyectosTableModel.CODIGO, ProyectosTableModel.DESCRIPCION, ProyectosTableModel.ENCARGADO, ProyectosTableModel.TAREAS};
                proyectos.setModel(new ProyectosTableModel(cols2,model.getProyectos()));
                break;
                case Model.TAREAS:
                    int[] cols4 = {TareasTableModel.NUMERO, TareasTableModel.DESCRIPCION, TareasTableModel.VENCE, TareasTableModel.PRIORIDAD, TareasTableModel.ESTADO, TareasTableModel.RESPONSABLE};
                    tareas.setModel(new TareasTableModel(cols4,model.getCurrent().getTareas()));
                    break;

        }
        this.mainPanelTablero.revalidate();
    }

    private void llenarComboBox() {
        if (model == null || model.getUsers() == null) return;
        for (User user : model.getUsers()) {
            usersCombo.addItem(user);
            usersTareasComboBox.addItem(user);
        }
    }

    private boolean validate() {
        boolean valid = true;
        if(textField2.getText().isEmpty()){
            valid = false;
            textField2.setBackground(Application.BACKGROUND_ERROR);
        }else {
            textField2.setBackground(null);
            textField2.setToolTipText(null);
        }
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

    private boolean validateTareas() {
        boolean valid = true;

        if (numeroFld.getText().isEmpty()) {
            valid = false;
            numeroFld.setBackground(Application.BACKGROUND_ERROR);
        }else {
            numeroFld.setBackground(null);
            numeroFld.setToolTipText(null);
        }
        if (fechaFld.getText().isEmpty()) {
            valid = false;
            fechaFld.setBackground(Application.BACKGROUND_ERROR);
        }else {
            fechaFld.setBackground(null);
            fechaFld.setToolTipText(null);
        }
        if (usersTareasComboBox.getSelectedItem() == null){
            valid = false;
            usersTareasComboBox.setBackground(Application.BACKGROUND_ERROR);
        }else {
            usersTareasComboBox.setBackground(null);
            usersTareasComboBox.setToolTipText(null);
        }
        if (prioCombo.getSelectedItem() == null){
            valid = false;
            prioCombo.setBackground(Application.BACKGROUND_ERROR);
        }else {
            prioCombo.setBackground(null);
            prioCombo.setToolTipText(null);
        }
        if (estCombo.getSelectedItem() == null){
            valid = false;
            estCombo.setBackground(Application.BACKGROUND_ERROR);
        }else {
            estCombo.setBackground(null);
            estCombo.setToolTipText(null);
        }
        if (descTareaFld.getText().isEmpty()) {
            valid = false;
            descTareaFld.setBackground(Application.BACKGROUND_ERROR);
        }else {
            descTareaFld.setBackground(null);
            descTareaFld.setToolTipText(null);
        }
        if(!valid){
            JOptionPane.showMessageDialog(mainPanelTablero, "Asegurese de llenar todos los espacios");
        }
        return valid;
    }

    public JPanel getMainPanelTablero() {return mainPanelTablero;}
    public User getSelectedUser() {return (User) usersCombo.getSelectedItem();}
    public String getDesc() {return descFld.getText();}
    public String getCode() {return textField2.getText();}
    public String getNum(){return numeroFld.getText();}
    public String getDescT(){return descTareaFld.getText();}
    public String getVence(){return fechaFld.getText();}
    public String getPrio(){return prioCombo.getSelectedItem().toString();}
    public String getEstado(){return estCombo.getSelectedItem().toString();}
    public User getEnc(){return (User) usersTareasComboBox.getSelectedItem();}

}
