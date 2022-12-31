package sgi.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import sgi.modelo.entidades.Persona;

public class PdfView extends AbstractPdfView {

	@Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document ,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Persona> personas = (List<Persona>) model.get("personasList");

        PdfPTable table = new PdfPTable(12);
        
        table.addCell("Nombre");
        table.addCell("Edad");
        table.addCell("Correo Electronico");
        table.addCell("Rfc");
        table.addCell("Genero");
        table.addCell("Nacionalidad");
        table.addCell("Pais");
        table.addCell("Estado");
        table.addCell("Localidad");
        table.addCell("Calle");
        table.addCell("Codigo Postal");
        table.addCell("Num. Ext.");
        table.addCell("Num. Int.");

        for(Persona persona : personas ) {
        	table.addCell(persona.getNombre());
            table.addCell(persona.getEdad().toString());
            table.addCell(persona.getCorreoElectronico());
            table.addCell(persona.getRfc());
            table.addCell(persona.getIdGenero().getNombre());
            table.addCell(persona.getIdNacionalidad().getNombre());
            table.addCell(persona.getPais());
            table.addCell(persona.getEstado());
            table.addCell(persona.getLocalidad());
            table.addCell(persona.getCalle());
            table.addCell(persona.getCodigoPostal().toString());
            
            if(persona.getNumExt() != null)
            {
            	table.addCell(persona.getNumExt().toString());
            }
            
            if(persona.getNumInt() != null)
            {
            	  table.addCell(persona.getNumInt().toString());
            }
            
 
        }
        
    
        document.add(table);
    }
	
}
