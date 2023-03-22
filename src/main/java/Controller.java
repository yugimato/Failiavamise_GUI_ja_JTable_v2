import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller {

    private Model model;
    private View view;
    private JTable table;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.registerOpenButton(new MyOpenButton());

    }

    private class MyOpenButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Failid", "csv");
            fc.addChoosableFileFilter(filter);
            int result = fc.showOpenDialog(view);
            if(result == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                model.setFilename(f.getAbsolutePath());
                view.pathLabel.setText(fc.getSelectedFile().getAbsolutePath());
                model.readFromFile();
                ArrayList<Filedata> filedata = model.getFiledata();
                if(filedata.size() > 0) {
                    createTable();
                }
            }
        }
    }

    private void createTable() {
        ArrayList<Filedata> filedatas = model.getFiledata();
        DefaultTableModel tablemodel = new DefaultTableModel();
        table = new JTable(tablemodel) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        for(String columnName : model.getColumnNames()) {
            tablemodel.addColumn(columnName);
        }
        List<String> list = new ArrayList<String>();
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int cols2 = table.getColumnCount();
                list.clear();
                for (int x = 0; x < cols2; x++) {
                    String selectedCellValue = (String) table.getValueAt(table.getSelectedRow(), x);
                    if (selectedCellValue == "") {
                        selectedCellValue = "[Andmed puuduvad]";
                    }
                    list.add(x, selectedCellValue);
                }
                String listString = String.join(", ", list);
                JOptionPane.showMessageDialog(null, "Valitud rea andmed on järgmised: " + listString);
            }
        });
        for(Filedata filedata : filedatas) {
            String firstname = filedata.getFirstname();
            String lastname = filedata.getLastname();
            String gender = filedata.getGender();
            String birth = filedata.getBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String death = "";
            if(filedata.getDeath() != null) {
                death = filedata.getDeath().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }
            String place = filedata.getPlace();
            String type = filedata.getType();
            String county = filedata.getCounty();

            tablemodel.addRow(new Object[] {firstname, lastname, gender, birth, death, place, type, county});
        }

        view.getPnlBottom().add(new JScrollPane(table));
        view.pack();
        view.getPnlBottom().setVisible(true);
    }

}
