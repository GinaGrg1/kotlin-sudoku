import java.io.File

class SudokuGame {

    // ## STEP_1 ##
    // Create a file named "sudoku_1" in the "src" folder of the project. Add the below content (the numbers separated by spaces, no other spaces or lines):
    //    3 5 9 6 1 8 4 2 7
    //    7 4 2 5 3 9 8 6 1
    //    1 6 8 4 7 2 9 5 3
    //    4 2 3 8 9 5 7 1 6
    //    5 8 7 1 6 4 3 9 2
    //    6 9 1 7 2 3 5 8 4
    //    2 7 5 9 4 6 1 3 8
    //    8 3 4 2 5 1 6 7 9
    //    9 1 6 3 8 7 2 4 5

    // ## STEP_3 ##
    // Replace in "sudoku_1" file with 0 the numbers located at (0, 0) and (1, 8). You should have the content as below:
    //    0 5 9 6 1 8 4 2 7
    //    7 4 2 5 3 9 8 6 0
    //    1 6 8 4 7 2 9 5 3
    //    4 2 3 8 9 5 7 1 6
    //    5 8 7 1 6 4 3 9 2
    //    6 9 1 7 2 3 5 8 4
    //    2 7 5 9 4 6 1 3 8
    //    8 3 4 2 5 1 6 7 9
    //    9 1 6 3 8 7 2 4 5

    // ## STEP_8 ##
    // Create a test to check the validation rules added in "isUserInputCorrect" function.

    // This property holds a 2D array of integers with the Sudoku game solution.
    // ## STEP_5 ##
    // Rename the property below to "sudokuBoard" as now we don't hold here anymore the solution of the game. Make sure you rename it in "GameFrame.kt" also.
    val sodukoBoard = readSudokuBoard()

    // This property holds a 2D array of booleans. It is used to show or hide a value from our Sudoku board.
    val visibleElements = initVisibleElements()

    // ## STEP_2 ##
    // Update the body of this function to populate the array with the values read from "sudoku_1" file.
    // Run the application again and confirm it behaves the same as before.
    // ## STEP_4 ##
    // Rename this function to "readSudokuBoard".

    private fun readSudokuBoard(): Array<IntArray> {
        val sudokuFile = File("./src/sudoku_1")

        val sudokuArray = Array(9) { IntArray(9) }
        sudokuFile.readLines().forEachIndexed { index, line ->
            sudokuArray[index] = line.split(" ").map { it.toInt() }.toIntArray()
        }

        return sudokuArray
    }

    // ## STEP_6 ##
    // Update the body of this function so that all numbers in "sudokuBoard" that are not 0 are visible.
    // Debug and check the result is as expected (as the old one). Notice that now we cannot check the game again as we don't know the solution anymore.
    private fun initVisibleElements(): Array<BooleanArray> {
        return Array(9) {rowIndex:Int ->
            BooleanArray(9){
                colIndex:Int -> sodukoBoard[rowIndex][colIndex] != 0
            }
        }
    }

    // ## STEP_7 ##
    // Update the body of this function to apply validation rules.
    // The user input is correct if the number entered was not used before on row / column / 3 x 3 area.
    fun isUserInputCorrect(userInput: Int, row: Int, col: Int): Boolean {
        //return sodukoBoard[row][col] == userInput
        // check the input is not in the given row yet
        if (sodukoBoard[row].contains(userInput)){
            return false
        }
        //check the input is not in the given column
        (0 until 9).filter { element:Int -> sodukoBoard[element][col] == userInput }.forEach { return false }

        //check the input is not in the given 3x3 area
        // e.g if the input is 3 which lies in row 3 col 4, then the start row is 3 and start col is
        val startRow:Int = row / 3 * 3
        val startCol:Int = col/ 3 * 3

        (startRow until startRow + 3).forEach { rowIndex ->
            (startCol until startCol + 3).forEach { colIndex ->
                if (sodukoBoard[rowIndex][colIndex] == userInput){
                    return false
                }
            }
        }
        return true
        }

    fun isSolved(): Boolean {
        visibleElements.forEach { array ->
            array.forEach { element ->
                if (!element) {
                    return false
                }
            }
        }
        return true
    }
}
