package br.com.fabricadoprogramador.dao;

import java.util.List;

import br.com.fabricadoprogramador.entidade.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO {

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

	
	public Usuario buscaPorId(Integer id) {
		return em.find(Usuario.class, id);

	}

	public List<Usuario> buscaTodos() {
		Query q = em.createQuery("select u from Usuario u"); // Consulta JPQL, linguagem Java para consulta
		return q.getResultList(); // retorna o resultado em um lista

	}

	public void exclui(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();

	}
}
