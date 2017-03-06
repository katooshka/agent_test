package cli;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ArgumentsValidator {

    /**
     * Checks if arguments passed to the program are valid.
     *
     * @param args a String array containing print function name, path to the input file
     *             and brand factor value
     * @throws RuntimeException if number or format of arguments is wrong
     *                          or if input file does not exists
     */
    public static void validateArguments(String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Wrong number of arguments");
        }
        String firstArgument = args[0];
        if (!firstArgument.equals("--process")) {
            throw new RuntimeException("Wrong first argument");
        }
        String secondArgument = args[1];
        if (!Files.exists(Paths.get(secondArgument))) {
            throw new RuntimeException("File does not exist");
        }
        double thirdArgument;
        try {
            thirdArgument = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Third argument is not a number");
        }
        if (thirdArgument < 0.1) {
            throw new RuntimeException("Third argument is less than 0.1");
        }
        if (thirdArgument > 2.9) {
            throw new RuntimeException("Third argument is greater than 2.9");
        }
    }
}
