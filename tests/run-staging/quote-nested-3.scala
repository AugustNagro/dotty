import quoted._
import scala.quoted.staging._

object Test {
  given Compiler = Compiler.make(getClass.getClassLoader)

  def main(args: Array[String]): Unit = withQuotes {
    val q = '{
      type T = String
      val x = "foo"
      ${
        val y = 'x
        '{ val z: T = $y }
      }
      x
    }

    println(q.show)
  }
}
