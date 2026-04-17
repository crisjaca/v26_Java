/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CodigoJuego;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kristian
 */
public class VistaSistemaAsistencia extends javax.swing.JFrame {

    /**
     * Creates new form VistaSistemaAsistencia
     */
    public VistaSistemaAsistencia() {
        initComponents();
//        ArrayList<String> materias = new ArrayList<>();
//        // con add solo agrego un solo elemnto
//        materias.add("Ingles");
//        // uso el metodo addall() para agregar mas elemntos ala lista dinamica
//        materias.addAll(Arrays.asList("Matematicas","Programación"));
    }
    
    private String nombreMateria;
    // LISTA ESTUDIANTES
    private List<Estudiante> listaEstudiantes = new ArrayList<>();
    
    public static class Estudiante{
        private String nombre;
        private boolean asistencia;
//        Constructor
        public Estudiante(String nombreEstudiante){
           this.nombre = nombreEstudiante;
           this.asistencia = false;
        }
//        creo funciones para interactuar con la clase interna
        public void marcarAsistencia(){
            this.asistencia = true;
        }
    }
    
    // Metodo para agregar estudiantes:
    public void agregarEstudiante(String nombreE){
        Estudiante nuevoEstudiante = new Estudiante(nombreE);
        listaEstudiantes.add(nuevoEstudiante);
    }
    public void MostarEstudiantes(){
        StringBuilder mensaje = new StringBuilder("=== LISTA DE ESTUDIANTES ===\n");
        // Recorrer la lista con un ciclo for
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            // Obtener cada estudiante y su nombre
            Estudiante indice = listaEstudiantes.get(i);
            mensaje.append((i+1) + ". " + indice.nombre + "\n");
        }
        
        // Muestra en una ventana emergente la lista estudiantes.
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
    
    // Lista para guardar todas las materias creadas
    private List<Materia> listaMaterias = new ArrayList<>();
    
    public class Materia{
        private String nombre;
        private List<Estudiante> listaEstudiantesMateria;
        // constructor
        public Materia(String nombreMateria, List<Estudiante> estudiantesGlobales) {
            this.nombre = nombreMateria;
//            cada materia tiene su propio array list
            this.listaEstudiantesMateria = new ArrayList<>();
//          RECORRO la lista global de estudiantes usando un ciclo for
            // El metodo size() devuelve la cantidad de elementos en la lista
            for (int i = 0; i < estudiantesGlobales.size(); i++) {
                // Obtengo cada estudiante usando el metodo get(indice)
                Estudiante estudianteActual = estudiantesGlobales.get(i);
                // Agrego el estudiante a la lista de esta materia usando add()
                this.listaEstudiantesMateria.add(estudianteActual);
            }
        }
            // Metodo que retorna el nombre de la materia
        public String getNombreMateria(){
            return nombre;
        }
        
        public List<Estudiante> getListaEstudiantesMateria(){
            return listaEstudiantesMateria;
        }
    }
     //Metodo para crear una nueva materia
    public  void agregarMateria(String nombre_materia){
        // Verifica si ya existe una materia con ese nombre
        for(int i = 0; i < listaMaterias.size(); i++){
            //condicional dnd trae el atributo nombre de cada uno de los objetos de la listaMaterias y compara caractes con la nueva materia que se va ha agregar.
            // El metodo getNombreMateria() obtiene el nombre de cada materia existente
            // equalsIgnoreCase() compara strings ignorando mayusculas/minusculas
            if(listaMaterias.get(i).getNombreMateria().equalsIgnoreCase(nombre_materia)){
                //dado caso hay simiitud es TRUE la condicional y entra dnd muestra el mensaje y sale
                JOptionPane.showMessageDialog(null, "Ya existe una materia con ese nombre");
                return;// Salgo del metodo si ya existe
            }
        }
        // Creo la nueva materia PASANDOLE la lista global de estudiantes
        Materia nuevaMateria = new Materia(nombre_materia,listaEstudiantes);
         // Agrego la nueva materia a la lista de materias usando add()
        listaMaterias.add(nuevaMateria);
        // mesaje para confirmar que se validaron todos las funciones 
        JOptionPane.showMessageDialog(null, "Materia " + nombre_materia + " creada exitosamente");
        // llamo al metodo para que actualice la JList y se muestre la nueva materia
        actualizarListaMaterias();
    }
    
    public void actualizarListaMaterias() {
    // Creo un arreglo de Strings con los nombres de las materias
    String[] nombresMaterias = new String[listaMaterias.size()];
    // Llena el arreglo con los nombres de cada materia
    for (int i = 0; i < listaMaterias.size(); i++) {
        nombresMaterias[i] = listaMaterias.get(i).getNombreMateria();
    }
    // Establecer los datos en el JList (usando metodo setListData de JList)
    list_materias.setListData(nombresMaterias);
}

    public void actualizarTablaEstudiantes(Materia materia){
        // Obtener el modelo de la tabla
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tbl_lista_estudiante_materia.getModel();
    
        // Limpiar la tabla (eliminar todas las filas)
         modelo.setRowCount(0);
    
        // Agregar cada estudiante de la materia a la tabla
        List<Estudiante> estudiantesMateria = materia.getListaEstudiantesMateria();
        for (int i = 0; i < estudiantesMateria.size(); i++) {
        Estudiante estudiante = estudiantesMateria.get(i);
        String asistenciaTexto = estudiante.asistencia ? "Presente" : "Ausente";
        // Agrega la fila con nombre y asistencia
        modelo.addRow(new Object[]{estudiante.nombre, asistenciaTexto});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_agregar_estudiante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_agregar_materia = new javax.swing.JButton();
        txt_materia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_materias = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_lista_estudiante_materia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Crear Estudiante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12))); // NOI18N

        btn_agregar_estudiante.setText("Agregar");
        btn_agregar_estudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_estudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btn_agregar_estudiante))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_agregar_estudiante)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar una Materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12))); // NOI18N

        btn_agregar_materia.setText("Agregar");
        btn_agregar_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_materiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_agregar_materia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar_materia)
                    .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecciona una Materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)); // NOI18N

        list_materias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_materias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_materiasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list_materias);

        tbl_lista_estudiante_materia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Estudiantes", "Asistencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_lista_estudiante_materia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btn_agregar_estudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_estudianteActionPerformed
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del nuevo estudiante: ");
        if (nombre != null  && !nombre.trim().isEmpty()) {
            agregarEstudiante(nombre);
        }
        MostarEstudiantes();
    }//GEN-LAST:event_btn_agregar_estudianteActionPerformed

    private void btn_agregar_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_materiaActionPerformed
        String nombre_materia = txt_materia.getText();
        if (nombre_materia != null && !nombre_materia.trim().isEmpty()) {
            agregarMateria(nombre_materia);
            txt_materia.setText(""); // Limpiar el campo de texto
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido para la materia");
        }
    }//GEN-LAST:event_btn_agregar_materiaActionPerformed

    private void list_materiasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_materiasValueChanged
        // getValueIsAdjusting() evita que el evento se ejecute multiples veces mientras se selecciona
        if (!evt.getValueIsAdjusting()) {
            // Obtengo la materia seleccionada usando getSelectedValue() de JList
            String materiaSeleccionada = list_materias.getSelectedValue();
            // Verifico que haya una materia seleccionada (no sea null)
            if (materiaSeleccionada != null) {
                // Busco la materia en listaMaterias usando ciclo for
                Materia materiaEncontrada = null;
                for (int i = 0; i < listaMaterias.size(); i++) {
                    // Comparo el nombre usando equals()
                    if (listaMaterias.get(i).getNombreMateria().equals(materiaSeleccionada)) {
                        materiaEncontrada = listaMaterias.get(i);
                        break; // Salgo del ciclo cuando encuentro la materia
                    }
                }

                // Si encontre la materia, actualizo la tabla
                if (materiaEncontrada != null) {
                    actualizarTablaEstudiantes(materiaEncontrada);
                }
            }
        }
    }//GEN-LAST:event_list_materiasValueChanged
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaSistemaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSistemaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSistemaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSistemaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSistemaAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_estudiante;
    private javax.swing.JButton btn_agregar_materia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_materias;
    private javax.swing.JTable tbl_lista_estudiante_materia;
    private javax.swing.JTextField txt_materia;
    // End of variables declaration//GEN-END:variables
}
