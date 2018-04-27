fun main(args: Array<String>) {

    var jake = Person()
    jake.age = 24
    jake.name = "Jack Hill"
    jake.college = "Stephen's College"

    var jack2 = Person2("Tyson", 23, "Texas")
    val jack3 = Person2("test", 23, "texas", "wp.pl")
    println(jack2.isEligibleToVote());
    println(jack2.isGamon())


    fun Person2.isTeenager(): Boolean{
        return age in 13..19
    }


    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}

    println(sumLambda(3,4));



    val numbers:Array<Int> = arrayOf(1,2,3,4,5)

    println(numbers.take(3) )


    val nullList : List<Int?> = listOf(1,2,3,5)

   for(item in nullList){
       item?.let { println(it) }
   }


    val asc :String  = Array(7,{i -> i*i}).toString()

    var matche = Mathe()
    println(matche.max(1,2))

    val a = Mathe()
    a.newfun(2)


    }
fun Mathe.newfun( a:Int) : Int{
    return -1;
}
class Person{
    var name: String =""
    var age: Int =0
    var college: String? = null

}

class Person2(var name: String, var age: Int, var college: String?){
    var email: String = ""
    constructor(name: String,age: Int,college: String?,email: String) : this (name, age,college){
        this.email=email;
    }

    fun isEligibleToVote(): Boolean {
        return age >=18
    }

    fun isGamon() : Boolean = age in 18 .. 23



}

class Mathe{
    fun max(x:Int,y:Int) :Int {
        return if(x>y) x else y
    }

}


