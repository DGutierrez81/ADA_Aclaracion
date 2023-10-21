package Animal

import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.*

class Animal {
    // Declaración de un  atributo de tipo String
    var name = "Sin nombre"

    var nombrePropietario = "Sin nombre"

    // Método que imprime el valor del atributo

    fun imprimirNombre(){
        println("El nombre del animal es: $name\nEl nombre del propietario es: $nombrePropietario")
    }

    /**
     * Se crea el documento XML y retorna un objeto de tipo Document.
     */

    fun crearXMLAtributoAnimal(): Document{
        val factory = DocumentBuilderFactory.newInstance()

        val builder = factory.newDocumentBuilder()

        val doc: Document = builder.newDocument()

        val rootElement: Element = doc.createElement("root")

        val animal: Element = doc.createElement("nombre_animal")

        val hijo: Element = doc.createElement("nombre_propietario")
        hijo.textContent = nombrePropietario

        animal.textContent = name

        doc.appendChild(rootElement)
        rootElement.appendChild(animal)
        rootElement.appendChild(hijo)
        doc.normalize()

        return doc
    }


    /**
     * Recupera(accede a la información) el valor del contenido del XML para introducirlo en los atributos de la clase.
     * @param Recibe el documento XML de donde se extrae los datos.
     */
    fun crea_atributo_animal(doc: Document){
        val elementosNombreAnimal: NodeList = doc.getElementsByTagName("nombre_animal")

        val elementosNombreDuenio: NodeList = doc.getElementsByTagName("nombre_propietario")

        // Obtener el primer elemento "nombre_animal" (suponiendo que solo hay uno)
        val elementoNombreAnimal: Element = elementosNombreAnimal.item(0) as Element

        val elementoNombreDuenio: Element = elementosNombreDuenio.item(0) as Element


        // Obtener el valor dentro del elemento "nombre-animal"
        val valor = elementoNombreAnimal.textContent

        val valorP = elementoNombreDuenio.textContent

        nombrePropietario = valorP

        name = valor
    }
}