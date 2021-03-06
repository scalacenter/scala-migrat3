package incompat

object ScalafixIncompat8 {
  trait IO[+A, +E] {
    def collectM[B, EE >: E](pf: PartialFunction[A, IO[B, EE]]): IO[B, EE]

    def collect[B](pf: PartialFunction[A, B]): IO[B, E] = collectM[B, E](pf.andThen[IO[B,Nothing]](IO.succeed[B] _))
  }

  object IO {
    def succeed[A](a: A): IO[A, Nothing] = ???
  }
}