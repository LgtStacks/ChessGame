package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chessboard.Board;

/**
 * The view window for the game of chess.
 * 
 * @author Gobindroop Mann
 * @version 0.1
 */
public class ChessView extends JFrame implements PropertyChangeListener {
    /** Serial Version UID. */
    private static final long serialVersionUID = 1L;
    private Point sourceTile;
    private Point destinationTile;
    private Board chessBoard;
    /** The board the game will be played on. */
    private final BoardPanel boardPanel;
    /** The color for the light colored tiles. */
    private final Color lightColor = Color.decode("#FFF4CB");
    /** The color for the dark colored tiles. */
    private final Color darkColor = Color.decode("#62745E");

    /**
     * Constructor for the ChessView.
     */
    public ChessView() {
        super("Chess Game");
        chessBoard = new Board();
        boardPanel = new BoardPanel();
        
    }

    /**
     * The start method that initializes the ChessView.
     */
    public void start() {
        setSize(600, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(boardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * A class that represents a Board in the game of chess.
     * 
     * @author Gobindroop Mann
     * @version 0.1
     */
    private class BoardPanel extends JPanel {
        /** Serial Version UID. */
        private static final long serialVersionUID = 1L;
        /** A list of all of the tiles on the Board. */
        final List<TilePanel> boardTiles;

        /**
         * Constructor for a board panel.
         */
        BoardPanel() {
            super(new GridLayout(8, 8));
            boardTiles = new ArrayList<>();
            for (int i = 0; i < 64; i++) {
                final TilePanel tilePanel = new TilePanel(this, i);
                boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(new Dimension(400, 350));
        }
        public void drawBoard(final Board board) {
        	removeAll();
        	for(TilePanel tilePanel: boardTiles) {
        		tilePanel.drawTile(board);
        		add(tilePanel);
        	}
        	validate();
        	repaint();
        }
    }

    /**
     * A class that represents an individual tile in the game of chess.
     * 
     * @author Gobindroop Mann
     * @version 0.1
     */
    private class TilePanel extends JPanel {
        /** Serial Version UID. */
        private static final long serialVersionUID = 1L;
        /** The position of the tile from 0-63. */
        private final int myTileID;

        /**
         * Constructor for an individual tile in the game of chess.
         * 
         * @param boardPanel The board that this tile is on.
         * @param theTileID  The position of this tile from 0-63.
         */
        TilePanel(final BoardPanel boardPanel, final int theTileID) {
            super(new GridBagLayout());
            myTileID = theTileID;
            setPreferredSize(new Dimension(10, 10));
            assignTileColor();
            assignTilePeiceIcon(chessBoard);
            addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(sourceTile == null) {
						sourceTile = tileIDToPoint(myTileID);
					} else {
						destinationTile = tileIDToPoint(myTileID);
						try {
							chessBoard.move(sourceTile, destinationTile);
						} catch(Exception ec) {
							JOptionPane.showMessageDialog(null, ec.getMessage());
						}
						
						sourceTile = null;
						destinationTile = null;
						assignTilePeiceIcon(chessBoard);
					}
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							boardPanel.drawBoard(chessBoard);
							
						}
						
					});
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
        }
        public void drawTile(final Board board) {
        	assignTileColor();
        	assignTilePeiceIcon(board);
        	repaint();
        }
        private void assignTilePeiceIcon(final Board board) {
            removeAll();
            Point theLocation = tileIDToPoint(myTileID);
            if (!board.isFree(theLocation)) {
            	try {
					final BufferedImage image = ImageIO.read(new File("images/" + board.getPiece(theLocation).getColor()
																					+ board.getPiece(theLocation).toString()
																					+ ".gif"));
					add(new JLabel(new ImageIcon(image)));
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }

        /**
         * Assigns a color for the tile based on its position on the board.
         */
        private void assignTileColor() {
            if (myTileID < 8 // row 1
                    || myTileID > 15 && myTileID < 24 // row 3
                    || myTileID > 31 && myTileID < 40 // row 5
                    || myTileID > 47 && myTileID < 56) {// row 7
                setBackground(myTileID % 2 == 0 ? lightColor : darkColor);
            } else {
                setBackground(myTileID % 2 != 0 ? lightColor : darkColor);
            }

        }

        private Point tileIDToPoint(int theTileID) {
            int x, y;
            x = theTileID / 8;
            y = theTileID % 8;
            return new Point(x,y);
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // TODO Auto-generated method stub

    }

}
