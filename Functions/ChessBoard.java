public class ChessBoard extends JComponent{
    private final int HEIGHT = 100;
    private final int WIDTH = 100;
    protected int positionX = 0;
    protected int positionY = 0;
    private boolean isWhite = true;
    protected int[][] pawns= {
        {0,2,0,2,0,2,0,2},
        {2,0,2,0,2,0,2,0},
        {0,2,0,2,0,2,0,2},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {1,0,1,0,1,0,1,0},
        {0,1,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0}
    };
    
    @Override
    public void paintComponent(Graphics g){
        for(int j = 0; j<8; j++){
            for(int i = 0; i<8; i++){
                if(isWhite){
                    g.setColor(Color.white);
                    g.fillRect(i*100, j*100, WIDTH, HEIGHT);
                } else {
                    g.setColor(Color.black);
                    g.fillRect(i*100, j*100, WIDTH, HEIGHT);
                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(pawns[j][i] == 2)
                {
                    g.setColor(Color.decode("#803f1f"));
                    g.fillOval(5 + (i * 100), 5 + (j * 100), size, size);
                }
                else if(pawns[j][i] == 1)
                {
                    g.setColor(Color.decode("#e6deda"));
                    g.fillOval(5 + (i * 100), 5 + (j * 100), size, size);
                }
            }
        }
    }
}
