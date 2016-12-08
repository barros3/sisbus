import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;

public class TesteQuadroHorario {
/*
//	@Test
//	public void main() {
//		SystemSisBusQuadroHorarioGeradoImpl s = new SystemSisBusQuadroHorarioGeradoImpl();
//		try {
//			String data = "2000-12-12";
//			SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
//			Date dates = ss.parse(data);
//			int t = s.listaQuantidadeFuncionarioEscaladoDia(dates);
//			System.out.println("teste: " + t);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
	
	@PersistenceContext
	private EntityManager manager;;
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	@Test
	public void main() {
		Query resultSize = null;
		try{
			String data = "2000-12-12";
			SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = ss.parse(data);
			resultSize =  manager.
					createNamedQuery("SELECT e FROM Escala e where e.dataEscala = 1?").setParameter(1, dates);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(resultSize.getMaxResults());
	}
	*/
}