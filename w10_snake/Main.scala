package snake
/////////////////////////// banan

def createTwoPlayerGame(): Unit = 
  Settings.default.windowTitle = "Snake: Two Player"
  TwoPlayerGame().play()

@main
def run: Unit = 
  val buttons = 
    Seq("One", "Two", "Competition", "Tournament", "Cancel")
  val selected = 
    introprog.Dialog.select("Number of players?", buttons, "Snake")
  selected match 
    case "Two"         => createTwoPlayerGame()
    case "Competition" => println(s"TODO: $selected") 
    case "Tournament"  => println(s"TODO: $selected") 
    case  _            => println("Goodbye!")