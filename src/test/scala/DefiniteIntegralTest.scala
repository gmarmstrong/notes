import org.scalatest.funsuite.AnyFunSuite
import spire.math.Real
import spire.syntax.all.poly

class DefiniteIntegralTest extends AnyFunSuite {

  test(
    "F' == F, satisfying the 1st part of the fundamental theorem of calculus"
  ) {
    val integral =
      DefiniteIntegral(1, Real.pi.toRational, poly"5/4x^6 - 7x - 2", 1)
    assert(integral.antiDer.derivative == integral.integrand)
  }

  test(
    "result == F(b) - F(a), satisfying the 2nd part of the fundamental theorem of calculus"
  ) {
    val integral =
      DefiniteIntegral(1, Real.pi.toRational, poly"5/4x^6 - 7x - 2", 1)
    assert(
      integral.result ==
        integral.antiDer(integral.upper) - integral.antiDer(integral.lower)
    )
  }

  test("lower <= upper is enforced") {
    assertThrows[IllegalArgumentException](
      DefiniteIntegral(2, 1, poly"x", 1)
    )
  }

  test("non-trivial integral gives a good result") {
    val integral =
      DefiniteIntegral(1, Real.pi.toRational, poly"5/4x^6 - 7x - 2", 1)
    assert(integral.result.round == 504)
  }

}
