import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.W
import java.util.*

enum class Color(val r: Int, val g: Int, val b: Int)
{
    RED(255,0,0), ORANGE(255, 165, 0),
    YELLOW(255,255,0), GREEN(0,255,0), BLUE(0,0,255),
    INDYGO(75,0,130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 +b
}

fun main(args : Array<String>){
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
    println(getWarm(Color.GREEN))
    println(mix(Color.RED,Color.YELLOW))
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithlogging(Sum(Sum(Num(1),Num(2)),Num(4))))
//    testWhenLoop(10)

    for(i in 100 downTo 1 step 2){
        print(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()

    for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    println()

    for((letter,binary) in binaryReps){
        println("$letter = $binary")
    }

    println()

    val list = arrayListOf("10", "11", "1001")

    for((index,element) in list.withIndex()){
        println("$index: $element")
    }

    println()

    isNotDigit('x')

    println(recognize('2'))

    println("Kotlin" in setOf("Java", "Scala"))

}

fun getMnemonic(color: Color) = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDYGO -> "In"
    Color.VIOLET -> "Vain"
}

fun getWarm(color: Color) = when (color) {
    Color.YELLOW, Color.ORANGE, Color.RED -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDYGO, Color.VIOLET -> "cold"
}

fun mix(c1 : Color, c2 : Color) = when (setOf(c1,c2)){
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDYGO

    else -> throw Exception("Dirty color")
}

interface Expr
class Num(val value : Int) : Expr
class Sum(val left :Expr, val right: Expr) : Expr

fun eval(e : Expr) : Int {
    if (e is Num){
        val n = e as Num
        return n.value
    }

    if(e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknow expression")
}

//refactor replace if by when

fun eval2(e: Expr) : Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval2(e.right) + eval2(e.left)
            else ->
                    throw IllegalArgumentException("Unknow expression")
        }

fun evalWithlogging(e:Expr): Int =
        when(e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithlogging(e.left)
                val right = evalWithlogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknow expression")
        }

fun testWhenLoop(x:Int){
    while (x<20){
        println("x= $x")

    }
}

fun fizzBuzz(i : Int) = when {
    i % 15 ==0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c)
{
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know..."
}
