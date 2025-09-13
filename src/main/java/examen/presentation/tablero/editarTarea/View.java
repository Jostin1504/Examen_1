package examen.presentation.tablero.editarTarea;

import examen.logic.Tarea;
import examen.presentation.tablero.Controller;
import examen.presentation.tablero.Model;
import examen.presentation.tablero.TareasTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JDialog implements PropertyChangeListener {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton cancelButton;
    private JButton OKButton;

    public View() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(OKButton);
        setLocationRelativeTo(null);
        setTitle("Editar Tarea");
        setSize(400, 250);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.TAREA:

                break;
        }
        this.contentPane.revalidate();
    }
}
