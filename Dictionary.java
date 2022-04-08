package com.mycompany.dictionary;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author Kamil Szywala
 */
public class Dictionary extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Dictionary();
    }
    /**
     * Variables.
     */
    private JLabel englishMeaning;
    private JLabel polishMeaning;
    private JTextField inEnglish;
    private JTextField toPolish;
    private JButton showNextWord;
    private JButton add;
    /**
     * Lists with english and polish words.
     */
    ArrayList<String> englishWords = new ArrayList<String>();
    ArrayList<String> polishWords = new ArrayList<String>();
    /**
     * Getters and setters
     * @return 
     */
    public JButton getAdd() {
        return add;
    }
    public void setAdd(JButton add) {
        this.add = add;
    }
    public JLabel getEnglishMeaning() {
        return englishMeaning;
    }
    public void setEnglishMeaning(JLabel englishMeaning) {
        this.englishMeaning = englishMeaning;
    }
    public JLabel getPolishMeaning() {
        return polishMeaning;
    }
    public void setPolishMeaning(JLabel polishMeaning) {    
        this.polishMeaning = polishMeaning;
    }
    public JTextField getInEnglish() {
        return inEnglish;
    }
    public void setInEnglish(JTextField inEnglish) {
        this.inEnglish = inEnglish;
    }
    public JTextField getToPolish() {
        return toPolish;
    }
    public void setToPolish(JTextField toPolish) {
        this.toPolish = toPolish;
    }
    public JButton getShowNextWord() {
        return showNextWord;
    }
    public void setShowNextWord(JButton showNextWord) {
        this.showNextWord = showNextWord;
    }
    /**
     * Constructor
     */
    public EngToPlDictionary(){
        super("EngToPlDictionary");
        InitInterface();
        setSize(500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
  /**
  * Add Interface
  */
    public void InitInterface(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        englishMeaning = new JLabel("English Meaning: ");
        polishMeaning = new JLabel("Polish Meaning: ");
        inEnglish = new JTextField(10);
        toPolish = new JTextField(10);
        showNextWord = new JButton("Show random word");
        add = new JButton("Add word to dictionary");
        JPanel header = new JPanel(new FlowLayout());
        header.add(englishMeaning);
        header.add(inEnglish);
        header.add(polishMeaning);
        header.add(toPolish);
        header.add(showNextWord);
        header.add(add);
        showNextWord.addActionListener(this);
        add.addActionListener(this);
        setContentPane(header);
    }
    /**
     * Logic
     * if text fields will not be empty you can add the word to your
     * dictionary.
     */
    public void AddWord(){
        if(getInEnglish().getText() != "" && getToPolish().getText() != ""){
            englishWords.add(getInEnglish().getText());
            polishWords.add(getToPolish().getText());
        }
        inEnglish.setText("");
        toPolish.setText("");
    }
    /**
     * Show random word translated to polish in textfield.
     */
    public void ShowRandomWord(){
        Random rand = new Random();
        int upperbound = englishWords.size();
        int random = rand.nextInt(upperbound);
        inEnglish.setText(englishWords.get(random));
        toPolish.setText(polishWords.get(random));
    }
    /**
     * ActionListener.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Add word to dictionary" -> AddWord();
            case "Show random word" -> ShowRandomWord();
        }
    } 
}
