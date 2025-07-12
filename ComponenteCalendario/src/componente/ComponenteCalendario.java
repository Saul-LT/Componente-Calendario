/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

/**
 *
 * @author Mendoza Jimenez Melody Nathalie 
 * @author Lopez Trujillo Josue Saul
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.border.Border;

public class ComponenteCalendario extends JButton {

    private LocalDate fechaSeleccionada;
    private String textoVisible = "";
    private boolean mostrarTexto = true;
    private Color colorFondo = Color.WHITE;
    private Color colorFondoCalendario = Color.WHITE;
    private Color colorBotonesDias = new Color(230, 230, 230);
    private Font fuente = new Font("Arial", Font.PLAIN, 12);
    private Border borde;
    private boolean mostrarTituloVentana = true;
    private ActionListener listenerFechaSeleccionada;

    public ComponenteCalendario() {
        super();
        ImageIcon iconoCalendario = new ImageIcon(getClass().getResource("dias-del-calendario.png"));
        this.setIcon(iconoCalendario);
        this.setToolTipText("Seleccionar fecha");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCalendario();
            }
        });
    }

    private void mostrarCalendario() {
        SelectorCalendario selector = new SelectorCalendario(null, true);

        // Pasa las propiedades
        selector.setMostrarTituloVentana(this.mostrarTituloVentana);
        selector.setColorFondo(this.colorFondoCalendario);
        selector.setColorBotonesDias(this.colorBotonesDias);
        selector.setFuente(this.fuente);
        selector.setMostrarTexto(this.mostrarTexto);
        selector.setTextoVisible(this.textoVisible);
        
        selector.actualizarCalendario();
        selector.aplicarEstilosYRedibujar();

        Point puntoBoton = this.getLocationOnScreen();
        selector.setLocation(puntoBoton.x + this.getWidth(), puntoBoton.y);
        selector.setVisible(true);

        if (selector.getFechaSeleccionada() != null) {
            this.fechaSeleccionada = selector.getFechaSeleccionada();

            if (listenerFechaSeleccionada != null) {
                ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "fechaSeleccionada");
                listenerFechaSeleccionada.actionPerformed(evt);
            }
        }
    }

    // ==== Getters y Setters ====
    public void setOnFechaSeleccionada(ActionListener listener) {
        this.listenerFechaSeleccionada = listener;
    }
    public void setMostrarTituloVentana(boolean mostrar) {
        this.mostrarTituloVentana = mostrar;
    }

    public LocalDate getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public void setFechaSeleccionada(LocalDate fecha) {
        this.fechaSeleccionada = fecha;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public void setTextoVisible(String texto) {
        this.textoVisible = texto;
        if (mostrarTexto) {
            setText(texto);
        }
    }

    public boolean isMostrarTexto() {
        return mostrarTexto;
    }

    public void setMostrarTexto(boolean mostrar) {
        this.mostrarTexto = mostrar;
        setText(mostrar ? textoVisible : "");
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
        setBackground(colorFondo);
    }

    public Color getColorFondoCalendario() {
        return colorFondoCalendario;
    }

    public void setColorFondoCalendario(Color color) {
        this.colorFondoCalendario = color;
    }

    public Color getColorBotonesDias() {
        return colorBotonesDias;
    }

    public void setColorBotonesDias(Color color) {
        this.colorBotonesDias = color;
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
        setFont(fuente);
    }

    public Border getBorde() {
        return borde;
    }

    public void setBorde(Border borde) {
        this.borde = borde;
        setBorder(borde);
    }

}
