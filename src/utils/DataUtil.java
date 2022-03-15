package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    public static String converterDateParaDataEHora(Date data){
        // 01/01/2021 12:00 hrs
        // HH upercase formato 24:00 hh lowcase 12:00
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatador.format(data);
    }
    public static String converterDateParaData(Date data){
        // 01/01/2021 12:00 hrs
        // HH upercase formato 24:00 hh lowcase 12:00
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }
    public static String converterDateHora(Date data){
        // 01/01/2021 12:00 hrs
        // HH upercase formato 24:00 hh lowcase 12:00
        SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss");
        return formatador.format(data);
    }


}
