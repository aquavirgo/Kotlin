package sequence

class People {
}

fun main (args : Array<String>){
    val marian = Person("Marian")
    val ta = Person("Ta")
   val people = listOf(marian,ta)

    people.map(Person::name).filter { it.startsWith("A") }

    people.asSequence().map { it.name }.filter { it.startsWith("A") }.toList()
}