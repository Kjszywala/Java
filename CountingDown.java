import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
/**
 *
 * @author Kamil Szywala
 * Countdown program in Swing
 */
public class CountDown extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new CountDown();
    }
    CountingDown cd = new CountingDown();
    private JButton start;
    private JButton stop;
    private JButton close;
    /**
     * Constructor
     */
    public CountDown(){
        InitInterface();
    }
    /**
     * Init user interface.
     */
    public void InitInterface(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel header = new JPanel(new FlowLayout());
        JPanel p = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(55,20,50,20));
        p.add(cd);
        start = new JButton("Start");
        stop = new JButton("Stop");
        close = new JButton("Close");
        header.add(start);
        header.add(stop);
        header.add(close);
        close.addActionListener(this);
        start.addActionListener(this);
        stop.addActionListener(this);
        setContentPane(panel);
        panel.add(p, BorderLayout.CENTER);
        panel.add(header, BorderLayout.SOUTH);
        setSize(400,270);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
    * Set operation on close
    */
    public void Close(){
        exit(0);
    }
    /**
     * ActionListener
     * @param e
    **/
    @Override
     public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Close" -> Close();
            case "Start" -> cd.start();
            case "Stop" -> cd.stop();
        }
    }
}
/**
* If the class implements the Runnable interface, the thread can be run by 
* passing an instance of the class to a Thread object's constructor and then 
* calling the thread's start() method
*/
public class CountingDown extends JLabel implements Runnable {
    private Thread thread;
    //The time from countdown starts can be set here 'number'.
    private int number = 20;
    private static final int stop = 1000;
    public CountingDown(){
        super("", SwingConstants.CENTER);
        setFont (new Font ("Consolas", Font.BOLD, 25));
        setForeground(Color.BLACK);
        setOpaque(true);
        setVisible(true);
    }
    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void run(){
        while (thread == Thread.currentThread()){ 
            number -= 1;
            String r = Integer.toString(number);
            setText(r);
            try {
                thread.sleep(stop);
            } catch(InterruptedException e){}
        }
    }
    public void stop() {
        thread = null;
    }
}
