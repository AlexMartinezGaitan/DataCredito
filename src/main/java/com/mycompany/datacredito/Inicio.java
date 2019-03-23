/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datacredito;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alexander Martinez
 */
public class Inicio {

    //List<Persona> listaPersona;
    List<Reporte> listaReporte;
    List<Persona> listaPersona = new ArrayList<>();

    public void ingreserPersonaReporte() {

        Scanner entrada = new Scanner(System.in);
        int opc = 1;
        int opc2 = 1;
        String cadena = "";
        /*
         while (opc == 1) {

         System.out.print("Ingrese la cedula de la persona: ");
         int cedula = entrada.nextInt();
         entrada.nextLine();

         System.out.print("Ingrese el nombre de la persona: ");
         String nombre = entrada.nextLine();

         System.out.print("Ingrese el apellido de la persona: ");
         String apellido = entrada.nextLine();

         System.out.print("Ingrese el correo de la persona: ");
         String correo = entrada.nextLine();

         cadena = cadena + cedula + "," + nombre + "," + apellido + "," + correo + ",";
         opc2 = 1;
         while (opc2 == 1) {
         System.out.print("Ingrese el codigo del reporte: ");
         int codigo = entrada.nextInt();
         entrada.nextLine();

         System.out.print("Ingrese el nombre de la empresa: ");
         String empresa = entrada.nextLine();

         System.out.print("Ingrese la descripcion del reporte: ");
         String descrip = entrada.nextLine();

         System.out.print("Ingrese el estado del reporte: ");
         boolean estado = entrada.nextBoolean();

         System.out.print("Ingrese el valor del reporte: ");
         int valor = entrada.nextInt();
         entrada.nextLine();
         cadena = cadena + codigo + "-" + empresa + "-" + descrip + "-" + estado + "-" + valor + "%";
         System.out.print("Digite 1 para ingresar otro reporte: ");
         opc2 = entrada.nextInt();

         }
         // per = new Persona(cedula, nombre, apellido, correo);
         //listaPersona.add(per);

         System.out.print("Digite 1 para ingresar otra persona: ");
         opc = entrada.nextInt();
         cadena = cadena + "!";

         }
         */
        cadena = "52561,ddsnvkhs,dfsdnfk,bdhsjd,1-povfs-ddvnk-true-561%!655,sdbvkhsf,dhsfbsdm,kjfgns,2-uihdfik-hgdksf-false-52565%2-uisdhviks-sdnuihsd-true-26526%!";
        System.out.print(cadena);
        FileWriter fichero = null;
        PrintWriter pw = null;
        FileReader rea= null;
        try {
            rea = new FileReader("Archivos/a.txt");
            pw = new PrintWriter(fichero);
            String[] cad = cadena.split("!");
            int longitud = cad.length;
            for (int i = 0; i < longitud; i++) {
                pw.println(cad[i]);

            }
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Success...");
            //for (Persona lisPersona : listaPersona) {
            //System.out.println("Cedula:" + lisPersona.getCedula() + "Nombre: " + lisPersona.getNombre() + "Apellido: " + lisPersona.getApellido() + "Correo: " + lisPersona.getCorreo());
            //}

        }
    }

    public List<Persona> leerArchivo(String archivo) throws Exception {
        List<Persona> listaPersona = new ArrayList<>();
        //List<Reporte> listaReporte= new ArrayList<>();
        String cadena;
        FileReader f;
        BufferedReader b;
        try {
            f = new FileReader(archivo);
            b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                List<Reporte> listaReporte = new ArrayList<>();
                String[] personaVector = cadena.split(",");
                Persona persona = new Persona(Integer.parseInt(personaVector[0]), personaVector[1], personaVector[2], personaVector[3]);
                listaPersona.add(persona);
                String[] reportes = personaVector[4].split("%");
                int longitud = reportes.length;

                for (int i = 0; i < longitud; i++) {

                    String[] repor = reportes[i].split("-");
                    Reporte reporte = new Reporte(Integer.parseInt(repor[0]), repor[1], repor[2], Boolean.valueOf(repor[3]), Integer.parseInt(repor[4]));
                    listaReporte.add(reporte);
                    persona.setReporte(listaReporte);

                }

                persona.setReporte(listaReporte);
            }
            b.close();
            return listaPersona;

        } catch (FileNotFoundException ex) {
            System.err.print("No se puede encontra el archivo");
            throw new FileNotFoundException("No se puede encontra el archivo");
        } catch (IOException ex) {
            System.err.print("Error al leer el archivo");
            throw new IOException("Error al leer el archivo");
        }

    }

    public void imprimepersona(List<Persona> list) {

        try {
            listaPersona = list;
        } catch (Exception ex) {
            System.err.print("Error al leer el archivo");
        }
        for (Persona x : listaPersona) {
            System.out.println(" Nombre: " + x.getNombre() + " Apellido: " + x.getApellido() + " correo: " + x.getCorreo());
            for (Reporte r : x.getReporte()) {
                if (r.isEstado() == false) {
                    System.out.println(" codigo: " + r.getCodigo() + " Empresa: " + r.getEmpresa() + " Descricion: " + r.getDescripcion() + " Valor: " + r.getValor());
                }
            }

        }
    }

    public void escribirPersonaReporte() {

    }

}
