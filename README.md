# Componente Calendario Personalizado en Java 

Este proyecto presenta un **componente personalizado de calendario en Java** utilizando Swing. El componente se integra como un botón con ícono, que al presionarse despliega un calendario personalizable para la selección de una fecha. Se puede reutilizar fácilmente en interfaces gráficas y proyectos Java Desktop.

---
## EQUIPO 11

## Vista del Componente Calendario

### Vista del botón calendario desplegado:
<img width="757" height="628" alt="Captura de pantalla 2025-07-12 001958" src="https://github.com/user-attachments/assets/75b23c38-021e-4a00-8398-f10809de795c" />


### Personalización del calendario :

<img width="507" height="508" alt="Captura de pantalla 2025-07-12 002018" src="https://github.com/user-attachments/assets/2d285afb-37b0-48f9-bb2d-d9237d5bdb47" />

### Fecha seleccionada mostrada en el JLabel:
<img width="770" height="642" alt="image" src="https://github.com/user-attachments/assets/36679859-f729-414f-b546-2c74c67375f1" />
<img width="511" height="421" alt="image" src="https://github.com/user-attachments/assets/6fec43ae-ba23-4da0-a246-ec6c4d9b244f" />



---

## Explicación del Componente

El componente `ComponenteCalendario` es una clase que extiende `JButton`, diseñado para proporcionar una manera elegante y eficiente de permitir a los usuarios seleccionar una fecha desde una interfaz gráfica.

Cuando el botón es presionado, despliega un diálogo de calendario (`SelectorCalendario`) que permite seleccionar visualmente una fecha. El diseño modular permite reutilizar este componente en múltiples interfaces sin duplicar código ni complejidad. Además, puede configurarse visualmente desde el diseñador de NetBeans o mediante código.

### ¿Por qué es útil este componente?
- ✅ Mejora la experiencia de usuario al evitar ingreso manual de fechas.
- ✅ Permite una alta personalización visual (colores, fuente, texto).
- ✅ Fácil de integrar a cualquier `JFrame` existente.
- ✅ Soporta eventos mediante `ActionListener` para reaccionar a la selección de fecha.
- ✅ Ideal para proyectos escolares, formularios, sistemas de citas, etc.

### ¿Qué hace internamente?
- Usa un `JDialog` modal que se posiciona al lado del botón.
- Transfiere estilos desde el botón al calendario para mantener coherencia visual.
- Usa `LocalDate` para trabajar con fechas modernas y seguras.
- Llama a un `listener` externo cuando se selecciona una fecha.

---

## Instrucciones de Uso

### 1. **Agregar el componente al JFrame (desde la paleta de NetBeans):**
Para usar tu componente desde la paleta de NetBeans:

1. Haz clic derecho sobre la **paleta de componentes** → `Palette Manager`.
2. Selecciona `Add from JAR...` y busca el `.jar` que contiene tu `ComponenteCalendario`.
3. Marca la clase `componente.ComponenteCalendario` como componente visual.
4. Selecciona la categoría o crea una nueva.
5. Da clic en `Finish`.

Ahora podrás arrastrarlo directamente a tus formularios.

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


## Métodos y Propiedades Relevantes

A continuación se listan algunos de los métodos más útiles para trabajar con este componente:

###  Código y explicación
```java
// Establece el texto visible en el botón
componenteCalendario1.setTextoVisible("Seleccionar fecha");

// Muestra u oculta el texto en el botón
componenteCalendario1.setMostrarTexto(true);

// Cambia el color del fondo del botón principal
componenteCalendario1.setColorFondo(Color.CYAN);

// Define el color del calendario al desplegarse
componenteCalendario1.setColorFondoCalendario(Color.LIGHT_GRAY);

// Establece el estilo de fuente en el calendario
componenteCalendario1.setFuente(new Font("Arial", Font.PLAIN, 12));

// Asigna una acción cuando se selecciona una fecha
componenteCalendario1.setOnFechaSeleccionada(event -> {
    // Acción personalizada
});
```

### Uso de los métodos

| Método / Propiedad | Descripción |
|--------------------|-------------|
| `setTextoVisible(String texto)` | Define el texto que se muestra en el botón. |
| `setMostrarTexto(boolean mostrar)` | Activa o desactiva el texto visible. |
| `setColorFondo(Color color)` | Cambia el color de fondo del botón. |
| `setColorFondoCalendario(Color color)` | Define el fondo del calendario desplegado. |
| `setColorBotonesDias(Color color)` | Personaliza los botones de días. |
| `setFuente(Font fuente)` | Cambia la fuente del calendario. |
| `setBorde(Border borde)` | Permite personalizar el borde del botón. |
| `setOnFechaSeleccionada(ActionListener listener)` | Registra una acción al seleccionar una fecha. |
| `getFechaSeleccionada()` | Obtiene la fecha seleccionada como `LocalDate`. |

---

## 🔗 Video de demostración
- Explicación paso a paso para importar un archivo det tipo .jar en un nuevo proyecto Java.
- Integración del Componente Visual en un JFrame.
- Ejemplo práctico del uso dentro de una interfaz gráfica.
https://youtu.be/K4dv77fNUAk
---

## Autores

- **Melody Nathalie Mendoza Jiménez**  
- **Josue Saúl López Trujillo**  (https://github.com/Saul-LT)


