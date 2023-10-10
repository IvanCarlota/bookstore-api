package com.ivan.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ivan.bookstore.domain.Categoria;
import com.ivan.bookstore.domain.Livro;
import com.ivan.bookstore.repositories.CategoriaRepository;
import com.ivan.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	public void run(String... args)throws Exception{
		Categoria cat1 = new Categoria(null, "Teologia", "Livros de Teologia");
		
		Livro l1 = new Livro(null, "Entendes o que lês?", "Gordon D. Fee & Douglas Stuart", "Lorem ipsum", cat1);
				
		cat1.getLivros().addAll(Arrays.asList(l1));
				
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
	
}
