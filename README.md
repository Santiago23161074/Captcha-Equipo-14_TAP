
# Libreria captcha Equipo 14 TAP

**Descripción General**

Sistema para generar y validar captchas de diferentes tipos (numéricos, alfabéticos o combinados) implementado en Java con interfaz gráfica Swing. Permite la creación de captchas personalizables en longitud y tipo de caracteres, con validación visual en tiempo real.

**Estructura del proyecto**

El proyecto se compone de tres clases principales:

- Validacion_Captcha: Clase abstracta que define la estructura base
- Captcha: Implementación concreta de la funcionalidad de captcha
- Prueba_Equipo14: Interfaz gráfica para probar el sistema
****

# Clase Abstracta

## Paquete

```bash
  package Paquete_Captcha;
```

## Dependencias

```bash
  import javax.swing.JLabel;
  import javax.swing.JTextField;
```
## Métodos Abstractos

**GenerarCaptcha(int N, int Tipo)**

```bash
   public abstract String GenerarCaptcha(int N, int Tipo);
```

## Parámetros:

- N - La longitud del captcha a generar
- Tipo - El tipo de captcha (1: numérico, 2: alfabético, 3: alfanumérico)

## Retorna:

- Una cadena de caracteres que representa el captcha generado
****

**ValidarCaptcha(String Captcha_Verdadero, String Captcha_Ingresado, JLabel resultLabel)**

```bash
  public abstract boolean ValidarCaptcha(String Captcha_Verdadero, String Captcha_Ingresado, JLabel resultLabel);
```
## Parámetros:

- Captcha_Verdadero - La cadena captcha original generada
- Captcha_Ingresado - La cadena captcha ingresada por el usuario
- resultLabel - Un JLabel para mostrar el resultado de la validación

## Retorna:

- true si el captcha ingresado coincide con el captcha generado, false en caso contrario.

****

**Restricciones_TxT(JTextField Campo_de_Texto, int Tipo)**

```bash
  public abstract void Restricciones_TxT(JTextField Campo_de_Texto, int Tipo);
```

## Retorna:

- Campo_de_Texto - El campo de texto al que se aplicarán las restricciones
- Tipo - El tipo de restricción (1: solo números, 2: alfanumérico)

# Clase Captcha

## Paquete

```bash
  package Paquete_Captcha;
```

## Dependencias

```bash
  import java.awt.*;
  import java.awt.event.KeyAdapter;
  import java.awt.event.KeyEvent;
  import java.awt.image.BufferedImage;
  import java.util.Random;
  import javax.swing.*;
```


## Campos


| Campo | Tipo |Description                |
| :-------- |--|:-------------------------- |
| `rand ` |private, Random|Generador de números aleatorios utilizado para crear CAPTCHAs aleatorios|

## Constructor

Captcha()

Crea una nueva instancia de la clase Captcha.

```bash
  public Captcha()
```


## Métodos

**GenerarCaptcha(int N, int Tipo)**

```bash
  public String GenerarCaptcha(int N, int Tipo)
```

Genera una cadena CAPTCHA según el tipo especificado.


**Parámetros:**

- N - La longitud del captcha a generar
- Tipo - El tipo de captcha:
 - 1: Solo números (0-9)
 - 2: Solo letras (A-Z, a-z)
 - 3: Combinación de números y letras

**Retorna:**

- Una cadena de caracteres aleatorios con la longitud especificada y el tipo seleccionado

****

**Restricciones_TxT(JTextField Campo_de_Texto, int Tipo)**

Aplica restricciones a un campo de texto para limitar los tipos de caracteres que pueden ser ingresados.


```bash
  public void Restricciones_TxT(JTextField Campo_de_Texto, int Tipo)
```

**Parámetros:**

- Campo_de_Texto - El campo de texto al que se aplicarán las restricciones
- Tipo - El tipo de restricción:

- 1: Solo permite dígitos numéricos
- 2: Permite letras, dígitos, espacios y caracteres 'ñ'/'Ñ'
****

**CrearImagen(String Captcha_A_Escribir))**

Crea una imagen que contiene el texto del captcha.

```bash
   public Image CrearImagen(String Captcha_A_Escribir)
```

**Parámetros:**

- Captcha_A_Escribir - La cadena captcha a renderizar como imagen

**Retorna:**

- Un objeto Image con el captcha renderizado

****

**ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero, JLabel resultLabel)**

Valida la entrada del usuario contra el captcha generado y actualiza una etiqueta de resultado.

```bash
   public boolean ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero, JLabel resultLabel)
```

**Parámetros:**

- CaptchaIngresado - La cadena captcha ingresada por el usuario
- CaptchaVerdadero - La cadena captcha original generada
- resultLabel - Un JLabel para actualizar con el resultado de la validación

**Retorna:**

- true si el captcha ingresado coincide con el captcha generado, false en caso contrario

****

**AgregarImagen(Image CaptchaCreado, JLabel lblImagen)**

Agrega la imagen captcha a un componente JLabel para mostrarla.

```bash
   public void AgregarImagen(Image CaptchaCreado, JLabel lblImagen)
```

**Parámetros:**

- CaptchaCreado - La imagen captcha a mostrar
- lblImagen - El componente JLabel donde se mostrará la imagen

****

# JFRAME de Prueba_Equipo14

## Paquete

```bash
   package Proyecto_equipo14;
```

## Dependecias

```bash
   import Paquete_Captcha.Captcha;
   import java.awt.Image;
```

## Campos


| Campos |Tipo| Description                |
| :-------- |--|:-------------------------- |
| `Captcha CaptchaObjeto ` |Captcha| Instancia de la clase Captcha utilizada para generar y validar captchas|
| `Image ImagenCaptcha ` |Image |Almacena la imagen CAPTCHA generada |
| `String CaptchaGenerado` |String| Almacena la cadena de texto CAPTCHA actual|
| `Varios componentes Swing` |JPanel, JLabel, JButton, etc.| Componentes de la interfaz de usuario para la aplicación|

****

## Constructor

Prueba_Equipo14()

Crea una nueva instancia del JFrame Prueba_Equipo14.

```bash
  public Prueba_Equipo14()
```

Crea una nueva instancia del JFrame Prueba_Equipo14. Este constructor:
- Inicializa los componentes del formulario
- Establece la visibilidad inicial de la etiqueta de resultado como falsa
- Configura restricciones para los campos de texto


## Métodos

**btnAceptarActionPerformed(java.awt.event.ActionEvent evt)**

```bash
  private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt)
```

Controlador de eventos para el botón "Verificar". Cuando se hace clic en el botón, este método:

- Valida el captcha ingresado contra el generado
- Si la validación falla, genera un nuevo captcha según el tipo seleccionado
- Crea una imagen para el nuevo captcha
- Actualiza la etiqueta de imagen con la nueva imagen captcha
- Verifica si los campos están vacíos y muestra mensajes de error si es necesario

****

**txtCaptchaLongitudActionPerformed(java.awt.event.ActionEvent evt)**

```bash
  private void txtCaptchaLongitudActionPerformed(java.awt.event.ActionEvent evt)
```
Controlador de eventos para el campo de texto de longitud del captcha. Cuando el usuario ingresa una longitud y presiona Enter, este método:

- Verifica si se ha ingresado una longitud
- Genera un nuevo captcha según el tipo seleccionado y la longitud especificada
- Crea una imagen para el captcha
- Actualiza la etiqueta de imagen con la imagen captcha
- Muestra mensajes de error si no se ha seleccionado un tipo de captcha o si la longitud está vacía

****

**main(String args[])**


```bash
  public static void main(String args[])
```
El punto de entrada de la aplicación. Este método:

- Configura el aspecto visual (Nimbus si está disponible)
- Crea y muestra la interfaz gráfica

****
# **Usuario**

## Componentes de la Interfaz de Usuario

| Cmponente |Tipo | Description                |
| :-------- |---|:-------------------------- |
| `Opciones ` |ButtonGroup| Agrupa los botones de radio para la selección del tipo de CAPTCHA|
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
 // Crear una nueva instancia de Captcha
Captcha captcha = new Captcha();

// Generar un captcha numérico con 6 caracteres
String captchaText = captcha.GenerarCaptcha(6, 1);

// Crear una imagen a partir del texto captcha
Image captchaImage = captcha.CrearImagen(captchaText);

// Mostrar la imagen en un JLabel
JLabel imageLabel = new JLabel();
captcha.AgregarImagen(captchaImage, imageLabel);

// Validar la entrada del usuario
JLabel resultLabel = new JLabel();
boolean esValido = captcha.ValidarCaptcha(entradaUsuario, captchaText, resultLabel);
```
****
# Instalación de la libreria 

## Requisitos técnicos

- Java SE 8 o superior
- Biblioteca Swing para la interfaz gráfica

## Instalación

- Clone el repositorio o descargue los archivos fuente
- Compile los archivos Java
- Ejecute la clase Prueba_Equipo14

## Contribución

## Video guía

## Autores

- Méndez García Ángel de Jesús
- Pérez Jiménez Santiago Enmanuel 
## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

