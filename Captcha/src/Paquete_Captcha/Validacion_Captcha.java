/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Captcha;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author megan
 */
public abstract class Validacion_Captcha
{
    public abstract String GenerarCaptcha (int N, int Tipo);
    public abstract boolean ValidarCaptcha (String Captcha_Verdadero, String Captcha_Ingresado,JLabel resultLabel);
    public abstract void Restricciones_TxT (JTextField Campo_de_Texto, int Tipo);
}
