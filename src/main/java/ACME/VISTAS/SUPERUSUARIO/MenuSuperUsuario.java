package ACME.VISTAS.SUPERUSUARIO;

import ACME.VISTAS.FUNCIONARIO.GestionInvitado;
import ACME.VISTAS.Login;
import ACME.VISTAS.SUPERVISOR.ReportesSupervisor;

import javax.swing.*;
import java.awt.*;

public class MenuSuperUsuario extends JFrame {
    private JButton btnReportes;
    private JButton btnAgregarSupervisor;
    private JButton btnModificarSupervisor;
    private JButton btnConexionDB;
    private JButton btnCerrarSesion;

    public MenuSuperUsuario() {
        setTitle("Menú SuperUsuario - Sistema de Gestión");
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
                Color color1 = new Color(66, 139, 202);
                Color color2 = new Color(127, 179, 213);
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
        JLabel lblTitulo = new JLabel("Sistema de Gestión", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitulo, gbc);

        // Botones principales
        btnReportes = createStyledButton("Reportes");
        btnAgregarSupervisor = createStyledButton("Agregar Supervisor");
        btnModificarSupervisor = createStyledButton("Modificar Supervisor");
        btnConexionDB = createStyledButton("Conexión DB");
        btnCerrarSesion = createStyledButton("Cerrar Sesión");

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        mainPanel.add(btnReportes, gbc);

        gbc.gridy = 2;
        mainPanel.add(btnAgregarSupervisor, gbc);

        gbc.gridy = 3;
        mainPanel.add(btnModificarSupervisor, gbc);

        gbc.gridy = 4;
        mainPanel.add(btnConexionDB, gbc);

        gbc.gridy = 5;
        mainPanel.add(btnCerrarSesion, gbc);

        add(mainPanel);

        // Acciones de los botones
        btnReportes.addActionListener(e -> {
            ReportesSuperUsuario reportes = new ReportesSuperUsuario();
            reportes.setVisible(true);
            dispose();
        });

        btnAgregarSupervisor.addActionListener(e -> {
            GestionSupervisor supervisores = new GestionSupervisor();
            supervisores.setVisible(true);
            dispose();
        });


        btnConexionDB.addActionListener(e -> {
            BasesDatosForm basesDatos = new BasesDatosForm();
            basesDatos.setVisible(true);
            dispose();
        });

        btnCerrarSesion.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro que desea cerrar sesión?",
                    "Confirmar Cierre de Sesión",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(250, 40));
        button.setBackground(new Color(40, 167, 69));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

    public static void main(String[] args) {
        MenuSuperUsuario msu = new MenuSuperUsuario();

        msu.setVisible(true);
    }
}

