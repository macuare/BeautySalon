package com.salon.beauty;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlmacenamientoProperties {
  private String directorioUpload = "/home/andy/Documentos/almacenamiento";

public String getDirectorioUpload() {
	return directorioUpload;
}

public void setDirectorioUpload(String directorioUpload) {
	this.directorioUpload = directorioUpload;
}
  
  
  
  
  
}
