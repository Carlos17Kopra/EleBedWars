//CopyRight at Carlos17Kopra | Arvid

package de.elementalcraft.util;

public enum Teams {

    //Teams-Enum für das einfache Management

    NONE("kein Team", '7');

    Teams(String prefix, char code){
        this.prefix = prefix;
        this.code = code;
    }

    private String prefix;
    private char code;

    public String getPrefix() {
        return prefix;
    }

    public char getCode() {
        return code;
    }
}
