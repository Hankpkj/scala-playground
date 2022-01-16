package funsets

object Main extends App:
  import FunSets.*
  println(contains(singletonSet(1), 1))
  val set1 = union(singletonSet(1), singletonSet(2)) 
  val set2 = singletonSet(3)
  val set3 = union(set1, singletonSet(5))
  println(contains(set1, 3))
  printSet(diff(set3, set1))

