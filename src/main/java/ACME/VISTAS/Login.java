package ACME.VISTAS;

import ACME.MODELO.CREDENCIALES.GESTION.Funcionario;
import ACME.MODELO.CREDENCIALES.GESTION.GestorCredenciales;
import ACME.MODELO.CREDENCIALES.GESTION.Guarda;
import ACME.MODELO.CREDENCIALES.GESTION.Supervisor;
import ACME.VISTAS.FUNCIONARIO.MenuFuncionario;
import ACME.VISTAS.GUARDA.MenuGuarda;
import ACME.VISTAS.SUPERUSUARIO.MenuSuperUsuario;
import ACME.VISTAS.SUPERVISOR.MenuSupervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public Login() {
        setTitle("Sistema de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
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
                Color color1 = new Color(66, 139, 202);
                Color color2 = new Color(127, 179, 213);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        // Configuración del panel de login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Icono de usuario
        JLabel iconLabel = new JLabel(new ImageIcon("path/to/user-icon.png")); // Añade tu propio ícono
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(iconLabel, gbc);

        // Campos de usuario y contraseña
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        loginPanel.add(txtUsuario, gbc);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(lblPassword, gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        loginPanel.add(txtPassword, gbc);

        // Botón de ingreso
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(new Color(0, 167, 0));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(btnIngresar, gbc);

        mainPanel.add(loginPanel);
        add(mainPanel);

        // Acción del botón ingresar
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());

                String archivoSupervisor = "supervisores.txt";
                String archivoFuncionario = "funcionarios.txt";
                String archivoGuarda = "guardas.txt";

                GestorCredenciales<Supervisor> supervisorGestor = new GestorCredenciales<>(archivoSupervisor, Supervisor::fromString);
                GestorCredenciales<Funcionario> funcionarioGestor = new GestorCredenciales<>(archivoFuncionario, Funcionario::fromString);
                GestorCredenciales<Guarda> guardaGestor = new GestorCredenciales<>(archivoGuarda, Guarda::fromString);

                try{
                    boolean validacionSupervisor = supervisorGestor.verificarCredencial(usuario, password);
                    boolean validacionFuncionario = funcionarioGestor.verificarCredencial(usuario, password);
                    boolean validacionGuarda = guardaGestor.verificarCredencial(usuario, password);

                    if(validacionSupervisor){
                        MenuSupervisor menuSupervisor = new MenuSupervisor();
                        menuSupervisor.setVisible(true);
                    } else if (validacionFuncionario) {
                        MenuFuncionario menuFuncionario = new MenuFuncionario();
                        menuFuncionario.setVisible(true);
                    } else if (validacionGuarda) {
                        MenuGuarda mg = new MenuGuarda();
                        mg.setVisible(true);
                    } else if (usuario.equals("admin") && password.equals("admin")) {
                        MenuSuperUsuario menuSuperUsuario = new MenuSuperUsuario();
                        menuSuperUsuario.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(Login.this,
                                "Usuario o contraseña incorrectos",
                                "Error de autenticación",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    System.out.println("Hubo un error al verificar credenciales " + ex.getMessage());
                }
            }
        });
    }
}
