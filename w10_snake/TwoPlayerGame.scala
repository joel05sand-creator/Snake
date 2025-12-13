package snake

class TwoPlayerGame(using settings: settings) extends SnakeGame(settings):
  
  private def greenPlayer = players(0)
  private def bluePlayer = players(1)
  private def greenSnake = greenPlayer.snake
  private def blueSnake = bluePlayer.snake
  // komma åt ormarna som spelarna styr
    val greenDead =
      greenSnake.isTailCollision(greenSnake) ||
      greenSnake.isTailCollision(blueSnake) ||
      greenSnake.isHeadCollision(blueSnake)
    val blueDead =
      blueSnake.isTailCollision(blueSnake) ||
      blueSnake.isTailCollision(greenSnake) ||
      blueSnake.isTailCollision(greenSnake)
    greenDead || blueDead
// spelet är slut om någon orm dör eller om huvudena krockar.
override def enterGameOverState(): Unit =
  state = SnakeGame.State.enterGameOver
  clearMessageArea()

  val greenDead =
    greenSnake.isTailCollision(greenSnake) ||
    greenSnake.isTailCollision(blueSnake) ||
    greenSnake.isHeadCollision(blueSnake)
  val blueDead =
    blueSnake.isTailCollision(blueSnake) ||
    blueSnake.isTailCollision(greenSnake) ||
    blueSnake.isHeadCollision(greenSnake)
  
  val msg =
      if greenDead && blueDead then
        "Game Over! Draw! Press SPACE to restart!"
      else if greenDead then
        s"Game Over! ${bluePlayer.name} player wins! Press SPACE to restart!"
      else if blueDead then
        s"Game Over! ${greenPlayer.name} player wins! Press SPACE to restart!"
      else
        "Game Over! Press SPACE to restart!"

  val (w, h) = settings.windowSize
  drawTextCentered(msg, w / 2, h / 2) // texten i spelplanet

private def drawTextCentered(text: String, x: Int, y: Int): Unit =
  drawText(text, x, y) //hjälpfunktion för centrerad text

override def play(playerNames: String*): Unit =
  val greenName = playerNames.lift(0).getOrElse("Green")
  val blueName = playerNames.lift(1).getOrElse("Blue")

  val dim = Dim(settings.windowSize)
  val middleY = dim.y / 2
  
  val greenStartPos = Pos(dim.x / 4, middleY, dim)
  val blueStartPos = Pos(3 * dim.x / 4, middleY, dim)

  val greenSnake =
    new Snake(
      initPos = greenStartPos,
      initDir = East,
      headColor = Colors.Green,
      tailColor = Colors.DarkGreen
    )(using this, settings)
  
  val blueSnake =
    new Snake(
      initPos = blueStartPos,
      initDir = West,
      headColor = Colors.Blue,
      tailColor = Colors.DarkBlue
    )(using this, settings)

  
  val greenPlayer = Player(greenName, Player.KeyMap.Letters, greenSnake)
  val bluePlayer  = Player(blueName,  Player.KeyMap.Arrows, blueSnake)

  start(greenPlayer, bluePlayer)(greenSnake, blueSnake)
  
// ska ärva SnakeGame

  // ormar och ev. äpple, bananer etc

  def play(playerNames: String*): Unit = ???  // ska överskugga play i SnakeGame

//Det ska gå att spela två och två. I varianten med två spelare
//finns två ormar. Det finns också äpplen, bananer och monster. Om en orm äter
//en banan blir dess svans längre. När ormen ätit ett visst antal äpplen, eller
//om ormen blivit uppäten av ett monster, är spelet slut och poängen visas. En
//ormsvans ska bli längre vid jämna tidsintervall eller om den äter frukt.



//Det ska finnas spelare som motsvarar mänskliga användare och som
//har ett namn och fyra tangenter som den kan spela med. Varje spelare har en
//egen orm som den kan styra med sina tangenter.



//Det ska finnas ormar. En orm består av ett antal block, där det främsta
//blocket kallas huvud och resten av blocken kallas svans. Huvudet har en ljusare
//färg än kroppen. Svansens längd ökar under spelets gång. En orm rör sig i
//en viss riktning och varje spelare kan ändra riktningen på sin orm med sina
//tangenter, i en av fyra riktningar North, South, East eller West.



//Inställningar för spelet ska vara konfigurerbara genom en textfil som
//laddas i början av spelet. Inställningar ska vara en kontextparameter.
