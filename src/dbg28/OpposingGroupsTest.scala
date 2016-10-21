package dbg28

import org.junit.Assert._
import org.junit.{Before, Test}

/**
  * EECS 293
  * Created by Daniel on 10/20/2016.
  * dbg28@case.edu
  */
class OpposingGroupsTest {

  // Global fields

  var database: OpposingGroups[Ninja] = _
  var n1: Ninja = _
  var n2: Ninja = _
  var n1Wrap: ObjectWrapper[Ninja] = _
  var n2Wrap: ObjectWrapper[Ninja] = _

  // Test Methods

  /**
    *  Setup: Initialize a database with two Pairs of single Ninjas
    */
  @Before
  def createDatabaseWithNinjas(): Unit = {
    database = new OpposingGroups[Ninja]()
    n1 = new Ninja()
    n2 = new Ninja()
    n1Wrap = database.create(n1)
    n2Wrap = database.create(n2)
  }

  /**
    * Attempts to create the database and check that values were added to it
    */
  @Test
  def testCreate(): Unit = {
    assert(database.getOpposingDatabase.nonEmpty)
    assert(database.getOpposingDatabase.size.equals(2))
  }

  /**
    * Checks for correct opponent status for two ninjas, in the three states of rivalry
    * Three States: Unknown Rivalry, allies, opponents
    */
  @Test
  def testOpponents() {
    assertEquals(database.opponents(n1Wrap, n2Wrap), None)
    database.oppose(n1Wrap, n2Wrap)
    assertEquals(Some(false), database.opponents(n2Wrap, n2Wrap))
    assertEquals(Some(true),database.opponents(n1Wrap, n2Wrap))
  }

  /**
    * Adds the fact that two Ninjas are opponents, and verifies this fact against the database
    */
  @Test
  def testOppose(): Unit = {
    assertEquals(None,database.opponents(n1Wrap, n2Wrap))
    database.oppose(n1Wrap, n2Wrap)
    assertEquals(Some(true),database.opponents(n1Wrap, n2Wrap))
    try {
      database.oppose(n1Wrap, n2Wrap)
      assert(false) // Exception should be thrown before this would occur
    } catch {
      case i: IllegalArgumentException => assert(true)
      case e: Exception => assert(false)
    }
  }
}