package br.com;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import enity.Aluno;



/**
 * Classe com métodos úteis relativos a usuários do sistema.
 * @author Renan
 */
public class UsuarioUtil {
	
	public static String md5(String senha) throws NoSuchAlgorithmException  {  
		MessageDigest messageDigest  = MessageDigest.getInstance("MD5");  
		BigInteger hash = new BigInteger(1, messageDigest.digest(senha.getBytes()));  
		return  hash.toString(16);  
	} 

	public static Aluno getAlunoLogado(){
		if (FacesContext.getCurrentInstance() == null)
			return null;
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return (Aluno) req.getSession().getAttribute("alunoLogado");
	}
	
	
	
}
