import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToeGUI {
    private JFrame frame;
    private JButton[] buttons;
    private JLabel statusLabel;
    private JButton resetButton;
    private boolean isXTurn;

    public TicTacToeGUI() {
        frame = new JFrame("Tic Tac Toe");
        buttons = new JButton[9];
        isXTurn = true;

        initialize();
    }

    private void initialize() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Game Board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(new Color(240, 240, 240));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(new ButtonClickListener(i));
            boardPanel.add(buttons[i]);
        }

        // Status Panel
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());

        statusLabel = new JLabel("Player X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusPanel.add(statusLabel, BorderLayout.CENTER);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.addActionListener(e -> resetBoard());
        statusPanel.add(resetButton, BorderLayout.EAST);

        // Add panels to the frame
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.SOUTH);

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
            buttons[index].setForeground(isXTurn ? Color.BLUE : Color.RED);

            if (checkWin()) {
                statusLabel.setText((isXTurn ? "Player X" : "Player O") + " Wins!");
                highlightWinningButtons();
                disableButtons();
            } else if (isBoardFull()) {
                statusLabel.setText("It's a Draw!");
                disableButtons();
            } else {
                isXTurn = !isXTurn; // Switch turn
                statusLabel.setText("Player " + (isXTurn ? "X" : "O") + "'s Turn");
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

    private void highlightWinningButtons() {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] condition : winConditions) {
            if (!buttons[condition[0]].getText().isEmpty() &&
                    buttons[condition[0]].getText().equals(buttons[condition[1]].getText()) &&
                    buttons[condition[0]].getText().equals(buttons[condition[2]].getText())) {
                for (int i : condition) {
                    buttons[i].setBackground(new Color(173, 216, 230)); // Highlight buttons
                }
                break;
            }
        }
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
            button.setBackground(Color.WHITE);
            button.setEnabled(true);
        }
        isXTurn = true; // Reset turn to X
        statusLabel.setText("Player X's Turn");
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}

