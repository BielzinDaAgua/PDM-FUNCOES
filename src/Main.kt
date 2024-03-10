val materiasENotas = mutableMapOf<String, MutableList<Double>>()

fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return MateriasENota.put(materia, notas) != null
}

fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = MateriasENota[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}

fun mostrarNotas(materia: String) {
    if (!MateriasENota.containsKey(materia)) {
        println("Matéria $materia não encontrada")
    } else {
        val listaNotas = MateriasENota[materia]

        if (listaNotas != null) {
            var cont = 1
            var soma = 0.0
            for (nota: Double in listaNotas) {
                println("Nota $cont: $nota")
                soma += nota
                cont++
            }
            val media = soma / listaNotas.size
            println("Média: $media")
        } else {
            println("Não foi possível mostrar as notas da matéria $materia")
        }
        println()
    }
}

fun adicionarVariasNotas(materia: String, vararg nota: Double): Boolean {
    val notasDaMateria = MateriasENota[materia] ?: return false
    notasDaMateria.addAll(nota.toList())
    return true
}

fun calcularMedia(vararg materias: String): Double {
    var totalNotas = 0.0
    var totalDisciplinas = 0
    for (materia in materias) {
        val notas = MateriasENota[materia] ?: continue
        totalNotas += notas.sum()
        totalDisciplinas++
    }
    return if (totalDisciplinas > 0) totalNotas / totalDisciplinas else 0.0
}

fun main() {
    adicionarDisciplina("Matemática", mutableListOf(7.5, 8.0, 9.0))
    adicionarDisciplina(materia = "Física", notas = mutableListOf(6.5, 7.0, 8.0))
    adicionarDisciplina("Química")

    adicionarNota("Matemática", 8.5)
    adicionarNota("Física", 7.5)
    adicionarNota("Química", 9.0)

    println("Notas de Matemática:")
    mostrarNotas("Matemática")
    println("Notas de Física:")
    mostrarNotas("Física")
    println("Notas de Química:")
    mostrarNotas("Química")

    adicionarDisciplina("Biologia")
    adicionarVariasNotas("Biologia", 8.0, 7.5, 9.0)
    println("Notas de Biologia:")
    mostrarNotas("Biologia")

    val mediaMatFis = calcularMedia("Matemática", "Física")
    println("Média de Matemática e Física: $mediaMatFis")
}
