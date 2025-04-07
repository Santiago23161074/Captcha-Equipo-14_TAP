
# Libreria captcha Equipo 14 TAP

**1.-Clase captcha**

La clase Captcha implementa un sistema de generación y validación de CAPTCHAs que puede integrarse en aplicaciones Java Swing. Admite tres tipos de CAPTCHAs: sólo números, sólo letras y combinaciones alfanuméricas.

****

## Paquete

```bash
  package captcha_e14;
```

## Dependencias

```bash
  import java.awt.*;
  import java.awt.image.BufferedImage;
  import java.util.Random;
  import javax.swing.*;
```
## Declaración de la Clase

```bash
   public class Captcha
```
## Campos


| Campos | Description                |
| :-------- |:-------------------------- |
| `private ` | Generador de números|
| `Random ` | aleatorios utilizado para |
| `rand` | crear CAPTCHAs aleatorios|

## Constructor

Captcha()

Crea una nueva instancia de la clase Captcha.

```bash
  public Captcha()
```


## Métodos

**generarCaptchaSoloNumeros(int n)**

Genera una cadena CAPTCHA que consta solo de caracteres numéricos (0-9).


```bash
  public String generarCaptchaSoloNumeros(int n)
```


**Parámetros:**

- n - La longitud de la cadena CAPTCHA a generar

**Retorna:**

- Una cadena de caracteres numéricos aleatorios con la longitud especificada

****

**generarCaptchaSoloLetras(int n)**

Genera una cadena CAPTCHA que consta solo de caracteres alfabéticos (A-Z, a-z).


```bash
  public String generarCaptchaSoloLetras(int n)
```

**Parámetros:**

- n - La longitud de la cadena CAPTCHA a generar

**Retorna:**

- Una cadena de caracteres alfabéticos aleatorios con la longitud especificada

****

**generarCaptchaCombinado(int n)**

Genera una cadena CAPTCHA que consta de caracteres alfabéticos y numéricos.

```bash
   public String generarCaptchaCombinado(int n)
```

**Parámetros:**

- n - La longitud de la cadena CAPTCHA a generar

**Retorna:**

- Una cadena de caracteres alfanuméricos aleatorios con la longitud especificada

****

**CrearImagen(String text)**

Crea una BufferedImage que contiene el texto CAPTCHA renderizado.

```bash
   public Image CrearImagen(String text)
```

**Parámetros:**

- text - La cadena CAPTCHA a renderizar como imagen

**Retorna:**

- Un objeto Image que contiene el CAPTCHA renderizado

****

**ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero, JLabel resultLabel)**

Valida la entrada del usuario contra el CAPTCHA generado y actualiza una etiqueta de resultado en consecuencia.

```bash
   public boolean ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero, JLabel resultLabel)
```

**Parámetros:**

- CaptchaIngresado - La cadena CAPTCHA ingresada por el usuario
- CaptchaVerdadero - La cadena CAPTCHA original generada
- resultLabel - Un JLabel para actualizar con el resultado de la validación

**Retorna:**

- true si el CAPTCHA ingresado coincide con el CAPTCHA generado, false en caso contrario

****

**AgregarImagen(Image CaptchaCreado, JLabel lblImagen)**

Agrega la imagen CAPTCHA a un componente JLabel para mostrarla.

```bash
   public void AgregarImagen(Image CaptchaCreado, JLabel lblImagen)
```

**Parámetros:**

- CaptchaCreado - La imagen CAPTCHA a mostrar

- lblImagen - El componente JLabel donde se mostrará la imagen

**Ejemplo de uso:**

```bash
// Crear una nueva instancia de Captcha
Captcha captcha = new Captcha();

// Generar un CAPTCHA numérico con 6 caracteres
String captchaText = captcha.generarCaptchaSoloNumeros(6);

// Crear una imagen a partir del texto CAPTCHA
Image captchaImage = captcha.CrearImagen(captchaText);

// Mostrar la imagen en un JLabel
JLabel imageLabel = new JLabel();
captcha.AgregarImagen(captchaImage, imageLabel);

// Validar la entrada del usuario
JLabel resultLabel = new JLabel();
boolean esValido = captcha.ValidarCaptcha(entradaUsuario, captchaText, resultLabel);
```
****



**Documentación del JFrame Prueba_Equipo14**

La clase Prueba_Equipo14 representa una aplicación Java Swing JFrame que demuestra la funcionalidad de la clase Captcha. Proporciona una interfaz de usuario para seleccionar diferentes tipos de CAPTCHAs, especificar su longitud, mostrar la imagen CAPTCHA generada y validar la entrada del usuario.

****

**Paquete**
```bash
  package captcha_e14;
```

**Dependecias**

```bash
  import captcha_e14.Captcha;
  import java.awt.Image;
  import javax.swing.ImageIcon;
  import javax.swing.JLabel;
```

**Declaración de la Clase**

```bash
  public class Prueba_Equipo14 extends javax.swing.JFrame
```

## Campos


| Campos | Description                |
| :-------- |:-------------------------- |
| `Captcha CaptchaObjeto ` | Instancia de la clase Captcha utilizada para generar y validar CAPTCHAs|
| `Image ImagenCaptcha ` | Almacena la imagen CAPTCHA generada |
| `String CaptchaGenerado` | Almacena la cadena de texto CAPTCHA actual|
| `Varios componentes Swing` | Componentes de la interfaz de usuario para la aplicación|

****

## Constructor

Prueba_Equipo14()

Crea una nueva instancia del JFrame Prueba_Equipo14.

```bash
  public Prueba_Equipo14()
```

Este constructor inicializa los componentes del formulario y establece la visibilidad inicial de la etiqueta de resultado como falsa.


## Métodos

**initComponents()**

Método generado que inicializa los componentes de la interfaz de usuario del JFrame.


```bash
  private void initComponents()
```

Este método es generado por el constructor de GUI de NetBeans y configura el diseño y las propiedades de todos los componentes de la interfaz de usuario.

****

**btnAceptarActionPerformed(java.awt.event.ActionEvent evt)**

Controlador de eventos para el botón "Verificar".


```bash
  private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt)
```
Cuando se hace clic en el botón, este método:

- Valida el CAPTCHA ingresado contra el generado
- Si la validación falla, genera un nuevo CAPTCHA basado en el tipo seleccionado
- Crea una imagen para el nuevo CAPTCHA
- Actualiza la etiqueta de imagen con la nueva imagen CAPTCHA

****

**txtCaptchaLongitudActionPerformed(java.awt.event.ActionEvent evt)**

Controlador de eventos para el campo de texto de longitud del CAPTCHA.

```bash
  private void txtCaptchaLongitudActionPerformed(java.awt.event.ActionEvent evt)
```
Cuando el usuario ingresa una longitud y presiona Enter, este método:

- Verifica si se ha seleccionado un tipo de CAPTCHA
- Genera un nuevo CAPTCHA basado en el tipo seleccionado y la longitud especificada
- Crea una imagen para el CAPTCHA
- Actualiza la etiqueta de imagen con la imagen CAPTCHA
- Muestra mensajes de error apropiados si es necesario

****
**main(String args[])**

El punto de entrada de la aplicación.

```bash
  public static void main(String args[])
```

Configura el aspecto visual (Nimbus si está disponible) y lanza la aplicación.

##Componentes de la Interfaz de Usuario

| Cmponente |Tipo | Description                |
| :-------- |---|:-------------------------- |
| `Opciones ` | Agrupa los botones de radio para la selección del tipo de CAPTCHA|
| `jPanel1 ` | JPanel|Panel principal que contiene todos los componentes de la interfaz |
| `jLabel1, jLabel3, jLabel4` |JLabel |Varias etiquetas para instrucciones de la interfazs|
| `rdbtSoloNumeros` |JRadioButton |Opción para CAPTCHA solo numérico|
| `rdbtSoloLetras` |JRadioButton |Opción para CAPTCHA solo alfabético|
| `rdbtCombinado` | JRadioButton|Opción para CAPTCHA alfanumérico|
| `lblImagen` |JLabel |Muestra la imagen CAPTCHA generada|
| `txtCaptchaLongitud` |JTextField |Campo de entrada para la longitud del CAPTCHA|
| `txtCaptcha` |JTextField |Campo de entrada para que el usuario ingrese el CAPTCHA|
| `btnAceptar` | JButton|Botón "Verificar" para validar la entrada del usuario|
| `lblResultado` |JLabel |cMuestra el resultado de la validación (éxito/fracaso)Muestra el resultado de la validación (éxito/fracaso)|

**Flujo de la Aplicación**
- El usuario selecciona un tipo de CAPTCHA (solo números, solo letras o combinado)
- El usuario ingresa la longitud deseada del CAPTCHA
- Se genera un CAPTCHA y se muestra como una imagen
- El usuario intenta leer e ingresar el texto CAPTCHA
- Al hacer clic en "Verificar", la aplicación valida la entrada:
- Si es correcta, muestra "Correcto!"
- Si es incorrecta, muestra "Incorrecto. Intente de nuevo." y genera un nuevo CAPTCHA

**Ejemplo de Uso**

```bash
  // Lanzar la aplicación
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Prueba_Equipo14().setVisible(true);
        }
    });
}
```