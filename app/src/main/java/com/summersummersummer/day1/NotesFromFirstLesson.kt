package com.summersummersummer.day1

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.summersummersummer.R

class NotesFromFirstLesson : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appendString(arg1 = "first", arg2 = "second")
        val firstUser = User(
            name = "elise",
            age = 21,
            userData = UserData(
                address = "RT, Kazan",
                phone = "8-917-777-99-44"
            ),
            email = "elissse@gmail.com"
        )
        println(User.mood)

        val userData = UserDataSecond(
            id = 1,
            address = "new adress", // so basically we can do this
            phone = "8932687364"
        )
        // we can't write testFun(userPhone = userData.phone) because phone is nullable so here's:
        // 1
        if (userData.phone != null)
            testFun(userPhone = userData.phone)
        // 2
        userData.phone?.let {
            testFun(userPhone = userData.phone)
        }
        // 3
        userData.phone?.let {
            testFun(userPhone = it)
        }
        // 4
        userData.phone?.let { phone ->
            testFun(userPhone = phone)
        }
        // 5
        testFun(userPhone = userData.phone ?: "")
        appendStringButNullable(arg1 = "first", arg2 = "second", userDataSecond = userData)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

fun appendString(arg1: String, arg2: String): String = arg1 + arg2

fun appendStringButNullable(arg1: String, arg2: String, userDataSecond: UserDataSecond): String? {
    return userDataSecond.phone?.let { // this means: if (userDataSecond.phone!=null)
            safePhone ->
        println("UserPhone: $safePhone")
        "$userDataSecond.address; $safePhone"
    }
    // if userDataSecond.phone == null then we'll return null
}

abstract class UserSample(
    open val name: String,
    open val age: Int,
    open val email: String,
)

fun testFun(userPhone: String): String {
    println("User Phone : $userPhone")
    return userPhone
}

open class User(
    open val name: String,
    val age: Int,
    val userData: UserData,
    email: String, // cannot access in functions except for init()
) {
    private var userInfo: String = ""

    init {
        userInfo = "$name; ${age + 10}; $email; ${userData.address}"
    }

    companion object {
        const val mood = "sad"
    }

    fun sendUserEmail() {

    }
}

class UserData(
    val address: String,
    val phone: String,
)

data class UserDataSecond(
    val id: Int,
    val address: String = "sample address",
    val phone: String?,
)

class EmailUser(
    override val name: String,
    age: Int,
    userData: UserData,
    email: String
) : User(
    name = name,
    age = age,
    userData = userData,
    email = email,
), UserAction, EmailAction, PhoneAction {
    override fun doSomething() {
        println("doing something yeah yeah yeah")
    }
}

interface UserAction {
    fun doSomething()
}

interface EmailAction
interface PhoneAction

class AbstractUser(
    override val name: String,
    override val age: Int,
    override val email: String
) : UserSample(
    name = name,
    age = age,
    email = email,
)
/*
1.
val - value - final
var - variable
2.
static in kotlin - everything companion object
3.
by default all classes are closed for inheritance, if we want to open them for it we use "open"
4.
data class - is needed for keeping models of data
what's the difference between class UserData and data class UserDataSecond?
in data class by default there are overrides for equals and hashcode, so if there are two
objects of UserDataSecond that are equal, their hash code will be the same too; whereas
when two different objects of type UserData are equal their hash codes will not be the same
5.
placing ? after String, Int ect (String?, Int?) means that now we have nullable something of type something
 */

