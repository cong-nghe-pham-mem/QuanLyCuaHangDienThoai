package stolenBtn;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FileButton extends JButton {

    public FileButton() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/icons/icons8_opened_folder_20px.png")));
    }
}
