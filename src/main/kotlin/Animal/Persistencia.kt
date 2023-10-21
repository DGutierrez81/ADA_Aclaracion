package Animal

import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import org.w3c.dom.*
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory


/**
 * Guarda el Documento XML creado en un archivo creado.
 * @param nombreFichero recibe el nombre que se quiere dar al archivo a guardar.
 * @param doc recibe el documento  fuente (de tipo Document) para transformarlo a XML.
 */
fun guardar_xml(nombreFichero:String, doc:Document){
    // Crear el archivo base_datos.xml y guardarlo
    val file = File(nombreFichero)
    val transformer = TransformerFactory.newInstance().newTransformer()
    val result = StreamResult(file)
    val source = DOMSource(doc)
    transformer.transform(source, result)
}

/**
 * Recibe un archivo XML y crea un nuevo objeto de tipo Document.
 * @param recibe el nombre o dirección del fichero.
 */

fun recuperar_xml(nombreFichero: String): Document{
    val archivoXML = File(nombreFichero)
    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()
    val doc: Document = builder.parse(archivoXML)
    return doc
}