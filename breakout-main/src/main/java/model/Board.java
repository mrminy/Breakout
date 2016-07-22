package model;

import utils.Utils;

import javax.rmi.CORBA.Util;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Board {
	private int cols, rows;
	private int[][] cells; // 1=cells, 0=dead

	public Board(){
		this(Utils.DEFAULT_BOARD_COLS, Utils.DEFAULT_BOARD_ROWS);
	}

	public Board(int cols, int rows) {
		this.cols = cols;
		this.rows = rows;
		reset();
	}

	public void reset(){
		cells = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cells[i][j] = Utils.ALIVE_CELL;
			}
		}
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isCellAlive(int r, int c){
		return cells[r][c] == Utils.ALIVE_CELL;
	}
}
