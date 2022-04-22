package de.materna.candyLord.Enums;

import java.awt.geom.Point2D;

//TODO ID reinbringen um für auswahl -> Cityenum.Berlin.ordinal nutzbar als auswahl ID
public enum CityEnum {
    BERLIN(10, new Point2D.Double(8,5)),
    FRANKFURT(30, new Point2D.Double(-3,-3)),
    BREMEN(20,new Point2D.Double(-5, 7)),
    HAMBURG(5, new Point2D.Double(0,8)),
    MUENCHEN(20, new Point2D.Double(-9, 4));

    private int priceFactor;
    private Point2D.Double pointOnMap;

    CityEnum(int priceFactor, Point2D.Double pointOnMap) {
        this.priceFactor = priceFactor;
        this.pointOnMap = pointOnMap;
    }

    public int getPriceFactor() {
        return priceFactor;
    }

    public Point2D.Double getPointOnMap() {
        return pointOnMap;
    }
}
