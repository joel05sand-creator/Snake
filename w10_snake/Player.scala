package snake

class Player(
  var name: String, 
  var keyMap: Player.KeyMap, 
  val snake: Snake,
  var points: Int = 0,    // TODO: count points when e.g. eating apple
  // var highscore; valfritt tillägg
)
:
  def handleKey(key: String): Unit = 
    if keyMap.dir.contains(key)
      then snake.dir = (keyMap.dir(key)) // om key ingår i keyMap så uppdatera snake.dir

object Player:
  enum KeyMap(left: String, right: String, up: String, down: String):
    val dir = Map(left -> West, right -> East, up -> North, down -> South) 
    case Letters extends KeyMap("a", "d", "w", "s")
    case Arrows extends KeyMap("Left", "Right", "Up", "Down")