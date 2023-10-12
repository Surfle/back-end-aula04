package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CarroDTO;
import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public List<CarroDTO> listAll(){
		List<Carro> lista = carroRepository.findAll();
		List<CarroDTO> listaDTO = new ArrayList<>();

		for(int i=0; i<lista.size(); i++) 
			listaDTO.add(this.toCarroDTO(lista.get(i)));

		return listaDTO;
	}
	
	public CarroDTO save(CarroDTO carroDTO){
		Carro carro = this.toCarro(carroDTO);

		Carro carrosalva = carroRepository.save(carro);

		return this.toCarroDTO(carrosalva);
	}
	
	public CarroDTO edit(CarroDTO carroDTO){
		Carro carro = this.toCarro(carroDTO);

		Carro carrosalva = carroRepository.save(carro);

		return this.toCarroDTO(carrosalva);
	}
	
	public String delete(long id){

		carroRepository.deleteById(id);
		
		return "OK";
	}

	private CarroDTO toCarroDTO(Carro carro) {
		CarroDTO carroDTO = new CarroDTO();
		carroDTO.setId(carro.getId());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setModelo(carro.getModelo());
		return carroDTO;
	}
	
	private Carro toCarro(CarroDTO carroDTO) {
		Carro carro = new Carro();
		carro.setId(carroDTO.getId());
		carro.setMarca(carroDTO.getMarca());
		carro.setModelo(carroDTO.getModelo());
		return carro;
	}
}
