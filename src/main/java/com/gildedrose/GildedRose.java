package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;

  }



  public void updateQuality() {

    for(Item item : items){
      /*Si on a sulfuras alors on change rien car il ne perd pas en qualité */
      if(item.name == "Sulfuras, Hand of Ragnaros"){
	return;
	}
  		/* Le switch permet une meilleur compréhension en fonction des noms d'items, de plus nous n'avons pas de répétition */
      switch (item.name) {
        case "Aged Brie":
          updateBrie(item); // Je propose de remplacer chaque action sur l'item par une méthode simple pour éviter la redondance
        break;
        case "Backstage passes to a TAFKAL80ETC concert":
          updateBackstage(item);
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
    if (item.sellIn <= 10) {
      addQuality(item);
    }
    if (item.sellIn <= 5) {
      addQuality(item);
    }
    if (item.sellIn <= 0) {
      item.quality = item.quality - item.quality;
    }
  }


  /* 
   	 Ces methodes vont permettre de reduire la redondance des conditions sur la qualité 
     tout en respectant les prérequis (Si c'est supérieur à 50 ou si c'est négatif)
  */

  public void addQuality(Item item) {
    if (item.quality < 50) {
      item.quality++;
    }
  }

  public void reduceQuality(Item item) {
    if (item.quality > 0) {
      item.quality--;
    }
  }
}
