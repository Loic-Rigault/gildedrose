package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;

  }

  public void updateQuality() {
  		/* Le switch permet une meilleur compréhension en fonction des noms d'items, de plus nous n'avons pas de répétition */
    switch (item.name) {
      case "Sulfuras, Hand of Ragnaros":
 			  return; // Comme sulfuras ne change pas de qualité alors je vais quitter la fonction pour eviter tout problèmes
        break;
      case "Aged Brie":
        updateBrie(); // Je propose de remplacer chaque action sur l'item par une méthode simple pour éviter la redondance
        break;
      case "Backstage passes to a TAFKAL80ETC concert":
        updateBackstage();
        break;
      default:
        reduceQuality();
        if (item.sellIn < 0) {
          reduceQuality();
        } 
        break;
    }
    /* Comme le sellin diminue à chaque fois alors on le fait pour tous */
    item.sellIn = item.sellIn - 1;
  }


  public void updateBrie() {
  	addQuality();
    if (item.sellIn < 0) {
      addQuality();
    }
  }

  public void updateBackstage() {
  	addQuality();
    if (item.sellIn < 10) {
      addQuality();
    }
    if (item.sellIn < 5) {
      addQuality();
    }
    if (item.sellIn < 0) {
      item.quality = item.quality - item.quality;
    }
  }


  /* 
   	 Ces methodes vont permettre de reduire la redondance des conditions sur la qualité 
     tout en respectant les prérequis (Si c'est supérieur à 50 ou si c'est négatif)
  */

  public void addQuality() {
    if (item.quality < 50) {
      item.quality++;
    }
  }

  public void reduceQuality() {
    if (item.quality > 0) {
      item.quality--;
    }
  }
}
