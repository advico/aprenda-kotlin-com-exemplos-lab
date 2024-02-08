// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("$usuario matriculado na formação $nome.")
    }

    fun exibirInformacoes() {
        println("Formação: $nome")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} (${conteudo.duracao} minutos)")
        }
        println("Inscritos: ${inscritos.size} usuários")
    }
}

fun main() {
    // Cenário de teste
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin")
    
    val formacaoKotlin = Formacao("Formação Kotlin")
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    val usuario1 = Usuario("Adrian")
    val usuario2 = Usuario("David")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.exibirInformacoes()
}