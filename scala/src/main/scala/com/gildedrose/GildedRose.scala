package com.gildedrose

import com.gildedrose.strategy.{AgedBriedStrategy, BackstagePassesStrategy, ConjuredStrategy, DefaultStrategy, SulfurasStrategy}

class GildedRose(val items: Array[Item]) {

  def applyStrategy(item: Item): Unit = item.name match {
    case ItemName.AgedBrie        => new AgedBriedStrategy().updateQuality(item)
    case ItemName.Sulfuras        => new SulfurasStrategy().updateQuality(item)
    case ItemName.BackstagePasses => new BackstagePassesStrategy().updateQuality(item)
    case ItemName.Conjured        => new ConjuredStrategy().updateQuality(item)
    case _                        => new DefaultStrategy().updateQuality(item)
  }

  def updateQuality(): Unit = items.foreach(e => applyStrategy(e))

}