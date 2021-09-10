import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ImageViewer {
    public static void main(String[] args) {
        JFrame frame = new ImageViewerFrame();
        frame.setTitle("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class ImageViewerFrame extends JFrame{
    JLabel label;
    JFileChooser chooser;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem menuitem;

    public ImageViewerFrame(){
        setSize(800,600);

        label = new JLabel();
        add(label);

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        menubar = new JMenuBar();
        setJMenuBar(menubar);

        menu = new JMenu("File");
        menubar.add(menu);

        menuitem = new JMenuItem("Open");
        menu.add(menuitem);

        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int result = chooser.showOpenDialog(null);

                if(result == JFileChooser.APPROVE_OPTION){
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                }
            }
        });
    }
}