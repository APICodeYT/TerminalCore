package net.pascal.terminal.component;

import net.pascal.terminal.application.TDisplayDrawer;
import net.pascal.terminal.application.TerminalScreen;
import net.pascal.terminal.key.ControlKeyInput;
import net.pascal.terminal.key.ControlKeyType;
import net.pascal.terminal.key.KeyInput;
import net.pascal.terminal.text.BackgroundColor;
import net.pascal.terminal.text.Color;
import net.pascal.terminal.text.ForegroundColor;
import net.pascal.terminal.util.Cancellable;
import net.pascal.terminal.util.TVector;

/**
 * The type Terminal button.
 * Stretchable: no
 */
public class TButton extends TComponent {

    private String name;
    private String text;
    private Runnable runnable;
    private Color[] selectColors;


    /**
     * Instantiates a new Terminal button.
     *
     * @param buttonName the button name
     */
    public TButton(String buttonName) {
        super(new TVector((buttonName.replaceAll("\n", "").length()+2), 1));
        this.name = buttonName.replaceAll("\n", "");
        this.text = "[" + this.name + "]";
        runnable = null;
        selectColors = new Color[]{BackgroundColor.GREEN};
        setSelectable(true);
    }

    /**
     * Sets colors on select
     *
     * @param selectColors the select colors
     */
    public void setSelectColors(Color... selectColors) {
        this.selectColors = selectColors;
    }

    /**
     * Gets name of button.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public void draw(TDisplayDrawer drawer, TerminalScreen screen) {
        drawer.point();
        drawer.reset();
        drawer.loadColors();
        drawer.write(text);
        drawer.dispose();
    }

    @Override
    public void select(TDisplayDrawer drawer, TerminalScreen screen) {
        drawer.point();
        drawer.reset();
        drawer.loadColors();
        drawer.setColors(selectColors);
        drawer.write(text);
        drawer.dispose();
    }

    @Override
    public void deselect(TDisplayDrawer drawer, TerminalScreen screen) {
        drawer.point();
        drawer.reset();
        drawer.loadColors();
        drawer.write(text);
        drawer.dispose();
    }

    @Override
    public void keyInput(TDisplayDrawer drawer, TerminalScreen screen, KeyInput keyInput, Cancellable outKeyInputCancelling) {
        if(keyInput instanceof ControlKeyInput) {
            if(((ControlKeyInput) keyInput).getType() == ControlKeyType.ENTER) {
                outKeyInputCancelling.setCancel(true);
                if(runnable != null) runnable.run();
            }
        }
    }

    /**
     * Sets click event.
     *
     * @param runnable the runnable
     */
    public void setClickEvent(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public boolean isStretchable() {
        return false;
    }
}
