package formes;

import java.awt.Color;

/**
 * Enum contenant les couleures disponibles et les liant aux couleures awt
 */
public enum MyColor {

    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    BLACK(Color.BLACK),
    YELLOW(Color.YELLOW),
    CYAN(Color.CYAN);

    private final Color awtColor;

    MyColor(Color awtColor) {
        this.awtColor = awtColor;
    }

    public Color toAwt() {
        return awtColor;
    }
}