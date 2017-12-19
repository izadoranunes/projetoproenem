package br.com;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;

import enity.EntityManagerUtil;
import br.com.AlunoMsg;

/*@author Aline e Izadora
* @since 07 de Dezembro de 2017
*/

public class AlunoMsgBean {
 
  private static final Logger log = Logger.getLogger(AlunoMsgBean.class);
 
  private EntityManager entityManager;
 
  private AlunoMsg AlunoMsg = new AlunoMsg();
 
  String senha ="";
  
  private Long id;
 
  private List<AlunoMsg> list;
 
 /* @throws o método criou a exceção do banco de dados ao realizar o cadastro dos alunos*/ 
  public String persist() {
    log.info("Cadastrando AlunoMsg: " + AlunoMsg.getNome());
 
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().persist(AlunoMsg);
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
    log.info("Alterando AlunoMsg: " + AlunoMsg.getNome());
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().merge(AlunoMsg);
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
    log.info("Removendo AlunoMsg: " + AlunoMsg.getNome());
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().remove(AlunoMsg);
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
      log.info("Buscando lista de AlunoMsg");
      list = getEntityManager().createQuery("FROM AlunoMsg")
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
 
  public void setAlunoMsg(AlunoMsg AlunoMsg) {
    this.AlunoMsg = AlunoMsg;
  }
 
  public AlunoMsg getAlunoMsg() {
    return AlunoMsg;
  }
 
  public void setId(Long id) {
    this.id = id;
    if (id != null) {
    	AlunoMsg = getEntityManager().find(AlunoMsg.class, id);
    }
  }
 
  public Long getId() {
    return id;
  }
 
  public void newInstance() {
	  AlunoMsg = new AlunoMsg();
  }
}
