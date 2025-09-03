package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberUtils {

	public static String agregarCerosAlaIzquierda(int numero,int cantidadDeDigitos) {
		String x = Integer.toString(numero);

		if(x.length() < cantidadDeDigitos) {
			int len = x.length();
			String z = "";
			while(len < cantidadDeDigitos) {
				z += "0";
				len ++;
			}
			x = z+x;

		}


		return x;
	}

	public static BigDecimal roundTo(int decimals, BigDecimal bd) {
	    //BigDecimal bd = new BigDecimal(num);
	    bd = bd.setScale(decimals, RoundingMode.HALF_UP);
	    return bd;
	}

	public static double roundDouble(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public static String formatNumber(Double number,int decimales) {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		DecimalFormat myFormatter = new DecimalFormat("###,###,##0.0",simbolos);
		switch ( decimales ) {
		 case 0:
	    	   myFormatter = new DecimalFormat("###,###,##0",simbolos);
	           break;
	      case 1:
	    	   myFormatter = new DecimalFormat("###,###,##0.0",simbolos);
	           break;
	      case 2:
	    	   myFormatter = new DecimalFormat("###,###,##0.00",simbolos);
	           break;
	      case 3:
	    	   myFormatter = new DecimalFormat("###,###,##0.000",simbolos);
	           break;
	      case 4:
	    	   myFormatter = new DecimalFormat("###,###,##0.0000",simbolos);
	           break;
	      default:
	           System.out.println("error" );
	           break;
	      }

		String output = myFormatter.format(number);

		return output;
	}

	public static String formatNumber(Double number) {
		return formatNumber(number,2);
	}

	public static String moneda(BigDecimal monto, int maximoFraccion, Integer tipo_moneda){
		monto = (monto == null || monto.compareTo(BigDecimal.ZERO) == 0)?new BigDecimal(0):monto;

		Currency currency = Currency.getInstance("ARS");
		if (tipo_moneda.equals(1)) {
			currency = Currency.getInstance("USD");
		}else if(tipo_moneda.equals(2)) {
			currency = Currency.getInstance("EUR");
		}


		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
		numberFormat.setMaximumFractionDigits(maximoFraccion);
		numberFormat.setCurrency(currency);
		numberFormat.setRoundingMode(RoundingMode.HALF_UP);
		return numberFormat.format(monto);
	}

	public static String monedaSinDecimales(BigDecimal monto){
		return transFormarMoneda(monto, 0, 0);
	}

	public static String moneda(BigDecimal monto){
		return transFormarMoneda(monto, 2, 0);
	}

	public static String moneda(BigDecimal monto, Integer tipo_moneda){
		return transFormarMoneda(monto, 2, tipo_moneda);
	}

	public static String moneda(BigDecimal monto, int maximoFraccion){
		return transFormarMoneda(monto, maximoFraccion, 0);
	}

	public static String transFormarMoneda(BigDecimal monto, int maximoFraccion, Integer tipo_moneda){
		monto = (monto == null || monto.compareTo(BigDecimal.ZERO) == 0)?new BigDecimal(0):monto;

		Currency currency = Currency.getInstance("ARS");
		if (tipo_moneda.equals(1)) {
			currency = Currency.getInstance("USD");
		}else if(tipo_moneda.equals(2)) {
			currency = Currency.getInstance("EUR");
		}

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
		numberFormat.setMaximumFractionDigits(maximoFraccion);
		numberFormat.setCurrency(currency);
		numberFormat.setRoundingMode(RoundingMode.HALF_UP);
		return numberFormat.format(monto);
	}

	public static boolean isInteger(String s) {
	    try {
	        Integer.parseInt(s);
	    } catch(NumberFormatException e) {
	        return false;
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}


}
