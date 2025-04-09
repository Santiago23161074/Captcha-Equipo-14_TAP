package Paquete_Captcha;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

/**
 * Clase Captcha que genera códigos de captcha, crea imágenes 
 * y permite validaciones de entrada en campos de texto.
 * Extiende la clase abstracta Validacion_Captcha.
 * 
 * @author Mendez Garcia Angel de Jesus y Perez Jimenez Santiago Enmanuel
 * @version 1.0
 */
public final class Captcha
{
     /**
     * Constructor vacío de la clase Captcha.
     */
    public Captcha ()
    {
        
    }

    /**
     * Genera un captcha compuesto solo de números.
     * 
     * @param N Longitud del captcha a generar.
     * @return Una cadena de texto con números aleatorios de longitud N.
     */
    
    public final static String GenerarCaptchaSoloNumeros (int N)
    {
        String caracteres = "0123456789";
        StringBuilder captcha = new StringBuilder();
        Random rand = new Random();
        for (int x = 0; x < N; x++) 
        {
            int posicion = rand.nextInt(caracteres.length());
            captcha.append(caracteres.charAt(posicion));
        }
        return captcha.toString();
    }
    
    /**
     * Genera un captcha compuesto solo de letras (mayúsculas y minúsculas).
     * 
     * @param N Longitud del captcha a generar.
     * @return Una cadena de texto con letras aleatorias de longitud N.
     */ 
    
    public final static String GenerarCaptchaSoloLetras (int N)
    {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder captcha = new StringBuilder();
        Random rand = new Random();
        for (int x = 0; x < N; x++) 
        {
            int posicion = rand.nextInt(caracteres.length());
            captcha.append(caracteres.charAt(posicion));
        }
        return captcha.toString();
    }
    
    /**
     * Genera un código captcha combinado de números y letras.
     * 
     * <p>El captcha generado tendrá una cantidad aleatoria de números y letras, 
     * asegurando siempre que la longitud total sea la especificada en {@code N}.</p>
     * 
     * @param N Longitud total del captcha a generar.
     * @return  Una cadena de texto con el captcha generado que contiene 
     *          una combinación aleatoria de números y letras.
     */
    
    public final static String GenerarCaptchaCombinados (int N)
    {
        String caracteresLetras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        StringBuilder captcha = new StringBuilder();
        Random rand = new Random();
        int Nnume = rand.nextInt(N-1) + 1;
        int Nletra = N - Nnume;
        for (int x = 0; x < Nnume; x++) 
        {
            int posicion = rand.nextInt(caracteresNumeros.length());
            captcha.append(caracteresNumeros.charAt(posicion));
        }
        for (int y = 0; y < Nletra; y++) 
        {
            int posicion = rand.nextInt(caracteresLetras.length());
            captcha.append(caracteresLetras.charAt(posicion));
        }
        return captcha.toString();
    }
    
    /**
     * Aplica restricciones a un campo de texto según el tipo especificado.
     * 
     * @param Campo_de_Texto JTextField donde se aplicará la restricción.
     * @param Tipo Tipo de restricción: 
     *             <ul>
     *             <li>1 = Solo permite números</li>
     *             <li>2 = Solo permite letras y números (sin caracteres especiales)</li>
     *             </ul>
     */
    public final static void Restricciones_TxT (JTextField Campo_de_Texto, int Tipo)
    {
        switch (Tipo)
        {
            case 1:
                Campo_de_Texto.addKeyListener(new KeyAdapter() 
                {
                    public void keyTyped(KeyEvent Evento) 
                    {
                        char caracter = Evento.getKeyChar();
                        if (!Character.isDigit(caracter)) 
                        {
                            Evento.consume();
                        }
                    }
                });
                break;
            case 2:
                Campo_de_Texto.addKeyListener(new KeyAdapter() 
                {
                    public void keyTyped(KeyEvent Evento) 
                    {
                        char caracter = Evento.getKeyChar();
                        if (!Character.isLetterOrDigit(caracter) && caracter != ' ' && caracter != 'ñ' && caracter != 'Ñ') {
                            Evento.consume();
                        }
                    }
                });
                break;
        }
    }

    /**
     * Genera una imagen con el texto del captcha.
     * 
     * @param Captcha_A_Escribir Texto del captcha a dibujar en la imagen.
     * @return Una imagen (BufferedImage) con el captcha generado.
     */
    public final static Image CrearImagen(String Captcha_A_Escribir) 
    {
        int width = 400; 
        int height = 40;
        BufferedImage Imagen_Captcha = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics TextoImagen = Imagen_Captcha.getGraphics();
        TextoImagen.setColor(Color.WHITE);
        TextoImagen.fillRect(0, 0, width, height);
        TextoImagen.setColor(Color.BLACK);
        TextoImagen.setFont(new Font("Arial", Font.BOLD, 20));
        TextoImagen.drawString(Captcha_A_Escribir, 20, 25);
        TextoImagen.dispose();
        return Imagen_Captcha;
    }

    /**
     * Valida si el captcha ingresado por el usuario es correcto.
     * 
     * @param CaptchaIngresado Captcha ingresado por el usuario.
     * @param CaptchaVerdadero Captcha previamente generado.
     * @param resultLabel Etiqueta donde se mostrará el resultado de la validación.
     * @return `true` si el captcha es correcto, `false` si es incorrecto.
     */
    public final static boolean ValidarCaptcha(String CaptchaIngresado, String CaptchaVerdadero,JLabel resultLabel) 
    {
        if (CaptchaIngresado.equals(CaptchaVerdadero)) 
        {
            resultLabel.setVisible(true);
            resultLabel.setText("Correcto!");
            return true;
        } 
        else 
        {
            resultLabel.setVisible(true);
            resultLabel.setText("Incorrecto. Intente de nuevo.");
            return false;
        }
    }
    
    /**
     * Agrega la imagen del captcha generado a un JLabel.
     * 
     * @param CaptchaCreado Imagen del captcha a mostrar.
     * @param lblImagen JLabel donde se colocará la imagen.
     */
    public final static void AgregarImagen (Image CaptchaCreado, JLabel lblImagen)
    {
        ImageIcon icono = new ImageIcon (CaptchaCreado);
        lblImagen.setIcon(icono);
        lblImagen.repaint();
    }
}