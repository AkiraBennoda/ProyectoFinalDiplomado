package sgi.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import sgi.modelo.entidades.Persona;

public class XlsView extends AbstractXlsView {
	
	@Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // cambiar nombre de archivo
        response.setHeader("Content-Disposition", "attachment; filename=\"personas.xls\"");

        // crear una pagina excel
        Sheet sheet = workbook.createSheet("Lista Personas");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("Edad");
        header.createCell(2).setCellValue("Correo Electronico");
        header.createCell(3).setCellValue("Rfc");
        header.createCell(4).setCellValue("Genero");
        header.createCell(5).setCellValue("Nacionalidad");
        header.createCell(6).setCellValue("Pais");
        header.createCell(7).setCellValue("Estado");
        header.createCell(8).setCellValue("Localidad");
        header.createCell(9).setCellValue("Calle");
        header.createCell(10).setCellValue("Codigo Postal");
        header.createCell(11).setCellValue("Num. Ext.");
        header.createCell(12).setCellValue("Num. Int.");
   
        

        int count_row = 1;

        for (Persona persona : (List<Persona>) model.get("personasList")) {
            Row productoRow = sheet.createRow(count_row++);
            productoRow.createCell(0).setCellValue(persona.getNombre());
            productoRow.createCell(1).setCellValue(persona.getEdad());
            productoRow.createCell(2).setCellValue(persona.getCorreoElectronico());
            productoRow.createCell(3).setCellValue(persona.getRfc());
            productoRow.createCell(4).setCellValue(persona.getIdGenero().getNombre());
            productoRow.createCell(5).setCellValue(persona.getIdNacionalidad().getNombre());
            productoRow.createCell(6).setCellValue(persona.getPais());
            productoRow.createCell(7).setCellValue(persona.getEstado());
            productoRow.createCell(8).setCellValue(persona.getLocalidad());
            productoRow.createCell(9).setCellValue(persona.getCalle());
            productoRow.createCell(10).setCellValue(persona.getCodigoPostal());
            
            if(persona.getNumExt() != null)
            {
            	 productoRow.createCell(11).setCellValue(persona.getNumExt().toString());
            }
            
            if(persona.getNumInt() != null)
            {
            	 productoRow.createCell(12).setCellValue(persona.getNumInt().toString());
            }
            
           
         
        }
    }

}
