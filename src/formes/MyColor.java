package formes;

import java.awt.Color;

/**
 * Enum contenant les couleures disponibles et les liant aux couleures awt
 */
public enum MyColor {
    /**
     * liaison des couleurs à celles de awt
     */
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    BLACK(Color.BLACK),
    YELLOW(Color.YELLOW),
    CYAN(Color.CYAN);

    private final Color awtColor;

    /**
     * constructeur via couleure awt
     * @param awtColor couleur awt
     */
    MyColor(Color awtColor) {
        this.awtColor = awtColor;
    }

    /**
     * get de la version AWT d'une couleure
     * @return awtColor
     */
    public Color toAwt() {
        return awtColor;
    }
}