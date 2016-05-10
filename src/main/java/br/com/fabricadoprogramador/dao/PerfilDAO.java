package br.com.fabricadoprogramador.dao;

import br.com.fabricadoprogramador.entidade.Perfil;
import br.com.fabricadoprogramador.exception.DAOException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // carregado no contexto do spring
public class PerfilDAO {

	@PersistenceContext
	EntityManager em;

	// Insert ou Update
	@Transactional
	public Perfil salvar(Perfil perfil) {
		// em.getTransaction().begin();
		perfil = em.merge(perfil); // método merge() do entity é inteligente o
							// suficiente para cadastrar um novo ou editar o
							// Perfil

		// em.getTransaction().commit();
		return perfil;
	}

	public Perfil buscaPorId(int id) {
		return em.find(Perfil.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Perfil> buscarTodos() {
		Query q = em.createQuery("select p from Perfil p"); // Consulta JPQL,
																// linguagem
																// Java para
																// consulta
		return (List<Perfil>) q.getResultList(); // retorna o resultado em um lista

	}

	@Transactional
	public void exclui(Perfil Perfil) throws DAOException{
		try{
			// em.getTransaction().begin();
			Perfil pAExcluir = em.find(Perfil.class, Perfil.getId()); 
			em.remove(pAExcluir);
			// em.getTransaction().commit()
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}
		

	}

}
