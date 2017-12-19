package proenem.form;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;


import proenem.entity.EntityManagerUtil;
import proenem.entity.Aluno;

/* @author Aline e Izadora
* @since 07 de Dezembro de 2017
*/

public class FormularioAlunoMBean {

	  private static final Logger log = Logger.getLogger(FormularioAlunoMBean.class);
	  
	  private EntityManager entityManager;
	 
	  private Aluno aluno = new Aluno();
	 
	  private Long id;
	 
	  private List<Aluno> list;
	 
	  public String persist() {
	    log.info("Cadastrando aluno: " + aluno.getNome());
	    try {
	      EntityTransaction transacao = getEntityManager().getTransaction();
	 
	      transacao.begin();
	      getEntityManager().persist(aluno);
	      transacao.commit();
	 
	      newInstance();
	      list = null;
	 
	      return "sucesso";
	    } catch (Exception e) {
	      e.printStackTrace();
	      return "falhou";
	    }
	  }
	  /* @throws o método criou a exceção do banco de dados ao realizar a alteração de dados dos alunos*/ 
	  public String update() {
	    log.info("Alterando aluno: " + aluno.getNome());
	    try {
	      EntityTransaction transacao = getEntityManager().getTransaction();
	 
	      transacao.begin();
	      getEntityManager().merge(aluno);
	      transacao.commit();
	 
	      newInstance();
	 
	      return "sucesso";
	    } catch (Exception e) {
	      e.printStackTrace();
	      return "falhou";
	    }
	  }
	 
	  /* @throws o método criou a exceção do banco de dados quando um aluno teve seu cadastro removido*/ 
	  public String remove() {
	    log.info("Removendo aluno: " + aluno.getNome());
	    try {
	      EntityTransaction transacao = getEntityManager().getTransaction();
	 
	      transacao.begin();
	      getEntityManager().remove(aluno);
	      transacao.commit();
	 
	      newInstance();
	      list = null;
	 
	      return "sucesso";
	    } catch (Exception e) {
	      e.printStackTrace();
	      return "falhou";
	    }
	  }
	 
	  /* O método criou a lista com os alunos cadastrados
	   * @return String List
	   * 
	   * */ 
	  @SuppressWarnings("unchecked")
	  public List getList() {
	    if (list == null) {
	      log.info("Buscando lista de alunos");
	      list = getEntityManager().createQuery("FROM Aluno")
	        .getResultList();
	    }
	 
	    return list;
	  }
	 
	  public EntityManager getEntityManager() {
	    if (entityManager == null) {
	      entityManager = EntityManagerUtil.getInstance().createEntityManager();
	    }
	 
	    return entityManager;
	  }
	 
	  public void setAluno(Aluno aluno) {
	    this.aluno = aluno;
	  }
	 
	  public Aluno getAluno() {
	    return aluno;
	  }
	 
	  public void setId(Long id) {
	    this.id = id;
	    if (id != null) {
	    	aluno = getEntityManager().find(Aluno.class, id);
	    }
	  }
	 
	  public Long getId() {
	    return id;
	  }
	 
	  public void newInstance() {
		  aluno = new Aluno();
	  }
	}