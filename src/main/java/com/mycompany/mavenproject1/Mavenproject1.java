/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        //CONTADORES
        double ch = 0, cm = 0, chijos = 0, ct = 0;
        double minimo = 0, maximo = 0, promedio = 0, tneto = 0;
        
        //VARIABLES CALCULOS
        int salario = 0, transporte = 0, bonohijos = 0;
        double alimentacion = 0, bonorec = 0;
        
        Scanner leer = new Scanner(System.in);
        
        String cant = JOptionPane.showInputDialog ("¿Cuántas personas usarán el programa?");
        
        int cantidad = Integer.parseInt(cant);
        
        
        for (int i = 0; i < cantidad; i++) {
            
            String nombre =  JOptionPane.showInputDialog ( "Introduzca su nombre:" );
            String apellido =  JOptionPane.showInputDialog ( "Introduzca su apellido:" );
            String cc =  JOptionPane.showInputDialog ( "Introduzca su cédula:" );
            
            String niv = JOptionPane.showInputDialog ("1. Técnico\n2. Tecnólogo\n3. Profesional\n4. Especialista\n5. Magister\n6. Doctor");
        
            int nivelac = Integer.parseInt(niv);
            
            switch (nivelac) {
                
                case 1:
                    salario = 1200000;
                    ct = ct + 1;
                    break;
                case 2:
                    salario = 1800000;
                    break;
                case 3:
                    salario = 3000000;
                    break;
                case 4:
                    salario = 3800000;
                    break;
                case 5:
                    salario = 4200000;
                    break;
                case 7:
                    salario = 7000000;
                    break;
            
            }
            
            String diast = JOptionPane.showInputDialog ("¿Cuántos días trabajó?");
            int diastrabajados = Integer.parseInt(diast);

            
            String ext = JOptionPane.showInputDialog ("¿Cuántas horas extras trabajó?");
            int extras = Integer.parseInt(ext);
            
            String noct = JOptionPane.showInputDialog ("¿Cuántas horas nocturnas trabajó?");
            int nocturnas = Integer.parseInt(noct);
           
            
            //CALCULOS
            
            int valord = salario / 30;
            int basico = diastrabajados * valord;
            double valorextras = (valord / 8) * 1.25 * extras;
            double valornocturnas = (valord / 8) * 1.75 * nocturnas;
            double subtotal = basico + valorextras + valornocturnas;
            
            //DEDUCCIONES
            
            double salud = subtotal * 0.4;
            double pension = subtotal * 0.4;
            
            double deduccion = salud + pension;
            
            //BONO DE RECREACIÓN
            
            String ant = JOptionPane.showInputDialog ("¿Cuántos meses lleva en la empresa?");
        
            int antiguedad = Integer.parseInt(ant);
            
            if (antiguedad >= 1 && antiguedad <=7) {
                bonorec = salario * 0.07;
            } else if (antiguedad <=16) {
                bonorec = salario * 0.15;
            } else if (antiguedad <=24) {
                bonorec = salario * 0.45;
            } else if (antiguedad <=45) {
                bonorec = salario * 0.55;
            } else if (antiguedad >45) {
                bonorec = salario * 0.7;
            }
            
            if (salario <= 2000000) {
                transporte = 117172;
            }
            
            //BONO DE ALIMENTACIÓN

            
            String sexo = JOptionPane.showInputDialog ("Indica tu género\n(H) ó (M)");
            
            if ("H".equals(sexo)) {
                alimentacion = salario * 0.15;
                ch = ch + 1;
            } else if ("M".equals(sexo)) {
                alimentacion = salario * 0.3;
                cm = cm + 1;
            }
            
            //SUBSIDIO POR NÚMERO DE HIJOS
            
            String hij = JOptionPane.showInputDialog ("¿Cuántos hijos tiene?");
        
            int hijos = Integer.parseInt(hij);
            
            switch (hijos) {
                case 0:
                    bonohijos = 0;
                    break;
                case 1:
                    bonohijos = 45000;
                    chijos = chijos + hijos;
                    break;
                case 2:
                    bonohijos = 90000;
                    chijos = chijos + hijos;
                    break;
                case 3:
                    bonohijos = 135000;
                    chijos = chijos + hijos;
                    break;
                case 4:
                    bonohijos = 280000;
                    chijos = chijos + hijos;
                    break;
            }
            
            if (hijos > 4) {
                bonohijos = 345000;
                chijos = chijos + hijos;
            }
            
            double neto = subtotal - deduccion + transporte + alimentacion + bonorec + bonohijos + extras + nocturnas;
            
            if (maximo < neto) {
                maximo = neto;
            }
            
            if (minimo > neto) {
                minimo = neto;
            }
            
            //ACUMULADOR PROMEDIO Y TOTAL NETO
            
            tneto = tneto + neto;
            
            promedio = tneto / cantidad;
            
            
            System.out.println("Nombre completo: " + nombre + " " + apellido);
            System.out.println("Cédula: " + cc);
            System.out.println("Salario neto: $" + neto);
            System.out.println("");
        }
        
        //ESTADISTICAS
        int totalhm = (int) (cm + ch);
        float ph = (float) (ch / totalhm) * 100;
        float pm = (float) (cm / totalhm) * 100;
        
        ct = ct * 1200000;
        
        System.out.println("Total de mujeres: " + cm);
        System.out.println("Total de hombres: " + ch);
        System.out.println("Porcentaje de mujeres: %" + pm);
        System.out.println("Porcentaje de hombres: %" + ph);
        System.out.println("Total de hijos: " + chijos);
        System.out.println("Total de la nomina: $" + tneto);
        System.out.println("Nómina promedio: $" + promedio);
        System.out.println("Salario más alto: $" + maximo);
        System.out.println("Salario más bajo: $" + minimo);
        System.out.println("Total de cada profesión Técnico: $" + ct);
        
    }
    
}
