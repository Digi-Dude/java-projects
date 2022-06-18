import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JTextArea name;
    private JTextArea patronymic;
    private JButton actionButton;
    private JTextArea surname;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JTextArea fullName;


    public JPanel getMainPanel() {
        return mainPanel;
    }
    public MainForm() {

        secondPanel.setVisible(false);

        actionButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
               changePanel();
            }
        });
    }

    private void changePanel() {
        if (firstPanel.isVisible()) {
            if (!surname.getText().equals("") && !name.getText().equals("")) {
                firstPanel.setVisible(false);
                if (actionButton.getText().equals("Collapse")) {
                    actionButton.setText("Expand");
                } else {
                    actionButton.setText("Collapse");
                }
                secondPanel.setVisible(true);
                String surnameText = surname.getText();
                String nameText = surname.getText();
                String patronymicText = patronymic.getText();
                fullName.setText(surnameText + " " + nameText + " " + patronymicText);
            }
            else {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Not all fields are filled",
                        "ERROR MESSAGE",
                        JOptionPane.PLAIN_MESSAGE
                );

            }
        }
        else if(secondPanel.isVisible()){
            if(fullName.getText().split(" ").length >= 2 && fullName.getText().split(" ").length <= 3 ) {
                secondPanel.setVisible(false);
                if (actionButton.getText().equals("Collapse")) {
                    actionButton.setText("Expand");
                } else {
                    actionButton.setText("Collapse");
                }
                firstPanel.setVisible(true);
                if (fullName.getText().split(" ").length == 3) {
                    surname.setText(fullName.getText().split(" ")[0]);
                    name.setText(fullName.getText().split(" ")[1]);
                    patronymic.setText(fullName.getText().split(" ")[2]);
                }
                surname.setText(fullName.getText().split(" ")[0]);
                name.setText(fullName.getText().split(" ")[1]);
            }
            else {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Not all fields are filled",
                        "ERROR MESSAGE",
                        JOptionPane.PLAIN_MESSAGE
                );
            }


        }
    }


}
