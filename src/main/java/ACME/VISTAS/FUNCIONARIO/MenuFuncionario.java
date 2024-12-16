package ACME.VISTAS.FUNCIONARIO;

import ACME.VISTAS.Login;

import javax.swing.*;

public class MenuFuncionario extends JFrame {

    private JButton btnGestionarTrabajador, btnGestionarInvitado, btnEstadoTrabajadorInvitado, btnReportes,
            btnGestionarVehiculo, btnCerrarSesion;

    public MenuFuncionario() {
        setTitle("Menú Principal");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnGestionarTrabajador = new JButton("GESTIONAR TRABAJADOR");
        btnGestionarTrabajador.setBounds(50, 50, 200, 40);
        add(btnGestionarTrabajador);

        btnGestionarInvitado = new JButton("GESTIONAR INVITADO");
        btnGestionarInvitado.setBounds(50, 120, 200, 40);
        add(btnGestionarInvitado);

        btnEstadoTrabajadorInvitado = new JButton("ESTADO TRABAJADOR / INVITADO");
        btnEstadoTrabajadorInvitado.setBounds(50, 190, 200, 40);
        add(btnEstadoTrabajadorInvitado);

        btnReportes = new JButton("REPORTES");
        btnReportes.setBounds(350, 50, 200, 40);
        add(btnReportes);

        btnGestionarVehiculo = new JButton("GESTIONAR VEHICULO");
        btnGestionarVehiculo.setBounds(350, 120, 200, 40);
        add(btnGestionarVehiculo);

        btnCerrarSesion = new JButton("cerrar sesión");
        btnCerrarSesion.setBounds(50, 280, 120, 30);
        add(btnCerrarSesion);

        btnEstadoTrabajadorInvitado.addActionListener(e->{
            EstadoFuncionario ef = new EstadoFuncionario();
            ef.setVisible(true);
            dispose();
        });

        btnGestionarTrabajador.addActionListener(e -> {
            GestionTrabajador gt = new GestionTrabajador();
            gt.setVisible(true);
            dispose();
        });

        btnGestionarInvitado.addActionListener(e->{
            GestionInvitado gi = new GestionInvitado();
            gi.setVisible(true);
            dispose();
        });

        btnGestionarVehiculo.addActionListener(e -> {
            GestionVehiculoFuncionario gv = new GestionVehiculoFuncionario();
            gv.setVisible(true);
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
        MenuFuncionario mf = new MenuFuncionario();
        mf.setVisible(true);
    }
}
