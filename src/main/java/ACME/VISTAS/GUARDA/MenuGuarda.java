package ACME.VISTAS.GUARDA;

import ACME.VISTAS.FUNCIONARIO.GestionInvitado;
import ACME.VISTAS.FUNCIONARIO.GestionTrabajador;
import ACME.VISTAS.Login;

import javax.swing.*;

public class MenuGuarda extends JFrame {
    private JButton btnGestionarSalida, btnGestionarEntrada, btnReportes,
            btnGestionarVehiculo, btnCerrarSesion, btnReportarUsuario;

    public MenuGuarda() {
        setTitle("Menú Principal");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnGestionarSalida = new JButton("GESTIONAR SALIDA");
        btnGestionarSalida.setBounds(50, 50, 200, 40);
        add(btnGestionarSalida);

        btnGestionarEntrada = new JButton("GESTIONAR ENTRADA");
        btnGestionarEntrada.setBounds(50, 120, 200, 40);
        add(btnGestionarEntrada);

        btnReportes = new JButton("REPORTES");
        btnReportes.setBounds(350, 50, 200, 40);
        add(btnReportes);

        btnGestionarVehiculo = new JButton("GESTIONAR VEHICULO");
        btnGestionarVehiculo.setBounds(350, 120, 200, 40);
        add(btnGestionarVehiculo);

        btnReportarUsuario = new JButton("REPORTAR USUARIO");
        btnReportarUsuario.setBounds(50, 190, 200, 40);
        add(btnReportarUsuario);

        btnCerrarSesion = new JButton("cerrar sesión");
        btnCerrarSesion.setBounds(50, 280, 120, 30);
        add(btnCerrarSesion);

        btnGestionarEntrada.addActionListener(e->{
            GestionEntrada gi = new GestionEntrada();
            gi.setVisible(true);
            dispose();
        });

        btnReportes.addActionListener(e -> {
            ReportesGuarda rg = new ReportesGuarda();
            rg.setVisible(true);
            dispose();
        });

        btnGestionarVehiculo.addActionListener(e -> {
            GestionVehiculoGuarda gv = new GestionVehiculoGuarda();
            gv.setVisible(true);
            dispose();
        });

        btnReportarUsuario.addActionListener(e->{
            ReporteGuarda rg =new ReporteGuarda();
            rg.setVisible(true);
            dispose();
        });

        btnCerrarSesion.addActionListener(e-> {
            Login login = new Login();

            login.setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        MenuGuarda mg = new MenuGuarda();

        mg.setVisible(true);
    }
}