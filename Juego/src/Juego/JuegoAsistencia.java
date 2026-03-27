//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//
//public class JuegoAsistencia extends JFrame {
//    private JPanel mainPanel;
//    private JList<String> materiasList;
//    private DefaultListModel<String> materiasListModel;
//    private JTable asistenciaTable;
//    private DefaultTableModel tableModel;
//    private JTextField nuevaMateriaField;
//    private JButton nuevaMateriaBtn;
//    private JButton guardarAsistenciaBtn;
//    private JComboBox<String> estadoComboBox;
//    
//    // Estructura de datos para almacenar asistencias por materia
//    private HashMap<String, HashMap<String, String>> asistenciasPorMateria;
//    private HashMap<String, ArrayList<String>> estudiantesPorMateria;
//    private String materiaSeleccionada;
//    
//    // Lista global de estudiantes
//    private String[] estudiantesGlobales = {
//        "Juan Pérez",
//        "María García",
//        "Carlos López",
//        "Ana Martínez",
//        "Luis Rodríguez",
//        "Laura Fernández",
//        "Pedro Sánchez",
//        "Sofía Torres"
//    };
//    
//    public JuegoAsistencia() {
//        setTitle("Sistema de Asistencia por Materias");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(900, 600);
//        setLocationRelativeTo(null);
//        
//        // Inicializar estructuras de datos
//        asistenciasPorMateria = new HashMap<>();
//        estudiantesPorMateria = new HashMap<>();
//        materiasListModel = new DefaultListModel<>();
//        
//        // Crear la interfaz
//        initComponents();
//        
//        // Agregar algunas materias de ejemplo
//        agregarMateriaEjemplo("Matemáticas");
//        agregarMateriaEjemplo("Programación");
//        agregarMateriaEjemplo("Física");
//        
//        setVisible(true);
//    }
//    
//    private void initComponents() {
//        setLayout(new BorderLayout(10, 10));
//        
//        // Panel superior - Crear nueva materia
//        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
//        topPanel.setBorder(BorderFactory.createTitledBorder("Nueva Materia"));
//        
//        topPanel.add(new JLabel("Nombre de la materia:"));
//        nuevaMateriaField = new JTextField(20);
//        topPanel.add(nuevaMateriaField);
//        
//        nuevaMateriaBtn = new JButton("Crear Materia");
//        nuevaMateriaBtn.addActionListener(e -> crearNuevaMateria());
//        topPanel.add(nuevaMateriaBtn);
//        
//        add(topPanel, BorderLayout.NORTH);
//        
//        // Panel central dividido
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//        splitPane.setDividerLocation(250);
//        
//        // Panel izquierdo - Lista de materias
//        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
//        leftPanel.setBorder(BorderFactory.createTitledBorder("Materias Disponibles"));
//        
//        materiasList = new JList<>(materiasListModel);
//        materiasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        materiasList.addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                String seleccion = materiasList.getSelectedValue();
//                if (seleccion != null) {
//                    materiaSeleccionada = seleccion;
//                    cargarAsistenciaMateria(seleccion);
//                }
//            }
//        });
//        
//        JScrollPane materiasScroll = new JScrollPane(materiasList);
//        leftPanel.add(materiasScroll, BorderLayout.CENTER);
//        
//        splitPane.setLeftComponent(leftPanel);
//        
//        // Panel derecho - Tabla de asistencia
//        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
//        rightPanel.setBorder(BorderFactory.createTitledBorder("Registro de Asistencia"));
//        
//        // Crear la tabla con columnas
//        String[] columnas = {"Estudiante", "Asistencia"};
//        tableModel = new DefaultTableModel(columnas, 0) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column == 1; // Solo la columna de asistencia es editable
//            }
//        };
//        
//        asistenciaTable = new JTable(tableModel);
//        asistenciaTable.setRowHeight(25);
//        
//        // Configurar combo box para la columna de asistencia
//        String[] estados = {"Presente", "Ausente", "Tarde", "Justificado"};
//        estadoComboBox = new JComboBox<>(estados);
//        
//        asistenciaTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(estadoComboBox));
//        
//        JScrollPane tableScroll = new JScrollPane(asistenciaTable);
//        rightPanel.add(tableScroll, BorderLayout.CENTER);
//        
//        // Panel inferior - Botón guardar
//        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        guardarAsistenciaBtn = new JButton("Guardar Asistencia");
//        guardarAsistenciaBtn.addActionListener(e -> guardarAsistencia());
//        bottomPanel.add(guardarAsistenciaBtn);
//        
//        rightPanel.add(bottomPanel, BorderLayout.SOUTH);
//        
//        splitPane.setRightComponent(rightPanel);
//        add(splitPane, BorderLayout.CENTER);
//        
//        // Panel de información
//        JPanel infoPanel = new JPanel();
//        infoPanel.setBorder(BorderFactory.createTitledBorder("Información"));
//        JLabel infoLabel = new JLabel("Seleccione una materia para ver/editar asistencias");
//        infoPanel.add(infoLabel);
//        add(infoPanel, BorderLayout.SOUTH);
//    }
//    
//    private void crearNuevaMateria() {
//        String nombreMateria = nuevaMateriaField.getText().trim();
//        
//        if (nombreMateria.isEmpty()) {
//            JOptionPane.showMessageDialog(this, 
//                "Por favor ingrese un nombre para la materia", 
//                "Campo vacío", 
//                JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        
//        // Verificar si la materia ya existe
//        if (materiasListModel.contains(nombreMateria)) {
//            JOptionPane.showMessageDialog(this, 
//                "La materia '" + nombreMateria + "' ya existe", 
//                "Materia duplicada", 
//                JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        
//        agregarMateriaEjemplo(nombreMateria);
//        nuevaMateriaField.setText("");
//        
//        JOptionPane.showMessageDialog(this, 
//            "Materia '" + nombreMateria + "' creada exitosamente", 
//            "Éxito", 
//            JOptionPane.INFORMATION_MESSAGE);
//    }
//    
//    private void agregarMateriaEjemplo(String nombreMateria) {
//        // Agregar a la lista visual
//        materiasListModel.addElement(nombreMateria);
//        
//        // Inicializar estudiantes para esta materia
//        ArrayList<String> estudiantes = new ArrayList<>(Arrays.asList(estudiantesGlobales));
//        estudiantesPorMateria.put(nombreMateria, estudiantes);
//        
//        // Inicializar asistencias (todos ausentes por defecto)
//        HashMap<String, String> asistencias = new HashMap<>();
//        for (String estudiante : estudiantes) {
//            asistencias.put(estudiante, "Ausente");
//        }
//        asistenciasPorMateria.put(nombreMateria, asistencias);
//    }
//    
//    private void cargarAsistenciaMateria(String materia) {
//        // Limpiar la tabla
//        tableModel.setRowCount(0);
//        
//        // Obtener estudiantes y asistencias de la materia seleccionada
//        ArrayList<String> estudiantes = estudiantesPorMateria.get(materia);
//        HashMap<String, String> asistencias = asistenciasPorMateria.get(materia);
//        
//        if (estudiantes != null && asistencias != null) {
//            for (String estudiante : estudiantes) {
//                String estado = asistencias.getOrDefault(estudiante, "Ausente");
//                tableModel.addRow(new Object[]{estudiante, estado});
//            }
//        }
//        
//        // Actualizar el título
//        setTitle("Sistema de Asistencia - " + materia);
//    }
//    
//    private void guardarAsistencia() {
//        if (materiaSeleccionada == null) {
//            JOptionPane.showMessageDialog(this, 
//                "Por favor seleccione una materia primero", 
//                "Sin selección", 
//                JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        
//        // Obtener el mapa de asistencias de la materia actual
//        HashMap<String, String> asistencias = asistenciasPorMateria.get(materiaSeleccionada);
//        
//        if (asistencias != null) {
//            // Guardar los valores de la tabla en el mapa de asistencias
//            for (int i = 0; i < tableModel.getRowCount(); i++) {
//                String estudiante = (String) tableModel.getValueAt(i, 0);
//                String estado = (String) tableModel.getValueAt(i, 1);
//                asistencias.put(estudiante, estado);
//            }
//            
//            JOptionPane.showMessageDialog(this, 
//                "Asistencias guardadas exitosamente para " + materiaSeleccionada, 
//                "Guardado exitoso", 
//                JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//    
//    public static void main(String[] args) {
//        // Ejecutar la interfaz en el hilo de eventos de Swing
//        SwingUtilities.invokeLater(() -> {
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            new JuegoAsistencia();
//        });
//    }
//}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JuegoAsistencia extends JFrame {
    
    private JComboBox<String> materiasComboBox;
    private DefaultComboBoxModel<String> materiasModel;
    private JTable tablaAsistencia;
    private DefaultTableModel tableModel;
    private JTextField nuevaMateriaField;
    private JButton btnGuardar;
    private JButton btnNuevaMateria;
    
    // Estructuras de datos
    private HashMap<String, HashMap<String, Boolean>> asistenciasPorMateria;
    private String[] estudiantes = {
        "Juan Pérez",
        "María García", 
        "Carlos López",
        "Ana Martínez",
        "Luis Rodríguez",
        "Laura Fernández"
    };
    
    private String materiaActual;
    
    public JuegoAsistencia() {
        setTitle("Sistema de Asistencia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        // Inicializar datos
        asistenciasPorMateria = new HashMap<>();
        materiasModel = new DefaultComboBoxModel<>();
        
        // Configurar la interfaz
        initComponents();
        
        // Agregar materias de ejemplo
        agregarMateria("Matemáticas");
        agregarMateria("Programación");
        
        setVisible(true);
    }
    
    private void initComponents() {
        // Panel principal con borde
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // ========== PANEL SUPERIOR ==========
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBorder(BorderFactory.createTitledBorder("Asistencias de una Materia"));
        
        // Panel para selector de materia
        JPanel selectorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        selectorPanel.add(new JLabel("Materia:"));
        
        materiasComboBox = new JComboBox<>(materiasModel);
        materiasComboBox.setPreferredSize(new Dimension(200, 25));
        materiasComboBox.addActionListener(e -> {
            if (materiasComboBox.getSelectedItem() != null) {
                materiaActual = (String) materiasComboBox.getSelectedItem();
                cargarAsistenciaMateria(materiaActual);
            }
        });
        selectorPanel.add(materiasComboBox);
        
        // Panel para nueva materia
        JPanel nuevaMateriaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        nuevaMateriaPanel.add(new JLabel("Nueva Materia:"));
        nuevaMateriaField = new JTextField(15);
        nuevaMateriaPanel.add(nuevaMateriaField);
        
        btnNuevaMateria = new JButton("Guardar");
        btnNuevaMateria.addActionListener(e -> crearNuevaMateria());
        nuevaMateriaPanel.add(btnNuevaMateria);
        
        topPanel.add(selectorPanel, BorderLayout.NORTH);
        topPanel.add(nuevaMateriaPanel, BorderLayout.SOUTH);
        
        // ========== TABLA DE ASISTENCIA ==========
        String[] columnas = {"Item", "Title 1", "Title 2", "Title 3", "Title 4"};
        
        tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Integer.class;
                if (columnIndex >= 1 && columnIndex <= 3) return String.class;
                if (columnIndex == 4) return Boolean.class;
                return String.class;
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Solo el checkbox de asistencia es editable
            }
        };
        
        tablaAsistencia = new JTable(tableModel);
        tablaAsistencia.setRowHeight(30);
        tablaAsistencia.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaAsistencia.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaAsistencia.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaAsistencia.getColumnModel().getColumn(3).setPreferredWidth(150);
        tablaAsistencia.getColumnModel().getColumn(4).setPreferredWidth(80);
        
        JScrollPane scrollPane = new JScrollPane(tablaAsistencia);
        
        // ========== BOTÓN GUARDAR ==========
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnGuardar = new JButton("Guardar Asistencia");
        btnGuardar.setPreferredSize(new Dimension(150, 35));
        btnGuardar.addActionListener(e -> guardarAsistencia());
        bottomPanel.add(btnGuardar);
        
        // Agregar todo al panel principal
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void crearNuevaMateria() {
        String nombreMateria = nuevaMateriaField.getText().trim();
        
        if (nombreMateria.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un nombre para la materia", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Verificar si ya existe
        for (int i = 0; i < materiasModel.getSize(); i++) {
            if (materiasModel.getElementAt(i).equalsIgnoreCase(nombreMateria)) {
                JOptionPane.showMessageDialog(this, 
                    "La materia '" + nombreMateria + "' ya existe", 
                    "Materia duplicada", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        agregarMateria(nombreMateria);
        nuevaMateriaField.setText("");
        
        JOptionPane.showMessageDialog(this, 
            "Materia '" + nombreMateria + "' creada exitosamente", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void agregarMateria(String nombreMateria) {
        materiasModel.addElement(nombreMateria);
        
        // Inicializar asistencias para esta materia (todos false = no asistieron)
        HashMap<String, Boolean> asistencias = new HashMap<>();
        for (String estudiante : estudiantes) {
            asistencias.put(estudiante, false);
        }
        asistenciasPorMateria.put(nombreMateria, asistencias);
        
        // Si es la primera materia, seleccionarla automáticamente
        if (materiasModel.getSize() == 1) {
            materiasComboBox.setSelectedIndex(0);
            materiaActual = nombreMateria;
            cargarAsistenciaMateria(materiaActual);
        }
    }
    
    private void cargarAsistenciaMateria(String materia) {
        // Limpiar la tabla
        tableModel.setRowCount(0);
        
        HashMap<String, Boolean> asistencias = asistenciasPorMateria.get(materia);
        
        if (asistencias != null) {
            int itemNum = 1;
            for (String estudiante : estudiantes) {
                Boolean asistio = asistencias.getOrDefault(estudiante, false);
                
                // Dividir el nombre del estudiante en partes para las columnas
                String[] nombrePartes = estudiante.split(" ");
                String nombre = nombrePartes[0];
                String apellido = nombrePartes.length > 1 ? nombrePartes[1] : "";
                String completo = estudiante;
                
                tableModel.addRow(new Object[]{
                    itemNum++,      // Item
                    nombre,         // Title 1
                    apellido,       // Title 2  
                    completo,       // Title 3
                    asistio         // Title 4 (checkbox)
                });
            }
        }
        
        // Actualizar título de la ventana
        setTitle("Sistema de Asistencia - " + materia);
    }
    
    private void guardarAsistencia() {
        if (materiaActual == null) {
            JOptionPane.showMessageDialog(this, 
                "No hay materia seleccionada", 
                "Error", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        HashMap<String, Boolean> asistencias = asistenciasPorMateria.get(materiaActual);
        
        if (asistencias != null) {
            // Recorrer la tabla y guardar los valores de los checkboxes
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String nombreCompleto = (String) tableModel.getValueAt(i, 3);
                Boolean asistio = (Boolean) tableModel.getValueAt(i, 4);
                asistencias.put(nombreCompleto, asistio);
            }
            
            // Contar cuántos asistieron
            int presentes = 0;
            for (Boolean asistio : asistencias.values()) {
                if (asistio) presentes++;
            }
            
            JOptionPane.showMessageDialog(this, 
                "Asistencias guardadas exitosamente para " + materiaActual + "\n" +
                "Estudiantes que asistieron: " + presentes + " de " + estudiantes.length, 
                "Guardado exitoso", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new JuegoAsistencia();
        });
    }
}