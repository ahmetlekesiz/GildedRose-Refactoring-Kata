package com.gildedrose

class GildedRose(val items: Array[Item]) {
  
  def updateQuailtyDefault(item: Item): Unit = {
    if (!item.name.equals("Aged Brie")
      && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (item.quality > 0) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
          if (item.name.equals("Conjured Mana Cake")) {
            item.quality = item.quality - 2
          } else {
            item.quality = item.quality - 1
          }
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
      }
    }

    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn = item.sellIn - 1
    }

    if (item.sellIn < 0) {
      if (!item.name.equals("Aged Brie")) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
              if (item.name.equals("Conjured Mana Cake")) {
                item.quality = item.quality - 2
              } else {
                item.quality = item.quality - 1
              }
            }
          }
        } else {
          item.quality = item.quality - item.quality
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1
        }
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

  def BackstagePasses(item: Item): Unit = {
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

  def callSpecialFunction(item: Item): Unit = item.name match {
    case ItemName.AgedBrie  => AgedBrieUpdateQuality(item)
    case ItemName.Sulfuras  => SulfurasUpdateQuality
    case ItemName.BackstagePasses => BackstagePasses(item)
    case _                  => updateQuailtyDefault(item)
  }

  def updateQuality() {
   items.foreach(e => callSpecialFunction(e))
  }
}