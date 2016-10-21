package dbg28

/**
  * EECS 293
  * Created by Daniel on 10/20/2016.
  * dbg28@case.edu
  *
  * The purpose of this class is to provide other tester classes with
  * easy access to fresh instances of default data, random data, and other testing data
  */
class TestTool {

  // Global fields

  var database: OpposingGroups[Ninja] = _
  var bigDatabase: OpposingGroups[Ninja] = _
  var n1: Ninja = _
  var n2: Ninja = _
  var ninjaSetOfTen: Set[Ninja] = _
  var n1Wrap: ObjectWrapper[Ninja] = _
  var n2Wrap: ObjectWrapper[Ninja] = _
  var objectWrapperSetOfTen: Set[ObjectWrapper[Ninja]] = _
  var setWrapperFirst: SetWrapper[Ninja] = _
  var setWrapperSecond: SetWrapper[Ninja] = _
  var setWrapperThird: SetWrapper[Ninja] = _
  var setWrapperFourth: SetWrapper[Ninja] = _
  var pairFirst: Pair[Ninja] = _
  var pairSecond: Pair[Ninja] = _

  /**
    *  Setup: Initialize a database with two Pairs of single Ninjas
    */
  def createDatabaseWithNinjas(): TestTool = {
    // Start new Database
    database = new OpposingGroups[Ninja]()
    //Initialize Two Ninjas and their ObjectWrappers -- probably can remove
    n1 = new Ninja()
    n2 = new Ninja()
    n1Wrap = database.create(n1)
    n2Wrap = database.create(n2)
    // Initialize a Set of 10 Ninjas and their set of ObjectWrappers
    ninjaSetOfTen = Set.empty[Ninja]
    1 to 10 foreach { _ => ninjaSetOfTen + new Ninja() }
    objectWrapperSetOfTen = Set.empty[ObjectWrapper[Ninja]]
    ninjaSetOfTen foreach {objectWrapperSetOfTen + bigDatabase.create(_)}
    // Initialize four SetWrappers
    setWrapperFirst = new SetWrapper[Ninja]()
    setWrapperSecond = new SetWrapper[Ninja]()
    setWrapperThird = new SetWrapper[Ninja]()
    setWrapperFourth = new SetWrapper[Ninja]()
    // Initialize two Pairs
    pairFirst = new Pair[Ninja](setWrapperFirst, setWrapperSecond)
    List(setWrapperFirst, setWrapperSecond).foreach(_.setPair(pairFirst))
    pairSecond = new Pair[Ninja](setWrapperThird, setWrapperFourth)
    List(setWrapperThird, setWrapperFourth).foreach(_.setPair(pairSecond))
    // TODO: Separate into functionally cohesive methods
    this
  }
}