package snake

import java.awt.Color

class Snake (
  val initPos: Pos,
  val initDir: Dir,
  val headColor: Color,
  val tailColor: Color,
 )(using ctx: SnakeGame, settings: Settings) extends CanMove: 
  var dir: Dir = initDir
  val initBody: List[Pos] = List(initPos + initDir, initPos)
  val body: scala.collection.mutable.Buffer[Pos] = initBody.toBuffer

  val initLength: Int = settings.snake.initLength
  val growEvery: Int = settings.snake.growEvery
  val startGrowingAfter: Int = settings.snake.startGrowingAfter

  private var _nbrOfSteps = 0
  def nbrOfSteps: Int = _nbrOfSteps

  private var _nbrOfApples = 0
  def nbrOfApples: Int = _nbrOfApples

  def reset(): Unit = {
    body.clear()
    body ++= initBody.take(initLength) //återställer kroppens längd till startlängd
    _nbrOfSteps = 0 // återställer steg till 0
    _nbrOfApples = 0 // återställer äpplen till 0
    dir = initDir // originalriktningen på ormen
  } 

  def grow(): Unit = 
    if (_nbrOfSteps >= startGrowingAfter && (_nbrOfSteps - startGrowingAfter) % growEvery == 0) {
      val tail = body.last
      body = body :+ tail // lägger till längd på svansen 
    } // väx i rätt riktning med extra svansposition

  def shrink(): Unit = {
  if (nbrOfSteps > startShrinkAfter &&
      shrinkEvery > 0 &&
      (nbrOfSteps - startShrinkAfter) % shrinkEvery == 0 &&
      body.length > 1) {
    body = body.dropRight(1) // tar bort sista svanspositionen
  }
} // krymp svansen om kroppslängden är större än 2

  def isOccupyingBlockAt(p: Pos): Boolean = ??? // kolla om p finns i kroppen

  def isHeadCollision(other: Snake): Boolean = ??? // kolla om huvudena krockar

  def isTailCollision(other: Snake): Boolean = ??? // mitt huvud i annans svans

  def move(): Unit = ??? 
    // väx och krymp enl. regler

  override def toString = // bra vid println-debugging
    body.map(p => (p.x, p.y)).mkString(">:)", "~", s" going $dir")

  def draw(): Unit = ???

  def erase(): Unit = ???
