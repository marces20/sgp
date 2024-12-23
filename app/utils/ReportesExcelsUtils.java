package utils;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

public class ReportesExcelsUtils {

	public CellStyle getCabecera(Workbook libro,int size ) {

		CellStyle estiloCabecera = libro.createCellStyle();
		estiloCabecera.setDataFormat((short) 7);
		estiloCabecera.setBorderRight(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderLeft(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderTop(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderBottom(CellStyle.BORDER_THIN);
		estiloCabecera.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		estiloCabecera.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)size);
		estiloCabecera.setFont(font);
		estiloCabecera.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		estiloCabecera.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		estiloCabecera.setWrapText(true);

		return estiloCabecera;
	}

	public CellStyle getCabeceraSinFondoGris(Workbook libro,int size ) {

		CellStyle estiloCabecera = libro.createCellStyle();
		estiloCabecera.setDataFormat((short) 7);
		estiloCabecera.setBorderRight(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderLeft(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderTop(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderBottom(CellStyle.BORDER_THIN);
		//estiloCabecera.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		//estiloCabecera.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)size);
		estiloCabecera.setFont(font);
		estiloCabecera.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		estiloCabecera.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		estiloCabecera.setWrapText(true);

		return estiloCabecera;
	}

	public CellStyle getCabeceraSinDecimales(Workbook libro,int size ) {
		DataFormat format = libro.createDataFormat();
		CellStyle estiloCabecera = libro.createCellStyle();
		estiloCabecera.setDataFormat(format.getFormat("#,##0"));
		estiloCabecera.setBorderRight(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderLeft(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderTop(CellStyle.BORDER_THIN);
		estiloCabecera.setBorderBottom(CellStyle.BORDER_THIN);
		estiloCabecera.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		estiloCabecera.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)size);
		estiloCabecera.setFont(font);
		estiloCabecera.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		estiloCabecera.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		estiloCabecera.setWrapText(true);

		return estiloCabecera;
	}

	public CellStyle getEstiloMonedaSinDecimales(Workbook libro) {
		DataFormat format = libro.createDataFormat();
		CellStyle estiloMoneda = libro.createCellStyle();
		estiloMoneda.setDataFormat(format.getFormat("$#,##0"));
		estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
		estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
		estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
		estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
		estiloMoneda.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		estiloMoneda.setFont(font);

		return estiloMoneda;
	}

	public CellStyle getEstiloMoneda(Workbook libro) {
		DataFormat format = libro.createDataFormat();
		CellStyle estiloMoneda = libro.createCellStyle();
		estiloMoneda.setDataFormat((short) 7);
		estiloMoneda.setBorderRight(CellStyle.BORDER_THIN);
		estiloMoneda.setBorderLeft(CellStyle.BORDER_THIN);
		estiloMoneda.setBorderTop(CellStyle.BORDER_THIN);
		estiloMoneda.setBorderBottom(CellStyle.BORDER_THIN);
		estiloMoneda.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		estiloMoneda.setFont(font);

		return estiloMoneda;
	}

	public CellStyle getEstiloComun(Workbook libro) {
		CellStyle comun = libro.createCellStyle();
		comun.setBorderRight(CellStyle.BORDER_THIN);
		comun.setBorderLeft(CellStyle.BORDER_THIN);
		comun.setBorderTop(CellStyle.BORDER_THIN);
		comun.setBorderBottom(CellStyle.BORDER_THIN);
		comun.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		comun.setWrapText(true);
		return comun;
	}

	public  CellStyle getEstiloConFondo(Workbook libro) {
		CellStyle style = libro.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);

		return style;
	}

	public  CellStyle getEstiloMonedaConFondo(Workbook libro) {
		CellStyle estiloMonedaConFondo = libro.createCellStyle();
		estiloMonedaConFondo.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		estiloMonedaConFondo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		estiloMonedaConFondo.setDataFormat((short) 7);
		estiloMonedaConFondo.setBorderRight(CellStyle.BORDER_THIN);
		estiloMonedaConFondo.setBorderLeft(CellStyle.BORDER_THIN);
		estiloMonedaConFondo.setBorderTop(CellStyle.BORDER_THIN);
		estiloMonedaConFondo.setBorderBottom(CellStyle.BORDER_THIN);
		estiloMonedaConFondo.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = (HSSFFont) libro.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		estiloMonedaConFondo.setFont(font);

		return estiloMonedaConFondo;
	}
}
