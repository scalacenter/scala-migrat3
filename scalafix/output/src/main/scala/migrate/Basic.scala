package migrate

object Basic {
  val name: String = "String"
  val people: List[Map[Int,Int]] = List.apply[Int](1).map[Int](_ + 1).map[Map[Int,Int]](elm => Map.apply[Int, Int](scala.Predef.ArrowAssoc(elm) -> elm))
  
  for {
    a <- List.apply[Int](1)
    b = a + 1 // assignment
  } yield a + b
  
  for {
    (a, b) <- List.apply[(Int, Int)](scala.Predef.ArrowAssoc(1) -> 2) // pattern
  } yield a + b
  
  val listOfTEst: List[Other.Test] = List.apply[Other.Test](Other.Test(1))
  def a[A](in: A): List[A] = List.apply[A](in)
}

object Other {
  case class Test(i: Int)
}

class Test {
  case class Ok(s: String)
  val list: List[Ok] = List.apply[Ok](Ok("ok"))
}