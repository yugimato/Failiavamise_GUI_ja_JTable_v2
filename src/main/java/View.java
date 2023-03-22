//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {
    private JPanel pnlTop = new JPanel(new FlowLayout(0));
    private JPanel pnlBottom = new JPanel(new BorderLayout());
    private JButton btnOpenfile = new JButton("Ava fail");
    public JLabel pathLabel = new JLabel("");

    public View() {
        super("Isikud");
        this.setPreferredSize(new Dimension(1000, 1000));
        this.pnlTop.add(this.btnOpenfile);
        this.pnlTop.add(this.pathLabel);
        JPanel container = new JPanel(new BorderLayout());
        container.add(this.pnlTop, "North");
        container.add(this.pnlBottom, "Center");
        this.add(container);
    }

    public void registerOpenButton(ActionListener al) {
        this.btnOpenfile.addActionListener(al);
    }

    public JPanel getPnlBottom() {
        return this.pnlBottom;
    }
}
