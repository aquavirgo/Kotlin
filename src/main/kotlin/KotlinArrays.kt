import java.util.*

fun main(args: Array<String>) {

    val language = arrayListOf("Java")
    language.add("Kotlin")


    language.map { x -> x + " Language"  }

    var x= 20
    x = 12

    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }

val name = if (x >11) "Test" else "Kotlin"

println("Hello, $name!")

val person = Person3("Bob",true)
    println(person.name)

    val rectangle = Rectangle(20,20)

    println(rectangle.isSquare)

    println(createrandomrectangle().isSquare)

}

class Person3(val name : String, val isMarrid : Boolean)

class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean
        get(){
            return height == width
        }
}

fun createrandomrectangle() : Rectangle
{
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}




