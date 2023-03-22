import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                View view = new View();
                new Controller(model, view);
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.pack();
                view.setLocationRelativeTo(null);
                view.setVisible(true);
            }
        });
    }
}