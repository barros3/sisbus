import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.br.pb.sisbus.system.dao.services.impl.SystemSisBusQuadroHorarioGeradoServiceImpl;

public class RunTeste {

	/*
	// public static void main(String[] args) {
	// Result result = JUnitCore.runClasses(TesteQuadroHorario.class);
	// for (Failure failure : result.getFailures()) {
	// System.out.println(failure.toString());
	// }
	// }

	public static void main(String[] args) {
		SystemSisBusQuadroHorarioGeradoServiceImpl s = new SystemSisBusQuadroHorarioGeradoServiceImpl();
		try {
			String data = "2000-12-12";
			SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = ss.parse(data);
			int t = s.listaQuantidadeFuncionarioEscaladoDia(dates);
			System.out.println("teste: " + t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	*/
}
