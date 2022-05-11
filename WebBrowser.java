import javax.swing.*; 
import javax.swing.event.*; 
import java.awt.*; 
import java.net.*; 
import java.awt.event.*; 

public class WebBrowser extends JFrame implements ActionListener, 
                                                  HyperlinkListener { 
    /**
     * Variables
     */
    JTextField address; 
    JButton buttonGo; 
    JLabel text, status;
    JEditorPane site;

    public static void main(String[] args) { 
    WebBrowser okno = new WebBrowser("My browser"); 
    okno.init(); 
    okno.setVisible(true); 
    } 
    /**
     * Constructor
     * @param tytul 
     */
    public WebBrowser(String tytul) { 
        super(tytul); 
    } 
    /**
     * Init Interface 
     */
    public void init() { 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setSize(600, 600); 
        setLayout(new BorderLayout()); 
        JPanel top = new JPanel(); 
        top.setLayout(new FlowLayout()); 
        text = new JLabel(""); 
        top.add(text); 
        address = new JTextField("", 30); 
        top.add(address); 
        buttonGo = new JButton("Go"); 
        buttonGo.addActionListener(this); 
        top.add(buttonGo); 
        add(BorderLayout.NORTH, top); 
        site = new JEditorPane(); 
        site.setEditable(false); 
        site.addHyperlinkListener(this); 
        JScrollPane sp = new JScrollPane(site); 
        add(BorderLayout.CENTER, sp ); 
        status = new JLabel(" "); 
        add(BorderLayout.SOUTH, status); 
    } 
    /**
     * 
     * @param Button clicked action event.
     * URL definition.
     */
    public void actionPerformed(ActionEvent ex) { 
        String addressText = address.getText(); 
        try { 
            URL url = new URL(addressText); 
            site.setPage(url); 
        } catch (MalformedURLException e) { 
            site.setText("\nURL error:\n" + e); 
        } catch (Exception e) { 
            site.setText("\nError:\n" + e); 
        } 
    }
    /**
     * @param e 
     * Reaction for the links on the sites.
     */
    public void hyperlinkUpdate(HyperlinkEvent e){ 
        if(e.getEventType() == HyperlinkEvent.EventType.ENTERED){ 
            status.setText(e.getDescription()); 
            return; 
        } 
        if(e.getEventType() == HyperlinkEvent.EventType.EXITED){ 
            status.setText(" "); 
            return; 
        } 
        try { 
            URL url = e.getURL(); 
            site.setPage(url); 
            address.setText(url.getProtocol() + "://"+ url.getHost() 
            + url.getFile()); 
        } catch (Exception threed) { 
            site.setText("\nError:\n" + threed); 
        } 
    } 
}

