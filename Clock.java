import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * @author Kamil Szywala
 * Basic clock in swing.
 * Clock class can be used in your application. Create an instance of the class in your main class
 * constructor and add it to the panel.
 */
public class Clock extends JLabel implements Runnable{
    private Thread thread;
    private static final int stop = 1000;
    public Clock(){
        super("", SwingConstants.CENTER);
        setFont (new Font ("Consolas", Font.BOLD, 25));
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
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
            Date date = Calendar.getInstance().getTime(); 
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            String strDate = dateFormat.format(date);  
            setText(strDate);
            try {
                thread.sleep(stop);
            } catch(InterruptedException e){}
        }
    }
    public void stop() {
        thread = null;
    }
}
