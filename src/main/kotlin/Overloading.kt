class Overloading {
}

data class Point(val x:Int,val y:Int){
    //operator  - key words with is used to mark that function will be overloaded
    // under the hood funtion is called a+b -> a.plus(b)
    operator fun plus(other : Point):Point
    {
        return Point(x+other.x,y+other.y)
    }

    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if(other !is Point) return false
        return other.x == x && other.y == y
    }
}

operator fun Point.plus(other: Point) : Point
{
    return Point(x+other.x, y+other.y)
}


operator fun Point.times(scale:Double) : Point{
    return Point((x*scale).toInt(),(y * scale).toInt())
}

operator fun Char.times(count:Int):String{
    return toString().repeat(count)
}

fun <T> take(t : T){
    println(t)
}
operator fun <T> T.times(count: Int) : String{
    return toString().repeat(count)
}


// a+=b; ----> a =a.plus(b)
//       ----> a.plusAssign(b)
operator fun <T> MutableCollection<T>.plusAssign(element: T){
    this.add(element)
}


operator fun Point.unaryMinus() : Point{
    return Point(-x,-y)
}

operator fun Point.unaryPlus() : Point{
    return Point(x*(-1),y*(-1))
}

class PersonsX(val firstName : String, val lastName:String) : Comparable<PersonsX>{
    override fun compareTo(other: PersonsX): Int {
        return compareValuesBy(this,other,PersonsX::lastName,PersonsX::firstName)
    }
}

operator fun Point.get(index: Int) : Int {
    return when(index){
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}
//Set method for MutablePoint
data class MutablePoint(var x:Int, var y:Int)

operator fun MutablePoint.set(index: Int,value: Int) {
    when(index){
        0 ->x = value
        1 ->y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

//in convention

data class RectangleX(val upperLeft:Point, val lowerRight : Point)

operator fun RectangleX.contains(p:Point):Boolean{
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}



fun main(args : Array<String>){
    var p1 = Point(10,20)
    var p2 = Point(-30,-40)

    //println(p1 + p2)
    //println(p1 *1.5)

    /*println('a' *3)
    take(p1*4)*/

    /*p1 += p2
    println(p1)*/

    /*val numbers = ArrayList<Int>()
    numbers+=42
    println(numbers[0])*/

   /* val list = arrayListOf(1,2)
    list+=3
    val newList = list + listOf(4,5)
    println(newList)

    val ex = hashSetOf(1,2,3,4,4)*/

  /*  println(-p1)
    println(p2.unaryPlus())

    println(Point(10,20) == p1)
    println(Point(10,20)!=Point(5,5))
*/
    val per1 = PersonsX("Alice","Smith")
    val per2 = PersonsX("Bob", "Johnson")
    println(per1==per2)

    val pr = Point(10,20)
    println(pr[1])

    val ps = MutablePoint(10,20)
    ps[1] = 42
    println(ps)

    val rect = RectangleX(Point(10,20),Point(50,50))
    println(Point(20,30) in rect)
}