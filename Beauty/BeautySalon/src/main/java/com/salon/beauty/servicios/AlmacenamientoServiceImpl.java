package com.salon.beauty.servicios;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.salon.beauty.AlmacenamientoProperties;
import com.salon.beauty.excepciones.FileStorageException;
import com.salon.beauty.excepciones.MyFileNotFoundException;

@Service
public class AlmacenamientoServiceImpl implements AlmacenamientoService {
	
	private Path direccion;
	
	@Autowired
	private AlmacenamientoProperties almacenamientoProperties;
	
	
	@Override
	public String almacenarArchivo(MultipartFile archivo) {
		// TODO Auto-generated method stub
		// Se normaliza el nombre del archivo en funcion al separador segun sistema operativo
        String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename());
        
        direccion = Paths.get(almacenamientoProperties.getDirectorioUpload()+"/"+nombreArchivo)
        .toAbsolutePath().normalize();
        
        try {
            // el nombre del archivo no debe tener parametros invalidos
            if(nombreArchivo.contains("..")) {
                throw new FileStorageException("Disculpa! El archivo no tiene los parametros de interes " + nombreArchivo);
            }

            // Copy file to the target location (Replacing existing file with the same name)
           
            Files.copy(archivo.getInputStream(), direccion, StandardCopyOption.REPLACE_EXISTING);

            return nombreArchivo;
            
        } catch (IOException ex) {
            throw new FileStorageException("No se puede almacenar " + nombreArchivo + ". Por favor, Intente Nuevamente!", ex);
        }
	}

	@Override
	public Resource cargarArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		try {
			direccion = Paths.get(almacenamientoProperties.getDirectorioUpload())
			        .toAbsolutePath().normalize();
			
			//System.out.println("rutaDescarga: "+direccion.toString());
			
            Path filePath = direccion.resolve(nombreArchivo).normalize();
            //System.out.println("rutaPath: "+filePath.toUri().toString());
            
            Resource resource = new UrlResource(filePath.toUri());
            
            if(resource.exists()) {
            	System.out.println("El recurso existe: "+resource.getFilename());
                return resource;
            } else {
                throw new MyFileNotFoundException("Archivo no encontrado " + nombreArchivo);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("Archivo no encontrado " + nombreArchivo, ex);
        }
		
	}

}
