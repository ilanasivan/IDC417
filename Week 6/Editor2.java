public class Editor2 {

    /**
     * Client program that resizes images
     * Receives command-line parameters: filename (with extension), width, then height (per ImageEditing.scale function)
     * The program reads the source from a file, opens a graphics window and displays the manipulated image.
     * @param String filename, int width, int height
     * @return resized image in graphics window
     */

    public static void main(String args[]) {

        // Initialize args, filename, width and height
        String filename = args[0];
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);

        // Reads file name, including file type ".ppm"
        int[][][] source = ImageEditing.read(filename);

        // Displays the scaled image by calling show and scale functions
        ImageEditing.show(ImageEditing.scale(source, width, height));
    }
}
