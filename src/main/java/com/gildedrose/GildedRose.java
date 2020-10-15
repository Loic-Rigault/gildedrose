package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;

  }

  public void updateQuality() {
    final String agedBrie = "Aged Brie";
    final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    final String sulfuras = "Sulfuras, Hand of Ragnaros";

    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals(agedBrie)
          && !items[i].name.equals(backstage)) {
        if (items[i].quality > 0) {
          if (!items[i].name.equals(sulfuras)) {
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;

          if (items[i].name.equals(backstage)) {
            if (items[i].sellIn < 11) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      }

      if (!items[i].name.equals(sulfuras)) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals(agedBrie)) {
          if (!items[i].name.equals(backstage)) {
            if (items[i].quality > 0) {
              if (!items[i].name.equals(sulfuras)) {
                items[i].quality = items[i].quality - 1;
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
          }
        }
      }
    }
  }
}
