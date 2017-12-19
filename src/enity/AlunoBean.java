package enity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;

import br.com.UsuarioUtil;
import enity.EntityManagerUtil;
import enity.Aluno;
 
public class AlunoBean {
 
  private static final Logger log = Logger.getLogger(AlunoBean.class);
 
  private EntityManager entityManager;
 
  private Aluno aluno = new Aluno();
 
  String senha = "";
  
  private Long id;
 
  private List<Aluno> list;
 
  public String persist() {
    log.info("Cadastrando aluno: " + aluno.getNome());
    try {
    	senha = UsuarioUtil.md5(aluno.getSenha());
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      aluno.setSenha(senha);
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
 
  public String update() {
    log.info("Alterando aluno: " + aluno.getNome());
    try {
    	senha = UsuarioUtil.md5(aluno.getSenha());
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      aluno.setSenha(senha);
      getEntityManager().merge(aluno);
      transacao.commit();
 
      newInstance();
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
 
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
 
  @SuppressWarnings("unchecked")
  public List getList() {
    if (list == null) {
      log.info("Buscando lista de Aluno");
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
 
  public void setAlunoa(Aluno aluno) {
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