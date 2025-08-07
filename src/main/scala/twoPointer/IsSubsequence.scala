package twoPointer

import scala.annotation.tailrec

object IsSubsequence extends App{
  def isSubsequence(s: String, t: String): Boolean = {
    val sArray = s.toCharArray
    val sArraySize = sArray.length
    val tArray = t.toCharArray
    val tArraySize = tArray.length

    @tailrec
    def isSubsequence(startt: Int, startS: Int): Boolean = {
      if (startS < sArraySize && startt < tArraySize) {
        if (sArray(startS) == tArray(startt)) isSubsequence(startt + 1, startS + 1)
        else isSubsequence(startt + 1, startS)
      } else if (startS == sArraySize) true else false
    }

    if (s == t) true else if (sArraySize >= tArraySize) false else isSubsequence(0, 0)
  }

}
