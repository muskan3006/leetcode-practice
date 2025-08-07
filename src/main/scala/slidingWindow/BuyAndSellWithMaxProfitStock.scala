package slidingWindow

object BuyAndSellWithMaxProfitStock extends App {

  import scala.annotation.tailrec
  def maxProfitBuySell(stockPrices: Array[Int]): Int = {
    val size = stockPrices.length

    @tailrec
    def helper(left: Int, right: Int, profit: Int): Int = {
      if (right < size) {
        val currentProfit = stockPrices(right) - stockPrices(left)
        if (currentProfit > 0) {
          helper(left, right + 1, math.max(profit, currentProfit))
        } else {
          helper(right, right + 1, profit)
        }
      } else profit
    }

    helper(0, 1, 0)
  }

  println(maxProfitBuySell(Array(7, 1, 2, 3, 4, 6, 5)))
}
