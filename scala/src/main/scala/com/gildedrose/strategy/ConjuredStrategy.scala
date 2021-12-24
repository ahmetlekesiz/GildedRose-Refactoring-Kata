package com.gildedrose.strategy

import com.gildedrose.Item

case class ConjuredStrategy() extends Strategy {
  override def updateQuality(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (item.quality > 0) {
      item.quality = item.quality - 2
      if (item.sellIn < 0) {
        item.quality = item.quality - 2
      }
    }
  }
}
