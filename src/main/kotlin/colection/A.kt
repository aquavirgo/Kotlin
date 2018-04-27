package colection


abstract  class A(val a : String) {


    abstract fun test (a:String)
    fun test2(){
        System.out.print("from test 2")

    }
}

class B(val b: String = "test") : A(b) {
    override fun test(a: String) {

    }

}