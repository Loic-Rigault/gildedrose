package com.gildedrose;

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    final String comma = ", ";
    return this.name + comma + this.sellIn + comma + this.quality;
  }
}
