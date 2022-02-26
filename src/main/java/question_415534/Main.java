package question_415534;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
	
	private static Date fech_prestamo;

	public static void main(String[] args) {
		try {
			System.out.println(dame_fecha("18", "12", "2020"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Calendar dame_fecha(String dia, String mes, String anio) throws ParseException {
        Calendar fechaPrestamo=Calendar.getInstance();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");			// "dd/MM/YYYY"
        int d = Integer.valueOf(dia);											// Integer.valueOf(dia)
        int m = Integer.parseInt(mes);											// Integer.valueOf(mes)
        int a = Integer.parseInt(anio);											// Integer.valueOf(anio)
        fechaPrestamo.set(Calendar.DAY_OF_MONTH, d);
        fechaPrestamo.set(Calendar.MONTH, m);
        fechaPrestamo.set(Calendar.YEAR, a);
        fechaPrestamo.setTime(formato.parse(dia + "/" + mes + "/" + anio));		// "dd/MM/YYYY"
        fech_prestamo = fechaPrestamo.getTime();

        return fechaPrestamo;
    }
}
