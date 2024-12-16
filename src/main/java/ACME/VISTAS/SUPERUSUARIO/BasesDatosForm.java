package ACME.VISTAS.SUPERUSUARIO;

import ACME.VISTAS.SUPERVISOR.ReportesSupervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasesDatosForm extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnConectar;
    private JButton btnCancelar;

    public BasesDatosForm() {
        setTitle("Conexión a Base de Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(230, 230, 230));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo de Usuario
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Usuario:"), gbc);
        txtUsuario = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(txtUsuario, gbc);

        // Etiqueta y campo de Contraseña
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("Contraseña:"), gbc);
        txtPassword = new JPasswordField(20);
        gbc.gridx = 1;
        mainPanel.add(txtPassword, gbc);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        btnConectar = new JButton("Conectar");
        btnCancelar = new JButton("Cancelar");

        buttonPanel.add(btnConectar);
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        // Configurar acciones de botones
        btnConectar.addActionListener(e -> conectarBaseDatos());
        btnCancelar.addActionListener(e -> {
            MenuSuperUsuario menuPrincipal = new MenuSuperUsuario();
            menuPrincipal.setVisible(true);
            dispose();
        });
    }

    private void conectarBaseDatos() {
        String usuario = txtUsuario.getText().trim();
        String contrasena = new String(txtPassword.getPassword()).trim();

        // Validar que todos los campos estén llenos
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, complete todos los campos antes de intentar conectar.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Simulación de prueba de conexión
        boolean conexionExitosa = Math.random() < 0.5; // Simulación aleatoria

        mostrarResultadoConexion(conexionExitosa);
    }

    private void mostrarResultadoConexion(boolean exitosa) {
        String mensaje = exitosa ? "Conexión exitosa a la base de datos." : "Error al conectar con la base de datos.";
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Resultado de Conexión",
                exitosa ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
        );

        if (exitosa) {
            // Aquí puedes redirigir al usuario a otra ventana si la conexión es exitosa
            MenuSuperUsuario menuPrincipal = new MenuSuperUsuario();
            menuPrincipal.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
            BasesDatosForm form = new BasesDatosForm();
            form.setVisible(true);
    }
}
