package com.summersummersummer.day1

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.widget.doOnTextChanged
import com.summersummersummer.R
import com.summersummersummer.databinding.ActivityMainBinding

fun main() {
    val array = arrayOf(1, 2, 3, 4)

    val list = listOf(1, 2, 3, 4) // only reading data can't modify it
    //  val list2 = ArrayList<Int>(initialCapacity = 15) i don't know what's wrong with it
    val list3 = mutableListOf(1, 2, 3)
    val list4 = arrayListOf(1, 2, 3)
    for (element in 1..10 step 2)
        println(element)
    for (element in 10 downTo 1 step 5)
        println(element)
    list.forEach {
        println("index: $it")
    }
    list.forEach { element: Int -> println("index: $element") }
    list.forEachIndexed { index, element -> println("index : $element") }
    val newList: List<String> = list
        .filter {
            it > 5
        }
        .map {
            "new value = $it"
        }
    val addingStrings = "fiuf" + "gubf"
}

fun myNameIs(arg1: String, arg2: Int = 0): String {
    fun calc(arg2: Int): String {
        return "TEST: $arg1"
    }
    "ANDROID: ${arg1.length}, ${calc(arg2)}"
    return arg1 + arg2
}

fun test() {
    val userData = listOf(
        UserDataSecond(id = 1, address = "hguhf", phone = "368634"),
        UserDataSecond(id = 2, address = "digdidg", phone = "32543543"),
        UserDataSecond(id = 3, address = "cgiysga", phone = "32231"),
        UserDataSecond(id = 4, address = "eopopej", phone = "31434"),
        UserDataSecond(id = 5, address = "dcjbdo", phone = "94947"),
        UserDataSecond(id = 6, address = "uodhoudh", phone = "8427302"),
    )
    val map: Map<Int, UserDataSecond> = userData.associateBy {
        it.id
    }
    val map2 = mapOf(
        Pair(first = 1, second = UserDataSecond(id = 32, address = "shgouh", phone = "974934")),
        2 to UserDataSecond(id = 22, address = "sgbgekjhgouh", phone = "974933443"),
    )
    val map3 = mutableMapOf(
        3 to "gjhogh",
        4 to "egorg"
    )
    map3[5] = "jkrehgihgr"
    map3 += mapOf(6 to "foh")
    map3.plus(mapOf(7 to "hdbfidhf"))
    map3.plus(8 to "rfhbrigf")
    val map4: HashMap<Int, String> = hashMapOf(2 to "fjogog")
    map.getOrElse(3) {
        // we can write a lot of code right in here
        UserDataSecond(id = 3, address = "sjdbgoer", phone = "4932649")
    }
    map.getOrDefault(3, UserDataSecond(id = 3, address = "sjdbgoer", phone = "4932649"))
    map[3]  // same as map.get(3) and also it's nullable
    map.forEach { key, value ->
        Log.e("TAG", "MSG $key, $value")
    }
    try {
        val user: UserDataSecond = userData.first {
            it.phone == "123123"
        }
    } catch (ex1: NoSuchElementException) {
        println(ex1.message)
    } finally {
        println("ffhuhf")
    }
    val user2: UserDataSecond? = userData.firstOrNull {
        it.phone == "123123"
    }
    val user3: UserDataSecond? = userData.find {//here function first or null called actually
        it.id == 3
    }
    userData.takeLast(5)
    userData.findLast {
        it.id > 3
    }
    val user4 = userData.maxBy { it.id }
    // userData.sortedWith(...) - used when we sorting by several parameters
    userData.sortedBy { it.id }
    userData.sortedWith(compareBy<UserDataSecond> {
        it.id
    }.thenByDescending {
        it.address.length
    }.thenByDescending {
        it.phone?.length
    })

    map.toList()
    listOf(Month.APR, Month.MAY, Month.JAN).maxOf { it.order }
}

fun testWhen(month: Month): String { // analogy of switch case
    return when (month) {
        Month.JAN -> "now is jan ${month.order}"
        Month.FEB -> "now is feb ${month.order}"
        Month.MARCH -> "now is march ${month.order}"
        Month.APR -> "now is apr ${month.order}"
        Month.MAY -> "now is may ${month.order}"
    }
}

fun testWhenButCooler(month: Month): String = when (month) {
    Month.JAN -> "now is jan ${month.order}"
    Month.FEB -> "now is feb ${month.order}"
    Month.MARCH -> "now is march ${month.order}"
    Month.APR -> "now is apr ${month.order}"
    Month.MAY -> "now is may ${month.order}"
}

fun testWhenOnceAgain(color: String) {
    /*
    if (color.isEmpty() {
        println("IS EMPTY")
    } else if (color.length > 10 || color.contains("green") {
        println("IS EMPTY")
    } else {

    }
    */
    when { //прокаченный иф
        color.isEmpty() -> println("IS EMPTY")
        color.length > 10 || color.contains("green") -> println()
        else -> {} // аналог дефолта
    }
}

enum class Color(val code: Int) {
    RED(0), GREEN(1), BLUE(2)
}

fun mapTest() {
    val map = HashMap<Int, String>()
    map[0] = "jrfurh"
    map[1] = "dfkfouhg"
    map.get(1)
    val s = map[1]
    map.getOrElse(1) {
        UserDataSecond(id = 7, address = "kshbfie", phone = "93798374")
    }
    map.getOrDefault(1, UserDataSecond(id = 8, address = "kshfbfdhfce", phone = "9379843535"))
    map.forEach { key, value ->
    }
    val map2 = mapOf(
        0 to "duhfoh",
        1 to "kjfbofh"
    )
    val map3 = hashMapOf(
        0 to "duhfoh",
        1 to "kjfbofh"
    )
}

enum class Month(val order: Int) {
    JAN(1), FEB(2), MARCH(3), APR(4), MAY(5)
}

// if we have class that is model of something (describes property of some object, abstraction)
data class Song(
    val name: String,
    val author: Author
)

// automatically generates lots of fields based on primary constructor (toString, equals, hashcode)
// equals will be comparing properties of objects not their links
data class Author(
    val name: String,
    val age: Int
)

class NotesFromSecondLesson : ComponentActivity() {
    private var header: TextView? = null
    private var button: Button? = null
    private var viewBinding: ActivityMainBinding? = null
    private val emailPattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* for classic initialization of view
        setContentView(R.layout.activity_main)
        initViewsClassic() */
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViewsModern()
    }

    private fun initViewsClassic() {
        this.header = findViewById(R.id.header)
        this.button = findViewById(R.id.button)
        var counter = 0
        button?.setOnClickListener {
            header?.text = "button clicked ${++counter} times"
            Toast.makeText(this, "${counter} hearts broken ;(", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewsModern() {
        viewBinding?.apply {
            emailEt.doOnTextChanged { text, start, before, count ->
                text?.let {
                    button?.isEnabled = emailPattern.matcher(text).matches()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}


