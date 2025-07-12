# Componente Calendario Personalizado en Java 

Este proyecto presenta un **componente personalizado de calendario en Java** utilizando Swing. El componente se integra como un botón con ícono, que al presionarse despliega un calendario personalizable para la selección de una fecha. Se puede reutilizar fácilmente en interfaces gráficas y proyectos Java Desktop.

---

## Vista del Componente Calendario

### Vista del botón calendario desplegado:
<img width="757" height="628" alt="Captura de pantalla 2025-07-12 001958" src="https://github.com/user-attachments/assets/75b23c38-021e-4a00-8398-f10809de795c" />


### Personalización del calendario :

<img width="507" height="508" alt="Captura de pantalla 2025-07-12 002018" src="https://github.com/user-attachments/assets/2d285afb-37b0-48f9-bb2d-d9237d5bdb47" />

---

## 🧩 Breve Explicación del Componente

El componente `ComponenteCalendario` es una extensión de `JButton` que, al hacer clic, despliega una ventana con un calendario interactivo. Está diseñado para ser reutilizable, altamente personalizable y fácil de integrar en cualquier JFrame.

### Características destacadas:
- Personalización de fuente, colores y texto.
- Icono de calendario en el botón.
- Posicionamiento dinámico del calendario.
- Notificación mediante listener al seleccionar una fecha.
- Visualmente amigable y profesional.

---

## 🔧 Instrucciones de Uso

### 1. **Agregar el componente al JFrame:**
Desde el diseñador de NetBeans (paleta de componentes), añade el `ComponenteCalendario` a tu formulario.

### 2. **Ejemplo de configuración mínima (desde código):**
```java
componenteCalendario1.setOnFechaSeleccionada(e -> {
    if (componenteCalendario1.getFechaSeleccionada() != null) {
        String fechaTexto = componenteCalendario1.getFechaSeleccionada().format(
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
        lblFechaSeleccionada.setText("Fecha seleccionada: " + fechaTexto);
    }
});
```

### 3. **Personalización opcional:**
```java
componenteCalendario1.setTextoVisible("Selecciona tu cita");
componenteCalendario1.setMostrarTexto(true);
componenteCalendario1.setColorFondo(new Color(240, 248, 255));
componenteCalendario1.setColorFondoCalendario(new Color(102, 51, 153));
componenteCalendario1.setColorBotonesDias(new Color(216, 191, 216));
componenteCalendario1.setFuente(new Font("Comic Sans MS", Font.BOLD, 14));
componenteCalendario1.setMostrarTituloVentana(false);
```

---

## 🔎 Métodos y Propiedades Relevantes

| Método / Propiedad | Descripción |
|--------------------|-------------|
| `setTextoVisible(String texto)` | Define el texto que se muestra en el botón. |
| `setMostrarTexto(boolean mostrar)` | Activa o desactiva el texto visible. |
| `setColorFondo(Color color)` | Cambia el color de fondo del botón. |
| `setColorFondoCalendario(Color color)` | Define el fondo del calendario desplegado. |
| `setColorBotonesDias(Color color)` | Personaliza los botones de días. |
| `setFuente(Font fuente)` | Cambia la fuente del calendario. |
| `setOnFechaSeleccionada(ActionListener listener)` | Registra una acción al seleccionar una fecha. |
| `getFechaSeleccionada()` | Obtiene la fecha seleccionada como `LocalDate`. |

---

## 🎬 Video de demostración




---

## 👩‍💻 Créditos del Equipo

- **Melody Nathalie Mendoza Jiménez**  
- **Josue Saúl López Trujillo**  


