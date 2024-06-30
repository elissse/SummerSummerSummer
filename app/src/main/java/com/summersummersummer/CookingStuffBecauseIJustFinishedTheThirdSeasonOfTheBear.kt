package com.summersummersummer

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.widget.doOnTextChanged
import com.summersummersummer.databinding.ActivityMainBinding
import kotlin.random.Random

class CookingStuffBecauseIJustFinishedTheThirdSeasonOfTheBear : ComponentActivity() {
    private var calling_the_chef_button: Button? = null
    private var editText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.criticising_food)
        initViewsClassic()
    }

    private fun initViewsClassic() {
        this.calling_the_chef_button = findViewById(R.id.button)
        this.editText = findViewById(R.id.dishes)
        val foodCritic = CrazyCritic()
        calling_the_chef_button?.setOnClickListener {
            val enteredData: String = editText?.text.toString()
            if (enteredData.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "pleasepleaseplease tell chef how many dishes do you need",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val howMany: Int = enteredData.toInt()
                Log.d("TAGTAGTAG", enteredData)
                Toast.makeText(
                    applicationContext,
                    "okay the order is accepted",
                    Toast.LENGTH_SHORT
                ).show()
                foodCritic.kitchenMakingWaiterBringing(howMany)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    class CrazyCritic() {
        var set = mutableListOf<Dish>()
        fun kitchenMakingWaiterBringing(howMany: Int) {
            for (i in 1..howMany) {
                val x: Int = Random.nextInt(0, 3)
                when (x) {
                    0 -> set.add(IceCreamSundae())
                    1 -> set.add(CheeseStuffedPastaInBrownButterWithPesto())
                    2 -> set.add(MarinatedRadicchioWithBurntGrapefruitAndPistachio())
                    3 -> set.add(ChocolateCake())
                }
            }
            while (set.size != 1) {
                val dish1: Dish = set.removeAt(Random.nextInt(0, 10).mod(set.size))
                val dish2: Dish = set.removeAt(Random.nextInt(0, 10).mod(set.size))
                Log.d(
                    "TAG_CRITIC",
                    "so ${dish1.name} and ${dish2.name} are on the table. who will end up in the trash?"
                )
                var winner = dish1
                if (comparingDishes(dish1, dish2) < 0) winner = dish2
                Log.d("TAG_CRITIC", "so basically the ${winner.name} is not so bad")

            }
            if (!set.isEmpty()) {
                Log.d(
                    "TAG_CRITIC",
                    "so the food critic ate so much food that he cannot make himself try ${set.get(0).name}"
                )
            }
        }

        fun comparingDishes(dish1: Dish, dish2: Dish): Int {
            var score1 =
                dish1.temperature.num + dish1.aroma.num + dish1.taste.num + dish1.howLongToPrepare.num
            var score2 =
                dish2.temperature.num + dish2.aroma.num + dish2.taste.num + dish2.howLongToPrepare.num
            return score1 - score2
        }
    }

    open class Dish(
        open val name: String = "some dish",
        val temperature: Temperature = Temperature.entries.get(
            Random.nextInt(0, 10).mod(Temperature.entries.size)
        ),
        val taste: Taste = Taste.entries.get(Random.nextInt(0, 10).mod(Taste.entries.size)),
        val aroma: Aroma = Aroma.entries.get(Random.nextInt(0, 10).mod(Aroma.entries.size)),
        val howLongToPrepare: HowLongToPrepare = HowLongToPrepare.entries.get(
            Random.nextInt(0, 10).mod(HowLongToPrepare.entries.size)
        )
    ) {

        override fun toString(): String {
            return "temperature : $temperature\ntaste : $taste\naroma : $aroma\nhow long does it take to prepare : $howLongToPrepare"
        }
    }

    class IceCreamSundae(
        override val name: String = "IceCreamSundae",
        val flavor: Flavor = Flavor.entries.get(Random.nextInt(0, 10).mod(Flavor.entries.size))
    ) : Dish(
    )

    class CheeseStuffedPastaInBrownButterWithPesto(
        override val name: String = "CheeseStuffedPastaInBrownButterWithPesto",
        val cheese: Cheese = Cheese.entries.get(Random.nextInt(0, 10).mod(Cheese.entries.size))
    ) : Dish(
    )

    class MarinatedRadicchioWithBurntGrapefruitAndPistachio(
        override val name: String = "MarinatedRadicchioWithBurntGrapefruitAndPistachio",
        val howTerribleIsIt: HowTerribleIsIt = HowTerribleIsIt.entries.get(
            Random.nextInt(0, 10).mod(HowTerribleIsIt.entries.size)
        )
    ) : Dish(
    )

    class ChocolateCake(
        override val name: String = "ChocolateCake",
        val whatTypeOfAChocolateCake: TypeOfChocolateCake = TypeOfChocolateCake.entries.get(
            Random.nextInt(
                0,
                10
            ).mod(TypeOfChocolateCake.entries.size)
        )
    ) : Dish(
    )

    enum class Taste(val num: Int) {
        SWEET(0), SOUR(1), BITTER(2), SALTY(3), UMAMI(4)
    }

    enum class Aroma(val num: Int) {
        TANGY(0), HERBY(1), EARTHY(2)
    }

    enum class Temperature(val num: Int) {
        MINUS_TEN_C(0), TWENTY_C(1), SIXTY_C(2), SEVENTY_C(3),
    }

    enum class HowLongToPrepare(val num: Int) {
        HOUR(0), HALF_AN_HOUR(1), TWO_HOURS(2),
    }

    enum class Flavor(val num: Int) {
        STRAWBERRY(0), VANILLA(1), CHOCOLATE(2)
    }

    enum class Cheese(val num: Int) {
        CHEDDAR(0), MOZZARELLA(1), BRIE(2), GOUDA(3), SWISS(4), FETA(5)
    }

    enum class HowTerribleIsIt(val num: Int) {
        VERY(0), NOT_VERY(1), NO_ACTUALLY_ITS_OKAY(2), NO_ACTUALLY_ITS_GREAT(3)
    }

    enum class TypeOfChocolateCake(val num: Int) {
        TRUFFLE(0), PINATA(1), MOCHA(2), RUM(3), LAVA(4)
    }

    enum class Dishes(val num: Int) {
        ICE_CREAM_SUNDAE(0), CHEESE_STUFFED_PASTAIN_BROWN_BUTTER_WITH_PESTO(1), MARINATED_RADICCHIO_WITH_BURNT_GRAPEFRUIT_AND_PISTACHIO(
            2
        ),
        CHOCOLATE_CAKE(3)
    }

}