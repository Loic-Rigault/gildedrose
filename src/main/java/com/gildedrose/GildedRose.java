package com.gildedrose;

class GildedRose {

  private static final int MAX_QUALITY = 50;
  private static final int TIME_BACKSTAGE_FIVE = 5;
  private static final int TIME_BACKSTAGE_TEN = 10;

//Private ?
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {

    for (Item item : items) {
      if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        return;
      }
  /* Le switch permet une meilleur compréhension en fonction des noms d'items*/
      switch (item.name) {
        case "Aged Brie":
          updateBrie(item);
/* Il faut remplacer chaque action sur l'item par une méthode simple pour éviter la redondance */
          break;
        case "Backstage passes to a TAFKAL80ETC concert":
          updateBackstage(item);
          break;
        case "Conjured Mana Cake":
          updateConjured(item);
          break;
        default:
          reduceQuality(item);
          if (item.sellIn <= 0) {
            reduceQuality(item);
          }
          break;
      }
    /* Comme le sellin diminue à chaque fois alors on le fait pour tous */
      item.sellIn = item.sellIn - 1;
    }
  }

  public void updateBrie(Item item) {
    addQuality(item);
    if (item.sellIn <= 0) {
      addQuality(item);
    }
  }

  public void updateBackstage(Item item) {
    addQuality(item);
    if (item.sellIn <= TIME_BACKSTAGE_TEN) {
      addQuality(item);
    }
    if (item.sellIn <= TIME_BACKSTAGE_FIVE) {
      addQuality(item);
    }
    if (item.sellIn <= 0) {
      item.quality = item.quality - item.quality;
    }
  }

  public void updateConjured(Item item) {
    reduceQuality(item);
    reduceQuality(item);
    if (item.sellIn <= 0) {
      reduceQuality(item);
      reduceQuality(item);
    }
  }

/* Ces methodes vont permettre de reduire la redondance
des conditions sur la qualité tout en respectant les prérequis.
(Si c'est supérieur à 50 ou si c'est négatif) */

  public void addQuality(Item item) {
    if (item.quality < MAX_QUALITY) {
      item.quality++;
    }
  }

  public void reduceQuality(Item item) {
    if (item.quality > 0) {
      item.quality--;
    }
  }
}
