import java.util.*

/**
 * Created by ReginaGurung on 13/03/2018.
 */

fun ClosedRange<Int>.random():Int {
    return Random().nextInt(endInclusive - start) + start
}