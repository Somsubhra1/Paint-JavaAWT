import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements MouseMotionListener, ActionListener {
    int c=0;
    Graphics g=getGraphics();
    Label l;
    MenuBar mb;
    Menu main;
    MenuItem close;
    MenuItem status;
    Menu color;
    MenuItem red,reset;
    MenuItem blue,green,yellow,black,pink,orange,cyan;
    Color select;

    Main() {
        setTitle("Paint");
        setSize(600,500);
        setLayout(null);

        l=new Label();
        l.setBounds(50,50,80,50);
        l.setVisible(false);
        add(l);

        addMouseMotionListener(this);

        mb=new MenuBar();
        main=new Menu("Menu");
        close=new MenuItem("Close");
        status=new MenuItem("Show Status");
        reset=new MenuItem("Reset Paint");
        main.add(status);
        main.add(reset);
        main.add(close);
        mb.add(main);
        setMenuBar(mb);
        status.addActionListener(this);
        reset.addActionListener(this);
        close.addActionListener(this);

        color=new Menu("Color");
        red=new MenuItem("Red");
        blue=new MenuItem("Blue");
        green=new MenuItem("Green");
        yellow=new MenuItem("Yellow");
        black=new MenuItem("Black");
        pink=new MenuItem("Pink");
        orange=new MenuItem("Orange");
        cyan=new MenuItem("Cyan");
        color.add(red);
        color.add(blue);
        color.add(green);
        color.add(yellow);
        color.add(black);
        color.add(pink);
        color.add(orange);
        color.add(cyan);
        mb.add(color);

        setVisible(true);

        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);
        black.addActionListener(this);
        pink.addActionListener(this);
        orange.addActionListener(this);
        cyan.addActionListener(this);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        l.setText("X: "+e.getX()+" Y: "+e.getY());
        g=getGraphics();
        g.setColor(select);
        g.fillOval(e.getX(), e.getY(), 30, 30);

    }


    @Override
    public void mouseMoved(MouseEvent e) {
        l.setText("X: "+e.getX()+" Y: "+e.getY());

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==status) {
            if(c%2==0) {
                l.setVisible(true);
            }
            else {
                l.setVisible(false);
            }
            c++;

        }
        else if(e.getSource()==close) {
            System.exit(0);
        }
        else if(e.getSource()==red) {
            select=Color.RED;
        }
        else if(e.getSource()==blue) {
            select=Color.BLUE;
        }
        else if(e.getSource()==green) {
            select=Color.GREEN;
        }
        else if(e.getSource()==yellow) {
            select=Color.YELLOW;
        }
        else if(e.getSource()==black) {
            select=Color.BLACK;
        }
        else if(e.getSource()==pink) {
            select=Color.PINK;
        }
        else if(e.getSource()==orange) {
            select=Color.ORANGE;
        }
        else if(e.getSource()==cyan) {
            select=Color.CYAN;
        }
        else if(e.getSource()==reset){
            repaint();
        }

    }

    public static void main(String[] args) {
        new Main();
    }

}
