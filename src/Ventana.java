import javax.swing.*;
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
    private JButton btnReset;
    private Pila pila1 = new Pila();

    public Ventana() {
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = txtUrl.getText();
                Post obj = new Post(url);
                pila1.push(obj);
                txtListar.setText(pila1.showAll());
            }
        });

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
        btnSima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post cima =pila1.peek();
                    txtListar.setText("La cima es: "+cima.toString());
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
        btnReset.addActionListener(new ActionListener() {
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
