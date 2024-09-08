package com.example.demo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.produits.dto.ProduitDTO;
import com.example.demo.produits.entities.Categorie;
import com.example.demo.produits.entities.Produit;
import com.example.demo.repos.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p))) ;
	}
	
	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}
	
	@Override
	public ProduitDTO getProduit(Long id) {
		return convertEntityToDto(produitRepository.findById(id).get());
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		
		return produitRepository.findAll().stream().
				map(this::convertEntityToDto)
				.collect(Collectors.toList()) ;
	}

	

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> findByNomProduitAscAndPrixProduitDesc() {
		return produitRepository.findByNomProduitAscAndPrixProduitDesc();
	}
	
	@Override
	public ProduitDTO convertEntityToDto (Produit p) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDTO produitDto = modelMapper.map(p, ProduitDTO.class);
		
		return produitDto;
		
		/*
		ProduitDTO produitDto = new ProduitDTO();
		
		produitDto.setNomProduit(p.getNomProduit());
		produitDto.setPrixProduit(p.getPrixProduit());
		produitDto.setDateCreation(p.getDateCreation());
		produitDto.setCategorie(p.getCategorie());
		
		return ProduitDTO.builder()
				.idProduit(p.getIdProduit())
				.nomProduit(p.getNomProduit())
				.prixProduit(p.getPrixProduit())
				.dateCreation(p.getDateCreation())
				.categorie(p.getCategorie())
				.build() ;
		*/
	}
	
	@Override
	public Produit convertDtoToEntity(ProduitDTO produitDto) {
		Produit produit = new Produit();
		
		produit.setIdProduit(produitDto.getIdProduit());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixProduit(produitDto.getPrixProduit());
		produit.setDateCreation(produitDto.getDateCreation());
		produit.setCategorie(produitDto.getCategorie());
		
		return produit;
	}

}


/*
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public Produit saveProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public Produit getProduit(Long id) {
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> getAllProduits() {
		return produitRepository.findAll();
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> findByNomProduitAscAndPrixProduitDesc() {
		return produitRepository.findByNomProduitAscAndPrixProduitDesc();
	}
	
	@Override
	public ProduitDTO convertEntityToDto (Produit p) {
		
		ProduitDTO produitDto = new ProduitDTO();
		
		produitDto.setNomProduit(p.getNomProduit());
		produitDto.setPrixProduit(p.getPrixProduit());
		produitDto.setDateCreation(p.getDateCreation());
		produitDto.setCategorie(p.getCategorie());
		
		return ProduitDTO.builder()
				.idProduit(p.getIdProduit())
				.nomProduit(p.getNomProduit())
				.prixProduit(p.getPrixProduit())
				.dateCreation(p.getDateCreation())
				.categorie(p.getCategorie())
				.build() ;
	}

}*/
