public class ChessBoard extends JComponent{
    private final int HEIGHT = 100;
    private final int WIDTH = 100;
    protected int positionX = 0;
    protected int positionY = 0;
    private boolean isWhite = true;
    
    @Override
    public void paintComponent(Graphics g){
        for(int j = 0; j<8; j++){
            for(int i = 0; i<8; i++){
                if(isWhite){
                    g.setColor(Color.white);
                    g.fillRect(i*100, j*100, WIDTH, HEIGHT);
                    isWhite = !isWhite;
                } else {
                    g.setColor(Color.black);
                    g.fillRect(i*100, j*100, WIDTH, HEIGHT);
                    isWhite = !isWhite;
                }
            }
            isWhite = !isWhite;
        }
    }
}
