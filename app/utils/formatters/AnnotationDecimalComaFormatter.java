package utils.formatters;

import play.data.format.Formatters;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AnnotationDecimalComaFormatter extends Formatters.AnnotationFormatter<DecimalComa, BigDecimal> {

	@Override
	public BigDecimal parse(DecimalComa arg0, String value, Locale arg2) throws ParseException {
		if (value != null) {
			return new BigDecimal(value.replaceAll(",", "."));
		} else {
			return null;
		}
	}

	@Override
	public String print(DecimalComa arg0, BigDecimal value, Locale arg2) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		nf.setGroupingUsed(false);
	    return nf.format(value);
	}

}