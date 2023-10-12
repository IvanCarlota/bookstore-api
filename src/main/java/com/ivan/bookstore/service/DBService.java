package com.ivan.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.bookstore.domain.Categoria;
import com.ivan.bookstore.domain.Livro;
import com.ivan.bookstore.repositories.CategoriaRepository;
import com.ivan.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Teologia", "Livros de Teologia");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

		Livro l1 = new Livro(null, "Entendes o que lês?", "Gordon D. Fee & Douglas Stuart", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "As institutas", "João Calvino", "Lorem ipsum", cat1);
		Livro l5 = new Livro(null, "Steve Jobs", "Steve Jobs", "Lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l4));
		cat2.getLivros().addAll(Arrays.asList(l2, l3));
		cat3.getLivros().addAll(Arrays.asList(l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
	}
	
}
