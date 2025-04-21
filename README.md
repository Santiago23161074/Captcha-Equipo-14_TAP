# Libreria captcha Equipo 14 TAP

**Descripción General**

Sistema para generar y validar captchas de diferentes tipos (numéricos, alfabéticos o combinados) implementado en Java con interfaz gráfica Swing. Permite la creación de captchas personalizables en longitud y tipo de caracteres, con validación visual en tiempo real.
- Solo se puede usar con un JDK 23 en adelante, si se intenta con una versión anterior marcara error
  

**Estructura del proyecto**

El proyecto se compone de dos clases principales:

- Captcha: Implementación concreta de la funcionalidad de captcha
- Prueba_Equipo14: Interfaz gráfica para probar el sistema
****
# Clase Captcha
**Explicación del código de la clase Captcha**
Este código define una clase Java llamada Captcha dentro del paquete Paquete_Captcha. La clase proporciona funcionalidad para generar códigos CAPTCHA (Completely Automated Public Turing test to tell Computers and Humans Apart), que son sistemas de verificación utilizados en aplicaciones web para distinguir entre usuarios humanos y programas automatizados.

**Descripción general**
- La clase Captcha contiene métodos estáticos para:
- Generar diferentes tipos de códigos CAPTCHA (numéricos, alfabéticos o combinados)
- Crear imágenes que representan visualmente los códigos CAPTCHA
- Validar la entrada del usuario contra el CAPTCHA generado
- Aplicar restricciones a campos de texto para aceptar solo ciertos tipos de caracteres

**Atributos**
La clase no define atributos de instancia o estáticos.

**Constructor**
## Paquete

```bash
  public Captcha():
```
 Constructor vacío sin funcionalidad específica.
 

## Métodos

```bash
  public final static String GenerarCaptchaSoloNumeros(int N)
```
- Propósito: Genera un CAPTCHA compuesto únicamente por dígitos numéricos.
- Parámetros: N - Longitud del CAPTCHA a generar.
- Retorno: String con números aleatorios de longitud N.
- Funcionamiento: Selecciona caracteres al azar del conjunto "0123456789".

```bash
  public final static String GenerarCaptchaCombinados(int N)
```
- Propósito: Genera un CAPTCHA combinado de números y letras.
- Parámetros: N - Longitud total del CAPTCHA.
- Retorno: String con combinación de números y letras de longitud N.
- Funcionamiento: Determina aleatoriamente cuántos caracteres serán números y cuántos serán letras, luego genera el código combinado.


## Manejo de restricciones de entrada
```bash
  public final static void Restricciones_TxT(JTextField Campo_de_Texto, int Tipo)
```
- Propósito: Aplica restricciones de entrada a un campo de texto.
- Parámetros:
- Campo_de_Texto - Campo de texto (JTextField) al que se aplicarán las restricciones.
- Tipo - Tipo de restricción (1: solo números, 2: solo letras y números).
- Funcionamiento: Agrega un KeyListener que filtra los caracteres no permitidos según el tipo especificado.

## Visualización del CAPTCHA
```bash
  public final static Image CrearImagen(String Captcha_A_Escribir)
```
- Propósito: Genera una imagen con el texto del CAPTCHA.
- Parámetros: Captcha_A_Escribir - Texto del CAPTCHA que se dibujará en la imagen.
- Retorno: Objeto Image que contiene la representación visual del CAPTCHA.
- Funcionamiento: Crea una imagen en blanco y dibuja el texto del CAPTCHA con un formato específico.

```bash
 public final static void AgregarImagen(Image CaptchaCreado, JLabel lblImagen)
```
- Propósito: Asigna la imagen del CAPTCHA a un componente JLabel.
- Parámetros:
- CaptchaCreado - Imagen del CAPTCHA generada previamente.
- lblImagen - Componente JLabel donde se mostrará la imagen.
- Funcionamiento: Convierte la imagen en un ImageIcon y lo asigna al JLabel especificado.

## Validación del CAPTCHA

```bash
  public final static boolean ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero, JLabel resultLabel)
```
- Propósito: Verifica si el CAPTCHA ingresado por el usuario coincide con el CAPTCHA generado.
- Parámetros:
- CaptchaIngresado - Texto ingresado por el usuario.
- CaptchaVerdadero - CAPTCHA generado previamente contra el cual se valida.
- resultLabel - Etiqueta donde se mostrará el resultado de la validación.
- Retorno: true si el CAPTCHA es correcto, false si es incorrecto.
- Funcionamiento: Compara las cadenas y muestra un mensaje adecuado en resultLabel.

## Características técnicas
- La clase está marcada como final, lo que significa que no puede ser extendida.
- Todos los métodos son estáticos y también marcados como final, lo que impide su sobrescritura.
- La clase utiliza componentes de Swing (JTextField, JLabel) para la interfaz gráfica.
- Se implementa manejo de eventos de teclado para las restricciones de entrada.

## Notas de implementación
Esta clase está diseñada para ser utilizada en aplicaciones Java que requieran un sistema de verificación CAPTCHA simple. Puede integrarse fácilmente con formularios u otros componentes de interfaz de usuario que necesiten verificar que el usuario es humano.
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

## Método de solo números (erroneo)
![Image](https://github.com/user-attachments/assets/5382d188-8411-4a67-8020-c83c3c126b7d)

## Método de solo números (correcto)
![Image](https://github.com/user-attachments/assets/08243030-fd97-4fe3-86d2-eaf76a6a76d5)

## Método de solo letras (erroneo)
![Image](https://github.com/user-attachments/assets/ba987fc4-0963-481f-bd5c-6e3e41f477ca)

## Método de solo letras (correcto)
![Image](https://github.com/user-attachments/assets/bd293734-57ff-472d-ba7f-d8650c24edf4)

## Método de solo mixto 
![Image](https://github.com/user-attachments/assets/f4cced12-8de1-4688-bb33-73b29c81efd1)

****
# Instalación de la libreria 
**Paso 1**
Desacrgar el .jar de Github de nuestro repositorio, llamado "Captcha.jar" y guardarlo en un lugar de facil accceso 
<br />
![Image](https://github.com/user-attachments/assets/edfc90db-7835-4a66-97de-8690c9526828)

**Paso 2**
Entrar a tu proyecto el cual quieras implemntar nuestro captcha y abrir el apartado de las librerias 
<br />
![Image](https://github.com/user-attachments/assets/4a804bdc-e117-4d40-93e7-510c8c27cf11)

**Paso 3**
Dar click derecho en la carpeta libreries y elegir la opción de "add jar/Folder.."
<br />
![Image](https://github.com/user-attachments/assets/d0473469-658c-422e-83f8-86090d4a8ed5)

**Paso 4**
Pegar la ruta del archivo Jar o seleccionarlo deesde la pestaña emergente y así habrás implementado de forma correcta nuestro -jar
<br />
![Image](https://github.com/user-attachments/assets/35923560-7a92-4fc0-b08a-b1e98d2d36cc)

**Paso 5**
Así se debe de ver si agregaste la libreria de una forma correcta
<br />
![Image](https://github.com/user-attachments/assets/cd3de793-27b6-4451-8eb6-11aee872220c)

**Extra**
Para un buen funcioamiento de nuestro Jar puedes guiarte de como lo implementamos en nuestro JFrame que esta en adentro de la carpeta Captcha Equipo 14 de nuestro repositorio de GitHub
<br />
![Image](https://github.com/user-attachments/assets/edfc90db-7835-4a66-97de-8690c9526828)
<br />
![Image](https://github.com/user-attachments/assets/53f010e2-0b47-4974-87da-877ce7d5bb92)
<br />
![Image](https://github.com/user-attachments/assets/f99bf70f-b399-4bde-aca3-cca2f8eadadc)
<br />
![Image](https://github.com/user-attachments/assets/500be052-bd21-4911-b587-a34a99c2fc82)


## Video guía

**Instalación del Jar en un proeyecto**
https://youtu.be/c7XfpK-TzV0

## Autores

- Méndez García Ángel de Jesús
- Pérez Jiménez Santiago Enmanuel 


