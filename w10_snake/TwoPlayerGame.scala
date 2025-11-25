package snake

class TwoPlayerGame:  // ska ärva SnakeGame

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
