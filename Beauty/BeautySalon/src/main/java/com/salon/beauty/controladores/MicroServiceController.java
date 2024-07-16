package com.salon.beauty.controladores;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salon.beauty.AlmacenamientoProperties;
import com.salon.beauty.entidades.Clasificacion;
import com.salon.beauty.entidades.Clientes;
import com.salon.beauty.entidades.Contratacion;
import com.salon.beauty.entidades.Estudiante;
import com.salon.beauty.entidades.Locales;
import com.salon.beauty.entidades.Pines;
import com.salon.beauty.entidades.Recursos;
import com.salon.beauty.entidades.Roles;
import com.salon.beauty.entidades.Seguridad;
import com.salon.beauty.entidades.Servicios;
import com.salon.beauty.entidades.Tokens;
import com.salon.beauty.entidades.Usuarios;
import com.salon.beauty.modelos.beans.Codificacion;
import com.salon.beauty.modelos.beans.DescripcionSubidaArchivo;
import com.salon.beauty.servicios.AlmacenamientoService;
import com.salon.beauty.servicios.ClasificacionService;
import com.salon.beauty.servicios.ClientesService;
import com.salon.beauty.servicios.ContratacionService;
import com.salon.beauty.servicios.EstudianteService;
import com.salon.beauty.servicios.LocalesService;
import com.salon.beauty.servicios.PinesService;
import com.salon.beauty.servicios.RecursosService;
import com.salon.beauty.servicios.RolesService;
import com.salon.beauty.servicios.SeguridadService;
import com.salon.beauty.servicios.ServiciosService;
import com.salon.beauty.servicios.TokensService;
import com.salon.beauty.servicios.UsuariosService;

@RestController
@RequestMapping("/api")
public class MicroServiceController {
	@Autowired
	private Codificacion encriptar;
	
	@Autowired
	private UsuariosService usuariosService;	
	@Autowired
	private PinesService pinesService;
	@Autowired
	private LocalesService localesService;
	@Autowired
	private SeguridadService seguridadService;
	@Autowired
	private RecursosService recursosService;
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private TokensService tokensService;
	@Autowired
	private ContratacionService contratacionService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private ServiciosService serviciosService;
	@Autowired
	private ClasificacionService clasificacionService;
	@Autowired
	private ClientesService clientesService;
	@Autowired
	private AlmacenamientoService almacenamiento;
	
	@Autowired
	private AlmacenamientoProperties almacenamientoProperties;
	
	
	
	
	//++++++++++++++++++++++++++++++++PRUEBAS+++++++++++++++++++++++++++++++++++++++++++++
	@GetMapping("/pruebas/estudiante/todos")
	public List<Estudiante> listarEstudiantes() { //listar todos los estudiantes
		System.out.println("Listando todos los estudiantes");
		return estudianteService.listarEstudiantes();
		
	}
	
	@GetMapping("/pruebas/estudiante/buscar/{id}")
	public Estudiante buscarEstudiantePorId(@PathVariable(value = "id") int id) {
		System.out.println("Buscando estudiante por ID: "+id);
		return estudianteService.buscarPorId(id);
	}
	
	@PostMapping("/pruebas/estudiante/agregar")
	public Estudiante agregarEstudiantes(@RequestBody Estudiante estudiante) {
		System.out.println("Agregando un nuevo estudiante: "+estudiante.getNombres());
		return estudianteService.agregarNuevoEstudiante(estudiante);
	}
	
	@PutMapping("/pruebas/estudiante/actualizar")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante) {
		System.out.println("Actualizando registro del estudiante: "+estudiante.getIdEstudiante()+" - "+estudiante.getNombres());	
		estudianteService.actualizarEstudiante(estudiante);
		
	}
	
	@DeleteMapping("/pruebas/estudiante/borrar/{id}")
	public void borrarEstudiante(@PathVariable(value = "id") int id) {
		System.out.println("Borrando registros del estudiante: "+id);
		estudianteService.borrarEstudiantePorId(id);
		
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//PINES--------------------------------------------------------------------
	@GetMapping("/pines/todos")
	public List<Pines> listarPines() {		
		return pinesService.listarLosPines();		
	}
	
	@GetMapping("/pines/buscar/{id}")
	public Pines buscarPinesPorId(@PathVariable(value = "id") int id) {		
		return pinesService.buscarPorId(id);
	}
	
	@PostMapping("/pines/agregar")
	public Pines agregarNuevoPin(@RequestBody Pines pin) {		
		return pinesService.agregarNuevoPin(pin);
	}
	
	@PutMapping("/pines/actualizar")
	public void actualizarPin(@RequestBody Pines pin) {			
		pinesService.actualizarPin(pin);		
	}
	
	@DeleteMapping("/pines/borrar/{id}")
	public void borrarPin(@PathVariable(value = "id") int id) {
		pinesService.borrarPinPorId(id);
	}
	
	//USUARIOS------------------------------------------------------------------
	
	@GetMapping("/usuarios/todos")
	public List<Usuarios> listarUsuarios() {		
		return usuariosService.listarLosUsuarios();		
	}
	
	@GetMapping("/usuarios/buscar/{token}")
	public Usuarios buscarUsuariosPorId(@PathVariable(value = "token") String tokenUsuario) {		
		return usuariosService.buscarPorToken(tokenUsuario);
	}
	
	@PostMapping("/usuarios/agregar")
	public Usuarios agregarNuevo(@RequestBody Usuarios usuario) {
		String valor = encriptar.codificar(UUID.randomUUID().toString()+usuario.getCorreo());
		usuario.setTokenUsuario(valor);
		return usuariosService.agregarNuevoUsuario(usuario);
	}
	
	@PutMapping("/usuarios/actualizar")
	public void actualizarUsuario(@RequestBody Usuarios usuario) {			
		usuariosService.actualizarUsuario(usuario);	
	}
	
	@DeleteMapping("/usuarios/borrar/{token}")
	public void borrarUsuario(@PathVariable(value = "token") String tokenUsuario) {
		usuariosService.borrarUsuario(tokenUsuario);
	}
	
	//SEGURIDAD--------------------------------------------------------------------
	@GetMapping("/seguridad/todos")
	public List<Seguridad> listarSeguridad() {		
		return seguridadService.listarSeguridad();		
	}
	
	@GetMapping("/seguridad/buscar/{id}")
	public Seguridad buscarSeguridadPorId(@PathVariable(value = "id") int idSeguridad) {		
		return seguridadService.buscarPorId(idSeguridad);
	}
	
	@PostMapping("/seguridad/agregar")
	public Seguridad agregarNuevaSeguridad(@RequestBody Seguridad seguridad) {
		
		return seguridadService.agregarNuevo(seguridad);
	}
	
	@PutMapping("/seguridad/actualizar")
	public void actualizarSeguridad(@RequestBody Seguridad seguridad) {			
		seguridadService.actualizarSeguridad(seguridad);	
	}
	
	@DeleteMapping("/seguridad/borrar/{id}")
	public void borrarSeguridadPorID(@PathVariable(value = "id") int idSeguridad) {
		seguridadService.borrarSeguridadPorId(idSeguridad);
	}
	
	//TOKENS-------------------------------------------------------------------------
	@GetMapping("/tokens/todos")
	public List<Tokens> listarTokens() {		
		return 	tokensService.listarTokens();	
	}
	
	@GetMapping("/tokens/buscar/{id}")
	public Tokens buscarTokensPorId(@PathVariable(value = "id") int idToken) {		
		return tokensService.buscarPorId(idToken);
	}
	
	@PostMapping("/tokens/agregar")
	public Tokens agregarNuevoToken(@RequestBody Tokens token) {
		return tokensService.agregarNuevoToken(token);
	}
	
	@PutMapping("/tokens/actualizar")
	public void actualizarToken(@RequestBody Tokens token) {			
		tokensService.actualizarToken(token);	
	}
	
	@DeleteMapping("/tokens/borrar/{id}")
	public void borrarTokenPorID(@PathVariable(value = "id") int idToken) {
		tokensService.borrarPorTokenPorId(idToken);
	}
	
	//CONTRATACION---------------------------------------------------------------------
	@GetMapping("/contratos/todos")
	public List<Contratacion> listarContratos() {		
		return contratacionService.listarLosContratos();		
	}
	
	@GetMapping("/contratos/buscar/{id}")
	public Contratacion buscarContratoPorId(@PathVariable(value = "id") int idContrato) {		
		return contratacionService.buscarPorId(idContrato);
	}
	
	@PostMapping("/contratos/agregar")
	public Contratacion agregarNuevoContrato(@RequestBody Contratacion contrato) {
		return contratacionService.agregarNuevoContrato(contrato);
	}
	
	@PutMapping("/contratos/actualizar")
	public void actualizarContrato(@RequestBody Contratacion contrato) {			
		contratacionService.actualizarContrato(contrato);	
	}
	
	@DeleteMapping("/contratos/borrar/{id}")
	public void borrarContratoPorID(@PathVariable(value = "id") int idContrato) {
		contratacionService.borrarContratoPorId(idContrato);	
	}
	
	//LOCALES----------------------------------------------------------------------------
	@GetMapping("/locales/todos")
	public List<Locales> listarLocales() {		
		return localesService.listarLocales();
	}
	
	@GetMapping("/locales/buscar/{id}")
	public Locales buscarLocalesPorId(@PathVariable(value = "id") int idLocal) {		
		return localesService.buscarPorId(idLocal);
	}
	
	@PostMapping("/locales/agregar")
	public Locales agregarNuevoLocal(@RequestBody Locales local) {
		return localesService.agregarNuevoLocal(local);
	}
	
	@PutMapping("/locales/actualizar")
	public void actualizarLocal(@RequestBody Locales local) {			
		localesService.actualizarLocal(local);	
	}
	
	@DeleteMapping("/locales/borrar/{id}")
	public void borrarLocalPorID(@PathVariable(value = "id") int idLocal) {
		localesService.borrarLocalPorId(idLocal);	
	}
	
	//ROLES------------------------------------------------------------------------------
	@GetMapping("/roles/todos")
	public List<Roles> listarRoles() {		
		return rolesService.listarRoles();
	}
	
	@GetMapping("/roles/buscar/{id}")
	public Roles buscarRolesPorId(@PathVariable(value = "id") int idRol) {		
		return rolesService.buscarPorId(idRol);
		
	}
	
	@PostMapping("/roles/agregar")
	public Roles agregarNuevoRol(@RequestBody Roles rol) {
		return rolesService.agregarNuevoRol(rol);
	}
	
	@PutMapping("/roles/actualizar")
	public void actualizarRol(@RequestBody Roles rol) {			
		rolesService.actualizarRol(rol);	
	}
	
	@DeleteMapping("/roles/borrar/{id}")
	public void borrarRolPorID(@PathVariable(value = "id") int idRol) {
		rolesService.borrarRolPorId(idRol);	
	}
	
	//SERVICIOS----------------------------------------------------------------------------
	@GetMapping("/servicios/todos")
	public List<Servicios> listarServicios() {		
		return serviciosService.listarServicios();
	}
	
	@GetMapping("/servicios/buscar/{id}")
	public Servicios buscarServiciosPorId(@PathVariable(value = "id") int idServicio) {		
		return serviciosService.buscarPorId(idServicio);
		
	}
	
	@PostMapping("/servicios/agregar")
	public Servicios agregarNuevoServicio(@RequestBody Servicios servicio) {
		return serviciosService.agregarNuevoServicio(servicio);
	}
	
	@PutMapping("/servicios/actualizar")
	public void actualizarServicio(@RequestBody Servicios servicio) {			
		serviciosService.actualizarServicio(servicio);
	}
	
	@DeleteMapping("/servicios/borrar/{id}")
	public void borrarServicioPorID(@PathVariable(value = "id") int idServicio) {
		serviciosService.borrarServicioPorId(idServicio);	
	}
	
	//RECURSOS------------------------------------------------------------------------------
	@GetMapping("/recursos/todos")
	public List<Recursos> listarRecursos() {		
		return recursosService.listarRecursos();
	}
	
	@GetMapping("/recursos/buscar/{id}")
	public Recursos buscarRecursoPorId(@PathVariable(value = "id") int idRecurso) {		
		return recursosService.buscarPorId(idRecurso);
		
	}
	
	@GetMapping("/recursos/buscar/servicio/{id}")
	public List<Recursos> buscarRecursoPorIdServicio(@PathVariable(value = "id") int idServicio) {		
		
		return recursosService.buscarRecursosPorIdServicio(idServicio);
		
	}
	
	@PostMapping("/recursos/agregar")
	public Recursos agregarNuevoRecurso(@RequestBody Recursos recurso) {
		return recursosService.agregarNuevoRecurso(recurso);
	}
	
	@PutMapping("/recursos/actualizar")
	public void actualizarRecurso(@RequestBody Recursos recurso) {			
		recursosService.actualizarRecurso(recurso);
	}
	
	@DeleteMapping("/recursos/borrar/{id}")
	public void borrarRecursoPorID(@PathVariable(value = "id") int idRecurso) {
		recursosService.borrarRecursoPorId(idRecurso);	
	}
	//CLASIFICACION--------------------------------------------------------------------------
	@GetMapping("/clasificacion/todos")
	public List<Clasificacion> listarClasificaciones() {		
		return clasificacionService.listarClasificaciones();
	}
	
	@GetMapping("/clasificacion/buscar/{id}")
	public Clasificacion buscarClasificacionPorId(@PathVariable(value = "id") int idClasificacion) {		
		return clasificacionService.buscarPorId(idClasificacion);
		
	}
	
	@PostMapping("/clasificacion/agregar")
	public Clasificacion agregarNuevaClasificacion(@RequestBody Clasificacion clasificacion) {
		return clasificacionService.agregarNuevaClasificacion(clasificacion);
	}
	
	@PutMapping("/clasificacion/actualizar")
	public void actualizarClasificacion(@RequestBody Clasificacion clasificacion) {			
		clasificacionService.actualizarClasificacion(clasificacion);
	}
	
	@DeleteMapping("/clasificacion/borrar/{id}")
	public void borrarClasificacionPorID(@PathVariable(value = "id") int idClasificacion) {
		clasificacionService.borrarClasificacionPorId(idClasificacion);
	}
	
	//CLIENTES--------------------------------------------------------------------------------
	@GetMapping("/clientes/todos")
	public List<Clientes> listarClientes() {		
		return clientesService.listarClientes();
	}
	
	@GetMapping("/clientes/buscar/{id}")
	public Clientes buscarClientePorId(@PathVariable(value = "id") String idCliente) {		
		return clientesService.buscarPorId(idCliente);
		
	}
	
	@PostMapping("/clientes/agregar")
	public Clientes agregarNuevoCliente(@RequestBody Clientes cliente) {
		String valor = encriptar.codificar(UUID.randomUUID().toString()+cliente.getCorreo());
		cliente.setIdCliente(valor);
		return clientesService.agregarNuevoCliente(cliente);
	}
	
	@PutMapping("/clientes/actualizar")
	public void actualizarCliente(@RequestBody  Clientes cliente) {			
		clientesService.actualizarCliente(cliente);
	}
	
	@DeleteMapping("/clientes/borrar/{id}")
	public void borrarClientePorID(@PathVariable(value = "id") String idCliente) {
		clientesService.borrarClientePorId(idCliente);
	}
	
	//ALMACENAMIENTO de ARCHIVO----------------------------------------------------------------
	
	@PostMapping("/recursos/digital")
	public  DescripcionSubidaArchivo agregarRecursoFisico(@RequestParam("file") MultipartFile file) {
		
		String nombreArchivo = almacenamiento.almacenarArchivo(file);
		
		String rutaArchivo = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/Descarga/")
				.path(nombreArchivo)
				.toUriString();
		
		
		//System.out.println("ruta: "+almacenamientoProperties.getDirectorioUpload());
		//return new DescripcionSubidaArchivo(file.getOriginalFilename(), "/media/recursos/imagenes", file.getContentType(), file.getSize());
		return new DescripcionSubidaArchivo(nombreArchivo,rutaArchivo, file.getContentType(), file.getSize());
		
	}
	
	@PostMapping("/recursos/digital/multiples")
    public List<DescripcionSubidaArchivo> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        
		return Arrays.asList(files)
                .stream()
                .map(file -> agregarRecursoFisico(file))
                .collect(Collectors.toList());
		
    }
	
	@GetMapping("/recursos/digital/{fileName:.+}")
	public  ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
        Resource resource = almacenamiento.cargarArchivo(fileName);
        
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
           System.out.println("Could not determine file type.");
        }
        
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
		
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
