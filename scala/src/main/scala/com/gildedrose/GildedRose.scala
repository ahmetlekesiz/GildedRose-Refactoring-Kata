package com.gildedrose

import com.gildedrose.strategy.{AgedBriedStrategy, BackstagePassesStrategy, ConjuredStrategy, DefaultStrategy}

class GildedRose(val items: Array[Item]) {

  def applyStrategy(item: Item): Unit = item.name match {
    case ItemName.AgedBrie        => AgedBriedStrategy().updateQuality(item)
    case ItemName.Sulfuras        => ()
    case ItemName.BackstagePasses => BackstagePassesStrategy().updateQuality(item)
    case ItemName.Conjured        => ConjuredStrategy().updateQuality(item)
    case _                        => DefaultStrategy().updateQuality(item)
  }

  def updateQuality(): Unit = items.foreach(e => applyStrategy(e))

}