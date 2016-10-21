package dbg28

/**
  * EECS 293
  * Created by Daniel on 10/16/2016.
  * dbg28@case.edu
  *
  * Pair: Contains two SetWrappers that are in diferent groups
  */
class Pair[N](primarySet: SetWrapper[N], secondarySet: SetWrapper[N]) {

  /** Return the SetWrapper that is the opponent of the argument - O(1)
    *
    * @param x the SetWrapper to find the opponents of
    * @return the opponents of the input
    */
  def getOpponentSet(x: SetWrapper[N]): SetWrapper[N] = {
    if (x equals primarySet) {
      secondarySet
    }
    else if (x equals secondarySet) {
      primarySet
    }
    else {
      throw new IllegalArgumentException("You tried to get the opponent set for an Set that is not in this Pair")
    }
  }
}