package com.cmc.eval.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.commons.DateUtil;
import com.cmc.eval.entidades.Pago;

public class AdminArchivos {
	
	private String rutaArchivo;
	
	private static Logger logger = LogManager.getLogger(AdminArchivos.class); 
	
	public AdminArchivos(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	
	public ArrayList<String> leer() throws ArchivoException {
		File file = new File(this.rutaArchivo);
//		System.out.println("*****************************************");
//		System.out.println(file.getAbsolutePath() + " --------------------------------------- ");
//		System.out.println("*****************************************");
		FileReader fileReader = null;
		BufferedReader br = null;
		ArrayList<String> archivos = new ArrayList<String>();
		String linea = "";
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			while ((linea = br.readLine()) != null) {
				archivos.add(linea);
			}
			br.close();
		} catch (FileNotFoundException e) {
//			logger.error("No existe el archivo ", e);
			System.out.println("No existe el archivo " + e);
			throw new ArchivoException("No existe el archivo: " + this.rutaArchivo);
		} catch (IOException e) {
//			logger.error("Error al leer el archivo", e);
			System.out.println("Error al leer el archivo" + e);
			throw new ArchivoException("Error al leer el archivo: " + this.rutaArchivo);
		} finally {
			try {
				if (br != null) { // Eliminamos la posibilidad de NullPointerExeption
					br.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el BufferedReader br " + e);
//				logger.error("Error al cerrar el BufferedReader br ", e);
			}
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el FileReader fr " + e);
//				logger.error("Error al cerrar el FileReader fr ", e);
			}
		}
		return archivos;
	}
	
	public static void guardarPago(Pago pago) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Program Files\\apache-tomcat-9.0.52\\bin\\pagos.txt", true);            
            pw = new PrintWriter(fichero);

            if (pago != null) {
            	String guardar = pago.getCedula() + "*" +
            				pago.getMonto() + "*" + 
            				DateUtil.convertir(new Date());
            	pw.print("\r\n" + guardar);
			}
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error al escribir el archivo", e);
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              logger.error("Error al cerrar el fichero", e2);
           }
        }        
}

}
