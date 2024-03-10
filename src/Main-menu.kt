val MateriasENota = mutableMapOf<String, MutableList<Double>>()

fun main() {
    var option: Int

    do {
        println("=== Menu ===")
        println("1. Adicionar disciplina")
        println("2. Adicionar nota")
        println("3. Mostrar notas de uma disciplina")
        println("4. Adicionar várias notas")
        println("5. Calcular média de disciplinas")
        println("0. Sair")
        print("Escolha uma opção: ")
        option = readLine()?.toIntOrNull() ?: 0

        when (option) {
            1 -> adicionarDisciplinaMenu()
            2 -> adicionarNotaMenu()
            3 -> mostrarNotasMenu()
            4 -> adicionarVariasNotasMenu()
            5 -> calcularMediaMenu()
            0 -> println("Saindo...")
            else -> println("Opção inválida!")
        }
    } while (option != 0)
}

fun adicionarDisciplinaMenu() {
    print("Digite o nome da disciplina: ")
    val disciplina = readLine() ?: ""
    adicionarDisciplina(disciplina)
}

fun adicionarNotaMenu() {
    print("Digite o nome da disciplina: ")
    val disciplina = readLine() ?: ""
    print("Digite a nota: ")
    val nota = readLine()?.toDoubleOrNull() ?: 0.0
    adicionarNota(disciplina, nota)
}

fun mostrarNotasMenu() {
    print("Digite o nome da disciplina: ")
    val disciplina = readLine() ?: ""
    mostrarNotas(disciplina)
}

fun adicionarVariasNotasMenu() {
    print("Digite o nome da disciplina: ")
    val disciplina = readLine() ?: ""
    print("Digite as notas separadas por espaço: ")
    val notas = readLine()?.split(" ")?.mapNotNull { it.toDoubleOrNull() }
    if (notas != null && notas.isNotEmpty()) {
        adicionarVariasNotas(disciplina, *notas.toDoubleArray())
    } else {
        println("Nenhuma nota válida foi inserida.")
    }
}

fun calcularMediaMenu() {
    print("Digite os nomes das disciplinas separados por espaço: ")
    val disciplinas = readLine()?.split(" ") ?: emptyList()
    val media = calcularMedia(*disciplinas.toTypedArray())
    println("Média das disciplinas: $media")
}
