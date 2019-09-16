package controller;

import view.ChessView;

import java.awt.EventQueue;
import java.awt.Point;

/**
 * Main method used to run the GUI.
 * @author Gobindroop Mann
 * @version 0.1
 */
public final class Main {
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private Main() {
        throw new IllegalStateException();
    }
    
    /**
     * The main method to test if functions of the board are working correctly.
     * @param theArgs Command Line arguments
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
        	private ChessView myChessView = new ChessView();
        	@Override
        	public void run() {
        		myChessView.start();
        	}	
        });
    }

}