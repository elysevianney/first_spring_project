package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.produits.entities.Categorie;
import com.example.demo.produits.entities.Produit;
import com.example.demo.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository; 
	
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC ASUS", 45500.500, new Date());  
		produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit() {
		Produit prod =  produitRepository.findById(1L).get();
		System.out.println(prod);
	}
	
	@Test
	public void testUpdateProduit() {
		Produit prod =  produitRepository.findById(2L).get();
		System.out.println(prod);
		
		prod.setNomProduit("PC HP");
		prod.setPrixProduit(852.25);
		produitRepository.save(prod);
		
		System.out.println(prod);
	}
	
	@Test
	public void tesDeleteProduit() {
		produitRepository.deleteById(2l);
	}
	
	@Test
	public void testFindAllProduit() {
		List<Produit> allProd = produitRepository.findAll();
		
		for(Produit prod : allProd) {
			System.out.println(prod);
		}
	}
	
	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("PC ASUS");
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("PC");
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomPrix(){
		List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
		for (Produit p : prods){
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByCategorie() {
		
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		
		List<Produit> prods = produitRepository.findByCategorie(cat);
		
		for(Produit p:prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByCategorieIdCat(){
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods){
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByOrderByNomProduitAsc(){
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods){
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomProduitAscAndPrixProduitDesc(){
		List<Produit> prods = produitRepository.findByNomProduitAscAndPrixProduitDesc();
		for (Produit p : prods){
			System.out.println(p);
		}
	}

}
