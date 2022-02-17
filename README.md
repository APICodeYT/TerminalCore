# TerminalCore
Terminal library for Windows/Linux.

This library contains all colors as ascii codes, native functions of the respective operating systems, cursor movement and simplified terminal functions.

![Sample app](https://github.com/APICodeYT/TerminalCore/blob/main/ressource-assets/2022-02-17-13-19-42.gif)



### Example (Simple Terminal)
```java

Terminal t = new Terminal();
t.setTitle("Test!");
t.clearScreen();
TStringBuilder sb = new TStringBuilder()
        .foreground(ForegroundColor.getColorFrom256ColorSet(135)) //Purple
        .append("A Terminal Test")
        .reset()
        .nextLine()
        .background(BackgroundColor.WHITE)
        .foreground(ForegroundColor.BLACK)
        .append("Background!")
        .reset();
t.writeLine(sb.toString() + "\n");
//yellow, pink
t.setColor(ForegroundColor.getColorFrom256ColorSet(227), BackgroundColor.getColorFrom256ColorSet(161));
t.writeLine("Background");
t.reset();
t.write("Press TAB to continue ...");
while (t.getch() != 9) {
    //tab not pressed
}
//tab pressed
t.write("\n\nSimple Movement:");
t.moveConsoleCursor(MoveDirection.RIGHT, 4);
t.write(ForegroundColor.RGB_AQUA + "Cursor Here!");
//wait of button
t.getch();
//close
t.dispose();

```






