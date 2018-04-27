import java.net.Inet4Address
import java.util.*

fun main(args : Array<String>){
    val list = listOf(1,2,3)

    println(joinToString(list,"; ","(",")"))
    println(joinToString(list))
    println(joinToString(list,prefix = "#"))

    println("WKS".lastChar())

    println(list.joinToString2())

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")


   saveUser(User(1,"kuba","tut"))

}

fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "",postfix: String ="") : String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = this.get(this.length -1)

fun <T> Collection<T>.joinToString2(separator: String = ", ", prefix: String = "", postfix: String = "") : String{
    val result = StringBuilder(prefix)

    for((index, element) in this.withIndex())
    {
        if(index > 0 )
            result.append(separator)
            result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var StringBuilder.lastChar: Char
    get() = get (length -1)
    set(value:Char){
        this.setCharAt(length -1,value)
    }


fun <T> Collection<T>.data() {

    for((index,element) in this.withIndex()){
        println("$index $element")
    }
}


class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String)
    {
        if (value.isEmpty()){
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")


}
fun saveUser(user: User){
    user.validateBeforeSave()
}
