package com.example.demo.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.produits.dto.ProduitDTO;
import com.example.demo.produits.entities.Produit;
import com.example.demo.service.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
	
	@Autowired
	ProduitService produitService;
	
	@GetMapping
	public List<ProduitDTO> getAllProduits(){
		return produitService.getAllProduits();	
	}
	
	@GetMapping("/{id}")
	public ProduitDTO getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	} 
	
	@PostMapping
	public ProduitDTO createProduit(@RequestBody ProduitDTO produit) {
		return produitService.saveProduit(produit);
	}
	
	
	
	@PutMapping
	public ProduitDTO updateProduit(@RequestBody ProduitDTO produit) {
		return produitService.updateProduit(produit);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduitById(id);
	}
	
	@GetMapping("/prodscat/{idCat}")
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
	}
}
