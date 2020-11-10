package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

////////////////////////////////////////////////////////////////////
//                                                                //
//           TP Génie Logiciel Avancé : Rigault Loïc              //
//                                                                //
////////////////////////////////////////////////////////////////////


class GildedRoseTest {

	//Test Default
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is("foo"));
    }


////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                    Tests unitaires sur la qualité                          //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////


	//Test qualité pour Aged Brie avec sa qualité qui augmente bien de 1
    @Test
    void qualityAgedBrie() {
        int qual = 5;
	int sell = 9;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+1));
    }

	//Test qualité pour Aged Brie avec sa qualité qui augmente bien de 1 avec la qualité en negative
    @Test
    void qualityAgedBrieQualityZero() {
        int qual = 0;
	int sell = 9;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+1));
	}

	//test qualité si ca depasse 50 de qualité
    @Test
    void qualityAgedBrieFifty(){
        int qual = 50;
	int sell = 10;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));
    }

	//Test qualité pour Aged Brie et sellIn <= 0
    @Test
    void qualityAgedBrieSellInZero() {
        int qual = 10;
	int sell = 0;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+2));
    }

	//Test qualité pour Aged Brie ou quality et sellIn <= 0
    @Test
    void qualityAgedBrieZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+2));
    }

	//Test qualité pour Backstage passes avec sa qualité qui augmente bien de 2 lorsque sellIn > 10
    @Test
    void qualityBackstageAboveTen() {
        int qual = 10;
	int sell = 15;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+1));
    }

	//Test qualité pour Backstage passes avec sa qualité qui augmente bien de 2 lorsque sellIn <= 10
    @Test
    void qualityBackstageUnderTen() {
        int qual = 10;
	int sell = 9;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+2));
    }

	//Test qualité pour Backstage passes avec sa qualité qui augmente bien de 3 lorsque sellIn <= 5
    @Test
    void qualityBackstageUnderFive() {
        int qual = 10;
	int sell = 5;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual+3));
    }

	//Test qualité du backstage qui atteint 0 si sellIn est <= -1
    @Test
    void qualityBackstageSellInZero() {
        int qual = 50;
	int sell = 0;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual-qual));
    }

	//Test qualité du backstage qui atteint 0 si sellIn est <= -1 + qualité a 0
    @Test
    void qualityBackstageZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual-qual));
    }

	//Test qualité pour sulfuras avec sa qualité de 80
    @Test
    void qualitySulfuras() {
        int qual = 80;
	int sell = 10;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));
    }

	//test qualité  si sulfuras descend pas même avec sellIn <= 0
   @Test
    void qualitySulfurasSellInZero() {
        int qual = 80;
	int sell = 0;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));
   }

	//test qualité si sulfuras descend pas même avec quality <= 0
   @Test
    void qualitySulfurasQualityZero() {
        int qual = 0;
	int sell = 10;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));
   }

	//test qualité si sulfuras descend pas même avec sellIn et quality <= 0
   @Test
    void qualitySulfurasZero() {
        int qual = 50;
	int sell = 0;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));
   }


	//Test qualité pour un item classique et SellIn a 0
    @Test
    void qualityItemSellInZero() {
        int qual = 10;
	int sell = 0;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual-2));
    }

	//Test qualité pour un item classique
    @Test
    void qualityItem() {
        int qual = 5;
	int sell = 9;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual-1));
    }

	//Test qualité pour un item classique mais avec quality a 0
    @Test
    void qualityItemQualityZero() {
        int qual = 0;
	int sell = 9;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));

    }
	//Test qualité pour un item classique mais avec quality et sellin a 0
    @Test
    void qualityItemZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual));

    }

    @Test
    void qualityConjured() {
        int qual = 20;
	int sell = 10;
	Item[] items = new Item[] { new Item("Conjured Mana Cake", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual-2));
    }

    @Test
    void qualityConjuredZero() {
        int qual = 20;
	int sell = 0;
	Item[] items = new Item[] { new Item("Conjured Mana Cake", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality, is(qual-4));
    }

////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                    Tests unitaires sur le SellIn                           //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

//assertThat(app.items[0].sellIn, is(sell-1));

	//Test sellIn pour Aged Brie avec sa qualité qui augmente bien de 1
    @Test
    void sellInAgedBrie() {
        int qual = 5;
	int sell = 9;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour Aged Brie avec sa qualité qui augmente bien de 1 avec la qualité en negative
    @Test
    void sellInAgedBrieQualityZero() {
        int qual = 0;
	int sell = 9;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
	}

	//test sellIn si ca depasse 50 de qualité
    @Test
    void sellInAgedBrieFifty(){
        int qual = 50;
	int sell = 10;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour Aged Brie et sellIn <= 0
    @Test
    void sellInAgedBrieSellInZero() {
        int qual = 10;
	int sell = 0;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour Aged Brie ou quality et sellIn <= 0
    @Test
    void sellInAgedBrieZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("Aged Brie", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour Backstage passes avec sa qualité qui augmente bien de 2 lorsque sellIn > 10
    @Test
    void sellInBackstageAboveTen() {
        int qual = 0;
	int sell = 15;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour Backstage passes avec sa qualité qui augmente bien de 2 lorsque sellIn <= 10
    @Test
    void sellInBackstageUnderTen() {
        int qual = 0;
	int sell = 9;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour Backstage passes avec sa qualité qui augmente bien de 3 lorsque sellIn <= 5
    @Test
    void sellInBackstageUnderFive() {
        int qual = 0;
	int sell = 5;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn du backstage qui atteint 0 si sellIn est <= -1
    @Test
    void sellInBackstageSellInZero() {
        int qual = 10;
	int sell = 0;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn du backstage qui atteint 0 si sellIn est <= -1 + qualité a 0
    @Test
    void sellInBackstageZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour sulfuras avec sa qualité de 80
    @Test
    void sellInSulfuras() {
        int qual = 80;
	int sell = 10;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell));
    }

	//test sellIn si sulfuras descend pas même avec sellIn <= 0
   @Test
    void sellInSulfurasSellInZero() {
        int qual = 80;
	int sell = 0;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell));
   }

	//test sellIn si sulfuras descend pas même avec quality <= 0
   @Test
    void sellInSulfurasQualityZero() {
        int qual = 0;
	int sell = 10;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell));
   }

	//test sellIn si sulfuras descend pas même avec sellIn et quality <= 0
   @Test
    void sellInSulfurasZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell));
   }


	//Test sellIn pour un item classique et SellIn a 0
    @Test
    void sellInItemSellInZero() {
        int qual = 10;
	int sell = 0;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour un item classique
    @Test
    void sellInItem() {
        int qual = 5;
	int sell = 9;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }

	//Test sellIn pour un item classique mais avec quality a 0
    @Test
    void sellInItemQualityZero() {
        int qual = 0;
	int sell = 9;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));

    }
	//Test sellIn pour un item classique mais avec quality et sellin a 0
    @Test
    void sellInItemZero() {
        int qual = 0;
	int sell = 0;
	Item[] items = new Item[] { new Item("+5 Dexterity Vest", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));

    }

    @Test
    void sellInConjured(){
        int qual = 40;
	int sell = 10;
	Item[] items = new Item[] { new Item("Conjured Mana Cake", sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sell-1));
    }
////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                    Tests unitaires sur le nom                              //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

//assertThat(app.items[0].name, is(n));

	//Test nominal pour Aged Brie avec sa qualité qui augmente bien de 1
    @Test
    void NameAgedBrie() {
        int qual = 5;
	int sell = 9;
	String n = "Aged Brie";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour Aged Brie avec sa qualité qui augmente bien de 1 avec la qualité en negative
    @Test
    void NameAgedBrieQualityZero() {
        int qual = 0;
	int sell = 9;
	String n = "Aged Brie";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
	}
	//test nominal si ca depasse 50 de qualité
    @Test
    void NameAgedBrieFifty(){
        int qual = 50;
	int sell = 10;
	String n = "Aged Brie";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour Aged Brie et sellIn <= 0
    @Test
    void NameAgedBrieSellInZero() {
        int qual = 10;
	int sell = 0;
	String n = "Aged Brie";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour Aged Brie ou quality et sellIn <= 0
    @Test
    void NameAgedBrieZero() {
        int qual = 0;
	int sell = 0;
	String n = "Aged Brie";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour Backstage passes avec sa qualité qui augmente bien de 2 lorsque sellIn > 10
    @Test
    void NameBackstageAboveTen() {
        int qual = 0;
	int sell = 15;
	String n = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour Backstage passes avec sa qualité qui augmente bien de 2 lorsque sellIn <= 10
    @Test
    void NameBackstageUnderTen() {
        int qual = 0;
	int sell = 9;
	String n = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour Backstage passes avec sa qualité qui augmente bien de 3 lorsque sellIn <= 5
    @Test
    void NameBackstageUnderFive() {
        int qual = 0;
	int sell = 5;
	String n = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal du backstage qui atteint 0 si sellIn est <= -1
    @Test
    void NameBackstageSellInZero() {
        int qual = 10;
	int sell = 0;
	String n = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal du backstage qui atteint 0 si sellIn est <= -1 + qualité a 0
    @Test
    void NameBackstageZero() {
        int qual = 0;
	int sell = 0;
	String n = "Backstage passes to a TAFKAL80ETC concert";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour sulfuras avec sa quality de 80
    @Test
    void NameSulfuras() {
        int qual = 80;
	int sell = 10;
	String n = "Sulfuras, Hand of Ragnaros";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//test nominal si sulfuras descend pas même avec sellIn <= 0
   @Test
    void NameSulfurasSellInZero() {
        int qual = 80;
	int sell = 0;
	String n = "Sulfuras, Hand of Ragnaros";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
   }

	//test nominal si sulfuras descend pas même avec quality <= 0
   @Test
    void NameSulfurasQualityZero() {
        int qual = 0;
	int sell = 10;
	String n = "Sulfuras, Hand of Ragnaros";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));;
   }

	//test nominal si sulfuras descend pas même avec sellIn et quality <= 0
   @Test
    void NameSulfurasZero() {
        int qual = 0;
	int sell = 0;
	String n = "Sulfuras, Hand of Ragnaros";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
   }


	//Test nominal pour un item classique et SellIn a 0
    @Test
    void NameItemSellInZero() {
        int qual = 10;
	int sell = 0;
	String n = "Diamond Boot";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour un item classique
    @Test
    void NameItem() {
        int qual = 5;
	int sell = 9;
	String n = "+5 Dexterity Vest";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));
    }

	//Test nominal pour un item classique mais avec quality a 0
    @Test
    void NameItemQualityZero() {
        int qual = 0;
	int sell = 9;
	String n = "+5 Dexterity Vest";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));

    }
	//Test nominal pour un item classique mais avec quality et sellin a 0
    @Test
    void NameItemZero() {
        int qual = 0;
	int sell = 0;
	String n = "+5 Dexterity Vest";
	Item[] items = new Item[] { new Item(n, sell, qual) };
	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name, is(n));

    }

}
