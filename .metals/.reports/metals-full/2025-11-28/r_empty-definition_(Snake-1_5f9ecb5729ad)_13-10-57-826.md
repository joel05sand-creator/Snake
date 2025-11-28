error id: file://<WORKSPACE>/w10_snake/Player.scala:`<none>`.
file://<WORKSPACE>/w10_snake/Player.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:
	 -key.
	 -key#
	 -key().
	 -scala/Predef.key.
	 -scala/Predef.key#
	 -scala/Predef.key().
offset: 347
uri: file://<WORKSPACE>/w10_snake/Player.scala
text:
```scala
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
      if (keyMap.dir)
      then snake.dir = (keyMap.dir(key@@)) // om key ingår i keyMap så uppdatera snake.dir
    

  def isOpposite(dir: Dir): Dir =
    dir match
      case North => South
      case South => North
      case East => West
      case West => East


object Player:
  enum KeyMap(left: String, right: String, up: String, down: String):
    val dir = Map(left -> West, right -> East, up -> North, down -> South) 
    case Letters extends KeyMap("a", "d", "w", "s")
    case Arrows extends KeyMap("Left", "Right", "Up", "Down")
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.