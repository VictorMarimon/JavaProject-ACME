package ACME.VISTAS.GUARDA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuGuarda extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel menuPanel;

    public MenuGuarda() {
        setTitle("Sistema de Guarda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Inicializar el CardLayout para la navegación entre pantallas
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear e inicializar todas las pantallas
        initComponents();

        // Añadir el panel principal al frame
        add(mainPanel);
    }

    private void initComponents() {
        // Panel del menú principal con degradado
        menuPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(66, 139, 202);
                Color color2 = new Color(219, 238, 244);
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };

        // Panel de botones del menú
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título
        JLabel titulo = new JLabel("MENÚ PRINCIPAL");
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 40, 0);
        buttonPanel.add(titulo, gbc);

        // Botones del menú
        String[] opciones = {"Reportes", "Informes", "Citas", "Inventario"};
        for (int i = 0; i < opciones.length; i++) {
            JButton boton = createMenuButton(opciones[i]);
            gbc.gridx = i % 2;
            gbc.gridy = (i / 2) + 1;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(10, 20, 10, 20);
            buttonPanel.add(boton, gbc);
        }

        menuPanel.add(buttonPanel, BorderLayout.CENTER);

        // Añadir todas las pantallas al mainPanel
        mainPanel.add(menuPanel, "Menu");

        // Mostrar el menú principal inicialmente
        cardLayout.show(mainPanel, "Menu");
    }

    private JButton createMenuButton(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(200, 80));
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(66, 139, 202));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createRaisedBevelBorder());

        boton.addActionListener(e -> cardLayout.show(mainPanel, texto));

        return boton;
    }

    public void navegarA(String pantalla) {
        cardLayout.show(mainPanel, pantalla);
    }

    public static void main(String[] args) {
        MenuGuarda mg = new MenuGuarda();

        mg.setVisible(true);
    }
}
