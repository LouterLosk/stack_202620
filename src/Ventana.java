import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTextField txtUrl;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnSima;
    private JButton btnMostrar;
    private JTextArea txtListar;
    private JButton likeButton;
    private JButton btnDeleteAll;
    private Pila pila1 = new Pila();

    public Ventana() {

        /**Insert**/
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = txtUrl.getText();
                if (url.isEmpty()) {return;}
                Post obj = new Post(url);
                pila1.push(obj);
                txtListar.setText(pila1.showAll());
            }
        });
        /**POP**/
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post eliminar = pila1.pop();
                    txtListar.setText(pila1.showAll());
                    JOptionPane.showMessageDialog(null, "Se elimino "+ eliminar.toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }

        });

        /**Peek**/
        btnSima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post cima =pila1.peek();
                    JOptionPane.showMessageDialog(null, "La cima es: " + cima.toString());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText(pila1.showAll());
            }
        });

        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post aux = pila1.peek();
                    aux.like();
                    txtListar.setText(pila1.showAll());
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnDeleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila1.deleteAll();
                    txtListar.setText("");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack(); // ajusta al tamaño preferido
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
