package com.crud.chamados.controller;

import java.util.List;

import com.crud.chamados.model.User;
import com.crud.chamados.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserRepository repository;

	@GetMapping("/all")
	public List<User> getAllUsers()
	{
		return repository.findAll();
	}


	//Retorna o usuária pelo ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id)
	{
		//verifica se existe o usuário
		if (repository.findById(id).isPresent())
		{
			return repository.findById(id).get();
		}
		return null;
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User user)
	{
		return repository.save(user);
	}

	//Atualiza o usuário
	@PutMapping("/update")
	public String updateUser(@RequestBody User user)
	{
		//verifica se existe o usuário
		if (repository.findById(user.getId()).isPresent())
		{
			repository.save(user);
			return "Usuário atualizado com sucesso!";
		}
		return "Usuário não encontrado!";
	}

	//Deleta o usuário
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		//verifica se existe o usuário
		if (repository.findById(id).isPresent())
		{
			repository.deleteById(id);
			return "Usuário deletado com sucesso!";
		}
		return "Usuário não encontrado!";
	}
}
