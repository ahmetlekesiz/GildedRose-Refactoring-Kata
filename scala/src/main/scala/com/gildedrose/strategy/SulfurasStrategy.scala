package com.gildedrose.strategy

import com.gildedrose.Item

case class SulfurasStrategy() extends Strategy {
  override def updateQuality(item: Item): Unit = {}
}
