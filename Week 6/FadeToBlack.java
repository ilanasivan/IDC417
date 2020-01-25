public class FadeToBlack {

    /**
     * Client program that fades images from color to black and white
     * Receives command-line parameters: filename (with extension), n (steps)
     * The program reads the source from a file, opens a graphics window and displays the gradual morphing image
     * @param String filename is the image being manipulated, saved to source, int n (how many steps)
     * @return the manipulated image from source to segmented over n-steps in a graphics window
     */

    public static void main(String args[]) {

        // Initialize args, filename and n-value
        String filename = args[0];
        int n = Integer.parseInt(args[1]);

        // Store the read image
        int[][][] source = ImageEditing.read(filename);

        // Store a segmented manipulation of the file
        int[][][] segmentedSource = ImageEditing.segement(source);

        // Morph the two stored images over n steps
        ImageEditing.morph(source, segmentedSource, n);
    }
}
