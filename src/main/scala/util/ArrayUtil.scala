package util

import scala.annotation.tailrec

object ArrayUtil {

  def switchPlaces[T](first: Int, second: Int, array: Array[T]) = {
    val value = array(first)
    array(first) = array(second)
    array(second) = value
  }

  @tailrec
  def reverseWithIndex[T](index1: Int, index2: Int, array: Array[T]): Array[T] = {
    if (index1 > index2) array
    else {
      switchPlaces(index1, index2, array)
      reverseWithIndex(index1 + 1, index2 - 1, array)
    }
  }
}
