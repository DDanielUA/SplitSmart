package com.SplitSmart.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public final class Config {
    public static final Color _BackgroundColor = new Color(162, 243, 185);

    public static final Border _ButtonBorder = BorderFactory.createEtchedBorder();
    public static final Color _ButtonColor = new Color(58, 167, 92);

    public static final Font _BaseFont = new Font("Consolas", Font.PLAIN, 14);
    public static final Font _ErrorFont = new Font("Consolas", Font.PLAIN, 14);

    public static final ImageIcon _Logo = new ImageIcon("src/com/SplitSmart/Images/logo_coloured_tp.png");
    public static final ImageIcon _SmallLogo = new ImageIcon(new ImageIcon("src/com/SplitSmart/Images/logo_coloured_tp.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    public static final ImageIcon _CheckMark = new ImageIcon(new ImageIcon("src/com/SplitSmart/Images/checkmark.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
}
