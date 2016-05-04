package br.com.fabricadoprogramador.dao;

import br.com.fabricadoprogramador.entidade.Usuario;
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
public class UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	// Insert ou Update
	@Transactional
	public Usuario salvar(Usuario usuario) {
		// em.getTransaction().begin();
		em.persist(usuario); // método merge() do entity é inteligente o
							// suficiente para cadastrar um novo ou editar o
							// usuario

		// em.getTransaction().commit();
		return usuario;
	}

	public Usuario buscaPorId(int id) {
		return em.find(Usuario.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		Query q = em.createQuery("select u from Usuario u"); // Consulta JPQL,
																// linguagem
																// Java para
																// consulta
		return (List<Usuario>) q.getResultList(); // retorna o resultado em um lista

	}

	@Transactional
	public void exclui(Usuario usuario) throws DAOException{
		try{
			// em.getTransaction().begin();
			em.remove(usuario);
			// em.getTransaction().commit()
		}catch(Exception e){
			throw new DAOException("Não foi possível excluir!");
		}
		

	}

	@Transactional
	public Usuario buscaLogin(String login) throws DAOException {
		try {
			// 1) Consulta JPQL
			String jpql = "Select u from Usuario u where u.login=:loginParam";
			// 2) Criando objeto de consulta a partir do JPQL, linguagem SQL do
			// JPA
			Query consulta = em.createQuery(jpql);
			// 3) Substituindo o parametro do m�todo String login, pelo
			// parametro do JPQL :loginParam
			consulta.setParameter("loginParam", login);
			// 4) Retornando um �nico registro como resultado getSingleResult,
			// convertido para Usuario

			return (Usuario) consulta.getSingleResult();

		} catch (NoResultException e) {
			// Queremos tratar como Nulo quando o objeto n�o existir no banco
			return null;
		} catch (NonUniqueResultException e) {
			throw new DAOException("Mais de um usu�rio encontrado", e);
		} catch (Exception e) {
			// Outra exception ocorreu.
			throw new DAOException(e);
		}

	}

}
