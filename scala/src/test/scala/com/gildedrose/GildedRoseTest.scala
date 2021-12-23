package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFlatSpec with Matchers {

  it should "foo" in {
    val items = Array[Item](new Item("foo", 5, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal ("foo")
  }

  "quality of an item" should "be positive" in {
    val items = Array[Item](new Item("foo", 5, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 0
    app.items(0).quality should equal(expected)
  }

  "quality of Aged Brie" should "increase when it gets older" in {
    val items = Array[Item](new Item("Aged Brie", 5, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 1
    app.items(0).quality should equal(expected)
  }

  "quality of Aged Brie" should "not be more than 50" in {
    val items = Array[Item](new Item("Aged Brie", 5, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 50
    app.items(0).quality should equal(expected)
  }

  "quality of Backstage passes" should "not be more than 50" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 50
    app.items(0).quality should equal(expected)
  }
}