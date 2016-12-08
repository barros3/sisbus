package com.br.pb.sisbus.daos.services;

import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.ConfigQuadroHorarioDao;
import com.br.pb.sisbus.models.ConfigQuadroHorario;

@Service
public class ConfigQuadroHorarioDaoService {

	@Autowired
	private ConfigQuadroHorarioDao configQuadroHorarioDao;
	
	public final void saveConfigQuadroHorario(ConfigQuadroHorario configQuadroHorario) {
		try{
			configQuadroHorarioDao.save(configQuadroHorario);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * totalIntervalo - RESPONSAVEL POR GENRECIAR O TEMPO
	 * sumOfIntervals - SOMA INTERVALOS GERADOS NO METODO managerInputHours*/
	static Period totalIntervalo = new Period();
	public final String sumOfIntervals(Period someTime){
		totalIntervalo = totalIntervalo.plus(someTime);
		int checkMin = 0;
		if(totalIntervalo.getMinutes() > 59){			
			checkMin = (int) (totalIntervalo.getMinutes()*0.6f);
			Integer checkHora = totalIntervalo.getMinutes() / 60;
			totalIntervalo.plusHours(checkHora);
			totalIntervalo.plusMinutes(checkMin);
		}
		String valorIntervaloString = totalIntervalo.getHours() + ":" + totalIntervalo.getMinutes() + "";
		return valorIntervaloString;
	}
	
	/**
	 * METODO RESPONSAVEL POR CONTAR AS HORAS ENTRE INTERVALOS DE TEMPO
	 * */ 
	public String managerInputHours(String inputEntrada){

		/**
		 * entradaDiv - SEPARA AS HORAS
		 * entradaSubDiv - INSTANCIA ARRAY E GUARDA AS HORAS SEPARADAS
		 * */ 
		String[] entradaDiv = inputEntrada.split("\\s");
		String[] entradaSubDiv = new String[100];

		/**
		 * outputIntervalo - REFERENCIA PARA SAIDA DO INTERVALO
		 * sumIntervals - REFERENCIA PARA SOMAS OS INTERVALOS*/
		String outputIntervalo = null;
		Period horaFinal;
		
		/**
		 * for - SUBDIVIDE A ENTRADA EM OS INTERVALOS DE CADA HORA. "EX: 14:00-15:35;"
		 * */
			for (int j = 0; j < entradaDiv.length; j++) {
				
		/**
		 *  REGEX DO INTERVALO " - "
		 */
				entradaSubDiv = entradaDiv[j].split("-");
				/**
				 * REGEX - CONSIDERA A HORA DE ENTRADA E VERFICA SE ESTÁ CORRETO - SE ESTIVER SOMA AO totalIntervalo
				 * */ 
				if(entradaSubDiv[0].matches("([01][0-9]|[2][0-3]):?([0-5]\\d)\\b") 
						&& entradaSubDiv[1].matches("([01][0-9]|[2][0-3]):?([0-5]\\d)\\W")){
					entradaSubDiv[1] = entradaSubDiv[1].replace(";", "");
					/**
					 * SEPARA HORA (hourZero) E MIN (minZero) DO PRIMEIRO COMPONENTE DO ARRAY
					 * */ 
					String[] sumHourSZero = entradaSubDiv[0].split(":");
					Integer hourZero = Integer.valueOf(sumHourSZero[0]);
					Integer minZero = Integer.valueOf(sumHourSZero[1]);
					Period horaInicial = new Period(hourZero, minZero, 0, 0);
					
					/**
					 * SEPARA HORA (hourZero) E MIN (minZero) DO SEGUNDO COMPONENTE DO ARRAY
					 * */
					String[] sumHourOne = entradaSubDiv[1].split("[:\\W]");
					Integer hourOne = Integer.valueOf(sumHourOne[0]);
					Integer minOne = Integer.valueOf(sumHourOne[1]);

					horaFinal = new Period(hourOne, minOne, 0, 0);
					
					/**
					 * REALIZA DIFERENCA ENTRE O HORARIO, ATRIBUI A SOMA DOS INTERVALOS EM sumIntervals
					 * */
					horaFinal = horaFinal.minus(horaInicial);
					horaFinal = horaFinal.normalizedStandard(PeriodType.time());
					
					/**
					 * ATRIBUI O VALOR A outputIntervalo PARA O RETORNO
					 * */ 
					outputIntervalo = sumOfIntervals(horaFinal);
					System.out.println(outputIntervalo);
				}else {
					/**
					 * RETORNO PARA HORA INVÁLIDA
					 * */
					System.out.println("Datas: " + entradaSubDiv[0] + " ou " + entradaSubDiv[1] + " está(ão) em formato(s) inválido(s)!");
					break;
				}
			}
			/**RETORNA O TOTAL DO INTERVALO EM STRING E ZERA O PERIODO*/
			String valorIntervaloString = totalIntervalo.normalizedStandard(PeriodType.time()).toString().replaceAll("PT", "").replaceAll("H", ":").replaceAll("M", "");
			totalIntervalo = Period.hours(0);
			totalIntervalo = Period.minutes(0);
			
		return valorIntervaloString;			
	}
	
}
