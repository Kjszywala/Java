public void Exit(){
    int reply = JOptionPane.showOptionDialog(
            new JFrame(),
            "Are you sure you want to exit?",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[] { "Yes", "No" }, 
            JOptionPane.YES_OPTION
            );
    if (reply == JOptionPane.YES_OPTION) {
        System.exit(0);
    } 
}
