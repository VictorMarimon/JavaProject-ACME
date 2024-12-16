package ACME.VISTAS.GUARDA;

import ACME.CONTROLADOR.*;
import ACME.MODELO.DAO.ACCESO.Acceso;
import ACME.MODELO.DAO.ESTADO.Estado;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.PERSONA_ACCESO.Persona_Acceso;
import ACME.MODELO.DAO.REGISTRO_ACCESO.Registro_Acceso;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.TIPO_ACCESO.Tipo_Acceso;
import ACME.MODELO.DAO.VEHICULO.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GestionEntrada extends JFrame {

    public GestionEntrada() {
        setTitle("Ingreso");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("INGRESO", SwingConstants.CENTER);
        titleLabel.setBounds(150, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        JLabel tipoLabel = new JLabel("Tipo");
        tipoLabel.setBounds(30, 80, 50, 20);
        add(tipoLabel);

        JComboBox<String> tipoComboBox= new JComboBox<>();

        ControladorEstadoAcceso cee = new ControladorEstadoAcceso();

        List<String> estados = cee.listado();

        for (String estado : estados){
            tipoComboBox.addItem(estado);
        }

        tipoComboBox.setBounds(80, 80, 100, 20);
        add(tipoComboBox);

        JLabel idLabel = new JLabel("Identificación");
        idLabel.setBounds(200, 80, 100, 20);
        add(idLabel);

        JTextField idTextField = new JTextField();
        idTextField.setBounds(300, 80, 100, 20);
        add(idTextField);

        JButton consultarIdButton = new JButton("consultar");
        consultarIdButton.setBounds(410, 80, 100, 20);
        add(consultarIdButton);

        JLabel placaLabel = new JLabel("Placa");
        placaLabel.setBounds(30, 120, 50, 20);
        add(placaLabel);

        JTextField placaTextField = new JTextField();
        placaTextField.setBounds(80, 120, 100, 20);
        add(placaTextField);

        JButton consultarPlacaButton = new JButton("consultar");
        consultarPlacaButton.setBounds(190, 120, 100, 20);
        add(consultarPlacaButton);

        JLabel motivoLabel = new JLabel("Motivo");
        motivoLabel.setBounds(30, 160, 50, 20);
        add(motivoLabel);

        JTextField motivoTextField = new JTextField();
        motivoTextField.setBounds(80, 160, 150, 20);
        add(motivoTextField);

        JLabel comentariosLabel = new JLabel("Comentarios");
        comentariosLabel.setBounds(30, 200, 100, 20);
        add(comentariosLabel);

        JTextArea comentariosTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(comentariosTextArea);
        scrollPane.setBounds(30, 230, 400, 100);
        add(scrollPane);

        JButton cancelarButton = new JButton("cancelar");
        cancelarButton.setBounds(30, 340, 100, 20);
        add(cancelarButton);

        JButton ingresarButton = new JButton("ingresar");
        ingresarButton.setBounds(450, 340, 100, 20);
        add(ingresarButton);

        cancelarButton.addActionListener(e->{
            MenuGuarda mg = new MenuGuarda();
            mg.setVisible(true);
            dispose();
        });

        ingresarButton.addActionListener(e->{
            ControladorPersonaAcceso cpa = new ControladorPersonaAcceso();
            ControladorRegistroAcceso cra = new ControladorRegistroAcceso();
            ControladorAcceso ca = new ControladorAcceso();

            Persona_Acceso pa = new Persona_Acceso();
            Persona guarda = new Persona();
            Persona per = new Persona();
            Acceso a = new Acceso();
            Vehiculo v = new Vehiculo();
            Registro_Acceso ra = new Registro_Acceso();
            Tipo_Acceso t = new Tipo_Acceso();
            Estado ea = new Estado();

            pa.setFecha("2024-12-12");

            guarda.setCedula(98);
            per.setCedula(Integer.parseInt(idTextField.getText()));

            a.setMotivo(motivoTextField.getText());
            a.setComentarios(comentariosTextArea.getText());

            v.setPlaca(placaTextField.getText());

            ra.setHora_entrada("");

            t.setTipo("Acceso general");

            ea.setEstado((String) tipoComboBox.getSelectedItem());

            if (placaTextField.getText().isEmpty()){
                v.setPlaca("23");
                if (ca.nuevoAcceso(a, t, ea)){
                    if (cpa.nuevoAcceso(pa, guarda, per, a, v) && cra.nuevoAcceso(ra, a)){
                        JOptionPane.showMessageDialog(this, "Acceso registra.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

                        idTextField.setText("");
                        placaTextField.setText("");
                        motivoTextField.setText("");
                        comentariosTextArea.setText("");
                    }else{
                        JOptionPane.showMessageDialog(this, "Las identificaciones no existen", "No reportado", JOptionPane.INFORMATION_MESSAGE);
                    }
                }  else {
                    JOptionPane.showMessageDialog(this, "El acceso fue denegado", "No reportado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    // Método main
    public static void main(String[] args) {
        new GestionEntrada();
    }
}
