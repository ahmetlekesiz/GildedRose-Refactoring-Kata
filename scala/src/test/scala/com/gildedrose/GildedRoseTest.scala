package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFlatSpec with Matchers {

  val items = Array[Item](new Item("foo", 5, 0))

  it should "foo" in {
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal ("foo")
  }

  "quality of an item" should "be positive" in {
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 0
    app.items(0).quality should equal(expected)
  }
}