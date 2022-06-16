import spire.*
import spire.algebra.*
import spire.compat.integral
import spire.math.*
import spire.std.any.*
import spire.syntax.all.*

import scala.collection.immutable.NumericRange

case class DefiniteIntegral(lower: Rational, upper: Rational, integrand: Polynomial[Rational], step: Rational):
  require(lower <= upper, s"$toString does not satisfy lower <= upper")

  lazy val interval: Interval[Rational] = Interval.closed[Rational](lower, upper)
  lazy val partition: NumericRange.Inclusive[Rational] = NumericRange.inclusive[Rational](lower, upper, step)

  /** some F such that F' = F, if such a function exists */
  lazy val antiDer: Polynomial[Rational] = integrand.integral

  lazy val upperAntiDer: Rational = antiDer(upper)

  lazy val lowerAntiDer: Rational = antiDer(lower)

  /** F(b) - F(a), by the fundamental theorem of calculus */
  lazy val result: Rational = upperAntiDer - lowerAntiDer

  override def toString: String = s"DefiniteIntegral($lower, $upper, $integrand, $step)"
