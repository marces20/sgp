/**
 * FUNCIÓN EXPORTAR A PDF — RRHH Dashboard
 * ----------------------------------------
 * Dependencias (agregar en el <head> antes de este script):
 *
 *   <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
 *   <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
 *
 * Uso: llamar exportarPDF() desde un botón, por ejemplo:
 *   <button onclick="exportarPDF()">Exportar PDF</button>
 */

function exportarPDF() {

  // 1. Referencia al contenedor principal
  const elemento = document.querySelector('.main');
  if (!elemento) {
    alert('No se encontró el contenedor .main');
    return;
  }

  // 2. Mostrar indicador de carga
  const btnExportar = document.getElementById('btnExportarPDF');
  if (btnExportar) {
    btnExportar.disabled = true;
    btnExportar.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Generando PDF...';
  }

  // 3. Opciones de captura html2canvas
  const opcionesCaptura = {
    scale: 2,                  // Mayor resolución (2x)
    useCORS: true,             // Permite imágenes cross-origin (logos, etc.)
    allowTaint: true,
    backgroundColor: '#f0f4f8',
    logging: false,
    scrollX: 0,
    scrollY: -window.scrollY,  // Captura desde el top sin importar el scroll actual
    windowWidth: elemento.scrollWidth,
    windowHeight: elemento.scrollHeight
  };

  html2canvas(elemento, opcionesCaptura).then(function(canvas) {

    const { jsPDF } = window.jspdf;

    // 4. Dimensiones del canvas capturado
    const imgWidth  = canvas.width;
    const imgHeight = canvas.height;

    // 5. Configurar PDF en orientación horizontal (landscape) para tablas anchas
    //    Cambiar a 'portrait' si se prefiere vertical
    const orientacion  = imgWidth > imgHeight ? 'landscape' : 'portrait';
    const pdf          = new jsPDF(orientacion, 'px', [imgWidth / 2, imgHeight / 2]);

    const pdfAncho     = pdf.internal.pageSize.getWidth();
    const pdfAlto      = pdf.internal.pageSize.getHeight();

    const imgData      = canvas.toDataURL('image/jpeg', 0.95);

    // 6. Si el contenido cabe en una sola página
    if (imgHeight / 2 <= pdfAlto) {

      pdf.addImage(imgData, 'JPEG', 0, 0, pdfAncho, pdfAlto);

    } else {

      // 7. Contenido multi-página: dividir el canvas en páginas
      let posicionY   = 0;
      const altoPixelPorPagina = pdfAlto * 2; // escala inversa (scale=2)

      while (posicionY < imgHeight) {

        // Crear canvas parcial para esta página
        const canvasPagina    = document.createElement('canvas');
        canvasPagina.width    = imgWidth;
        canvasPagina.height   = Math.min(altoPixelPorPagina, imgHeight - posicionY);

        const ctx = canvasPagina.getContext('2d');
        ctx.drawImage(
          canvas,
          0, posicionY,                   // origen en el canvas original
          imgWidth, canvasPagina.height,  // tamaño a copiar
          0, 0,                           // destino en el canvas de página
          imgWidth, canvasPagina.height   // tamaño destino
        );

        const imgPagina    = canvasPagina.toDataURL('image/jpeg', 0.95);
        const altoRelativo = (canvasPagina.height / 2);

        if (posicionY > 0) pdf.addPage([pdfAncho, altoRelativo], orientacion);

        pdf.addImage(imgPagina, 'JPEG', 0, 0, pdfAncho, altoRelativo);

        posicionY += altoPixelPorPagina;
      }
    }

    // 8. Nombre del archivo con fecha y hora
    const ahora    = new Date();
    const fecha    = ahora.toLocaleDateString('es-AR').replace(/\//g, '-');
    const hora     = ahora.toTimeString().substring(0, 5).replace(':', '-');
    const nombreArchivo = 'RRHH_Informe_' + fecha + '_' + hora + '.pdf';

    pdf.save(nombreArchivo);

    // 9. Restaurar botón
    if (btnExportar) {
      btnExportar.disabled = false;
      btnExportar.innerHTML = '<i class="fas fa-file-pdf"></i> Exportar PDF';
    }

  }).catch(function(error) {
    console.error('Error al generar PDF:', error);
    alert('Error al generar el PDF. Ver consola para detalles.');
    if (btnExportar) {
      btnExportar.disabled = false;
      btnExportar.innerHTML = '<i class="fas fa-file-pdf"></i> Exportar PDF';
    }
  });
}
