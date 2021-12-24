package com.gildedrose.strategy

import com.gildedrose.Item

class AgedBriedStrategy extends Strategy {
  override def updateQuality(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (item.quality < 50) {
      item.quality = item.quality + 1
      if (item.sellIn < 0) {
        item.quality = item.quality + 1
      }
    }
  }
}
