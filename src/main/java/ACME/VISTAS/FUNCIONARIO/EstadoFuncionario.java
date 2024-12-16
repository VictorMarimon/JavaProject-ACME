/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACME.VISTAS.FUNCIONARIO;

import ACME.CONTROLADOR.ControladorEstadoPersona;
import ACME.CONTROLADOR.ControladorPersona;
import ACME.CONTROLADOR.ControladorReportePersona;
import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_Persona;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.REPORTE_PERSONA.Reporte_Persona;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EstadoFuncionario extends JFrame {
    private JTextField txtIdentificacionUsuario;
    private JTextField txtIdentificacionSupervisor;
    private JComboBox<String> cbEstado;
    private JButton btnConsultarUsuario;
    private JButton btnConsultarSupervisor;
    private JButton btnCancelar;
    private JButton btnModificar;

    public EstadoFuncionario() {
        setTitle("Estado - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Panel principal con degradado
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(52, 152, 219);
                Color color2 = new Color(41, 128, 185);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("ESTADO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitulo, gbc);

        // Campos y etiquetas
        gbc.gridwidth = 1;

        JLabel lblIdentificacionUsuario = new JLabel("Identificación Usuario:");
        lblIdentificacionUsuario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblIdentificacionUsuario, gbc);

        txtIdentificacionUsuario = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(txtIdentificacionUsuario, gbc);

        btnConsultarUsuario = createStyledButton("Consultar");
        gbc.gridx = 2;
        mainPanel.add(btnConsultarUsuario, gbc);

        JLabel lblIdentificacionSupervisor = new JLabel("Identificación Supervisor:");
        lblIdentificacionSupervisor.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblIdentificacionSupervisor, gbc);

        txtIdentificacionSupervisor = new JTextField(15);
        gbc.gridx = 1;
        mainPanel.add(txtIdentificacionSupervisor, gbc);

        btnConsultarSupervisor = createStyledButton("Consultar");
        gbc.gridx = 2;
        mainPanel.add(btnConsultarSupervisor, gbc);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblEstado, gbc);

        cbEstado = new JComboBox<>();

        ControladorEstadoPersona cep = new ControladorEstadoPersona();

        List<String> estados = cep.listado();

        for (String estado : estados){
            cbEstado.addItem(estado);
        }
        gbc.gridx = 1;
        mainPanel.add(cbEstado, gbc);

        // Botones
        btnCancelar = createStyledButton("Cancelar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(btnCancelar, gbc);

        btnModificar = createStyledButton("Modificar");
        gbc.gridx = 2;
        mainPanel.add(btnModificar, gbc);

        add(mainPanel);

        // Acciones de los botones
        btnCancelar.addActionListener(e -> {
            MenuFuncionario mf = new MenuFuncionario();
            mf.setVisible(true);
            dispose();});

        btnModificar.addActionListener(e -> {

            ControladorPersona cp = new ControladorPersona();
            ControladorReportePersona crp = new ControladorReportePersona();

            Persona usuario = new Persona();
            Persona supervisor = new Persona();
            Estado_Persona estadoPersona = new Estado_Persona();
            Reporte_Persona reporte = new Reporte_Persona();


            usuario.setCedula(Integer.parseInt(txtIdentificacionUsuario.getText()));
            supervisor.setCedula(Integer.parseInt(txtIdentificacionSupervisor.getText()));
            estadoPersona.setEstado_per((String) cbEstado.getSelectedItem());
            reporte.setFecha("2024-10-10");
            reporte.setDescripcion("Se realizo la modificación del estado");

            if (cp.modificarEstadoPersona(usuario, estadoPersona) && crp.reportarPersona(reporte, usuario, supervisor)){
                JOptionPane.showMessageDialog(this, "Modificación realizada exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

                txtIdentificacionUsuario.setText("");
                txtIdentificacionSupervisor.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Las identificaciones no existen", "No reportado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 30));
        button.setBackground(new Color(46, 204, 113));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstadoFuncionario().setVisible(true));
    }
}

