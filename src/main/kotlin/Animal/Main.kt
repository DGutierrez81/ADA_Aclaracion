package Animal
import org.w3c.dom.*
fun main(args: Array<String>) {
    // Creo una instancia de la clase
    val perroJuan = Animal()

    // Asigno un valor al atributo
    perroJuan.name = "Rul"

    perroJuan.nombrePropietario = "Juan"


    var perroJuan_Xml: Document = perroJuan.crearXMLAtributoAnimal()


    //LLamo al método que imprime el valor del atributo
    guardar_xml("base_datos.xml",perroJuan_Xml)

    println("Imprimo nombre del perro de Juan")
    perroJuan.imprimirNombre()

    val perroAntonio = Animal()

    println("Imprimo nombre del perro de Antonio")

    perroAntonio.imprimirNombre()

    println("imprimir nombre del perro de Antonio copiado de Juan")

    val doc = recuperar_xml("base_datos.xml")
    perroAntonio.crea_atributo_animal(doc)
    perroAntonio.imprimirNombre()
}