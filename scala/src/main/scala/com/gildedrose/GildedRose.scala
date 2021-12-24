package com.gildedrose

class GildedRose(val items: Array[Item]) {
  
  def updateQualityDefault(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (item.quality > 0) {
        item.quality = item.quality - 1
      if(item.sellIn < 0){
        item.quality = item.quality - 1
      }
    }
  }

  def AgedBrieUpdateQuality(item: Item): Unit = {
    if (item.quality < 50) {
      item.quality = item.quality + 1
    }
    item.sellIn = item.sellIn - 1
    if (item.sellIn < 0) {
      if (item.quality < 50) {
        item.quality = item.quality + 1
      }
    }
  }

  def SulfurasUpdateQuality: Unit = {}

  def BackstagePassesUpdateQuality(item: Item): Unit = {
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

  def ConjuredUpdateQuality(item: Item): Unit = {
    if (item.quality > 0) {
      item.quality = item.quality - 2
    }
    item.sellIn = item.sellIn - 1
    if (item.sellIn < 0) {
      if (item.quality > 0) {
        item.quality = item.quality - 2
      }
    }
  }

  def callSpecialFunction(item: Item): Unit = item.name match {
    case ItemName.AgedBrie  => AgedBrieUpdateQuality(item)
    case ItemName.Sulfuras  => SulfurasUpdateQuality
    case ItemName.BackstagePasses => BackstagePassesUpdateQuality(item)
    case ItemName.Conjured => ConjuredUpdateQuality(item)
    case _                  => updateQualityDefault(item)
  }

  def updateQuality() {
   items.foreach(e => callSpecialFunction(e))
  }
}