package exercici5;

public class EXERCICI5 {
	static final float MAX_TEMPERATURA = 40, MIN_TEMPERATURA = -10;
	public static void main(String[] args) {
		float temperatures[]= new float[13];
		
		// Omplir array
		omplirArray(temperatures);
	
		//Visualizar el Array
		visualitzarArray(temperatures);
		
		//Cridem la funció que ens calculi tots els màxims, mínims, mitjanes,... de les temperatures
		System.out.println("El número de messos en el qual la temperatura és inferior a la mitjana de l'any, és de: " + temperaturesMitjanesMaxMin(temperatures));
		System.out.println("---------------------------------------------------------------------");
	}
	public static int temperaturesMitjanesMaxMin(float [] temperaturesCalculs) {
		String mesCalid, mesFred;
		String mitjanaTemperatura;
		
		// Calcul de temperatura mínima
		mesFred = calcularMin(temperaturesCalculs);
		System.out.println("---------------TEMPERATURA MES FREDA---------------------------------");
		System.out.println("La temperatura més freda és de: " + mesFred + "ºC");
		System.out.println("---------------------------------------------------------------------");
		// Calcul de temperatura màxima
		mesCalid = calcularMax(temperaturesCalculs);
		System.out.println("---------------TEMPERATURA MES CÀLIDA--------------------------------");
		System.out.println("La temperatura més càlida és de: " + mesCalid + "ºC");
		System.out.println("---------------------------------------------------------------------");
		//Calcul de la mitjana temperatura de l'any
		mitjanaTemperatura = calcularMitjana(temperaturesCalculs);
		System.out.println("---------------TEMPERATURA MITJANA-----------------------------------");
		System.out.println("La temperatura mitjana és de: " + mitjanaTemperatura + "ºC");
		System.out.println("---------------------------------------------------------------------");
		//Calcul de quants messos hi ha per sota de la mitja
		System.out.println("---------------Nº MESOS INFERIOR MITJANA-----------------------------");
		return calculSiHiHa5SotaMitja(temperaturesCalculs,mitjanaTemperatura);
	}
	
	/*****************************************************************************************/
	/********************************Funció Omplir Array**************************************/
	/*****************************************************************************************/
	static void omplirArray(float[] temperatures) {
		float range = MAX_TEMPERATURA - MIN_TEMPERATURA;
		for (int i = 1; i <= temperatures.length - 1; i++) {
			temperatures[i] = (float) (Math.random() * range) + MIN_TEMPERATURA;
		}
	}
	/*****************************************************************************************/
	/********************************Funció Visualitzar Array*********************************/
	/*****************************************************************************************/
	static void visualitzarArray(float[] temperatures) {
		String strDouble;
		System.out.println("--------------------TEMPERATURES----------------------------------");
		for (int i = 1; i <= temperatures.length - 1; i++) {
			strDouble = String.format("%.2f", temperatures[i]);
			System.out.println("La temperatura del mes: " + i + " és de: " + strDouble + "°C");
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println();
	}
	/*****************************************************************************************/
	/******************************Funció Calcul Temp Mínima**********************************/
	/*****************************************************************************************/
	static String calcularMin(float[] temperaturesCalculs) {
		float mesFred = MAX_TEMPERATURA;
		for (int i = 1; i <= temperaturesCalculs.length - 1; i++) {
			if (temperaturesCalculs[i] < mesFred) {
				mesFred = temperaturesCalculs[i];
			}
		}
		String strDouble = String.format("%.2f", mesFred);
		return strDouble;
	}
	/*****************************************************************************************/
	/******************************Funció Calcul Temp Màxima**********************************/
	/*****************************************************************************************/
	static String calcularMax(float[] temperaturesCalculs) {
		float mesCalid = MIN_TEMPERATURA;
		for (int i = 0; i < temperaturesCalculs.length - 1; i++) {
			if (temperaturesCalculs[i] > mesCalid) {
				mesCalid = temperaturesCalculs[i];
			}
		}
		String strDouble = String.format("%.2f", mesCalid);
		return strDouble;
	}
	/*****************************************************************************************/
	/*************************Funció Calcul mitjana Tempertaura*******************************/
	/*****************************************************************************************/
	static String calcularMitjana(float[] temperaturesCalculs) {
		float sumTemperatures = 0;
		for (int i = 1; i <= temperaturesCalculs.length - 1; i++) {
			sumTemperatures += temperaturesCalculs[i];
		}
		temperaturesCalculs[12] = sumTemperatures / temperaturesCalculs.length - 1;
		String strDouble = String.format("%.2f", temperaturesCalculs[12]);
		return strDouble;
	}
	/*****************************************************************************************/
	/****************Funció Calcul si hi ha 5 mesos per sota la mitja*************************/
	/*****************************************************************************************/
	static int calculSiHiHa5SotaMitja(float[] temperaturesCalculs, String mitjanaTemperatura) {
		int numMesosMenorMitjana = 0;
		for (int i = 1; i <= temperaturesCalculs.length - 1; i++) {
			if(temperaturesCalculs[i] < temperaturesCalculs[12]) {
				numMesosMenorMitjana++;
			}
		}
		if (numMesosMenorMitjana > 5) {
			System.out.print("Winter is Coming! ");
		}
		return numMesosMenorMitjana;
	}
}
