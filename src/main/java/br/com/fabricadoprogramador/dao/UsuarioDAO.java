package br.com.fabricadoprogramador.dao;

import br.com.fabricadoprogramador.entidade.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import antlr.collections.List;

@Repository
public class UsuarioDAO {
	// Fala p spring injetar o EntityManager
	@PersistenceContext
	EntityManager em;

	public UsuarioDAO(EntityManager em) { 
		this.em = em;
	}

	// Insert ou Update
	public void salvar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario); // método merge() do entity é inteligente o
							// suficiente para cadastrar um novo ou editar o
							// usuario
		
		em.getTransaction().commit();
	}

	
	public Usuario buscaPorId(int id) {
		return em.find(Usuario.class, id);

	}

	public List buscaTodos() {
		Query q = em.createQuery("select u from Usuario u"); // Consulta JPQL, linguagem Java para consulta
		return (List) q.getResultList(); // retorna o resultado em um lista

	}

	public void exclui(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();

	}
}
