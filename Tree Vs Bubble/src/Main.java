import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        int[] numberArray = new int[1000];
        BinaryTree tree = new BinaryTree();
        tree.init();
        File file = new File("C:\\Users\\neera\\IdeaProjects\\Tree Vs Bubble\\src\\numbers.txt");
        Scanner input = new Scanner(file);
        int i = 0;
        while (input.hasNextLine()) {

            int number = input.nextInt();
            tree.makeTree(number);
            numberArray[i] = number;
            i++;
        }
        input.close();
        System.out.println("RECURSIVE");
        tree.sortedRecursive(tree.getRoot());
        System.out.println("NUMBER OP COMPARISON = " +

                tree.numberOfComparison());
        scanner.nextLine();

        System.out.println("ITERATIVE");
        tree.sortedIterative();
        scanner.nextLine();
        File output;
        output = new File("TREE.txt");
        FileWriter fileWriter = new FileWriter(output);
        tree.Recursive(tree.getRoot(), fileWriter);
        fileWriter.write("Number of comparsions = " + tree.numberOfComparison());
        fileWriter.close();
        System.out.println("BUBBLY BUBBLE");
        bubbleSort(numberArray);
        scanner.close();
    }

    public static void bubbleSort(int[] numberArray) {
        int n = numberArray.length;
        int comparison = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comparison++; // Count every comparison

                if (numberArray[j] > numberArray[j + 1]) {
                    // Swap elements
                    int temp = numberArray[j];
                    numberArray[j] = numberArray[j + 1];
                    numberArray[j + 1] = temp;
                }
            }
        }
        try {
            File outFile = new File("arrayOutput.txt");
            try (FileWriter fileWriter = new FileWriter(outFile)) {
                fileWriter.write("BUBBLE_SORT \n");
                for (int i = 0; i < n; i++) {
                    fileWriter.write(numberArray[i] + "\n");
                    System.out.println(numberArray[i]);
                }
                fileWriter.write("Number of comparisons = " + comparison);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        System.out.println("Number of comparisons made during bubble sort: " + comparison);
    }
}