package com.site.siteweb.controller; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.site.siteweb.constante.StaticListOfValues;
import com.site.siteweb.helpers.ResponseHelper; 
 

@RestController
@RequestMapping("/constante")
@CrossOrigin(origins = "*")
public class ConstanteController {
    
    private StaticListOfValues data = new StaticListOfValues();

	@GetMapping("/type") 
	public ResponseEntity<Object> getAllParametreDivers() {
		
		if (!data.getType().isEmpty()) {
			return new ResponseEntity<>(new ResponseHelper("constant", data.getType(), true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseHelper("constant null", false), HttpStatus.OK);
		}

	}

	@GetMapping("/role") 
	public ResponseEntity<Object> getRole() {
		
		if (!data.getRoles().isEmpty()) {
			return new ResponseEntity<>(new ResponseHelper("constante", data.getRoles(), true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseHelper("constante null", false), HttpStatus.OK);
		}

	}

	@GetMapping("/typefichier") 
	public ResponseEntity<Object> getTypeFichier() {
		
		if (!data.getTypeFichier().isEmpty()) {
			return new ResponseEntity<>(new ResponseHelper("constante", data.getTypeFichier(), true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseHelper("constante null", false), HttpStatus.OK);
		}

	}

	@GetMapping("/typemail") 
	public ResponseEntity<Object> getTypemail() {
		
		if (!data.getTypeMail().isEmpty()) {
			return new ResponseEntity<>(new ResponseHelper("constante", data.getTypeMail(), true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseHelper("constante null", false), HttpStatus.OK);
		}

	}

	@GetMapping("/langue") 
	public ResponseEntity<Object> getLangue() {
		
		if (!data.getLangue().isEmpty()) {
			return new ResponseEntity<>(new ResponseHelper("constante", data.getLangue(), true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseHelper("constante null", false), HttpStatus.OK);
		}

	}

	@GetMapping("/travail") 
	public ResponseEntity<Object> getTravail() {
		
		if (!data.getLangue().isEmpty()) {
			return new ResponseEntity<>(new ResponseHelper("constante", data.getTravail(), true), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseHelper("constante null", false), HttpStatus.OK);
		}

	}
}
