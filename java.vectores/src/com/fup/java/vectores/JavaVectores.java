package com.fup.java.vectores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class JavaVectores extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnMarcarAsistencia;
    private JButton btnMarcarFalta;

    public JavaVectores() {
        setTitle("Juego de Asistencia de Clase");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo de la tabla con columnas
        modelo = new DefaultTableModel(new Object[]{"Estudiante", "Estado"}, 0);
        tabla = new JTable(modelo);

        // Agregar algunos estudiantes de ejemplo
        modelo.addRow(new Object[]{"Ana", "Pendiente"});
        modelo.addRow(new Object[]{"Carlos", "Pendiente"});
        modelo.addRow(new Object[]{"María", "Pendiente"});
        modelo.addRow(new Object[]{"José", "Pendiente"});

        JScrollPane scrollPane = new JScrollPane(tabla);

        // Botones
        btnMarcarAsistencia = new JButton("Marcar Asistencia");
        btnMarcarFalta = new JButton("Marcar Falta");

        // Acción de botones
        btnMarcarAsistencia.addActionListener(e -> marcar("Asistió"));
        btnMarcarFalta.addActionListener(e -> marcar("Faltó"));

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnMarcarAsistencia);
        panelBotones.add(btnMarcarFalta);

        // Layout
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void marcar(String estado) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            modelo.setValueAt(estado, fila, 1);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un estudiante primero.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JavaVectores().setVisible(true);
        });
    }
}
