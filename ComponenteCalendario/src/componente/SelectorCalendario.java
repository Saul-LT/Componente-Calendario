/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

/**
 *
 * @author Mendoza Jimenez Melody Nathalie 
 * @author Lopez Trujillo Josue Saul
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class SelectorCalendario extends JDialog {

    //ATRIBUTOS-PROPIEDADES
    private JComboBox<String> comboMes;
    private JComboBox<Integer> comboAnio;
    private JPanel panelDias;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private boolean mostrarTituloVentana = true;
    private boolean mostrarTexto = false;
    private LocalDate fechaSeleccionada = null;

    private Color colorFondo = Color.WHITE;
    private Color colorBotonesDias = new Color(230, 230, 230);
    private Font fuente = new Font("Arial", Font.PLAIN, 12);
    private String textoVisible = "";

    public SelectorCalendario(Frame parent, boolean modal) {
        //TÍTULO GENERAL
        super(parent, modal);
        setSize(400, 400);
        setLayout(new BorderLayout());

        //FONDO GENERAL
        getContentPane().setBackground(colorFondo);

        // Mostrar texto visible si está habilitado
        if (mostrarTexto && textoVisible != null && !textoVisible.isEmpty()) {
            JLabel etiqueta = new JLabel(textoVisible, SwingConstants.CENTER);
            etiqueta.setFont(fuente);
            etiqueta.setForeground(Color.DARK_GRAY);
            etiqueta.setBackground(colorFondo);
            etiqueta.setOpaque(true);
            add(etiqueta, BorderLayout.BEFORE_FIRST_LINE);
        }

        //PANEL SUPERIOR:MES Y AÑO
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(colorFondo);
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        comboMes = new JComboBox<>(meses);
        comboAnio = new JComboBox<>();
        for (int i = 1950; i <= 2050; i++) {
            comboAnio.addItem(i);
        }

        comboMes.setSelectedIndex(LocalDate.now().getMonthValue() - 1);
        comboAnio.setSelectedItem(LocalDate.now().getYear());

        panelSuperior.add(comboMes);
        panelSuperior.add(comboAnio);
        add(panelSuperior, BorderLayout.NORTH);
        //PANEL CENTRAL:CALENDARIO
        panelDias = new JPanel(new GridLayout(7, 7));
        panelDias.setBackground(colorFondo);  //
        add(panelDias, BorderLayout.CENTER);
        //PANEL INFERIOR:BOTONES
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(colorFondo);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> dispose());
        btnCancelar.addActionListener(e -> {
            fechaSeleccionada = null;
            dispose();
        });

        panelInferior.add(btnCancelar);
        panelInferior.add(btnAceptar);
        add(panelInferior, BorderLayout.SOUTH);

        comboMes.addActionListener(e -> actualizarCalendario());
        comboAnio.addActionListener(e -> actualizarCalendario());

        actualizarCalendario();
    }

    public void actualizarCalendario() {
        panelDias.removeAll();
        panelDias.setLayout(new BorderLayout());
        // Panel superior solo para los nombres de los días
        JPanel encabezadoSemana = new JPanel(new GridLayout(1, 7));
        encabezadoSemana.setBackground(colorFondo);
        String[] diasSemana = {"L", "M", "x", "J", "V", "S", "D"};
        for (String dia : diasSemana) {
            JLabel label = new JLabel(dia, SwingConstants.CENTER);
            label.setForeground(Color.WHITE);
            label.setOpaque(true);
            label.setBackground(Color.BLUE);
            label.setFont(fuente);
            encabezadoSemana.add(label);
        }
        // Panel para los botones de días
        JPanel panelBotonesDias = new JPanel(new GridLayout(0, 7)); // filas automáticas, 7 columnas
        panelBotonesDias.setBackground(colorFondo);
        int mes = comboMes.getSelectedIndex() + 1;
        int anio = (int) comboAnio.getSelectedItem();
        YearMonth yearMonth = YearMonth.of(anio, mes);
        LocalDate primerDia = yearMonth.atDay(1);
        int diaSemana = primerDia.getDayOfWeek().getValue(); // 1 = Lunes, 7 = Domingo
        int espaciosIniciales = diaSemana - 1;
        for (int i = 0; i < espaciosIniciales; i++) {
            panelBotonesDias.add(new JLabel(""));
        }
        for (int dia = 1; dia <= yearMonth.lengthOfMonth(); dia++) {
            JButton botonDia = new JButton(String.valueOf(dia));
            botonDia.setOpaque(true);
            botonDia.setPreferredSize(new Dimension(50, 40));
            botonDia.setBackground(colorBotonesDias);      // Aplicar color de fondo
            botonDia.setFont(fuente);                // Aplicar fuente

            int d = dia;
            botonDia.addActionListener(e -> {
                fechaSeleccionada = LocalDate.of(anio, mes, d);
            });
            panelBotonesDias.add(botonDia);
        }

        // Agrega encabezado y botones al panel principal
        panelDias.add(encabezadoSemana, BorderLayout.NORTH);
        panelDias.add(panelBotonesDias, BorderLayout.CENTER);
        panelDias.revalidate();
        panelDias.repaint();
    }

    public void aplicarEstilosYRedibujar() {
        actualizarCalendario(); // vuelve a construir el panel con los nuevos valores
    }

    public LocalDate getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public void setColorFondo(Color color) {
        this.colorFondo = color;
        if (getContentPane() != null) {
            getContentPane().setBackground(colorFondo);
        }
        if (panelSuperior != null) {
            panelSuperior.setBackground(colorFondo);
        }
        if (panelDias != null) {
            panelDias.setBackground(colorFondo);
        }
        if (panelInferior != null) {
            panelInferior.setBackground(colorFondo);
        }

        // También actualiza los subpaneles que puedas tener (ejemplo encabezadoSemana, panelBotonesDias)
        // Si los tienes como campos, también actualízalos aquí
        repaint();
        revalidate();
    }

    public void setMostrarTituloVentana(boolean mostrar) {

    if (!mostrar) {
        // Quitar decoración (barra de título, ícono, X)
        setUndecorated(true);
    } else {
        // Restaurar decoración con título
        setUndecorated(false);
        setTitle("Seleccionar Fecha");
    }
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }

    public void setMostrarTexto(boolean mostrar) {
        this.mostrarTexto = mostrar;
    }

    public void setTextoVisible(String texto) {
        this.textoVisible = texto;
    }

    public void setColorBotonesDias(Color color) {
        this.colorBotonesDias = color;
        actualizarCalendario();
    }
}
