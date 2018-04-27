import sun.misc.Cleaner
import java.io.Serializable
import javax.naming.Context
import javax.swing.text.AttributeSet
import javax.xml.stream.events.Attribute

interface Clickable
{
    fun click()
    fun showOff() = println("I 'm clickable!")  //defult implementation
}

class Button : Clickable {
    override fun click() {
        println("I was clicked")
    }
}

interface Focusable{
    fun setFocus(b : Boolean) =
            println("I ${if (b) "got" else "lost"} focus.")
fun showOff() = println("I 'm clickable!")  //defult implementation
}

class Button1 : Clickable, Focusable {

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() {
        println("I was clicked")
    }
}

open class RichButton : Clickable{
    fun disable() {}
    open fun animate(){}
    override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

abstract class Animate{
    abstract fun animate()
    open fun stopAnimating(){}
    fun animateTwice(){}
}

//in module
internal open class TalkativeButton : Focusable{
    private fun yell() = println("Hey") // visable in class
    protected fun whisper() = println("Let's talk!") // in subclass
}


interface State: Serializable
interface View {
    fun getCurrentState() : State
    fun restoreState(state: State)
}

class Button3 : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState : State{}
}


class Outer {
    inner class Iner {
        fun getOuterReference(): Outer = this@Outer //referencja do klasy outer
    }
}
//klasa zapieczetowana
sealed class Expr1{ //all posible class are nested  this techincs prevent else statment in when loop (deafult branche)
    class Num(val value: Int) : Expr1()
    class Sum(val left: Expr1, val right: Expr1) : Expr1()
}
fun eval(e : Expr1) : Int =
        when(e){
            is Expr1.Num -> e.value
            is Expr1.Sum -> eval(e.right) + eval(e.left)
        }

//how Kotlin class is create
class User1 constructor(_nick : String){
    val nick : String
    init {
        nick = _nick
    }
}

open class User2 (val nickname: String){}
class TwitterUser(nickname: String) : User2(nickname){}

//to ensure that class can be instatiated by another code you should make private constructor

class Secret private constructor()

//class with two constructors
open class View2 {
    constructor(ctx : Context)
    constructor(ctx: Context, attr : AttributeSet)
}

class MyButton : View2 {
    constructor(ctx: Context) : super (ctx) // call super class
    constructor(ctx: Context, attr: AttributeSet) : super(ctx,attr)
}

// call another class constructor of your own class

class MyButton2 : View2 {

    //constructor(ctx: Context) : this(ctx,MY_STYLE)
    val MY_STYLE = Any()
    constructor(ctx: Context,attr: AttributeSet) :super(ctx, attr)
}

// toString

class Clinet(val nickname: String, val postalCode: Int) {

   /* override fun equals(other: Any?): Boolean {
        if (other == null && other !is Clinet) {
            return false
        }
        return nickname == other.nickname &&
                postalCode == other.postalCode
    }*/
    override fun toString(): String = "Client(name = $nickname, postalcode = $postalCode)"

    override fun hashCode(): Int = nickname.hashCode() * 31 + postalCode
}


data class Client(val name: String, val postalCode: Int)

//Delgation of new features to another class / decorator pattern

class DelegationCollection<T> : Collection<T>{
    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): Iterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun contains(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val innerList = arrayListOf<T>()
    override val size: Int get() = innerList.size
}

//Is possible to obtain similar effect with out effor

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList{}

//singleton = object
object Payroll {
    val allEmployess = arrayListOf<Person>()
    fun calculateSalary(){
        for (person in allEmployess){}
    }
}

//static method similar like in java
class A{
    companion object {
        fun bar(){
            println("Campanion object called")
        }
    }
}

//create class by factory pattern without multipleconstructor

class User4(val nickname: String){
    companion object {
        fun newSubscribingUser(email:String) = User4(email.substringBefore('@'))
      //  fun newFacebookUser(accountId : Int) = User4(getFacebookName(accountId))
    }
}

//seriqalziation logic for JSON reader

/*class Person5(val name: String){
    companion object Loader{
        fun fromJSON(jsonText:String) : Person5{
            println("read json")
        }
    }
}
*/

fun main(args: Array<String>) {
    val button = Button()
    println(button.click())

    val button1 = Button1()

    button1.showOff()
    button1.setFocus(true)
    button1.click()

    println(Clinet("MAKS",23456))

    //equals
    val client1 = Clinet("Alice",23456)
    val client2 = Clinet(nickname = "Tom", postalCode = 23456)

    val client = Clinet("Tom", 1234)
    println(client.hashCode())

    Payroll.allEmployess.add(Person())
    Payroll.calculateSalary()
    A.bar()

    var subsUser = User4.newSubscribingUser("bob@hmail.com")
    println(subsUser.nickname)

    //person = Person5.fromJSON({name: 'Dimitry'})

}