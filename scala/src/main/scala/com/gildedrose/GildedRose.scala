package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def defaultUpdateQuality(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (item.quality > 0) {
        item.quality = item.quality - 1
      if(item.sellIn < 0){
        item.quality = item.quality - 1
      }
    }
  }

  def agedBrieUpdateQuality(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (item.quality < 50) {
      item.quality = item.quality + 1
      if (item.sellIn < 0) {
        item.quality = item.quality + 1
      }
    }
  }

  def backstagePassesUpdateQuality(item: Item): Unit = {
    if (item.quality < 50) {
      item.quality = item.quality + 1
      if (item.sellIn < 11) {
        if (item.quality < 50) {
          item.quality = item.quality + 1
        }
      }
      if (item.sellIn < 6) {
        if (item.quality < 50) {
          item.quality = item.quality + 1
        }
      }
    }
    item.sellIn = item.sellIn - 1
    if (item.sellIn < 0) {
      item.quality = item.quality - item.quality
    }
  }

  def conjuredUpdateQuality(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (item.quality > 0) {
      item.quality = item.quality - 2
      if (item.sellIn < 0) {
        item.quality = item.quality - 2
      }
    }
  }

  def callSpecialFunction(item: Item): Unit = item.name match {
    case ItemName.AgedBrie        => agedBrieUpdateQuality(item)
    case ItemName.Sulfuras        => ()
    case ItemName.BackstagePasses => backstagePassesUpdateQuality(item)
    case ItemName.Conjured        => conjuredUpdateQuality(item)
    case _                        => defaultUpdateQuality(item)
  }

  def updateQuality(): Unit = items.foreach(e => callSpecialFunction(e))

}