package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println() 
    }
    println(balance(List(':', '-', ')')))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    c match {
      case 0 => 1
      case _ if (c == r) => 1
      case _ => pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def f(chars: List[Char], nums: Int): Boolean = {
      chars.isEmpty match {
        case true => nums == 0
        case _ => {
          val n = chars.head match {
            case '(' => nums + 1
            case ')' => nums - 1
            case _ => nums
          }
          if (n >= 0) f(chars.tail, n)
          else false
        }
      }
    }
    f(chars, 0)
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

      def loop(money:Int, coins: List[Int]):Int = {
        if (money == 0) 1   // check whether change(money - first coin of list ) is 0 or not
        else if (money < 0 || coins.isEmpty) 0 // case : money - first coin of list < 0 -> break
        else loop(money, coins.tail) + loop((money - coins.head), coins) // keep going
      }

    loop(money, coins)
  }


}
