public class Editor1 {

    /**
     * Client program that processes manipulations on images
     * Receives two command-line parameters: filename (with extension) and the operation code
     * The program reads the source from a file, opens a graphics window and displays the manipulated image.
     * @param String filename, String manipulation (the operation code)
     * @return manipulated image in a graphics window
     */

    public static void main(String args[]) {

        // Initialize arguments, command-line filename and operation code
        String filename = args[0];
        String manipulation = args[1];

        // Reads file name, including file type ".ppm" and stores it
        int[][][] source = ImageEditing.read(filename);

        // Flip vertically
        if (manipulation.equals("fv")){
           ImageEditing.show(ImageEditing.flipVertical(source));
        }

        // Flip horizontally
        if (manipulation.equals("fh")){
            ImageEditing.show(ImageEditing.flipHorizontal(source));
        }

        // Segment
        if (manipulation.equals("se")){
            ImageEditing.show(ImageEditing.segement(source));
        }
    }
}
