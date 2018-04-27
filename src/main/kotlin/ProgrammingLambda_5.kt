import javax.annotation.processing.Messager

data class PersonL(val name: String, val age: Int)

fun printMesageWithPrefix(message: Collection<String>,prefix: String){
    message.forEach { println("$prefix $it") }
}

fun printProblemCount(response: Collection<String>){
    var clientErrors =0
    var serverError =0
    response.forEach {

        if(it.startsWith("4")){
            clientErrors++
        }else if(it.startsWith("5")){
            serverError++
        }
    }
    println("$clientErrors client errors, $serverError server error")
}

fun printProblemCountWith(response: Collection<String>){
    var clientErrors =0
    var serverError =0
    response.forEach {
        if(it.startsWith("4")){
            clientErrors++
        }else if(it.startsWith("5")){
            serverError++
        }
    }
    println("$clientErrors client errors, $serverError server error")
}

fun salute() = println("Salute?")

fun sendEmail(name: PersonL, message: String) = println("$name $message")

fun PersonL.isAdult() = age >=21

class Book(val title:String,val authors : List<String>)

//with to prevent repeating of statment during it maintenance
fun alphabet() : String{
    val str = StringBuilder()
    return with(str){
        for(letter in 'A'..'Z'){
            this.append(letter)
        }
        append("\nNow I know")
        this.toString()
    }
}

fun alphabetApply() = StringBuilder().apply { for(letter in 'A'..'Z'){
    append(letter) }
    append("\n I know")
}.toString()

fun main(args: Array<String>) {
    val people = listOf(PersonL("Alice", 26), PersonL("Bob", 31))
    println(people.maxBy { it.age })
    println(people.maxBy(PersonL::age))
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    println(people.joinToString(" ") { p: PersonL -> p.name })

    val sum2 = { x: Int, y: Int ->
        println("Computing the sum of $x and $y")
        x + y
    }

    println(sum2(2,2))

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMesageWithPrefix(errors,"Errors: ")

    val response = listOf("200 OK", "418 I'm teapot", "500 Internal Server Error")
    printProblemCount(response)

    val getAge = PersonL::age
    println(getAge)

    run (::salute)

    //delegat to sendEmail function

    val action = {person : PersonL, message: String -> sendEmail(person,message)}
    val nextAction = :: sendEmail
    val createPerson = ::PersonL
    println(createPerson)

    val p = createPerson("Alice",29)
    println(p)

    val predicate = PersonL::isAdult
    println(predicate(p))

    val list = listOf(1,2,3,4)
    list.filter { it % 2 ==0}
    people.filter { it.age >30 }

    println(list.map { it * it })

    println(people.map{it.name}.filter { it.startsWith("B") })

    val numbers = mapOf(0 to "zero", 1 to "one")

    println(numbers.mapValues { it.value.toUpperCase() })

    val canBeInClub27 = {p: PersonL -> p.age <=27}

    println(people.all(canBeInClub27))
    println(people.count(canBeInClub27))

    println(people.groupBy(getAge)) //it.age

    val list2 = listOf("a", "ab", "b")
    println(list2.groupBy( String::first ))

    val books = listOf(Book("Java for All", listOf("Topic","marian")),Book("Tazo", listOf("Tatarak")))

    println(books.flatMap { it.authors }.toSet())

    println(people.asSequence().map(PersonL::name).filter { it.startsWith("A") }.toList())

    println(listOf(1,2,3,4).asSequence().map { it * it  }.find { it>3 })

    val naturalNumber = generateSequence(0){it +1}
    val numbersTo100 = naturalNumber.takeWhile { it <=100 }
    println(numbersTo100.sum())

    println(alphabet())
    println(alphabetApply())
}