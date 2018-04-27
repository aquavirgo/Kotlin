// important informations
/*You can create sequence from collections and is possible generating this structure throught generateSequence() method */

class Sequence {
}

fun main(args : Array<String>){
    val naturalNumber = generateSequence(0) {it + 1}
    val numberTo100 = naturalNumber.takeWhile { it <=100 }

    numberTo100.iterator().forEach { println(it) }

    println(alphabet1())


}
//look like a special constructor, bierze dwa argumenty, stringBuilder i lambde
//mozna zapisac jako with(stringbuilder,{}) ale nie eleganckie dlatego ominiete
//ostatnie wyrazenie w lambdzie automatycznie konwertowany jest na wartosc zwracana
//nie potrzeba this
fun alphabet1() = with(StringBuilder()){
    for(letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

//apply dziala jak with ale zwracany jest argument wejsciowy
fun alphabet2() = buildString {
    for(letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet!")
}