package vista;

import modelo.cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AplicacionSwing extends JFrame {

    private ArrayList<cliente> clientes;

    private int posicionActual = 0;

    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;

    private JButton anteriorButton;
    private JButton siguienteButton;

    public AplicacionSwing() {

        super("Gestión de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientes = new ArrayList<cliente>();
        cargarClientes();
        crearComponentes();
        mostrarCliente();
        actualizarBotones();
    }

    private void cargarClientes() {

        clientes.add(new cliente(1,"Ana García",25,1250.50));

        clientes.add(new cliente(2,"Carlos López",32,875.75));

        clientes.add(new cliente(3, "María Fernández",41,2300.00));
    }

    private void crearComponentes() {

        numeroLabel = new JLabel("Número: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");
        puntosLabel = new JLabel("Puntos: ");

        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        nombreField = new JTextField(10);
        nombreField.setEditable(false);

        edadField = new JTextField(10);
        edadField.setEditable(false);

        puntosField = new JTextField(10);
        puntosField.setEditable(false);

        JPanel labelPane = new JPanel();

        labelPane.setLayout(
                new GridLayout(0, 1, 5, 5)
        );

        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);

        JPanel fieldPane = new JPanel();

        fieldPane.setLayout(new GridLayout(0, 1, 5, 5));

        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);

        JPanel datosPane = new JPanel();

        datosPane.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));

        datosPane.setLayout(new BorderLayout(10, 10));

        datosPane.add(labelPane,BorderLayout.WEST);

        datosPane.add(fieldPane,BorderLayout.CENTER);

        anteriorButton = new JButton("Anterior");

        siguienteButton = new JButton("Siguiente");

        anteriorButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        if (posicionActual > 0) {
                            posicionActual--;
                            mostrarCliente();
                            actualizarBotones();
                        }
                    }
                }
        );

        siguienteButton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        if (posicionActual <
                                clientes.size() - 1) {
                                    posicionActual++;
                                    mostrarCliente();
                                    actualizarBotones();
                                }
                    }
                }
        );

        JPanel buttonPane = new JPanel();

        buttonPane.setLayout(
                new FlowLayout(FlowLayout.CENTER,20,10));

        buttonPane.add(anteriorButton);
        buttonPane.add(siguienteButton);

        JPanel contentPane = new JPanel();

        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        contentPane.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("GESTIÓN DE CLIENTES",JLabel.CENTER);

        contentPane.add(titulo,BorderLayout.NORTH);

        contentPane.add(datosPane,BorderLayout.CENTER);

        contentPane.add( buttonPane,BorderLayout.SOUTH);

        setContentPane(contentPane);
    }

    private void mostrarCliente() {

        cliente cliente =
                clientes.get(posicionActual);

        numeroField.setText(
                String.valueOf(
                        cliente.getNumero()
                )
        );

        nombreField.setText(
                cliente.getNombre()
        );

        edadField.setText(
                String.valueOf(
                        cliente.getEdad()
                )
        );

        puntosField.setText(
                String.valueOf(
                        cliente.getPuntos()
                )
        );
    }


    private void actualizarBotones() {

        if (posicionActual == 0) {

            anteriorButton.setEnabled(false);

        } else {

            anteriorButton.setEnabled(true);
        }

        if (posicionActual ==
                clientes.size() - 1) {

            siguienteButton.setEnabled(false);

        } else {

            siguienteButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {

                        AplicacionSwing app =
                                new AplicacionSwing();

                        app.pack();

                        app.setLocationRelativeTo(null);

                        app.setVisible(true);
                    }
                }
        );
    }
}