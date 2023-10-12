package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.LivroDTO;
import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public List<LivroDTO> listAll(){
		List<Livro> lista = livroRepository.findAll();
		List<LivroDTO> listaDTO = new ArrayList<>();

		for(int i=0; i<lista.size(); i++) 
			listaDTO.add(this.toLivroDTO(lista.get(i)));

		return listaDTO;
	}
	
	public LivroDTO save(LivroDTO livroDTO){
		Livro livro = this.toLivro(livroDTO);

		Livro livrosalva = livroRepository.save(livro);

		return this.toLivroDTO(livrosalva);
	}
	
	public LivroDTO edit(LivroDTO livroDTO){
		Livro livro = this.toLivro(livroDTO);

		Livro livrosalva = livroRepository.save(livro);

		return this.toLivroDTO(livrosalva);
	}
	
	public String delete(long id){

		livroRepository.deleteById(id);
		
		return "OK";
	}

	private LivroDTO toLivroDTO(Livro livro) {
		LivroDTO livroDTO = new LivroDTO();
		livroDTO.setId(livro.getId());
		livroDTO.setNome(livro.getNome());
		livroDTO.setAutor(livro.getAutor());
		return livroDTO;
	}
	
	private Livro toLivro(LivroDTO livroDTO) {
		Livro livro = new Livro();
		livro.setId(livroDTO.getId());
		livro.setNome(livroDTO.getNome());
		livro.setAutor(livroDTO.getAutor());
		return livro;
	}

}
