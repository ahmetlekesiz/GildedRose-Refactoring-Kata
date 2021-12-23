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

  "quality of an item" should "degrades twice as fast when the sell by date has passed" in {
    val items = Array[Item](new Item("foo", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 8
    app.items(0).quality should equal(expected)
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

  "quality of Aged Brie" should "increase by 2 when it gets older and passed the sellIn" in {
    val items = Array[Item](new Item("Aged Brie", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 2
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

  "sellIn of Sulfuras, Hand of Ragnaros" should "not decrease" in {
    val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 5, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 5
    app.items(0).sellIn should equal(expected)
  }

  "quality of Sulfuras, Hand of Ragnaros" should "not change" in {
    val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 5, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 50
    app.items(0).quality should equal(expected)
  }

  "quality of Backstage passes" should "increase by 2 when there are 10 days or less" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 22
    app.items(0).quality should equal(expected)
  }

  "quality of Backstage passes" should "increase by 3 when there are 5 days or less" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 23
    app.items(0).quality should equal(expected)
  }

  "quality of Backstage passes" should "drops to 0 after the concert" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 0
    app.items(0).quality should equal(expected)
  }

  "quality of Conjured items" should "degrade in Quality twice as fast as normal items" in {
    val items = Array[Item](new Item("Conjured Mana Cake", 5, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 8
    app.items(0).quality should equal(expected)
  }

  "quality of Conjured items" should "degrade in Quality twice as fast as normal items when the sell by date has passed" in {
    val items = Array[Item](new Item("Conjured Mana Cake", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    val expected = 6
    app.items(0).quality should equal(expected)
  }
}