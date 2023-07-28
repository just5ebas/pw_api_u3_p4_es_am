package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService iMateriaService;

//	@GetMapping(path = "/{asignatura}")
//	public Materia consultarNombreMateria(@PathVariable String asignatura) {
//		return this.iMateriaService.seleccionarPorMateria(asignatura);
//	}
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MateriaTO consultarPorId(@PathVariable Integer id) {
		return this.iMateriaService.buscarPorId(id);
	}

//	@PostMapping
//	public void guardar(@RequestBody Materia materia) {
//		this.iMateriaService.registrar(materia);
//	}
//
//	@PutMapping(path = "/{identificador}")
//	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
//		materia.setId(identificador);
//		this.iMateriaService.actualizar(materia);
//	}
//
//	@PatchMapping(path = "/{identificador}")
//	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {
//		Materia mat1 = this.iMateriaService.buscarPorId(identificador);
//		mat1.setNombre(materia.getNombre());
//		this.iMateriaService.actualizar(mat1);
//	}
//
//	@DeleteMapping(path = "/{id}")
//	public void borrar(@PathVariable Integer id) {
//		this.iMateriaService.borrar(id);
//	}

}
