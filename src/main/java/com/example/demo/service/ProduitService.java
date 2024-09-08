package com.example.demo.service;

import java.util.List;

import com.example.demo.produits.dto.ProduitDTO;
import com.example.demo.produits.entities.Categorie;
import com.example.demo.produits.entities.Produit;

public interface ProduitService {
	
	
	ProduitDTO getProduit(Long id);
	List<ProduitDTO> getAllProduits();
	ProduitDTO saveProduit(ProduitDTO p);
	ProduitDTO updateProduit(ProduitDTO p);
	
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	
	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> findByNomProduitAscAndPrixProduitDesc();
	
	ProduitDTO convertEntityToDto (Produit produit);
	Produit convertDtoToEntity(ProduitDTO produitDto);
}

/*
public interface ProduitService {
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduit(Long id);
	List<Produit> getAllProduits();
	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> findByNomProduitAscAndPrixProduitDesc();
	
	ProduitDTO convertEntityToDto (Produit produit);
}
*/
