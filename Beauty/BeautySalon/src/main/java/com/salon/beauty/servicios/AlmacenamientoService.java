package com.salon.beauty.servicios;



import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface AlmacenamientoService {
	
	public String almacenarArchivo(MultipartFile archivo);
	public Resource cargarArchivo(String nombreArchivo);
}
