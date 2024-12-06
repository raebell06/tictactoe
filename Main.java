import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToeGUI {
    private JFrame frame;
    private JButton[] buttons;
    private boolean isXTurn;

    public TicTacToeGUI() {
        frame = new JFrame("Tic Tac Toe");
        buttons = new JButton[9];
        isXTurn = true;

        initialize();
    }

    private void initialize() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(new ButtonClickListener(i));
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int index;

        public ButtonClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!buttons[index].getText().isEmpty()) {
                return; // Ignore clicks on already filled buttons
            }

            buttons[index].setText(isXTurn ? "X" : "O");
            if (checkWin()) {
                JOptionPane.showMessageDialog(frame, (isXTurn ? "X" : "O") + " Wins!");
                resetBoard();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(frame, "It's a Draw!");
                resetBoard();
            } else {
                isXTurn = !isXTurn; // Switch turn
            }
        }
    }

    private boolean checkWin() {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] condition : winConditions) {
            if (!buttons[condition[0]].getText().isEmpty() &&
                    buttons[condition[0]].getText().equals(buttons[condition[1]].getText()) &&
                    buttons[condition[0]].getText().equals(buttons[condition[2]].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
        }
        isXTurn = true; // Reset turn to X
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
