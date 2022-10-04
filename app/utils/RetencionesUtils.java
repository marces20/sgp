package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RetencionesUtils {
	
	public static final Integer CUENTA_DGR_SELLOS = 263;
	public static final Integer CUENTA_DGR_CM_196 = 110;
	public static final Integer CUENTA_AFIP_SUSS_6_1556 = 260;
	public static final Integer CUENTA_AFIP_SUSS_2 = 259;
	public static final Integer CUENTA_AFIP_IVA_868 = 258;
	public static final Integer CUENTA_AFIP_SUSS_6_1769 = 109;
	public static final Integer CUENTA_AFIP_GCIAS_2 = 108;

	public static BigDecimal getBaseByRentecion(BigDecimal r,Integer c) {
		BigDecimal b = new BigDecimal(0);
		switch (c) {
			case 263:
				b = r.divide(new BigDecimal(0.005), 3, RoundingMode.HALF_UP);
				break;
			case 110:
				b = r.divide(new BigDecimal(0.0169), 4, RoundingMode.HALF_UP);
				break;
			case 260:
				b = r.divide(new BigDecimal(0.06), 2, RoundingMode.HALF_UP);		
				break;
			case 259:
				b = r.divide(new BigDecimal(0.02), 2, RoundingMode.HALF_UP);
				break;
			case 258:
				b = r.divide(new BigDecimal(0.06), 2, RoundingMode.HALF_UP);
				break;
			case 109:
				b = r.divide(new BigDecimal(0.0868), 4, RoundingMode.HALF_UP);
				break;
			case 108:
				b = r.divide(new BigDecimal(0.02), 2, RoundingMode.HALF_UP);
				break;
	
			default:
				break;
		}
		return b;
	}
}
